package com.fm.business.base.service.sm.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fm.business.base.dao.sm.IUserMapper;
import com.fm.business.base.model.sm.*;
import com.fm.business.base.service.sm.*;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.core.model.DBFieldConst;
import com.fm.framework.core.model.DataStatus;
import com.fm.framework.core.query.*;
import com.fm.framework.core.service.AuditStatusBaseService;
import com.fm.framework.core.utils.SubModelCompareResult;
import com.fm.framework.core.utils.UpdateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 默认用户服务
 * @author hubo
 * @version 1.0.0
 **/
@Service("userService")
@RequiredArgsConstructor
public class DefaultUserServiceImpl extends AuditStatusBaseService<IUserMapper, User> implements IUserService {

    public static final String USER_SYSTEM = "system";

    public static final Long USER_SYSTEM_ID = 1L;

    private final IOrgService orgService;

    private final IRoleService roleService;

    private final IAccountService accountService;

    private final IRoleUserService roleUserService;

    @Override
    public User createSystemUser() {

        User system = new User();
        system.setId(genId(system));
        system.setCode(USER_SYSTEM);
        system.setName(USER_SYSTEM);
        system.setStatus(DataStatus.disable.code()); //系统用户是一个
        system.setCreateUser(USER_SYSTEM_ID);

        system.setCreateTime(new Date());
        system.setTs(LocalDateTime.now());
        system.setIsDelete(false);

        getBaseMapper().insert(system);

        return system;
    }

    @Override
    public Page<User> list(Long orgId, long currPage, long pageSize) {
        return list(orgId, null, currPage, pageSize);
    }


    public Page<User> list(Long orgId, List<QueryItem> otherQueryList, long currPage, long pageSize) {

        if(currPage <= 0) {
            currPage = 1;
        }

        if(pageSize <= 0) {
            pageSize = 5;
        }

        if(Objects.isNull(orgId)) {
            return list(currPage, pageSize);
        }

        List<Long> orgIds = orgService.findAllChild(orgId).stream().map(Org::getId).collect(Collectors.toList());

        orgIds.add(orgId);

        List<QueryItem> queryItemList = new ArrayList<>();

        queryItemList.add(new QueryItem().setQueryField(DBFieldConst.ORG_ID).setValue(orgIds).setType(QueryType.in));

        if(!CollectionUtils.isEmpty(otherQueryList)) {
            queryItemList.addAll(otherQueryList);
        }
        return list(queryItemList,new OrderItem(OrderType.desc,"ts"), currPage, pageSize);

    }

    public Page<User> listFullUser(Long orgId, List<QueryItem> queryItemList, long currPage, long pageSize) {

        if(!CollectionUtils.isEmpty(queryItemList)) {
            Iterator<QueryItem> it = queryItemList.iterator();

            List<QueryItem> addQueryItemList = new ArrayList<>();

            while (it.hasNext()) {
                QueryItem item = it.next();
                if(DBFieldConst.ROLE_ID.equals(item.getQueryField())) {
                    it.remove();

                    Long roleId = Long.valueOf(item.getValue().toString());

                    List<RoleUser> roleUsers = roleUserService.getRoleUsersRoleId(roleId);

                    QueryItem roleUserItem = new QueryItem();
                    if(!roleUsers.isEmpty()) {
                        roleUserItem.setQueryField(DBFieldConst.ID).setType(QueryType.in)
                                .setValue(roleUsers.stream().map(RoleUser::getUserId).collect(Collectors.toList()));

                    }else {
                        roleUserItem.setQueryField(DBFieldConst.ID).setType(QueryType.eq)
                                .setValue(-1);
                    }
                    addQueryItemList.add(roleUserItem);
                }
            }

            if(!addQueryItemList.isEmpty()) {
                queryItemList.addAll(addQueryItemList);
            }

        }

        Page<User> userPage = list(orgId, queryItemList, currPage, pageSize);

        fillUserOtherInfo(userPage.getData());

        return userPage;
    }

    @Override
    public Page<User> listFullUser(Long orgId, long currPage, long pageSize) {

        Page<User> userPage = list(orgId, currPage, pageSize);

        fillUserOtherInfo(userPage.getData());

        return userPage;
    }

    /**
     * 补充用户其他信息
     * @param userList 用户列表
     */
    public void fillUserOtherInfo(List<User> userList) {

        if(userList.isEmpty()) {
            return;
        }

        List<Long> orgIds = userList.stream().map(User::getOrgId).collect(Collectors.toList());
        List<Long> userIds = userList.stream().map(User::getId).collect(Collectors.toList());

        Map<Long, List<Role>> roleNameMap = roleService.getUserRoleMap(userIds);
        Map<Long, Org >  orgNameMap = orgService.getByIds(orgIds).stream().collect(Collectors.toMap(Org::getId, Function.identity(), (key1, key2) -> key2));
        Map<Long, Account> accountMap = accountService.getAccountMap(userIds);

        userList.forEach(user -> {

            List<Role> roles = roleNameMap.get(user.getId());
            if(roles!=null){
                roles = roles.stream().filter(a->a.getStatus()==DataStatus.enable.code()).collect(Collectors.toList());
            }
            if(!CollectionUtils.isEmpty(roles)){
                user.setRoles(roles);
            }
            user.setOrg(orgNameMap.get(user.getOrgId()));

            if(accountMap.containsKey(user.getId())) {
                user.setAccount(accountMap.get(user.getId()));
            }
        });
    }

    @Override
    public User findById(Long id) {
        User user = super.getById(id);
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        fillUserOtherInfo(list);
        return user;
    }

    @Override
    public boolean exists(String userCode) {
        List<QueryItem> queryItemList = new ArrayList<>();
        queryItemList.add(new QueryItem().setQueryField(DBFieldConst.CODE).setValue(userCode).setType(QueryType.eq));
        return this.count(queryItemList) > 0;
    }

    @Override
    public boolean existsPhone(String phone) {
        List<QueryItem> queryItemList = new ArrayList<>();
        queryItemList.add(new QueryItem().setQueryField(DBFieldConst.PHONE).setValue(phone).setType(QueryType.eq));
        return this.count(queryItemList) > 0;
    }

    @Override
    @Transactional
    public boolean delete(List<User> users) {

        if(users.isEmpty()) {
            return false;
        }

        List<Long> userIds = users.stream().map(User::getId).collect(Collectors.toList());

        accountService.deleteAccount(userIds);

        roleUserService.deleteByUserId(userIds);

        return super.delete(users);

    }

    @Override
    @Transactional
    public boolean delete(User user) {

        accountService.deleteAccount(user.getId());

        roleUserService.deleteByUserId(user.getId());

        return super.delete(user) ;

    }

    @Override
    @Transactional
    public boolean save(User model) {

        if(exists(model.getCode())) {
            throw new BusinessException("已存在相同的编码" + model.getCode());
        }

        if(existsPhone(model.getPhone())) {
            throw new BusinessException("已存在相同的手机号" + model.getPhone());
        }

        boolean result = super.save(model);

        if(result) {
            if(!CollectionUtils.isEmpty(model.getRoles())) {
                addRoles(model);
            }

            if(Objects.nonNull(model.getAccount())) {
                addAccount(model);
            }
        }

        return result;
    }
    @Override
    @Transactional
    public boolean save(Collection<User> entityList) {

        entityList.forEach(this::initDefaultField);

        beforeSave(entityList);

        boolean result = super.save(entityList);
        if(result) {
            //批量保存角色
            List<RoleUser> roleUsers = new ArrayList<>();
            entityList.forEach(a->{
                if(!CollectionUtils.isEmpty(a.getRoles())){
                    roleUsers.addAll(getRoleUsers(a,false));
                }});
            roleUserService.save(roleUsers);

            //批量保存账号
            List<Account> accounts = new ArrayList<>();
            entityList.forEach(a->{
                if(Objects.nonNull(a.getAccount())){
                    accounts.add(getAccount(a));
                }});
            accountService.save(accounts);
        }
        return result;
    }

    private void addRoles(User model) {
        List<RoleUser> roleUsers = getRoleUsers(model,true);

        roleUserService.save(roleUsers);

    }

    @Override
    @Transactional
    public boolean update(User model) {

        boolean result = super.update(model);

        if(result) {

            updateRoleUser(model);

            updateAccount(model);
        }

        return result;
    }

    private void updateAccount(User model) {

        Account newAccount = getAccount(model);

        Account oldAccount = accountService.getAccount(model.getId());

        if(Objects.isNull(oldAccount)) {
            if(Objects.nonNull(newAccount)) {
                accountService.save(newAccount);
            }
        } else {
            if(Objects.isNull(newAccount)) {
                accountService.deleteAccount(model.getId());
            } else {
                accountService.update(newAccount);
            }
        }

//        SubModelCompareResult<Account> accountCompareResult = UpdateUtils
//                .compare(newAccounts, oldAccounts,
//                        account ->  String.valueOf(account.getUserId()),
//                        (old, newT) -> Objects.equals(old.getUsername(), newT.getUsername()));
//
//        if(!CollectionUtils.isEmpty(accountCompareResult.getNewList())) {
//            accountService.save(accountCompareResult.getNewList());
//        }
//
//        if(!CollectionUtils.isEmpty(accountCompareResult.getDelList())) {
//            accountService.delete(accountCompareResult.getDelList());
//        }
//
//        if(!CollectionUtils.isEmpty(accountCompareResult.getUpdateList())) {
//            accountService.update(accountCompareResult.getUpdateList());
//        }

    }

    private void updateRoleUser(User model) {

        List<RoleUser> oldRoleUser = roleUserService.getRoleUsersByUserIds(Collections.singletonList(model.getId()));

        List<RoleUser> newRoleUsers = getRoleUsers(model,true);

        SubModelCompareResult<RoleUser> roleUserCompareResult = UpdateUtils
                .compare(newRoleUsers, oldRoleUser,
                        roleUser -> roleUser.getRoleId() + "-"+ roleUser.getUserId()
                        , (old, newT) -> Objects.equals(old.getRoleId(), newT.getRoleId()));

        if(!CollectionUtils.isEmpty(roleUserCompareResult.getNewList())) {
            roleUserService.save(roleUserCompareResult.getNewList());
        }

        if(!CollectionUtils.isEmpty(roleUserCompareResult.getDelList())) {
            roleUserService.delete(roleUserCompareResult.getDelList());
        }

        if(!CollectionUtils.isEmpty(roleUserCompareResult.getUpdateList())) {
            roleUserService.update(roleUserCompareResult.getUpdateList());
        }
    }

    private List<RoleUser> getRoleUsers(User model,boolean needQueryRole) {
        List<Role> roles = null;
        if(needQueryRole){
            List<Long> rolesId = model.getRoles().stream().map(Role::getId).collect(Collectors.toList());
            roles = roleService.getByIds(rolesId);
        }else{
            roles = model.getRoles();
        }
        return roles.stream().map(role -> {
            RoleUser roleUser = new RoleUser();
            roleUser.setRoleId(role.getId());
            roleUser.setUserId(model.getId());
            return roleUser;
        }).collect(Collectors.toList());
    }

    private void addAccount(User model) {
        Account account = getAccount(model);
        if(Objects.nonNull(account)) {
            accountService.save(account);
        }

    }

    private Account getAccount(User model) {
        Account account = model.getAccount();
        if(Objects.isNull(account)) {
            return null;
        }
        account.setUserId(model.getId());
        return account;
    }

    @Override
    public List<User> getFullUserByIds(List<Long> id) {

        List<User> userList = super.getByIds(id);

        fillUserOtherInfo(userList);

        return userList;

    }

    /**
     * 更新头像
     *
     * @param url 头像地址
     * @param user 用户
     * @return 是否成功
     */
    @Override
    public boolean updateAvatarHref(User user, String url) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq(DBFieldConst.ID, user.getId());
        updateWrapper.set(DBFieldConst.USER_AVATAR_HREF, url);
        return super.update(updateWrapper);
    }

    @Override
    public boolean hasUserInOrg(Org org) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq(DBFieldConst.ORG_ID, org.getId());
        List<User> users = getBaseMapper().selectList(queryWrapper);
        return !CollectionUtils.isEmpty(users);
    }

    @Override
    public List<User> getEnableByIds(List<Long> userIds) {
        if(CollectionUtils.isEmpty(userIds)) {
            return new ArrayList<>();
        }

        QueryItem item = new QueryItem();
        item.setValue(userIds);
        item.setQueryField(DBFieldConst.ID);
        item.setType(QueryType.in);

        return this.getEnableStatus(Collections.singletonList(item));
    }

    @Override
    public User getByCode(String code) {
        QueryItem item = new QueryItem();
        item.setValue(code);
        item.setQueryField(DBFieldConst.CODE);
        item.setType(QueryType.eq);

        return this.getOneFromExistSame(Collections.singletonList(item));
    }

    @Override
    public List<User> getByPhone(String phone) {
        QueryItem item = new QueryItem();
        item.setValue(phone);
        item.setQueryField(DBFieldConst.PHONE);
        item.setType(QueryType.eq);
        return this.get(Collections.singletonList(item));
    }


    /**
     * 查找有效的
     *
     * @param code
     */
    @Override
    public User getEnableOneByCode(String code) {
        QueryItem item = new QueryItem();
        item.setValue(code);
        item.setQueryField(DBFieldConst.CODE);
        item.setType(QueryType.eq);

        return this.getOneEnableStatus(Collections.singletonList(item));
    }

    /**
     * 用户和用户角色关联分页查询
     *
     */
    @Override
    public Page<User> pageList(Page<User> page, User user) {
        return toPage(getBaseMapper().pageList(page, user));
    }

    @Override
    public List<User> findAllByOrgId(Long orgId) {
        if (Objects.isNull(orgId)){
            return Collections.emptyList();
        }

        QueryItem item = new QueryItem();
        item.setValue(orgId);
        item.setQueryField(DBFieldConst.ORG_ID);
        item.setType(QueryType.eq);
        return this.getEnableStatus(Collections.singletonList(item));
    }
}
