package com.fm.api.web.controller.sm;

import com.fm.framework.core.service.FileService;
import com.fm.framework.web.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * 文件图片上传功能
 *
 * @Date 2020/3/23 17:01
 * @Created by lujunwei
 **/
@RestController
@RequestMapping("/file")
@Slf4j
public class UpLoaderController {
    @Autowired
    FileService fileService;
    /**
     * 图片文件后缀list
     */
    @Value("${img.postfix}")
    List<String> imgPostfix;

    private final int MAX_IMG_SIZE=10*1024*1024;

    /**
     * 上传图片
     * @param file
     * @return  上传成功后返回图片地址url
     * @throws IOException
     */
    @RequestMapping(value = "/uploadimage", method = {RequestMethod.GET, RequestMethod.POST})
    public ApiResponse<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return ApiResponse.ofFailed("入参为空");
        }
        String fileName = file.getOriginalFilename();
        if (Objects.isNull(fileName) || !isImage(fileName)) {
            return ApiResponse.ofFailed("图片格式不正确");
        }
        if(file.getInputStream().available()>MAX_IMG_SIZE){
            return ApiResponse.ofFailed("图片大小不能超过10M");
        }

        try(InputStream uploadedStream = file.getInputStream()) {
            byte[] imgBytes = IOUtils.toByteArray(uploadedStream);
            String url = fileService.upload(file.getOriginalFilename(), imgBytes);
            log.debug("图片上传成功,图片名称:{},url为:{}", file, url);
            return ApiResponse.ofSuccess(fileService.getFullPath(file.getOriginalFilename()));
        }
    }

    /**
     * 上传文件
     * @param file
     * @return 上传成功后返回文件地址url
     * @throws IOException
     */
    @RequestMapping(value = "/uploadfile", method = {RequestMethod.GET, RequestMethod.POST})
    public ApiResponse<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return ApiResponse.ofFailed("入参为空");
        }
        String fileName = file.getOriginalFilename();
        if (Objects.isNull(fileName) || !isImage(fileName)) {
            return ApiResponse.ofFailed("图片格式不正确");
        }

        try(InputStream uploadedStream = file.getInputStream()) {
            String url = fileService.upload(fileName, IOUtils.toByteArray(uploadedStream));
            log.debug("图片上传成功,图片名称:{},url为:{}", file, url);
            return ApiResponse.ofSuccess(fileService.getFullPath(fileName));
        }
    }



    /**
     * 判断是否图片文件
     *
     * @param fileName
     * @return
     */
    private boolean isImage(String fileName) {
        String lowerName = fileName.toLowerCase();
        int index = lowerName.lastIndexOf(".");
        if (index < 1) {
            return false;
        }
        String postfix = fileName.substring(index + 1);
        if (imgPostfix.contains(postfix)) {
            return true;
        }
        return false;
    }
}
