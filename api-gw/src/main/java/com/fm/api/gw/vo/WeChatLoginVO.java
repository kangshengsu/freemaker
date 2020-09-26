package com.fm.api.gw.vo;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;


@Data
public class WeChatLoginVO extends VO implements Serializable {

    /**
     * 昵称(名称)
     */
    private String nickName;

    /**
     * 语言
     */
    private String language;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 县
     */
    private String county;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 用户性别 0-女 1-男
     */
    private String gender;

    //加密相关
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
//
//    /**
//     * 签名
//     */
//    private String signature;
//
//    /**
//     * 用于对比解密的可公开数据
//     */
//    private String rawData;

}
