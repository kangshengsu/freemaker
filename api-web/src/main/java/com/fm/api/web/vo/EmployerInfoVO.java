/**
 * @filename:EmployerInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo;

import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(雇佣者信息请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class EmployerInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1599835185585L;
	


    /**
    * 雇佣者编码
    **/
	private String code;


    /**
    * 雇佣者姓名
    **/
	private String name;


    /**
    * 关联账户(微信登录认证)
    **/
	private String accountCode;


    /**
    * 省份编码
    **/
	private String provinceCode;


    /**
    * 城市编码
    **/
	private String cityCode;


    /**
    * 区编码
    **/
	private String districtCode;


    /**
    * 县编码
    **/
	private String countyCode;


    /**
    * 手机号
    **/
	private String phone;


    /**
    * 创建时间
    **/
	private Date createTime;


    /**
    * 修改时间
    **/
	private Date updateTime;


    /**
    * 创建人
    **/
	private String createUser;


    /**
    * 修改人
    **/
	private String updateUser;





}
