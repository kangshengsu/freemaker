package com.fm.framework.core.cos;

import com.fm.framework.core.exception.OssException;
import com.fm.framework.core.model.CosTmpSecret;
import com.fm.framework.core.service.StorageService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.tencent.cloud.CosStsClient;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;

/**
 * 腾讯cos文件操作
 *
 * @author zhangleqi
 * @date 2020/9/13
 */
@Slf4j
@Service("cosServiceImpl")
public class CosServiceImpl implements StorageService {

    @Autowired
    private COSClient cosClient;

    @Autowired
    private CosProperties cosProperties;

    /**
     * 解析的凭证标识
     */
    private static final String CREDENTIALS = "credentials";
    /**
     * 解析的临时密钥Id标识
     */
    private static final String TMP_SECRET_ID = "tmpSecretId";
    /**
     * 解析的临时密钥Key标识
     */
    private static final String TMP_SECRET_KEY = "tmpSecretKey";
    /**
     *  解析的请求时需要用的token标识
     */
    private static final String SESSION_TOKEN = "sessionToken";

    /**
     * 解析临时密匙
     *
     * @return
     */
    @Override
    public CosTmpSecret getTmpSecret() {
        CosTmpSecret cosTmpSecret;
        TreeMap<String, Object> config = new TreeMap<>();
        try {
            config.put("SecretId", cosProperties.getSecretId());
            config.put("SecretKey", cosProperties.getSecretKey());
            // 临时密钥有效时长，单位是秒，默认1800秒，目前主账号最长2小时（即7200秒），子账号最长36小时（即129600秒）
            config.put("durationSeconds", 1800);
            // 换成您的 bucket
            config.put("bucket", cosProperties.getBucketName());
            // 换成 bucket 所在地区
            config.put("region", cosProperties.getRegion());
            // 这里改成允许的路径前缀，可以根据自己网站的用户登录态判断允许上传的具体路径，例子：a.jpg 或者 a/* 或者 * 。
            // 如果填写了“*”，将允许用户访问所有资源；除非业务需要，否则请按照最小权限原则授予用户相应的访问权限范围。
            config.put("allowPrefix", "*");
            // 密钥的权限列表。简单上传、表单上传和分片上传需要以下的权限，其他权限列表请看 https://cloud.tencent.com/document/product/436/31923
            String[] allowActions = new String[]{
                    // 简单上传
                    "name/cos:PutObject",
                    // 表单上传、小程序上传
                    "name/cos:PostObject",
                    // 分片上传
                    "name/cos:InitiateMultipartUpload",
                    "name/cos:ListMultipartUploads",
                    "name/cos:ListParts",
                    "name/cos:UploadPart",
                    "name/cos:CompleteMultipartUpload"
            };
            config.put("allowActions", allowActions);
            JSONObject resultObject = CosStsClient.getCredential(config);
            cosTmpSecret = this.parseSecret(resultObject);
        } catch (IOException ioException) {
            log.error("获取腾讯云存储临时密匙失败:", ioException);
            throw new OssException(OssException.CONNECT_FAILURE, "获取云存储密匙失败");
        }
        log.debug("获取腾讯云存储临时密匙为:{}", cosTmpSecret);
        return cosTmpSecret;
    }

    @Override
    public String upload(String path, byte[] bytes) {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(bytes.length);
        objectMetadata.setContentType("image/jpeg");
        PutObjectResult putObjectResult = cosClient.putObject(cosProperties.getBucketName(), path, inputStream,
                objectMetadata);
        return null;
    }

    @Override
    public String upload(String patch, String fileName, File file) {
        // TODO: 2020/9/19
        return null;
    }

    @Override
    public void download() {
        // TODO: 2020/9/19
    }

    /**
     * 解析临时密匙
     *
     * @param jsonObject
     * @return
     */
    private CosTmpSecret parseSecret(JSONObject jsonObject) {
        if (jsonObject == null) {
            throw new OssException(OssException.CONNECT_FAILURE, "获取云存储密匙失败");
        }
        CosTmpSecret cosTmpSecret = new CosTmpSecret();
        JSONObject credentials = (JSONObject) jsonObject.get(CREDENTIALS);
        cosTmpSecret.setTmpSecretId((String) credentials.get(TMP_SECRET_ID));
        cosTmpSecret.setTmpSecretKey((String) credentials.get(TMP_SECRET_KEY));
        cosTmpSecret.setSessionToken((String) credentials.get(SESSION_TOKEN));
        return cosTmpSecret;
    }
}
