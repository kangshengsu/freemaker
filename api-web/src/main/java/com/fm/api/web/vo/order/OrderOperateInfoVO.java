/**
 * @filename:OrderInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.order.OrderOperateInfo;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**   
 * @Description:(订单信息请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class OrderOperateInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;

	/**
	 * 逻辑主键
	 **/
	private Long id;


	/**
	 * 订单编码
	 **/
	private Long orderId;

	/**
	 * 操作类型
	 **/
	private Integer operateType;
	private String operateTypeName;

	/**
	 * 操作人
	 **/
	private Long operateUser;
	private String operateUserName;


	/**
	 * 接收人
	 **/
	private Long receiveUser;
	private String receiveUserName;

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

	/**
	 * 操作描述
	 */
	private String description;

	private List<AttachmentInfo> attachmentInfos;
}
