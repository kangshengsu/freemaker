package com.fm.business.base.service.sm;

import com.fm.business.base.model.sm.Org;
import com.fm.business.base.model.sm.User;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * 用户服务
 * @author hubo
 * @version 1.0.0
 **/
public interface IUserService extends Service<User> {

    /**
     * 创建系统用户，系统用户是一个状态为禁用的用户，用于系统初始化等目的。
     * @return 系统用户
     */
    User createSystemUser();

    /**
     * 分页查询当前组织下所有人员信息（包括子组织）
     * @param orgId 组织ID
     * @return 人员分页列表
     */
    Page<User> list(Long orgId, long currPage, long pageSize);

    /**
     * 分页查询当前组织下所有人员完整信息（包括子组织）
     * @param orgId 组织ID
     * @return 人员分页列表
     */
    Page<User> listFullUser(Long orgId, long currPage, long pageSize);

    /**
     * 分页查询当前组织下所有人员完整信息（包括子组织）
     * @param orgId 组织ID
     * @return 人员分页列表
     */
    Page<User> listFullUser(Long orgId, List<QueryItem> queryItemList, long currPage, long pageSize);


    /**
     * 分页查询当前组织下所有人员完整信息（包括子组织）
     * @param orgId 组织ID
     * @return 人员分页列表
     */
    Page<User> list(Long orgId, List<QueryItem> otherQueryList, long currPage, long pageSize);

    /**
     * 根据查询条件分页查询当前组织下所有人员完整信息（包括子组织）
     * @param queryItemList 查询条件列表
     * @return 人员分页列表
     */
    Page<User> list(List<QueryItem> queryItemList, long currPage, long pageSize);

    /**
     * 是否存在相同的用户编码
     * @param userCode 用户编码
     * @return boolean
     */
    boolean exists(String userCode);

    /**
     * 是否存在相同的用户手机号
     * @param phone 用户手机号
     * @return boolean
     */
    boolean existsPhone(String phone);


    /**
     * 分页查询当前组织下所有人员完整信息
     * @param ids id集合
     * @return 人员列表
     */
    List<User> getFullUserByIds(List<Long> ids);

    /**
     * 更新头像
     * @param url 头像地址
     * @param user 用户
     * @return 是否成功
     */
    boolean updateAvatarHref(User user, String url);

    boolean hasUserInOrg(Org org);

    List<User> getEnableByIds(List<Long> userIds);

    User getByCode(String code);

    List<User> getByPhone(String phone);

    /**
     * 查找有效的
     * */
    User getEnableOneByCode(String code);

    /**
     * 用户和用户角色关联分页查询
     *
     */
    Page<User> pageList(Page<User> page, User user);

    List<User> findAllByOrgId(Long orgId);
}
