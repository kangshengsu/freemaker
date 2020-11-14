package com.fm.business.base.model.sm;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fm.framework.core.model.AuditStatusBaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hubo
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sm_account")
public class Account extends AuditStatusBaseModel {

    /**
     * ID
     */
    private Long id;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 用户实体
     */
    private transient User user;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}