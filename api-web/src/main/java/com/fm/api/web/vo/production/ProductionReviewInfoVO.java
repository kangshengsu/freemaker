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

import javax.validation.constraints.NotBlank;
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

	private static final long serialVersionUID = 1599835185585L;
	


    /**
    * 作品编码
    **/
	@NotBlank(message = "作品编码不能为空")
	private String productionCode;


    /**
    * 审核人
    **/
	private String reviewerCode;


    /**
    * 审核意见
    **/
	@NotBlank(message = "审核意见不能为空")
	private String reviewerOpinion;


    /**
    * 状态（10-未审核，20-审核未通过，30-审核通过）
    **/
	private Integer status;


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
	private String createUser;


    /**
    * 修改人
    **/
	private String updateUser;





}
