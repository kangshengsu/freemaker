package com.fm.api.gw.vo.order;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/6 15:27
 */
@Data
public class OrderAmountVO extends VO implements Serializable {
    private static final long serialVersionUID = 2053256964866516542L;

    /**
     * 订单主键
     */
    private Long orderId;

    /**
     * 人才收费标准
     */
    private String freelancerServiceCharge;

    /**
     * 雇主收费标准
     */
    private String employerServiceCharge;

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
}
