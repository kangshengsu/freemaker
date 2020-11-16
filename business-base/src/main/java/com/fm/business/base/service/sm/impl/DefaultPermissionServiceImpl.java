package com.fm.business.base.service.sm.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.sm.IPermissionMapper;
import com.fm.business.base.model.sm.Menu;
import com.fm.business.base.model.sm.MenuType;
import com.fm.business.base.model.sm.Permission;
import com.fm.business.base.model.sm.Role;
import com.fm.business.base.service.sm.IMenuService;
import com.fm.business.base.service.sm.IPermissionService;
import com.fm.framework.core.model.DBFieldConst;
import com.fm.framework.core.model.DataStatus;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.AuditStatusBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hubo
 * @version 1.0.0
 **/
@Service("permissionService")
@RequiredArgsConstructor
public class DefaultPermissionServiceImpl extends AuditStatusBaseService<IPermissionMapper, Permission> implements IPermissionService {

    private final IMenuService menuService;

    @Override
    public void assign(Role role, List<Menu> menuList) {

        if (Objects.isNull(role) || Objects.isNull(menuList) || CollectionUtils.isEmpty(menuList)) {
            return;
        }

        List<Permission> permissions = menuList.stream().map(menu -> {
            Permission p = new Permission();
            p.setMenuId(menu.getId());
            p.setRoleId(role.getId());
            p.setStatus(DataStatus.enable.code());
            return p;
        }).collect(Collectors.toList());

        save(permissions);

    }

    /**
     * 角色关联权限
     *
     * @param role 角色
     */
    public List<Menu> getPermissions(Role role) {
        if (role == null || role.getId() == null) {
            return new ArrayList<>();
        }

        return getPermissions(role.getId());
    }

    @Override
    public List<Menu> getPermissionsByRoles(List<Role> roles) {

        if(roles.isEmpty()) {
            return Collections.emptyList();
        }

        return getPermissionsByRoleIds(roles.stream().map(Role::getId).collect(Collectors.toList()));

    }

    @Override
    public List<Menu> getPermissionsByRoleIds(List<Long> roleId) {
        if(roleId.isEmpty()) {
            return Collections.emptyList();
        }

        QueryItem roleItem = new QueryItem();

        roleItem.setType(QueryType.in);
        roleItem.setQueryField(DBFieldConst.ROLE_ID);
        roleItem.setValue(roleId);

        List<Permission> permissions = this.getEnableStatus(Collections.singletonList(roleItem));

        if (permissions.isEmpty()) {
            return new ArrayList<>();
        }

        List<Long> menuIdList = permissions.stream().map(Permission::getMenuId).collect(Collectors.toList());

        List<Menu> result = menuService.getMenus(menuIdList).stream()
                .filter(menu -> (menu.getType() == MenuType.menu.value() || menu.getType() == MenuType.catalog.value())
                        && menu.getStatus() == DataStatus.enable.code())
                .collect(Collectors.toList());

        menuService.completionParentNode(result);

        return result;

    }

    @Override
    public List<Menu> getPermissions(Long roleId) {
        return getPermissionsByRoleIds(Collections.singletonList(roleId));
    }

    /**
     * 通过角色id 删除权限
     *
     */
    @Override
    public void deleteByRoleId(Long roleId) {
        UpdateWrapper<Permission> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq(DBFieldConst.ROLE_ID, roleId);
        super.remove(updateWrapper);
    }

    @Override
    public List<Menu> getAllPermissions(Role role) {
        if(role == null || role.getId() == null) {
            return Collections.emptyList();
        }

        QueryItem roleItem = new QueryItem();

        roleItem.setType(QueryType.in);
        roleItem.setQueryField(DBFieldConst.ROLE_ID);
        roleItem.setValue(role.getId());

        List<Permission> permissions = this.getEnableStatus(Collections.singletonList(roleItem));

        if (permissions.isEmpty()) {
            return new ArrayList<>();
        }

        List<Long> menuIdList = permissions.stream().map(Permission::getMenuId).collect(Collectors.toList());
        return this.menuService.getMenus(menuIdList);
    }

    @Override
    public List<Menu> getAllMenuByRoleIds(List<Long> roleIds) {
        if(CollectionUtils.isEmpty(roleIds)) {
            return Collections.emptyList();
        }

        QueryItem roleItem = new QueryItem();

        roleItem.setType(QueryType.in);
        roleItem.setQueryField(DBFieldConst.ROLE_ID);
        roleItem.setValue(roleIds);

        List<Permission> permissions = this.getEnableStatus(Collections.singletonList(roleItem));

        if (permissions.isEmpty()) {
            return new ArrayList<>();
        }

        List<Long> menuIdList = permissions.stream().map(Permission::getMenuId).collect(Collectors.toList());

        List<Menu> result = menuService.getMenus(menuIdList).stream().filter(menu ->  menu.getStatus() == DataStatus.enable.code()).collect(Collectors.toList());

        menuService.completionParentNode(result);

        return result;
    }

    @Override
    public Menu getPermissionMenu(String menuCode) {

        Menu menu = menuService.getByCode(menuCode);

        if(menu == null) {
            return null;
        }

        Permission permission = getOne(Wrappers.lambdaQuery(Permission.class).eq(Permission::getMenuId, menu.getId()));

        if(permission != null) {
            return menu;
        }

        return null;
    }

    @Override
    public boolean deleteByMenus(List<Menu> menus) {

        UpdateWrapper<Permission> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in(DBFieldConst.MENU_ID, menus.stream().map(Menu::getId).collect(Collectors.toList()));

        return this.getBaseMapper().delete(updateWrapper) > 0;
    }


    /**
     * 删除角色赋予的菜单权限
     *
     * @param roleId    角色id
     * @param menuIds 菜单id集合
     */
    @Override
    public boolean retrieve(Long roleId, Collection<Long> menuIds) {
        if(roleId == null || CollectionUtils.isEmpty(menuIds)){
            return false;
        }

        return this.deleteByMenuIds(roleId, menuIds);
    }

    private boolean deleteByMenuIds(Long roleId, Collection<Long> menuIds) {
        UpdateWrapper<Permission> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq(DBFieldConst.ROLE_ID, roleId);
        updateWrapper.in(DBFieldConst.MENU_ID, menuIds);

        updateWrapper.set(DBFieldConst.IS_DELETE, true);

        return super.update(updateWrapper);
    }

}
