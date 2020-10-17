/**
 * @filename:SysUserServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.sys.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.sys.ISysUserMapper;
import com.fm.business.base.model.sys.SysUser;
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

/**   
 * @Description:(用户服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("sysUserService")
public class SysUserServiceImpl extends BaseService<ISysUserMapper, SysUser> implements ISysUserService  {


    @Autowired
    private IFreelancerInfoService freelancerInfoService;

    @Autowired
    private IEmployerInfoService employerInfoService;

    /**
     * 根据编码获取用户信息
     *
     * @param code
     * @return
     */
    @Override
    public SysUser findByCode(String code) {
        return getBaseMapper().selectOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getCode,code));
    }

    /**
     * 更新用户数据，包含 用户表数据  自由职业者数据  雇佣者数据
     *
     * @param sysUser
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = Throwable.class)
    public boolean updateUserAllInfo(SysUser sysUser) {

        if(!update(sysUser)){
            log.error("更新用户失败！更新用户表数据失败 {}", JsonUtil.obj2String(sysUser));
            throw new BusinessException("更新用户失败！更新用户表数据失败");
        }

        if(sysUser.getFreelancerInfo() != null && sysUser.getFreelancerInfo().getId() != null &&
                !freelancerInfoService.update(sysUser.getFreelancerInfo())){
            log.error("更新用户失败！更新自由职业者表数据失败 {}", JsonUtil.obj2String(sysUser));
            throw new BusinessException("更新用户失败！更新自由职业者数据失败");
        }

        if(sysUser.getEmployerInfo() != null && sysUser.getEmployerInfo().getId() != null &&
                !employerInfoService.update(sysUser.getEmployerInfo())){
            log.error("更新用户失败！更新雇佣者数据失败 {}", JsonUtil.obj2String(sysUser));
            throw new BusinessException("更新用户失败！更新雇佣者数据失败");
        }

        return true;
    }

    @Override
    protected void afterSave(SysUser sysUser) {

    }
}