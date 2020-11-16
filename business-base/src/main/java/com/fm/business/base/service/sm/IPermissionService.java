package com.fm.business.base.service.sm;


import com.fm.business.base.model.sm.Menu;
import com.fm.business.base.model.sm.Org;
import com.fm.business.base.model.sm.Permission;
import com.fm.business.base.model.sm.Role;
import com.fm.framework.core.service.IStatusService;
import com.fm.framework.core.service.Service;

import java.util.Collection;
import java.util.List;

/**
 * 分配权限服务
 * @author hubo
 * @version 1.0.0
 **/
public interface IPermissionService extends Service<Permission>, IStatusService<Permission> {

    /**
     * 分配权限
     * @param role 角色
     * @param menuList 菜单列表
     */
    void assign(Role role, List<Menu> menuList);

    /**
     * 删除角色赋予的菜单权限
     *
     * @param roleId  角色id
     * @param menuIds 菜单id集合
     * */
    boolean retrieve(Long roleId, Collection<Long> menuIds);


    List<Menu> getPermissions(Role role);

    List<Menu> getPermissionsByRoles(List<Role> roles);

    /**
     * 根据角色查询菜单
     * @param roleId 角色id
     * */
    List<Menu> getPermissions(Long roleId);

    List<Menu> getPermissionsByRoleIds(List<Long> roleId);

    /**
     * 通过角色id 删除权限
     * */
    void deleteByRoleId(Long roleId);

    List<Menu> getAllPermissions(Role role);

    /**
     * 获取所有菜单
     * */
    List<Menu> getAllMenuByRoleIds(List<Long> roleId);


    Menu getPermissionMenu(String menuCode);


    boolean deleteByMenus(List<Menu> menus);

}
