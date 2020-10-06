/**
 * @filename:OrderInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.gw.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(订单操作息请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class OrderOperateInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;

	private Long id;

	/**
	 * 订单编码
	 **/
	private Long orderId;

	/**
	 * 操作详细描述
	 **/
	private String description;

	/**
	 * 操作人
	 **/
	private Long operateUser;


	/**
	 * 接收人
	 **/
	private Long receiveUser;

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
	private Long createUser;


    /**
    * 修改人
    **/
	private Long updateUser;

}
