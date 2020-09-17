/**
 * @filename:SysBaseDict 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model.sys;

import com.fm.framework.core.model.BaseModel;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(基础字典实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class SysBaseDict extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1600351931385L;
	
    /**
    * 主键ID
    **/
	private Long id;


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
     * 获取主键方法，主键整体平台定义成Long数据类型，方便数据的整体插入性能
     *
     * @return 主键
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * 设置模型主键
     *
     * @param id 主键
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
