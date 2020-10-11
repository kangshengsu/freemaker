/**
 * @filename:OrderInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.gw.vo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	 * 创建时间
	 **/
	private Date createTime;

	/**
	 * 附件
	 */
	private List<AttachmentVO> images;



}
