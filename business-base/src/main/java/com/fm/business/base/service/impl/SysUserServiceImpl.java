/**
 * @filename:SysUserServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.model.SysUser;
import com.fm.business.base.dao.ISysUserMapper;
import com.fm.business.base.service.ISysUserService;
import com.fm.framework.core.model.DBFieldConst;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

import java.sql.Wrapper;

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