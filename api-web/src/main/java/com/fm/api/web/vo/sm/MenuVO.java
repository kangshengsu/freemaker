package com.fm.api.web.vo.sm;

import com.fm.framework.core.model.ITreeNode;
import com.fm.framework.web.VO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>菜单对象</p>
 *
 * @author hubo
 */
@Data
public class MenuVO extends VO implements ITreeNode {

    private String name;

    private String code;

    private String incode;

    private String href;

    private String icon;

    private String memo;

    private Long parentId;

    private String parentCode;

    private String parentName;


    private Integer sq;

    private Long productId;

    private String productCode;

    private String productName;


    private Long roleId;
    /**
     * 时间戳
     */
    private LocalDateTime ts;

    private List<MenuVO> children;

    private boolean hasChildren = true;

    private String component;

    /**
     * 菜单类型
     */
    private Integer type;

    private String helpUrl;

    private Integer status;
    /**
     * 返回当前树节点ID
     *
     * @return 树节点ID
     */
    @Override
    public Long getNodeId() {
        return getId();
    }
}
