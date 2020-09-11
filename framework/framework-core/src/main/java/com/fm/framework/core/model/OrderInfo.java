/**
 * @filename:OrderInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.model;

import com.fm.framework.core.model.BaseModel;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(订单信息实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class OrderInfo extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1599831722595L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 订单编码
    **/
	private String code;


    /**
    * 需求类型
    **/
	private Long jobCode;


    /**
    * 需求类型
    **/
	private Long treeCode;


    /**
    * 订单状态（10-初始态 20-已拒单 30-已接单 40-已支付 50-制作中 60-待验收 70-已完成 80-已评价）
    **/
	private Integer status;


    /**
    * 订单金额
    **/
	private Double orderMny;


    /**
    * 期望交付时间
    **/
	private Date expectDeliveryTime;


    /**
    * 实际交付时间
    **/
	private Date actDeliverTime;


    /**
    * 需求编码
    **/
	private String demandCode;


    /**
    * 需求执行人
    **/
	private String freelancer;


    /**
    * 需求提出人
    **/
	private String employer;


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
