package com.fm.business.base.model.demand;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/12 10:59
 */
@Data
public class DemandRemarkInfo extends BaseModel implements Serializable, IAudit {
    private static final long serialVersionUID = 616857482949813093L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 需求主键
     */
    private Long demandId;

    /**
     * 备注信息
     */
    private String remarkInfo;


    /**
     * 下次联系时间
     */
    private Date nextTime;

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
