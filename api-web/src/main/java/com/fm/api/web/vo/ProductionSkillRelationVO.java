/**
 * @filename:ProductionSkillRelation 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo;

import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(作品技能关系请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class ProductionSkillRelationVO extends VO implements Serializable {

	private static final long serialVersionUID = 1599835185585L;
	


    /**
    * 作品编码
    **/
	private String productionCode;


    /**
    * 技能编码
    **/
	private String skillCode;


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




}
