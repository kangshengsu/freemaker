package com.fm.api.web.vo.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fm.framework.web.VO;
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
public class LoginVO extends VO implements Serializable{

    private static final long serialVersionUID = 1L;


    /**
     * 编码
     **/
    @NotBlank(message = "用户编码不能为空")
    private String username;

    /**
     * 密码
     **/
    @NotBlank(message = "密码不能为空")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * token
     **/
    private String token;

    /**
     * roles
     **/
    private String[] roles;

    /**
     * name
     **/
    private String name;

    /**
     * avatar
     **/
    private String avatar;

    /**
     * introduction
     **/
    private String introduction;
}
