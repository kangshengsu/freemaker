/**
 * @filename:OrderInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.gw.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.api.gw.vo.employer.EmployerInfoApiVO;
import com.fm.api.gw.vo.evaluation.EvaluationInfoVO;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.order.OrderAmountVO;
import com.fm.api.gw.vo.order.OrderOperateInfoVO;
import com.fm.business.base.model.order.OrderInfoDetail;
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
public class OrderInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;

	private Long id;


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
	 * 需求类型名称
	 */
	private String jobCateName;

	/**
	 * 需求分类
	 */
	private String jobCatePath;


    /**
    * 需求类型
    **/
	private String cateTreeCode;


    /**
    * 订单状态（10-初始态 40-已支付 50-服务中 51-雇主取消 60-待验收 70-已完成 80-已评价）
    **/
	private Integer status;

	/**
	 * 订单取消审核备注
	 */
	private String auditInfo;

	private String statusName;

	private Integer statusStep;

	/**
	 * 预算计算方式(0-时薪  1-一口价  2-面谈)
	 */
	private Integer budgetType;

	/**
	 * 订单金额
	 **/
	private Double orderMny;

	/**
	 * 实付订单金额
	 **/
	private Double actOrderMny;
	/**
	 * 订单单价
	 **/
	private Double orderPrice;
	/**
	 * 订单数量
	 **/
	private Double orderTimes;

	/**
	 * 流水描述
	 */
	private String memo;

    /**
    * 期望交付时间
    **/
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date expectDeliveryTime;


    /**
    * 实际交付时间
    **/
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date actDeliverTime;


    /**
    * 需求编码
    **/
	private Long demandId;


    /**
    * 需求执行人
    **/
	private Long freelancerId;

	/**
	 * 需求执行人
	 */
	private FreelancerInfoApiVO freelancer;


    /**
    * 需求提出人
    **/
	private Long employerId;

	/**
	 * 需求提出人
	 */
	private EmployerInfoApiVO employer;

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

	/**
	 * 用户类型，区分需求提出人还是开发者
	 */
	private Integer userType;

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

	private Integer orderBelongType;

	/**
	 * 流水描述
	 */
	private String followDesc;

	private List<AttachmentVO> attachmentList;

	private Boolean canChargeback;

	/**
	 * 是否上传支付凭证
	 **/
	private Boolean isUploadVoucher;

	EvaluationInfoVO evaluationInfoVO;

	private transient OrderInfoDetail orderInfoDetail;

	/**
	 * 人才上传验收信息
	 */
	private transient List<OrderOperateInfoVO> orderOperateInfo;

	/**
	 * 服务费及实际到手金额
	 */
	private transient OrderAmountVO orderAmount;
}
