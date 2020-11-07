package com.fm.business.base.service.sm;


import com.fm.business.base.model.sm.Role;
import com.fm.framework.core.service.Service;

import java.util.List;
import java.util.Map;

/**
 * 角色服务
 * @author hubo
 * @version 1.0.0
 **/
public interface IRoleService extends Service<Role> {

    Map<Long, List<Role>> getUserRoleMap(List<Long> userIds);

    List<Role> getUserRoles(List<Long> userIds);

    List<Role> getUserRoles(Long userId);

    Role getRoleByCode(String code);

    /**
     * 更新角色的权限信息
     * @param role 角色
     * @return 成功or失败
     */
    boolean updatePermissionMenu(Role role);
    /**
     * 查找菜单关联角色
     * */
    List<Role> getAllByMenuId(Long menuId);

    /**
     * 通过编码查询有效
     * */
    Role getEnableOneByCode(String code);
}
