/**
 * @filename:ProductionInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.web.vo;

import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**   
 * @Description:(作品请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class ProductionInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1599835185585L;
	


    /**
    * 作品编码
    **/
	private String code;


    /**
    * 发布用户编码
    **/
	private String freelancerCode;


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
    * 所属领域
    **/
	private String jobCode;


    /**
    * 技能全路径
    **/
	private String treeCode;


    /**
    * 创建时间
    **/
	private Date createTime;


    /**
    * 修改时间
    **/
	private Date updateTime;


    /**
    * 创建人
    **/
	private String createUser;


    /**
    * 修改人
    **/
	private String updateUser;


    /**
    * 删除标记（0-否，1-是）
    **/
	private Integer isDeleted;




}
