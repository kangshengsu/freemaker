package com.fm.api.web.vo.sm;

import com.fm.framework.core.model.ITreeNode;
import com.fm.framework.web.VO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 组织VO.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrgVO extends VO implements ITreeNode {

    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 内码
     */
    private String incode;
    /**
     * 父级ID
     */
    private Long parentId;

    private String parentName;

    /**
     * 父级编码
     */
    private String parentCode;

    /**
     * 状态
     */
    private Integer status;
    /**
     * 排序
     */
    private Integer sq;

    /**
     * 备注
     */
    private String memo;
    /**
     * 组织类型id
     * */
    private Integer type;

    /**
     * 时间戳
     */
    private LocalDateTime ts;

    private List<OrgVO> children;

    private boolean hasChildren = true;
    /**
     * 负责人
     * */
    private String principal;

    /**
     * 电话
     * */
    private String phone;


    @Override
    public Long getNodeId() {
        return getId();
    }
}
