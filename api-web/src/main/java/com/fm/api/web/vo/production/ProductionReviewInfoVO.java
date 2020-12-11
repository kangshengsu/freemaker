/**
 * @filename:ProductionReviewInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo.production;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(作品审核请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class ProductionReviewInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;
	


    /**
    * 作品编码
    **/
	private Long productionId;


    /**
    * 审核人
    **/
	private Long reviewerId;

	/**
	 * 审核人名称
	 */
	private String reviewerName;

    /**
    * 审核意见
    **/
	private String reviewerOpinion;

	/**
	 * 记录对自由职业者信息的修改记录
	 **/
	private Long freelancerId;

	/**
	 * 修改内容
	 **/
	private String modifyContent;


    /**
    * 状态（10-未审核，20-审核未通过，30-审核通过）
    **/
	private Integer status;

	/**
	 * 状态名称
	 */
	private String statusName;

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
