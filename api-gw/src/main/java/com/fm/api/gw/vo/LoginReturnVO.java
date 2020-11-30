package com.fm.api.gw.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录返回信息
 */
@Getter
@Setter
public class LoginReturnVO {

    /**
     * 生成的登录唯一码
     */
    private String userToken;

    /**
     * 是否存在手机号
     */
    private boolean hasPhone;

    /**
     * 返回用户Id
     */
    private Long userId;
}
