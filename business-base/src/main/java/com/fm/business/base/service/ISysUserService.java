/**
 * @filename:SysUserService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service;

import com.fm.business.base.model.SysUser;
import com.fm.framework.core.service.Service;
/**   
 * @Description:(用户服务层)
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
public interface ISysUserService extends Service<SysUser> {

    /**
     * 根据编码获取用户信息
     * @param code
     * @return
     */
    SysUser findByCode(String code);

}