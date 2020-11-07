package com.fm.business.base.service.sm.impl;

import com.fm.business.base.dao.sm.IRoleMapper;
import com.fm.business.base.model.sm.Menu;
import com.fm.business.base.model.sm.Permission;
import com.fm.business.base.model.sm.Role;
import com.fm.business.base.model.sm.RoleUser;
import com.fm.business.base.service.sm.IMenuService;
import com.fm.business.base.service.sm.IPermissionService;
import com.fm.business.base.service.sm.IRoleService;
import com.fm.business.base.service.sm.IRoleUserService;
import com.fm.framework.core.model.DBFieldConst;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.AuditStatusBaseService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 默认角色服务
 * @author hubo
 * @version 1.0.0
 **/
@Service("roleService")
@RequiredArgsConstructor
public class DefaultRoleServiceImpl extends AuditStatusBaseService<IRoleMapper, Role> implements IRoleService {

    private final IRoleUserService roleUserService;
    private final IPermissionService permissionService;
    private final IMenuService menuService;

    @Override
    protected void afterSave(Role model) {
        super.afterSave(model);
        //TODO 同步SUSF 的菜单角色
    }



    @Override
    public Map<Long, List<Role>> getUserRoleMap(List<Long> userIds) {

        if(userIds.isEmpty()) {
            return Collections.emptyMap();
        }

        List<RoleUser> roleUsers = roleUserService.getRoleUsersByUserIds(userIds);

        if(roleUsers.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<Long, Role> roles = getByIds(roleUsers.stream().map(RoleUser::getRoleId).collect(Collectors.toList()))
                .stream().collect(Collectors.toMap(Role::getId, Function.identity(),(v1, v2) -> v1));

        Map<Long, List<Role>> result = new HashMap<>();

        roleUsers.forEach(roleUser -> {
            if(!result.containsKey(roleUser.getUserId())) {
                result.put(roleUser.getUserId(), new ArrayList<>());
            }
            if(roles.containsKey(roleUser.getRoleId())) {
                result.get(roleUser.getUserId()).add(roles.get(roleUser.getRoleId()));
            }
        });

        return result;

    }

       @Override
    public List<Role> getUserRoles(List<Long> userIds) {

        if(userIds.isEmpty()) {
            return Collections.emptyList();
        }

        List<RoleUser> roleUsers = roleUserService.getRoleUsersByUserIds(userIds);

        if(roleUsers.isEmpty()) {
            return Collections.emptyList();
        }

        return getByIds(roleUsers.stream().map(RoleUser::getRoleId).collect(Collectors.toList()));
    }

    @Override
    public List<Role> getUserRoles(Long userId) {
        if(Objects.isNull(userId)) {
            return Collections.emptyList();
        }
        return getUserRoles(Collections.singletonList(userId));
    }

    @Override
    public Role getRoleByCode(String code) {
        QueryItem item = new QueryItem();
        item.setQueryField(DBFieldConst.CODE);
        item.setValue(code);
        item.setType(QueryType.eq);
        return getOneFromExistSame(Collections.singletonList(item));
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class, Throwable.class}, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @Override
    public boolean save(Role role) {
        boolean save = super.save(role);
        //save pm
        savePermissionMenu(role);
        return save;
    }

    /**
     * 保存角色菜单关联关系
     * */
    private void savePermissionMenu(Role role) {
        List<Long> menuIds = role.getMenuIds();
        List<Menu> menus = menuService.getMenus(menuIds);
        menuService.completionParentNode(menus);
        permissionService.assign(role, menus);
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class, Throwable.class}, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @Override
    public boolean saveBatch(Collection<Role> roles) {
        return super.saveBatch(roles);
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class, Throwable.class}, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @Override
    public boolean delete(Role role) {
        boolean delete = super.delete(role);
        deletePermissionMenu(role);
        deleteRoleUser(role);
        return delete;
    }

    /**
     * 删除角色下用户信息
     * @param role 角色
     */
    private void deleteRoleUser(Role role) {
        roleUserService.deleteByRoleId(role.getId());
    }

    /**
     * 删除角色对应菜单
     * */
    private void deletePermissionMenu(Role role) {
        permissionService.deletByRoleId(role.getId());
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class, Throwable.class}, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @Override
    public boolean update(Role role) {
        boolean update = super.update(role);
        if(role.getMenuIds() != null) {
            updatePermissionMenu(role);
        }
        return update;
    }

    /**
     * 更新角色对应菜单
     * */
    public boolean updatePermissionMenu(Role role) {
        //现有角色对应菜单权限
        List<Long> newMenuIds = role.getMenuIds();
        List<Menu> newMenus = menuService.getByIds(newMenuIds);
        menuService.completionParentNode(newMenus);
        newMenuIds = newMenus.stream().map(Menu::getId).collect(Collectors.toList());

        //历史
        List<Menu> oldRoleMenuList = this.permissionService.getAllMenuByRoleIds(Collections.singletonList(role.getId()));
        Set<Long> oldMenuIdSet = oldRoleMenuList.stream().map(Menu::getId).collect(Collectors.toSet());

        //已收回的菜单
        Set<Long> oldMenus = Sets.difference(oldMenuIdSet, Sets.newHashSet(newMenuIds)).immutableCopy();
        Set<Long> saveMenus = Sets.difference(Sets.newHashSet(newMenuIds), oldMenuIdSet).immutableCopy();

        //删除已删掉的菜单权限
        permissionService.retrieve(role.getId(), oldMenus);

        //保存角色菜单权限
        List<Menu> menus = menuService.getMenus(Lists.newArrayList(saveMenus));

        permissionService.assign(role, menus);

        return true;
    }

    /**
     * 查找菜单关联角色
     *
     * @param menuId
     */
    @Override
    public List<Role> getAllByMenuId(Long menuId) {
        if(menuId == null){
            return Collections.emptyList();
        }

        QueryItem item = new QueryItem();
        item.setType(QueryType.eq);
        item.setQueryField(DBFieldConst.MENU_ID);
        item.setValue(menuId);

        List<Permission> permissions = permissionService.get(Collections.singletonList(item));

        List<Long> roleIdList = permissions.stream().map(Permission::getRoleId).collect(Collectors.toList());

        return this.getByIds(roleIdList);
    }

    /**
     * 通过编码查询有效
     *
     * @param code
     */
    @Override
    public Role getEnableOneByCode(String code) {
        QueryItem item = new QueryItem();
        item.setType(QueryType.eq);
        item.setQueryField(DBFieldConst.CODE);
        item.setValue(code);
        return super.getOneEnableStatus(Collections.singletonList(item));
    }


}
