package com.fm.api.web.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @program: freemaker-parent
 * @description: 登录API入参
 * @author: liuduo8
 * @create: 2020-09-12 17:37
 **/
@Data
public class LoginVO implements Serializable{

    private static final long serialVersionUID = 1L;


    /**
     * 编码
     **/
    @NotBlank(message = "用户编码不能为空")
    private String code;



    /**
     * 密码
     **/
    @NotBlank(message = "密码不能为空")
    private String password;
}
