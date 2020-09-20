/**
 * @filename:OrderInfoDetail 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo.order;

import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
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

	private static final long serialVersionUID = 1600497555102L;
	


    /**
    * 订单码
    **/
	private Long orderId;


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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;


    /**
    * 修改时间
    **/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;


    /**
    * 创建人
    **/
	private Long createUser;


    /**
    * 修改人
    **/
	private Long updateUser;








}
