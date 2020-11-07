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
@TableName("sm_permission")
public class Permission extends AuditStatusBaseModel {

    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 备注
     */
    private String memo;

}
