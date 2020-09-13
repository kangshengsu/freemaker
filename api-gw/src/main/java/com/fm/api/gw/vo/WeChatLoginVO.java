package com.fm.api.gw.vo;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;


@Data
public class WeChatLoginVO  extends VO implements Serializable {
    
    private String encryptedData;
    
    private String iv;
    
    private String code;
    
    private String signature;
    
    private String rawData;
    
    private Integer userType;
    
    private String tenantCode;
    /**已有用户的编号 新登录用户在code换sessionKey时会生成*/
    
    private String userNo;
    
    private Long userId;
}
