package com.fm.business.base.service.sm;

import com.fm.business.base.model.sm.RoleUser;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * <p>角色用户关联服务</p>
 *
 * @author hubo
 */
public interface IRoleUserService extends Service<RoleUser> {

    /**
     * 根据用户ID删除用户角色信息
     * @param userId 用户ID
     * @return 是否成功
     */
    boolean deleteByUserId(Long userId);
    /**
     * 根据用户ID集合删除用户角色信息
     * @param userIds 用户IDs
     * @return 是否成功
     */
    boolean deleteByUserId(List<Long> userIds);


    /**
     * 根据角色Id删除用户角色信息
     * @param roleId 角色Id
     * @return 是否成功
     */
    boolean deleteByRoleId(Long roleId);


    /**
     * 根据用户ID获取角色用户
     * @param userIds 用户ID
     * @return 角色用户
     */
    List<RoleUser> getRoleUsersByUserIds(List<Long> userIds);

    /**
     * 根据用户ID获取角色ID
     * @param roleId 用户ID
     * @return 角色ID
     */
    List<RoleUser> getRoleUsersRoleId(Long roleId);

    /**
     * 根据用户ID和角色id删除用户角色信息
     * @param userId 用户ID
     * @param roleId 用户ID
     * @return 是否成功
     */
    boolean deleteByUserIdAndRoleId(Long userId, Long roleId);


    /**
     * 根据用户ID集合和角色id删除用户角色信息
     * @param userIds 用户ID集合
     * @param roleId 用户ID
     * @return 是否成功
     */
    boolean deleteByUserIdsAndRoleId(Long roleId, List<Long> userIds);
    /**
     * 根据角色id集合获取用户角色信息
     * @param roleIds 角色id集合
     * @return
     */
    List<RoleUser> getRoleUsersRoleIds(List<Long> roleIds);

    /**
     * 根据用户ID集合删除用户角色信息
     * @param userIds 用户IDs
     * @param roleId 角色id
     * @return 是否成功
     */
    boolean deleteByUserIdAndRoleId(Long roleId, List<Long> userIds);
}
