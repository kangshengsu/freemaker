package com.fm.framework.core.model;

import java.util.Date;

/**
 * 审计接口
 * @author clufeng
 * @version 1.0.0
 **/
public interface IAudit {

    /**
     * 获取创建时间
     * @return 创建时间
     */
    Date getCreateTime();

    /**
     * 设置创建时间
     * @param createTime 创建时间
     */
    void setCreateTime(Date createTime);

    /**
     * 获取更新时间
     * @return 更新时间
     */
    Date getUpdateTime();

    /**
     * 设置更新时间
     * @param updateTime 更新时间
     */
    void setUpdateTime(Date updateTime);

    /**
     * 获取创建人
     * @return 创建人ID
     */
    Long getCreateUser();


    /**
     * 设置创建人
     * @param createUser 创建人ID
     */
    void setCreateUser(Long createUser);



    /**
     * 获取更新用户
     * @return 更新用户
     */
    Long getUpdateUser();


    /**
     * 设置更新人
     * @param updateUser 更新人ID
     */
    void setUpdateUser(Long updateUser);



}


