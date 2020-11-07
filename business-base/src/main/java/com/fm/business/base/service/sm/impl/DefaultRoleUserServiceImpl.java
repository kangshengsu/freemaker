package com.fm.business.base.service.sm.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fm.business.base.dao.sm.IRoleUserMapper;
import com.fm.business.base.model.sm.RoleUser;
import com.fm.business.base.service.sm.IRoleUserService;
import com.fm.framework.core.model.DBFieldConst;
import com.fm.framework.core.service.AuditStatusBaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <p>默认角色用户实现类</p>
 *
 * @author hubo
 */
@Service
public class DefaultRoleUserServiceImpl extends AuditStatusBaseService<IRoleUserMapper, RoleUser> implements IRoleUserService {

    @Override
    public boolean deleteByUserId(Long userId) {

        if(Objects.isNull(userId)) {
            return false;
        }

        QueryWrapper<RoleUser> queryWrapper = getQueryWrapper(true);

        queryWrapper.eq(DBFieldConst.USER_ID, userId);

        return this.getBaseMapper().delete(queryWrapper) > 0;
    }

    @Override
    public boolean deleteByUserId(List<Long> userIds) {
        if(Objects.isNull(userIds) || userIds.isEmpty()) {
            return false;
        }

        QueryWrapper<RoleUser> queryWrapper = getQueryWrapper(true);

        queryWrapper.in(DBFieldConst.USER_ID, userIds);

        return this.getBaseMapper().delete(queryWrapper) > 0;
    }

    @Override
    public boolean deleteByRoleId(Long roleId) {

        if(Objects.isNull(roleId)) {
            return false;
        }

        List<RoleUser> roleUsers = getRoleUsersRoleId(roleId);

        return delete(roleUsers);

    }

    @Override
    public List<RoleUser> getRoleUsersByUserIds(List<Long> userIds) {

        if(userIds.isEmpty()) {
            return new ArrayList<>();
        }

        QueryWrapper<RoleUser> queryWrapper = getQueryWrapper(true);

        queryWrapper.in(DBFieldConst.USER_ID, userIds);

        return this.getBaseMapper().selectList(queryWrapper);

    }

    @Override
    public List<RoleUser> getRoleUsersRoleId(Long roleId) {

        QueryWrapper<RoleUser> queryWrapper = getQueryWrapper(true);

        queryWrapper.eq(DBFieldConst.ROLE_ID, roleId);

        return this.getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public boolean deleteByUserIdAndRoleId(Long userId, Long roleId) {

        if(Objects.isNull(userId)) {
            return false;
        }

        QueryWrapper<RoleUser> queryWrapper = getQueryWrapper(true);

        queryWrapper.eq(DBFieldConst.USER_ID, userId);
        queryWrapper.eq(DBFieldConst.ROLE_ID, roleId);

        return this.getBaseMapper().delete(queryWrapper) > 0;
    }

    @Override
    public boolean deleteByUserIdsAndRoleId(Long roleId, List<Long> userIds) {
        if(Objects.isNull(userIds) || userIds.isEmpty()) {
            return false;
        }

        QueryWrapper<RoleUser> queryWrapper = getQueryWrapper(true);
        queryWrapper.eq(DBFieldConst.ROLE_ID, roleId);

        queryWrapper.in(DBFieldConst.USER_ID, userIds);

        return this.getBaseMapper().delete(queryWrapper) > 0;
    }

    /**
     * 根据角色id集合获取用户角色信息
     *
     * @param roleIds 角色id集合
     * @return RoleUser集合
     */
    @Override
    public List<RoleUser> getRoleUsersRoleIds(List<Long> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)){
            return Collections.emptyList();
        }

        QueryWrapper<RoleUser> queryWrapper = getQueryWrapper(true);

        queryWrapper.in(DBFieldConst.ROLE_ID, roleIds);

        return this.getBaseMapper().selectList(queryWrapper);
    }

    /**
     * 根据用户ID集合删除用户角色信息
     *
     * @param roleId  角色id
     * @param userIds 用户IDs
     * @return 是否成功
     */
    @Override
    public boolean deleteByUserIdAndRoleId(Long roleId, List<Long> userIds) {

        if(Objects.isNull(roleId)) {
            return false;
        }

        if(userIds == null || userIds.isEmpty()){
            return false;
        }

        QueryWrapper<RoleUser> queryWrapper = getQueryWrapper(true);

        queryWrapper.in(DBFieldConst.USER_ID, userIds);
        queryWrapper.eq(DBFieldConst.ROLE_ID, roleId);

        return this.getBaseMapper().delete(queryWrapper) > 0;
    }
}
