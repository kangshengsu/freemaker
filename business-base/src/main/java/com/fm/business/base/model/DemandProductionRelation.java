/**
 * @filename:DemandProductionRelation 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model;

import com.fm.framework.core.model.BaseModel;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(需求作品关系实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class DemandProductionRelation extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1599831722595L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 订单号
    **/
	private String orderCode;


    /**
    * 关系状态
    **/
	private Integer status;


    /**
    * 作品编码
    **/
	private String productionCode;


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