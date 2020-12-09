package com.fm.business.base.service.resume.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.aspose.words.Document;
import com.aspose.words.ImageSaveOptions;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.resume.IResumeAttachmentInfoMapper;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.resume.ResumeAttachmentInfo;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.resume.IResumeAttachmentInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.cos.CosProperties;
import com.fm.framework.core.cos.CosServiceImpl;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import com.fm.framework.core.service.FileService;
import com.qcloud.cos.COSClient;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/2 17:42
 */
@Service
@EnableAsync
public class ResumeAttachmentInfoServiceImpl extends AuditBaseService<IResumeAttachmentInfoMapper, ResumeAttachmentInfo> implements IResumeAttachmentInfoService {
    static final String key = "file/" + DateUtil.today() + "/" + DateUtil.date().getTime() + ".png";
    @Autowired
    private IFreelancerInfoService freelancerInfoService;

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private FileService fileService;

    @Autowired
    private COSClient cosClient;

    @Autowired
    private CosProperties cosProperties;

    @Override
    protected Page<ResumeAttachmentInfo> toPage(com.baomidou.mybatisplus.extension.plugins.pagination.Page<ResumeAttachmentInfo> mybatisPlusPage) {
        Page<ResumeAttachmentInfo> page = super.toPage(mybatisPlusPage);
        if (!CollectionUtils.isEmpty(page.getData())) {
            fillResumeInfo(page.getData());
        }
        return page;
    }

    private void fillResumeInfo(List<ResumeAttachmentInfo> resumeAttachmentInfos) {
        if (CollectionUtils.isEmpty(resumeAttachmentInfos)) {
            return;
        }
        Set<Long> jobCateIds = resumeAttachmentInfos.stream().map(ResumeAttachmentInfo::getJobCateId).collect(Collectors.toSet());
        Map<Long, BdJobCate> bdJobCateMap = bdJobCateService.getByIds(jobCateIds).stream().collect(Collectors.toMap(BdJobCate::getId, Function.identity(), (v1, v2) -> v2));
        resumeAttachmentInfos.forEach(resumeAttachmentInfo -> {
            if (bdJobCateMap.containsKey(resumeAttachmentInfo.getJobCateId())) {
                resumeAttachmentInfo.setBdJobCateName(bdJobCateMap.get(resumeAttachmentInfo.getJobCateId()).getCateName());
            }
            if (productionInfoService.findByFreeLancer(resumeAttachmentInfo.getFreelancerId()) != null) {
                resumeAttachmentInfo.setIsProduction(10);
            } else {
                resumeAttachmentInfo.setIsProduction(20);
            }

        });

    }


    /**
     * PDF转图片，异步执行
     *
     * @param filePath
     */
    @Override
    @Async
    public void pdf2Image(String filePath) {
        ArrayList<BufferedImage> list = new ArrayList<>();
        PDDocument pdDocument = null;
        ByteArrayOutputStream outputStream = null;
        try {
            int dpi = 100;
            pdDocument = PDDocument.load(fileService.getInputStream(filePath));
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            int pageCount = pdDocument.getNumberOfPages();
            outputStream = new ByteArrayOutputStream();
            /**
             * dpi越大图片越清晰，相对转换越慢
             */
            for (int i = 0; i < pageCount; i++) {
                BufferedImage bufferedImage = renderer.renderImageWithDPI(i, dpi);
                list.add(bufferedImage);
            }
            BufferedImage mergeImage = mergeImage(list);
            ImageIO.write(mergeImage, "png", outputStream);
            outputStream.flush();
            byte[] data = outputStream.toByteArray();
            fileService.upload(key, data);
            updateOtherPath(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pdDocument.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    @Async
    public void doc2Image(String path) {
        try {
            InputStream inputStream = fileService.getInputStream(path);
            Document document = new Document(inputStream);
            ImageSaveOptions imageSaveOptions = new ImageSaveOptions(SaveFormat.PNG);
            int pageCount = document.getPageCount();
            ArrayList<BufferedImage> list = new ArrayList<>();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < pageCount; i++) {
                document.save(byteArrayOutputStream, imageSaveOptions);
                ImageInputStream imageInputStream = javax.imageio.ImageIO.createImageInputStream(parse(byteArrayOutputStream));
                list.add(javax.imageio.ImageIO.read(imageInputStream));
            }
            BufferedImage mergeImage = mergeImage(list);
            ImageIO.write(mergeImage, "png", byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byte[] data = byteArrayOutputStream.toByteArray();
            fileService.upload(key, data);
            updateOtherPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ResumeAttachmentInfo> getResumeByFreelancerId(Long freelancerId) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(ResumeAttachmentInfo.class).eq(ResumeAttachmentInfo::getFreelancerId,freelancerId));

    }

    private static ByteArrayInputStream parse(OutputStream out) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos = (ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream;
    }


    /**
     * 拼接之后修改路径
     *
     * @param filePath
     */
    private String updateOtherPath(String filePath) {
        String bucketName = cosProperties.getBucketName();
        Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
        URL oldUrl = cosClient.generatePresignedUrl(bucketName, key, expiration);
        String newUrl = oldUrl.toString();
        newUrl = StrUtil.sub(newUrl, newUrl.indexOf("f"), newUrl.indexOf("?"));
        ResumeAttachmentInfo resumeAttachmentInfo1 = getBaseMapper().selectOne(Wrappers.lambdaQuery(ResumeAttachmentInfo.class).eq(ResumeAttachmentInfo::getPath, filePath));
        if (ObjectUtil.isNotNull(resumeAttachmentInfo1)) {
            resumeAttachmentInfo1.setOtherPath(newUrl);
            update(resumeAttachmentInfo1);
            return null;
        }
        return oldUrl.toString();
    }

    /**
     * 拼接图片
     *
     * @param bufferedImages
     * @return
     */
    private BufferedImage mergeImage(List<BufferedImage> bufferedImages) {
        int allH = bufferedImages.stream().mapToInt(BufferedImage::getHeight).sum();
        int allWMax = bufferedImages.stream().mapToInt(BufferedImage::getWidth).filter(bufferedImage -> bufferedImage >= 0).max().orElse(0);
        BufferedImage destImage = new BufferedImage(allWMax, allH, BufferedImage.TYPE_INT_RGB);
        // 合并所有子图片到新图片
        int wy = 0;
        for (int i = 0; i < bufferedImages.size(); i++) {
            BufferedImage img = bufferedImages.get(i);
            int w1 = img.getWidth();
            int h1 = img.getHeight();
            // 从图片中读取RGB
            int[] ImageArrayOne = new int[w1 * h1];
            ImageArrayOne = img.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 逐行扫描图像中各个像素的RGB到数组中
            // 垂直方向合并
            destImage.setRGB(0, wy, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            wy += h1;
        }
        return destImage;
    }

    @Override
    protected void beforeSave(ResumeAttachmentInfo model) {
        super.beforeSave(model);
        if (ObjectUtil.isNotNull(model)){
            String[] split = model.getName().split("\\.");
            model.setName(split[0]);
            model.setResumeType(split[1]);
            String path = model.getPath().startsWith("http") ? StrUtil.sub(model.getPath(), model.getPath().indexOf("f"), -1) : model.getPath();
            model.setPath(path);
            String otherPath = model.getOtherPath().startsWith("http") ? StrUtil.sub(model.getOtherPath(), model.getOtherPath().indexOf("f"),-1) : model.getOtherPath();
            model.setOtherPath(otherPath);
            model.setFreelancerId(Context.getCurrFreelancerId());
            model.setPhone(freelancerInfoService.get(Context.getCurrFreelancerId()).getPhone());
        }

    }

    @Override
    protected void beforeUpdate(ResumeAttachmentInfo model) {
        super.beforeUpdate(model);
        if (model.getName().contains(".")) {
            String[] split = model.getName().split("\\.");
            model.setName(split[0]);
            model.setResumeType(split[1]);
        }

    }
}
