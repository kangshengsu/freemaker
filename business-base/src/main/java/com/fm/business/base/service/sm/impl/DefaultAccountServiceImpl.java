package com.fm.business.base.service.sm.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.sm.IAccountMapper;
import com.fm.business.base.model.sm.Account;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.service.sm.IAccountService;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.core.model.DBFieldConst;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.AuditStatusBaseService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 默认账号服务
 *
 * @author hubo
 * @version 1.0.0
 **/
@Service
public class DefaultAccountServiceImpl extends AuditStatusBaseService<IAccountMapper, Account> implements IAccountService {

    @Override
    public void relate(Account account, User user) {

        account.setUserId(user.getId());

        saveOrUpdate(account);

    }

    public boolean existSameUsername(String username) {

        if (StringUtils.isEmpty(username)) {
            return false;
        }

        QueryWrapper<Account> queryWrapper = getQueryWrapper();
        queryWrapper.eq("username", username);

        return this.getBaseMapper().selectCount(queryWrapper) > 0;
    }

    @Override
    protected void beforeSave(Account model) {
        checkSameUsername(model);
        super.beforeSave(model);
    }

    @Override
    protected void beforeSave(Collection<Account> models) {
        super.beforeSave(models);
        for (Account model : models) {
            checkSameUsername(model);
        }
    }

    /**
     * 检查相同的用户名
     *
     * @param model 账号信息
     */
    private void checkSameUsername(Account model) {
        if (existSameUsername(model.getUsername())) {
            throw new BusinessException(model.getUsername() + "账号已存在！");
        }
    }

    @Override
    public Long getUserId(String username) {
        return getAccount(username).getUserId();
    }


    @Override
    public Account getAccount( String username) {

        if(StringUtils.isEmpty(username)) {
            return null;
        }

        return get(username);
    }

    @Override
    public List<Account> getAccount(List<Long> userIds) {
        if (userIds.isEmpty()) {
            return new ArrayList<>();
        }
        List<QueryItem> queryItems = new ArrayList<>();
        queryItems.add(new QueryItem().setQueryField(DBFieldConst.USER_ID).setType(QueryType.in).setValue(userIds));
        return getEnableStatus(queryItems);
    }

    @Override
    public List<Account> getAccountById(List<Long> acctIds) {
        if (acctIds.isEmpty()) {
            return new ArrayList<>();
        }
        List<QueryItem> queryItems = new ArrayList<>();
        queryItems.add(new QueryItem().setQueryField(DBFieldConst.ID).setType(QueryType.in).setValue(acctIds));
        return getEnableStatus(queryItems);
    }

    @Override
    public Account getAccount(Long userId) {

        if (Objects.isNull(userId)) {
            return null;
        }

        return getOne(Wrappers.lambdaQuery(Account.class).eq(Account::getUserId, userId));
    }

    @Override
    public boolean deleteAccount(Long userId) {

        Account account = getAccount(userId);

        if (Objects.nonNull(account)) {
            return this.delete(account);
        }

        return false;
    }

    @Override
    public boolean deleteAccountById(Long acctId) {
        Account account = new Account();
        account.setId(acctId);
        return this.delete(account);
    }

    @Override
    public boolean deleteAccount(List<Long> userIds) {

        List<Account> accounts = getAccount(userIds);

        if (!accounts.isEmpty()) {
            return this.delete(accounts);
        }

        return false;
    }

    @Override
    public Map<Long, Account> getAccountMap(List<Long> userIds) {

        return getAccount(userIds).stream().collect(Collectors.toMap(Account::getUserId, Function.identity(), (v1, v2) -> v2));
    }

    @Override
    public Account get(String username) {

        if(StringUtils.isEmpty(username)) {
            return null;
        }

        return this.getOne(getQueryWrapper()
                .eq("username", username),false);
    }


    @Override
    public Boolean existsAccount(String username) {

        if(StringUtils.isEmpty(username)) {
            return false;
        }

        return this.getBaseMapper().selectCount(getQueryWrapper().eq("username", username))> 0;
    }

    @Override
    public Boolean modifyById(Account entity) {
        int ret = this.getBaseMapper().updateById(entity);
        return ret > 0;
    }

    @Override
    public Boolean existAdminAcct(String acctName) {
        return this.getBaseMapper().selectCount(getQueryWrapper().eq("username", acctName)) > 0;
    }

}
