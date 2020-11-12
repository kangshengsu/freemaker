package com.fm.api.web.vo.sm;

import com.fm.business.base.model.sm.MenuComponentType;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>类描述</p>
 *
 * @author hubo
 */
@Data
public class PermissionMenuVO {

    private String path;

    private String name;

    private PermissionMenuMeta meta;

    private boolean affix = false;

    private boolean noCache = true;

    private boolean alwaysShow;

    private int sq;

    private String component;

    private List<PermissionMenuVO> children;

    private final Map<String, Object> props = new HashMap<>();

    public void addProp(String key, Object value) {
        props.put(key, value);
    }


    public boolean isAlwaysShow() {
        return !MenuComponentType.layout.value().equals(this.component);
    }
}
