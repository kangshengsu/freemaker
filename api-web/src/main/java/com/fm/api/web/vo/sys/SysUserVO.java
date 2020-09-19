/**
 * @filename:SysUser 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo.sys;

import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
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

	private static final long serialVersionUID = 1600497555102L;
	


    /**
    * 编码
    **/
	private String code;


    /**
    * 名字
    **/
	private String name;


    /**
    * 
    **/
	private String password;


    /**
    * 
    **/
	private String phone;


    /**
    * 最近登录时间
    **/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date lastLoginTime;


    /**
    * 创建时间
    **/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;








}
