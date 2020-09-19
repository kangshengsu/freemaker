/**
 * @filename:SysBaseDict 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo.sys;

import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**   
 * @Description:(数据字典请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class SysBaseDictVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;
	


    /**
    * 分类名称
    **/
	private String name;


    /**
    * 分类编号
    **/
	private String code;


    /**
    * 备注
    **/
	private String memo;


    /**
    * 与id进行关联
    **/
	private Integer parentId;


    /**
    * 节点级别
    **/
	private Integer nodeLevel;


    /**
    * 类型分类
    **/
	private Integer belongGroup;


    /**
    * 排序值
    **/
	private Integer orderNum;


    /**
    * 创建人ID
    **/
	private Long createUser;


    /**
    * 修改人ID
    **/
	private Long updateUser;


    /**
    * 创建时间
    **/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;


    /**
    * 更新时间
    **/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;








}
