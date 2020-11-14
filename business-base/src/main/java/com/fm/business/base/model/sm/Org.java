package com.fm.business.base.model.sm;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fm.framework.core.model.AuditStatusBaseModel;
import com.fm.framework.core.model.ITreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组织
 * @author clufeng
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sm_org")
public class Org extends AuditStatusBaseModel implements ITreeNode {
    /**
     * ID
     */
    private Long id;
    /**
     * 组织名称
     */
    private String name;
    /**
     * 组织编码
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
     * 负责人
     */
    private String principal;

    /**
     * 负责人电话
     */
    private String phone;

    /**
     * 排序
     */
    private Integer sq;

    /**
     * 备注信息
     */
    private String memo;

    @Override
    public Long getNodeId() {
        return id;
    }

    @Override
    public String getParentCode() {
        return null;
    }
}
