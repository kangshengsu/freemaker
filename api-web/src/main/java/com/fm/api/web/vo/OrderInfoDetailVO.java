/**
 * @filename:OrderInfoDetail 2020年09月11日
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
 * @Description:(订单详情请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class OrderInfoDetailVO extends VO implements Serializable {

	private static final long serialVersionUID = 1599835185585L;
	


    /**
    * 订单码
    **/
	private String orderCode;


    /**
    * 需求省份编码
    **/
	private String provinceCode;


    /**
    * 需求城市编码
    **/
	private String cityCode;


    /**
    * 需求区编码
    **/
	private String districtCode;


    /**
    * 需求县编码
    **/
	private String countyCode;


    /**
    * 订单概括
    **/
	private String summarize;


    /**
    * 订单详细描述
    **/
	private String description;


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
