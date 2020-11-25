/**
 * @filename:OrderInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model.order;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;
import org.springframework.data.annotation.Transient;

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
public class OrderInfo extends BaseModel implements Serializable,IAudit {

	private static final long serialVersionUID = 1600497555102L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 订单编码
    **/
	private String code;

    /**
     * 作品Id
     */
    private Long productionId;

    /**
    * 需求类型
    **/
	private Long jobCateId;


    /**
    * 需求类型
    **/
	private String cateTreeCode;


    /**
    * 订单状态（10-初始态 20-已拒单 30-已接单 40-已支付 50-服务中 60-待验收 70-已完成 80-已评价）
    **/
	private Integer status;

    /**
     * 预算计算方式(0-时薪  1-一口价  2-面谈)
     */
    private Integer budgetType;


    /**
     * 订单金额
     **/
    private Double orderMny;
    /**
     * 订单金额
     **/
    private Double actOrderMny;

    /**
     * 订单单价
     **/
    private Double orderPrice;
    /**
     * 订单数量
     **/
    private Double orderTimes;


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
	private Long demandId;


    /**
    * 需求执行人
    **/
	private Long freelancerId;


    /**
    * 需求提出人
    **/
	private Long employerId;


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
    * 是否上传支付凭证
    **/
	private Integer isUploadVoucher;

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
