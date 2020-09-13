/**
 * @filename:DemandInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(需求请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class DemandInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1599835185585L;
	


    /**
    * 需求编码
    **/
	private String code;


    /**
    * 发布用户编码
    **/
	private String employerCode;


    /**
    * 需求状态（10-未发布，20-已发布，30-已取消，40-已下单）
    **/
	private Integer status;


    /**
    * 需求类型
    **/
	private Long jobCode;


    /**
    * 需求类型
    **/
	private Long treeCode;


    /**
    * 期望交付时间
    **/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date expectDeliveryTime;


    /**
    * 预算
    **/
	private Double budget;


    /**
    * 推荐人数
    **/
	private Integer recommendCount;


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
    * 需求概括
    **/
	private String summarize;


    /**
    * 需求详细描述
    **/
	private String description;


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
