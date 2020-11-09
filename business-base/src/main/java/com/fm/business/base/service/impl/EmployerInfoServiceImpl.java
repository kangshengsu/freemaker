/**
 * @filename:EmployerInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.IEmployerInfoMapper;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Description:(雇佣者信息服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Slf4j
@Service("employerInfoService")
public class EmployerInfoServiceImpl extends AuditBaseService<IEmployerInfoMapper, EmployerInfo> implements IEmployerInfoService {

    @Override
    public List<EmployerInfo> findLikeNameOrPhone(String str) {
        if(StringUtils.isEmpty(str)){
            return Collections.emptyList();
        }

        return getBaseMapper().selectList(Wrappers.lambdaQuery(EmployerInfo.class)
                .like(EmployerInfo::getName,str)
                .or()
                .like(EmployerInfo::getPhone,str)
                .orderByAsc(EmployerInfo::getName,EmployerInfo::getPhone)
                .last("limit 10"));
    }


    @Override
    public EmployerInfo getByUserId(Long userId) {
        if(null == userId) {
            return null;
        }

        List<EmployerInfo> employerInfos =
                getBaseMapper().selectList(Wrappers.<EmployerInfo>lambdaQuery().eq(EmployerInfo::getUserId,userId));
        if(CollectionUtils.isEmpty(employerInfos)) {
            return null;
        }

        return employerInfos.get(0);
    }

    @Override
    public EmployerInfo getById(Long id) {
        if(null == id) {
            return null;
        }

        List<EmployerInfo> employerInfos =
                getBaseMapper().selectList(Wrappers.<EmployerInfo>lambdaQuery().eq(EmployerInfo::getId,id));
        if(CollectionUtils.isEmpty(employerInfos)) {
            return null;
        }

        return employerInfos.get(0);
    }

    @Override
    public boolean updateCompanyName(Long employerId, String companyName) {
        EmployerInfo employerInfo = new EmployerInfo();
        employerInfo.setCompany(companyName);
        int result = getBaseMapper().update(employerInfo, new LambdaQueryWrapper<EmployerInfo>().eq(EmployerInfo::getId, employerId));
        if(result == 0){
            return false;
        }else {
            return true;
        }
    }
}
