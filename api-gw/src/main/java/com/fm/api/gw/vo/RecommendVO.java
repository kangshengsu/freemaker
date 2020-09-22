/**
 * @filename:DemandProductionRelation 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.gw.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**   
 * @Description:(需求作品关系请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class RecommendVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;

	/**
	 * 作品编码
	 **/
	private String code;


	/**
	 * 发布用户编码
	 **/
	private Long freelancerId;

	/**
	 * 自由职业者
	 */
	private FreelancerInfo freelancerInfo;

	/**
	 * 作品标题
	 **/
	private String title;


	/**
	 * 技能描述
	 **/
	private String summarize;


	/**
	 * 时薪
	 **/
	private BigDecimal hourlyWage;


	/**
	 * 状态（10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除）
	 **/
	private Integer status;

	/**
	 * 状态（10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除）
	 **/
	private String statusName;

	/**
	 * 所属领域
	 **/
	private Long jobCateId;

	/**
	 * 所属领域 + 岗位数据路径
	 **/
	private String jobCateName;

}
