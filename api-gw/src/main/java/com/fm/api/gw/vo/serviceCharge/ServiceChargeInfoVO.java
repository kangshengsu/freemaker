package com.fm.api.gw.vo.serviceCharge;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/6 11:04
 */
@Data
public class ServiceChargeInfoVO extends VO implements Serializable {
    private static final long serialVersionUID = -6986588520528581613L;

    /**
     *人才服务费标准
     */
    private String freelancerServiceCharge;

    /**
     * 企业服务费标准
     */
    private String companyServiceCharge;

}
