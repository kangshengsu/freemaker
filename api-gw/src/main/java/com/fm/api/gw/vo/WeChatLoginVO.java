package com.fm.api.gw.vo;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;


@Data
public class WeChatLoginVO extends VO implements Serializable {

    /**
     * 加密数据
     */
    private String encryptedData;

    /**
     * 用于加密计算的向量
     */
    private String iv;

    /**
     * 登录凭证
     */
    private String code;

    /**
     * 签名
     */
    private String signature;

    /**
     * 用于对比解密的可公开数据
     */
    private String rawData;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 语言
     */
    private String language;

    private String province;

    private String city;

    private String district;

    private String county;

    /**
     * 用户头像
     */
    private String avatarUrl;
    /**
     * 用户性别 0-女 1-男
     */
    private String gender;

}
