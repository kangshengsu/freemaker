/**
 * @filename:EmployerInfoService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service;

import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(雇佣者信息服务层)
 * @version: V1.0
 * @author: LiuDuo
 *
 */
public interface IEmployerInfoService extends Service<EmployerInfo> {

    /**
     * 通过名字或电话查找数据 最多返回10条
     * @param str
     * @return
     */
    List<EmployerInfo> findLikeNameOrPhone(String str);
}
