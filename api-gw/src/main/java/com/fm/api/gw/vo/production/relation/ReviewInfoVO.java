/**
 * @filename:ProductionReviewInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.gw.vo.production.relation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(作品审核请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ReviewInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497955102L;
	

    /**
    * 审核意见
    **/
	private String reviewerOpinion;


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



}
