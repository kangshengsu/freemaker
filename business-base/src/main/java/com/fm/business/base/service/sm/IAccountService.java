package com.fm.business.base.service.sm;


import com.fm.business.base.model.sm.Account;
import com.fm.business.base.model.sm.User;
import com.fm.framework.core.service.Service;

import java.util.List;
import java.util.Map;

/**
 * 账号服务
 * @author hubo
 * @version 1.0.0
 **/
public interface IAccountService extends Service<Account> {

    /**
     * 用户关联账号信息
     * @param user 用户
     * @param account 账号
     */
    void relate(Account account, User user);

    Long getUserId(String username);

    Account getAccount(String username);

    Account getAccount(Long userId);

    List<Account> getAccount(List<Long> userIds);

    List<Account> getAccountById(List<Long> acctIds);

    boolean deleteAccount(Long userId);

    boolean deleteAccount(List<Long> userIds);

    boolean deleteAccountById(Long acctId);

    Map<Long,Account> getAccountMap(List<Long> userIds);

    Account get(String username);

    Boolean existsAccount(String username);

    Boolean modifyById(Account account);

    Boolean existAdminAcct(String acctName);
}
