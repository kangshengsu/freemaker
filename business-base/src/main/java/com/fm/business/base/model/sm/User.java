package com.fm.business.base.model.sm;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fm.framework.core.model.AuditStatusBaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author hubo
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sm_user")
public class User extends AuditStatusBaseModel implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 员工编号
     */
    private String code;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 头像链接
     */
    private String avatarHref;

    /**
     * 组织ID
     */
    private Long orgId;

    /**
     * 组织
     */
    private transient Org org;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 备注
     */
    private String memo;

    /**
     * 账号信息
     */
    private transient Account account;

    /**
     * 角色信息
     */
    private transient List<Role> roles;


}
