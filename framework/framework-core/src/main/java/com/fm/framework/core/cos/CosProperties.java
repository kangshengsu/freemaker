package com.fm.framework.core.cos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(
        prefix = "spring.cos"
)
@Data
public class CosProperties {
    private int appId;
    private String secretId;
    private String secretKey;
    private String bucketName;
    private String region;
}
