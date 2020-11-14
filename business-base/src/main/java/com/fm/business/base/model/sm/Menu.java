package com.fm.business.base.model.sm;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fm.framework.core.model.AuditBaseModel;
import com.fm.framework.core.model.AuditStatusBaseModel;
import com.fm.framework.core.model.IStatus;
import com.fm.framework.core.model.ITreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hubo
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sm_menu")
public class Menu extends AuditStatusBaseModel implements IStatus , ITreeNode {


    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * tree code
     */
    private String incode;
    /**
     * 父级ID
     */
    private Long parentId;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 链接
     */
    private String href;
    /**
     * icon
     */
    private String icon;

    /**
     * 对应的组件类型
     */
    private String component;
    /**
     * 顺序
     */
    private Integer sq;
    /**
     * 状态
     */
    private Integer status;

    @Override
    public Long getNodeId() {
        return id;
    }

    @Override
    public String getParentCode() {
        return null;
    }
}
