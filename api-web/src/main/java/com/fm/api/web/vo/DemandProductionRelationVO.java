/**
 * @filename:DemandProductionRelation 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(需求作品关系请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class DemandProductionRelationVO extends VO implements Serializable {

	private static final long serialVersionUID = 1599835185585L;
	


    /**
    * 订单号
    **/
	private String orderCode;


    /**
    * 关系状态
    **/
	private Integer status;


    /**
    * 作品编码
    **/
	private String productionCode;


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
	private String createUser;


    /**
    * 修改人
    **/
	private String updateUser;






}
