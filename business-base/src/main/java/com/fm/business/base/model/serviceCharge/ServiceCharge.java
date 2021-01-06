package com.fm.business.base.model.serviceCharge;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/6 11:00
 */
@Data
public class ServiceCharge extends BaseModel implements IAudit, Serializable {
    private static final long serialVersionUID = 4769349041193133646L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 人才服务费
     */
    private Integer freelancerServiceCharge;

    /**
     * 企业服务费
     */
    private Integer companyServiceCharge;

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
