package com.fm.framework.core.cos;

import com.fm.framework.core.service.StorageService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

/**
 * 腾讯cos文件操作
 * @author zhangleqi
 * @date 2020/9/13
 */
@Service("cosServiceImpl")
public class CosServiceImpl implements StorageService {

    @Autowired
    private COSClient cosClient;

    @Autowired
    private CosProperties cosProperties;

    @Override
    public String upload(String path, byte[] bytes) {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(bytes.length);
        objectMetadata.setContentType("image/jpeg");
        PutObjectResult putObjectResult =cosClient.putObject(cosProperties.getBucketName(),path,inputStream,
                objectMetadata);
        return null;
    }

    @Override
    public String upload(String patch, String fileName, File file) {
        return null;
    }

    @Override
    public void download() {

    }
}
