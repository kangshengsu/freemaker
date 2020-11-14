package com.fm.framework.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 支持审计模型
 * @author clufeng
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AuditBaseModel extends BaseModel implements IAudit {


    /**
     * 创建人ID
     **/
    private Long createUser;


    /**
     * 修改人ID
     **/
    private Long updateUser;


    /**
     * 创建时间
     **/
    private Date createTime;


    /**
     * 更新时间
     **/
    private Date updateTime;

}
