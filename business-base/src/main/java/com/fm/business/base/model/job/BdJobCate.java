/**
 * @filename:BdJobCate 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model.job;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(岗位实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class BdJobCate extends BaseModel implements Serializable,IAudit {

	private static final long serialVersionUID = 1600497555102L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 
    **/
	private String cateName;


    /**
    * 
    **/
	private String cateCode;

	private String englishName;

	private String icon;


    /**
    * 
    **/
	private Integer cateType;


    /**
    * 
    **/
	private String treeCode;


    /**
    * 
    **/
	private Long parentId;


    /**
    * 
    **/
	private String parentCode;


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
	private Long createUser;


    /**
    * 修改人
    **/
	private Long updateUser;







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
