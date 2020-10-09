/**
 * @filename:OrderInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.gw.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.api.gw.vo.evaluation.EvaluationInfoVO;
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
    * 订单状态（10-初始态 20-已拒单 30-已接单 40-已支付 50-制作中 60-待验收 70-已完成 80-已评价）
    **/
	private Integer status;

	private String statusName;

	private Integer statusStep;

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
	private FreelancerInfoAppVO freelancer;


    /**
    * 需求提出人
    **/
	private Long employerId;

	/**
	 * 需求提出人姓名
	 */
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

	private List<String> attachmentList;

	private Boolean canChargeback;

	EvaluationInfoVO evaluationInfoVO;
}
