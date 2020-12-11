package com.fm.business.base.service.resume.impl;

import cn.hutool.core.date.DateUtil;
import com.fm.business.base.service.resume.IResumeAttachmentInfoService;
import com.fm.framework.core.service.FileService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/11 11:23
 */
public class ResumeThread implements Callable {
    private Integer i;
    private Integer dpi;
    private PDFRenderer renderer;
    private List<BufferedImage> list;
    private Integer pageCount;
    private String filePath;

    public ResumeThread(Integer i, Integer dpi, PDFRenderer renderer, List<BufferedImage> list, Integer pageCount, String filePath) {
        this.i = i;
        this.dpi = dpi;
        this.renderer = renderer;
        this.list = list;
        this.pageCount = pageCount;
        this.filePath = filePath;
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
    public BufferedImage call() throws Exception {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = renderer.renderImageWithDPI(i, dpi);
            list.add(bufferedImage);
            if (list.size() == pageCount) {
                BufferedImage mergeImage = mergeImage(list);
                return mergeImage;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}