package com.fm.business.base.service.sm;

import com.fm.business.base.model.sm.Org;
import com.fm.business.base.model.sm.OrgType;
import com.fm.framework.core.service.TreeService;

import java.util.List;

/**
 * @author hubo
 * @version 1.0.0
 **/
public interface IOrgService extends TreeService<Org> {


    boolean canChangeParent(Org org);

    /*
     * 获取公司类型
     * */
    OrgType getCorpType();

    /*
     * 获取部门类型
     * */
    OrgType getDeptType();

    /**
     * 查询所有组织机构类型
     * */
    List<OrgType> getAllOrgType();

    /**
     * 通过编码查询
     * */
    Org getEnableOne(String code);

    int countChildren(Long orgId);
}
