/**
 * @filename:DemandProductionRelation 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.web.vo.demand;

import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @Description:(需求作品关系请求实体类)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Data
public class DemandProductionRelationVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;



	/**
	 * 需求号
	 **/
	private Long demandId;

	/**
	 * 订单编号
	 **/
	private Long orderId;

	/**
	 * 关系状态
	 **/
	private Integer status;


	/**
	 * 作品编码
	 **/
	private Long productionId;

	/**
	 * 作品名称
	 **/
	private String productionName;

	/**
	 * 作者姓名
	 */
	private String freelancerName;

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
