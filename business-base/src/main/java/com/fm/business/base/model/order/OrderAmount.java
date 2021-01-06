package com.fm.business.base.model.order;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/6 15:18
 */
@Data
public class OrderAmount extends BaseModel implements Serializable, IAudit {
    /**
     * 主键
     */
    private Long id;

    /**
     * 订单主键
     */
    private Long orderId;

    /**
     * 人才收费标准
     */
    private Integer freelancerServiceCharge;

    /**
     * 雇主收费标准
     */
    private Integer employerServiceCharge;

    /**
     * 实际收取人才手续费
     */
    private Double freelancerActServiceCharge;

    /**
     * 实际收取雇主手续费
     */
    private Double employerActServiceCharge;

    /**
     * 人才实际到手金额
     */
    private Double freelancerActGetMny;

    /**
     * 雇主实际支付金额
     */
    private Double employerActPayMny;

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
}
