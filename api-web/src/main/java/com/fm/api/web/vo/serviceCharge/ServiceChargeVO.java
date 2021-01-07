package com.fm.api.web.vo.serviceCharge;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/7 11:28
 */
@Data
public class ServiceChargeVO extends VO implements Serializable {
    private static final long serialVersionUID = -1610383778460117523L;

    /**
     * 人才服务费标准
     */
    private Integer freelancerServiceCharge;

    /**
     * 雇主服务费标准
     */
    private Integer companyServiceCharge;
}
