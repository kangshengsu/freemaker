package com.fm.business.base.service.sm.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fm.business.base.dao.sm.IOrgMapper;
import com.fm.business.base.model.sm.Org;
import com.fm.business.base.model.sm.OrgType;
import com.fm.business.base.service.sm.IOrgService;
import com.fm.business.base.service.sm.IUserService;
import com.fm.framework.core.model.DBFieldConst;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.TreeAuditStatusBaseService;
import com.fm.framework.core.utils.TreeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;


/**
 * 默认组织服务
 * @author hubo
 * @version 1.0.0
 **/
@Service("orgService")
@RequiredArgsConstructor
@Slf4j
public class DefaultOrgServiceImpl extends TreeAuditStatusBaseService<IOrgMapper, Org> implements IOrgService {

    @Autowired
    private final IUserService userService;

    @Override
    protected void beforeSave(Org org) {

        super.beforeSave(org);

        if(isNull(org.getSq())) {
            setOrder(org);
        }
    }

    private void setOrder(Org org) {

        int order = 0;

        if(!TreeUtil.isNull4ParentId(org)) {
            QueryWrapper<Org> queryWrapper = new QueryWrapper<>();

            queryWrapper
                    .eq("parent_id", org.getParentId()).orderByDesc("sq");

            List<Org> brotherList = getBaseMapper().selectList(queryWrapper);

            log.debug("查询兄弟组织信息: {}", brotherList);

            order = brotherList.stream()
                    .findFirst()
                    .map(Org::getSq)
                    .orElse(order) + 1;

        }

        org.setSq(order);

    }

    @Override
    public boolean canChangeParent(Org org) {
        //父级机构可以修改的条件：当机构为末级机构，且机构下无用户、机构未关联数据权限才能修改父级机构

        //末级机构 && //机构下有用户
        return isChildNode(org) && !hasUser(org);
    }

    /**
     * 保存默认的组织机构类型
     */


    @Override
    public OrgType getCorpType() {
        return OrgType.CORP;
    }

    @Override
    public OrgType getDeptType() {
        return OrgType.DEPT;
    }

    /**
     * 查询所有组织机构类型
     */
    @Override
    public List<OrgType> getAllOrgType() {
        return Arrays.asList(OrgType.values());
    }

    /**
     * 通过编码查询
     *
     */
    @Override
    public Org getEnableOne(String code) {
        QueryItem item = new QueryItem();
        item.setType(QueryType.eq);
        item.setQueryField(DBFieldConst.CODE);
        item.setValue(code);
        return super.getOneEnableStatus(Collections.singletonList(item));
    }

    @Override
    public int countChildren(Long orgId) {
        QueryItem item = new QueryItem();
        item.setType(QueryType.eq);
        item.setQueryField(DBFieldConst.PARENT_ID);
        item.setValue(orgId);
        return super.countEnableStatus(Collections.singletonList(item));
    }


    private boolean hasUser(Org org) {
        return userService.hasUserInOrg(org);
    }

    private boolean isChildNode(Org org) {
        QueryWrapper<Org> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq(DBFieldConst.PARENT_ID, org.getId());
        List<Org> children = getBaseMapper().selectList(queryWrapper);

        return CollectionUtils.isEmpty(children);
    }
}
