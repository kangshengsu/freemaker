package com.fm.api.web.vo.sm.mapper;

import com.fm.api.web.vo.sm.AccountVO;
import com.fm.api.web.vo.sm.UserFormVO;
import com.fm.api.web.vo.sm.UserTableVO;
import com.fm.business.base.model.sm.Account;
import com.fm.business.base.model.sm.Role;
import com.fm.business.base.model.sm.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>类描述</p>
 *
 * @author hubo
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "orgName", source = "org.name")
    UserFormVO toUserVO(User user);


    @Mapping(target = "org", ignore = true)
    @Mapping(target = "isDelete", ignore = true)
    User toUser(UserFormVO user);


    @Mapping(target = "org", ignore = true)
    @Mapping(target = "isDelete", ignore = true)
    User toUser(UserTableVO user);

    @Mapping(target = "orgName", source = "org.name")
    @Mapping(target = "avatarHref", source = "avatarHref", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserTableVO toUserTableVO(User user);

    default List<Long> toRoleIds(List<Role> roles) {

        if(roles == null || roles.isEmpty()) {
            return Collections.emptyList();
        }

        return roles.stream().map(Role::getId).collect(Collectors.toList());

    }

    default List<Role> toRoles(List<Long> roleIds) {

        if(roleIds == null || roleIds.isEmpty()) {
            return Collections.emptyList();
        }

        return roleIds.stream().map(roleId -> {
            Role role = new Role();
            role.setId(roleId);
            return role;
        }).collect(Collectors.toList());
    }

    /**
     * Account集合转换成AccountVO对象
     * @param accounts accountList
     * @return AccountVO
     */
    default List<AccountVO> toAccountVO(List<Account> accounts) {
        List<AccountVO> results = new ArrayList<>();
        //AccountVO accountVO = new AccountVO();
        if(accounts != null && !accounts.isEmpty()) {
            accounts.forEach(account -> {
                AccountVO item = new AccountVO();
                item.setAcctName(account.getUsername());
                results.add(item);
            });
        }
        return results;
    }

    /**
     * AccountVO对象转换成List<Account>集合
     * @param accountVOs AccountVO对象
     * @return List<Account>集合
     */
    default List<Account> toAccountList(List<AccountVO> accountVOs) {
        if(accountVOs != null && accountVOs.size() > 0){
            List<Account> accounts = new ArrayList<>();
            accountVOs.forEach(accountVO -> {
                Account item = new Account();
                item.setUsername(accountVO.getAcctName());
                accounts.add(item);
            });
            return accounts;
        }else{
            return Collections.emptyList();
        }
    }
}
