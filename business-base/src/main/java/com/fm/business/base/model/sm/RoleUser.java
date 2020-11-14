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
@TableName("sm_role_user")
public class RoleUser extends AuditStatusBaseModel {

    /**
     * ID
     */
    private Long id;

    /**
     * 角色Id
     */
    private Long roleId;

    /**
     * 用户ID
     */
    private Long userId;



}
