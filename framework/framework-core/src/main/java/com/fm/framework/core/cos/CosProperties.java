package com.fm.framework.core.cos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(
        prefix = "spring.cos"
)
@Data
public class CosProperties {
    /**
     * 应用
     */
    private int appId;
    /**
     * 秘钥ID
     */
    private String secretId;
    /**
     * 秘钥key
     */
    private String secretKey;
    /**
     * 桶名称
     */
    private String bucketName;
    /**
     * 区域
     */
    private String region;
    /**
     * 前缀:howwork-1301749332
     */
    private String prefix;
    /**
     * 中缀: cos
     */
    private String midfix;
    /**
     * 后缀: myqcloud.com
     *
     * 例:
     * 整体url: https://howwork-1301749332.cos.ap-beijing.myqcloud.com
     */
    private String suffix;

    /**
     * cdn地址
     */
    private String cdnUrl;
}
