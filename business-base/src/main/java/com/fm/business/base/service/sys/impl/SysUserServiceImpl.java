/**
 * @filename:SysUserServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.sys.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.dao.sys.ISysUserMapper;
import com.fm.business.base.service.sys.ISysUserService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

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
}