/**
 * @filename:SysUser 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo;

import com.fm.framework.web.VO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(用户请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class SysUserVO extends VO implements Serializable {

	private static final long serialVersionUID = 1599898313938L;
	


    /**
    * 编码
    **/
	private String code;


    /**
    * 名字
    **/
	private String name;


    /**
    * 密码
    **/
	private String password;


    /**
    * 电话号码
    **/
	private String phone;


    /**
    * 最近登录时间
    **/
	private Date lastLoginTime;


    /**
    * 创建时间
    **/
	private Date createTime;








}
