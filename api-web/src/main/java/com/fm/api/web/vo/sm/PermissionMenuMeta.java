package com.fm.api.web.vo.sm;

import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * <p>授权菜单元数据</p>
 *
 * @author hubo
 */
@Data
public class PermissionMenuMeta {

    private String title;

    private String icon = "tree-table";

    private List<String> roles;

    private boolean hidden;

    private String component;

//    private boolean alwaysShow;

    private String productCode;

    private String menuCode;

    private String helpUrl;

    public void setIcon(String icon) {
        if(Objects.isNull(icon) || icon.trim().length() == 0) {
            return;
        }
        this.icon = icon;
    }
}
