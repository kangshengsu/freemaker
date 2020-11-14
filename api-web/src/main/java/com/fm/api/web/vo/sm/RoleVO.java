package com.fm.api.web.vo.sm;

import com.fm.framework.web.VO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * 角色.
 */
@Data
public class RoleVO extends VO {

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
     * 菜单
     * */
    private List<MenuVO> menus;

    /**
     * 时间戳
     */
    private LocalDateTime ts;

    private List<Long> menuIds = Collections.emptyList();

    private List<UserTableVO> users;

    private Integer status;


    @Override
    public String toString() {
        return "RoleVO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", memo='" + memo + '\'' +
                ", menus=" + menus +
                ", ts=" + ts +
                ", menuIds=" + menuIds +
                "} " + super.toString();
    }
}
