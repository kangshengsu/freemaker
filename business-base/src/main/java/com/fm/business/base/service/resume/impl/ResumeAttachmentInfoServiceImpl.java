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
import jodd.util.StringUtil;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.CountDownLatch;
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
     * PDF????????????????????????
     *
     * @param filePath
     */
    @Override
    @Async
    public void pdf2Image(String filePath, byte[] input) {
        ArrayList<BufferedImage> list = new ArrayList<>();
        PDDocument pdDocument = null;
        ByteArrayOutputStream outputStream = null;
        BufferedImage mergeImage = null;
        try {
            int dpi = 96;
            if (StringUtil.isNotBlank(filePath)) {
                pdDocument = PDDocument.load(fileService.getInputStream(filePath));
            } else {
                pdDocument = PDDocument.load(input);
            }
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            int pageCount = pdDocument.getNumberOfPages();
            outputStream = new ByteArrayOutputStream();
            /**
             * dpi??????????????????????????????????????????
             */
            for (int i = 0; i < pageCount; i++) {
//                BufferedImage bufferedImage = renderer.renderImageWithDPI(i, dpi);
//                list.add(bufferedImage);
                ResumeThread thread = new ResumeThread(i, dpi, renderer, list, pageCount, filePath);
                mergeImage = thread.call();
            }
//            BufferedImage mergeImage = mergeImage(list);
            int width = mergeImage.getWidth();
            int height = mergeImage.getHeight();
            BufferedImage bufferedImage = Thumbnails.of(mergeImage).scale(0.6).outputQuality(0.6).asBufferedImage();
            ImageIO.write(bufferedImage, "png", outputStream);
            outputStream.flush();
            byte[] data = outputStream.toByteArray();
            String today = DateUtil.today();
            long time = DateUtil.date().getTime();
            String key = "file/" + today + "/" + time + ".png";
            fileService.upload(key, data);
            updateOtherPath(filePath, key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pdDocument != null) {
                    pdDocument.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Override
     * @Async public void doc2Image(String filePath) {
     * ByteArrayOutputStream byteArrayOutputStream = null;
     * try {
     * String path = filePath.startsWith("http") ? filePath.substring(filePath.lastIndexOf(".com/") + 5) : filePath;
     * InputStream inputStream = fileService.getInputStream(path);
     * Document document = new Document(inputStream);
     * byteArrayOutputStream = new ByteArrayOutputStream();
     * document.save(byteArrayOutputStream, SaveFormat.PDF);
     * byteArrayOutputStream.flush();
     * byte[] data = byteArrayOutputStream.toByteArray();
     * pdf2Image(null, data);
     * fileService.upload(pdfKey,data);
     * ImageSaveOptions imageSaveOptions = new ImageSaveOptions(SaveFormat.PNG);
     * int pageCount = document.getPageCount();
     * ArrayList<BufferedImage> list = new ArrayList<>();
     * ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
     * for (int i = 0; i < pageCount; i++) {
     * document.save(byteArrayOutputStream, imageSaveOptions);
     * ImageInputStream imageInputStream = javax.imageio.ImageIO.createImageInputStream(parse(byteArrayOutputStream));
     * list.add(javax.imageio.ImageIO.read(imageInputStream));
     * }
     * BufferedImage mergeImage = mergeImage(list);
     * ImageIO.write(mergeImage, "png", byteArrayOutputStream);
     * byteArrayOutputStream.flush();
     * byte[] data = byteArrayOutputStream.toByteArray();
     * fileService.upload(key, data);
     * updateOtherPath(path);
     * } catch (Exception e) {
     * e.printStackTrace();
     * } finally {
     * try {
     * byteArrayOutputStream.close();
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */

    @Override
    public List<ResumeAttachmentInfo> getResumeByFreelancerId(Long freelancerId) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(ResumeAttachmentInfo.class).eq(ResumeAttachmentInfo::getFreelancerId, freelancerId));

    }

    private static ByteArrayInputStream parse(OutputStream out) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos = (ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream;
    }


    /**
     * ????????????????????????
     *
     * @param filePath
     */
    @Override
    public void updateOtherPath(String filePath, String key) {
        String bucketName = cosProperties.getBucketName();
        Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
        URL oldUrl = cosClient.generatePresignedUrl(bucketName, key, expiration);
        String newUrl = oldUrl.toString();
        newUrl = StrUtil.sub(newUrl, newUrl.lastIndexOf(".com/") + 5, newUrl.indexOf("?"));

        ResumeAttachmentInfo resumeAttachmentInfo1 = getBaseMapper().selectOne(Wrappers.lambdaQuery(ResumeAttachmentInfo.class).eq(ResumeAttachmentInfo::getPath, filePath));
        resumeAttachmentInfo1.setOtherPath(newUrl);
        update(resumeAttachmentInfo1);
    }

    /**
     * ????????????
     *
     * @param
     * @return
     */
//    private BufferedImage mergeImage(List<BufferedImage> bufferedImages) {
//        int allH = bufferedImages.stream().mapToInt(BufferedImage::getHeight).sum();
//        int allWMax = bufferedImages.stream().mapToInt(BufferedImage::getWidth).filter(bufferedImage -> bufferedImage >= 0).max().orElse(0);
//        BufferedImage destImage = new BufferedImage(allWMax, allH, BufferedImage.TYPE_INT_RGB);
//        // ?????????????????????????????????
//        int wy = 0;
//        for (int i = 0; i < bufferedImages.size(); i++) {
//            BufferedImage img = bufferedImages.get(i);
//            int w1 = img.getWidth();
//            int h1 = img.getHeight();
//            // ??????????????????RGB
//            int[] ImageArrayOne = new int[w1 * h1];
//            ImageArrayOne = img.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // ????????????????????????????????????RGB????????????
//            // ??????????????????
//            destImage.setRGB(0, wy, w1, h1, ImageArrayOne, 0, w1); // ????????????????????????????????????RGB
//            wy += h1;
//        }
//        return destImage;
//    }
    @Override
    protected void beforeSave(ResumeAttachmentInfo model) {
        super.beforeSave(model);
        if (ObjectUtil.isNotNull(model)) {
            if (model.getName().contains(".")) {
                int lastIndexName = model.getName().toLowerCase().lastIndexOf(".");
                String lastName = model.getName().substring(lastIndexName + 1);
                if (lastName.equals("pdf") || lastName.equals("doc") || lastName.equals("docx") || lastName.equals("png") || lastName.equals("jpg") || lastName.equals("jpeg")) {
                    String name = model.getName().substring(0, lastIndexName);
                    model.setName(name);
                }
            }

            if (StringUtil.isNotBlank(model.getPath())) {
                int lastIndex = model.getPath().toLowerCase().lastIndexOf(".");
                String resumeType = model.getPath().substring(lastIndex + 1);
                model.setResumeType(resumeType);
                String path = model.getPath().startsWith("http") ? model.getPath().substring(model.getPath().lastIndexOf(".com/") + 5) : model.getPath();
                model.setPath(path);
                String otherPath = model.getOtherPath().startsWith("http") ? model.getOtherPath().substring(model.getOtherPath().lastIndexOf(".com/") + 5) : model.getOtherPath();
                model.setOtherPath(otherPath);
            }
            if (ObjectUtil.isNotNull(Context.getCurrFreelancerId())) {
                model.setUserName(freelancerInfoService.get(Context.getCurrFreelancerId()).getName());
                model.setFreelancerId(Context.getCurrFreelancerId());
                model.setPhone(freelancerInfoService.get(Context.getCurrFreelancerId()).getPhone());
            }
        }

    }

    @Override
    protected void beforeUpdate(ResumeAttachmentInfo model) {
        super.beforeUpdate(model);
        if (model.getName().contains(".")) {
            int lastIndex = model.getName().toLowerCase().lastIndexOf(".");
            String resumeType = model.getName().substring(lastIndex + 1);
            if ("pdf".equals(resumeType) || "doc".equals(resumeType) || "docx".equals(resumeType) || "png".equals(resumeType) || "jpg".equals(resumeType) || "jpeg".equals(resumeType)) {
                model.setResumeType(resumeType);
                String name = model.getName().substring(0, lastIndex);
                model.setName(name);
            }
        }

    }
}
