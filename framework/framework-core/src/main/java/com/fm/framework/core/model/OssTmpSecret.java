package com.fm.framework.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 临时秘钥
 * @author zhangleqi
 * @date 2020-09-18 11:27 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OssTmpSecret {

    /**
     * 临时密钥 Id，可用于计算签名
     */
    private String tmpSecretId;
    /**
     * 临时密钥 Key，可用于计算签名
     */
    private String tmpSecretKey;

    /**
     * 请求时需要用的 token 字符串，最终请求 COS API 时，需要放在 Header 的 x-cos-security-token 字段
     */
    private String sessionToken;

    /**
     * 桶名称
     */
    private String bucketName;

    /**
     * 区域名称
     */
    private String region;
}
