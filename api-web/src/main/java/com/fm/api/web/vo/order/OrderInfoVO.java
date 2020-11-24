/**
 * @filename:OrderInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.web.vo.order;

import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.model.order.OrderOperateInfo;
import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class OrderInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;
	


    /**
    * 订单编码
    **/
	private String code;

	/**
	 * 作品id
	 */
	private Long productionId;

    /**
    * 需求类型
    **/
	private Long jobCateId;
	/**
	 * 需求类型
	 **/
	private String jobCateName;

    /**
    * 需求类型
    **/
	private String cateTreeCode;


    /**
    * 订单状态（10-初始态 20-已拒单 30-已接单 40-已支付 50-服务中 60-待验收 70-已完成 80-已评价）
    **/
	private Integer status;

	/**
	 * 预算计算方式(0-时薪  1-一口价  2-面谈)
	 */
	private Integer budgetType;

	/**
	 * 订单状态（10-初始态 20-已拒单 30-已接单 40-已支付 50-服务中 60-待验收 70-已完成 80-已评价）
	 **/
	private String statusName;


    /**
    * 订单金额
    **/
	private Double orderMny;

	/**
	 * 订单单价
	 **/
	private Double orderPrice;

	/**
	 * 订单数量
	 **/
	private Double orderTimes;

    /**
    * 期望交付时间
    **/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date expectDeliveryTime;


    /**
    * 实际交付时间
    **/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date actDeliverTime;

	/**
	 * 订单概括
	 **/
	private String summarize;


	/**
	 * 订单详细描述
	 **/
	private String description;

	/**
	 * 需求编码
	 **/
	private Long demandId;

	/**
	 * 需求描述
	 **/
	private String demandSummarize;

	/**
	 * 需求执行人
	 **/
	private Long freelancerId;
	/**
	 * 需求执行人
	 **/
	private String freelancerName;


	/**
	 * 需求提出人
	 **/
	private Long employerId;
	/**
	 * 需求提出人
	 **/
	private String employerName;

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
	 * 订单详情信息
	 */
	private OrderInfoDetail orderInfoDetail;

    /**
    * 创建人
    **/
	private Long createUser;


    /**
    * 修改人
    **/
	private Long updateUser;

	private List<OrderOperateInfoVO> orderOperateInfos;

}
