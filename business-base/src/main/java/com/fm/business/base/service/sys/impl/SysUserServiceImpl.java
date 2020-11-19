/**
 * @filename:SysUserServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.sys.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.sys.ISysUserMapper;
import com.fm.business.base.enums.LanguageEnum;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.IAccountInfoService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.core.service.BaseService;
import com.fm.framework.core.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Description:(用户服务实现)
 * @version: V1.0
 * @author: LiuDuo
 */
@Slf4j
@Service("sysUserService")
public class SysUserServiceImpl extends BaseService<ISysUserMapper, SysUser> implements ISysUserService {


    @Autowired
    private IFreelancerInfoService freelancerInfoService;

    @Autowired
    private IEmployerInfoService employerInfoService;

    @Autowired
    private IAccountInfoService iAccountInfoService;

    /**
     * 根据编码获取用户信息
     *
     * @param code
     * @return
     */
    @Override
    public SysUser findByCode(String code) {
        return getBaseMapper().selectOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getCode, code));
    }

    /**
     * 更新用户数据，包含 用户表数据  自由职业者数据  雇佣者数据
     *
     * @param sysUser
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public boolean updateUserAllInfo(SysUser sysUser) {

        if (!update(sysUser)) {
            log.error("更新用户失败！更新用户表数据失败 {}", JsonUtil.obj2String(sysUser));
            throw new BusinessException("更新用户失败！更新用户表数据失败");
        }

        if (sysUser.getFreelancerInfo() != null && sysUser.getFreelancerInfo().getId() != null &&
                !freelancerInfoService.update(sysUser.getFreelancerInfo())) {
            log.error("更新用户失败！更新自由职业者表数据失败 {}", JsonUtil.obj2String(sysUser));
            throw new BusinessException("更新用户失败！更新自由职业者数据失败");
        }

        if (sysUser.getEmployerInfo() != null && sysUser.getEmployerInfo().getId() != null &&
                !employerInfoService.update(sysUser.getEmployerInfo())) {
            log.error("更新用户失败！更新雇佣者数据失败 {}", JsonUtil.obj2String(sysUser));
            throw new BusinessException("更新用户失败！更新雇佣者数据失败");
        }

        return true;
    }

    @Override
    public SysUser findById(Long id) {
        SysUser sysUser = getBaseMapper().selectOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getId, id));
        fillInfo(sysUser);
        return sysUser;
    }

    private void fillInfo(SysUser sysUser) {
        if (sysUser == null) {
            return;
        }
        sysUser.setFreelancerInfo(freelancerInfoService.getByUserId(sysUser.getId()));
        sysUser.setEmployerInfo(employerInfoService.getByUserId(sysUser.getId()));
    }

    @Override
    protected void afterSave(SysUser sysUser) {
        FreelancerInfo freelancerInfo = convertFreelancerInfo(sysUser);
        EmployerInfo employerInfo = convertEmployerInfo(sysUser);
        iAccountInfoService.createAccount(freelancerInfo, employerInfo);
    }

    private EmployerInfo convertEmployerInfo(SysUser sysUser) {
        EmployerInfo employerInfo = new EmployerInfo();
        employerInfo.setName(sysUser.getName());
        employerInfo.setCode(sysUser.getName());
        //电话在绑定电话节点更新，此节点不写入
        //employerInfo.setPhone(phoneNumber);
        /* todo 四级地址，此节点不写入，会单独维护吧？不需要可直接删除
        employerInfo.setProvinceCode(null);
        employerInfo.setCityCode(null);
        employerInfo.setDistrictCode(null);
        employerInfo.setCountyCode(null);
        */
        employerInfo.setAccountCode("");
        employerInfo.setUserId(sysUser.getId());
        employerInfo.setHeadImg(sysUser.getAvatarUrl());
        return employerInfo;
    }

    private FreelancerInfo convertFreelancerInfo(SysUser sysUser) {
        FreelancerInfo freelancerInfo = new FreelancerInfo();
        freelancerInfo.setName(sysUser.getName());
        freelancerInfo.setCode(sysUser.getName());
        //电话在绑定电话节点更新，此节点不写入
        //freelancerInfo.setPhone(phoneNumber);
        //todo zyc 下面四个没值
        freelancerInfo.setCateTreeCode("");
        freelancerInfo.setJobCateId(0L);
        freelancerInfo.setSkillSummarize("");
        freelancerInfo.setAccountCode("");

        freelancerInfo.setLanguage(LanguageEnum.CHINESE.getCode());
        /* todo 四级地址，此节点不写入，会单独维护吧？不需要可直接删除
        freelancerInfo.setProvinceCode(null);
        freelancerInfo.setCityCode(null);
        freelancerInfo.setDistrictCode(null);
        freelancerInfo.setCountyCode(null);
         */
        freelancerInfo.setUserId(sysUser.getId());
        freelancerInfo.setHeadImg(sysUser.getAvatarUrl());
        freelancerInfo.setReferrer(sysUser.getScene());
        return freelancerInfo;
    }


}
