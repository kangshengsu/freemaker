/**
 * @filename:OrderInfoDetail 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model.order;

import com.fm.framework.core.model.BaseModel;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(订单详情实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class OrderInfoDetail extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1599831722595L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 订单码
    **/
	private String orderCode;


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
    * 订单概括
    **/
	private String summarize;


    /**
    * 订单详细描述
    **/
	private String description;


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
