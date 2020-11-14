package com.fm.business.base.model.sm;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fm.framework.core.model.AuditStatusBaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author hubo
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sm_role")
public class Role extends AuditStatusBaseModel {

    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 备注
     */
    private String memo;

    /**
     * 关联菜单
     * */
    private transient List<Long> menuIds;


}
