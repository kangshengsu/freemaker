/**
 * @filename:OrderInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.gw.vo.order;

import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.framework.web.VO;
import lombok.Data;

import javax.validation.constraints.NotNull;
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

    public interface UploadPayAttachment { }

	/**
	 * 操作id
	 */
	private Long id;

	/**
	 * 订单编码
	 **/
    @NotNull(message = "订单id不能为空",groups = {UploadPayAttachment.class})
    private Long orderId;

	/**
	 * 操作详细描述
	 **/
	private String description;

	/**
	 * 操作类型
	 **/
	private Integer operateType;

	/**
	 * 操作人
	 **/
	private Long operateUser;
	private String operateUserName;

	/**
	 * 创建时间
	 **/
	private Date createTime;

	/**
	 * 附件
	 */
   // @NotEmpty(message = "支付凭证附件列表不能为空",groups = {UploadPayAttachment.class})
    private List<AttachmentVO> images;



}
