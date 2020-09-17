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
import java.util.Date;
import java.util.List;

/**   
 * @Description:(基础字典请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class SysBaseDictVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600351931385L;
	


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
	private Long createUserCode;


    /**
    * 修改人ID
    **/
	private Long updateUserCode;


    /**
    * 创建时间
    **/
	private Date createTime;


    /**
    * 更新时间
    **/
	private Date updateTime;


	/**
	 *	子级数据
	 */
	private List<SysBaseDictVO> children;





}
