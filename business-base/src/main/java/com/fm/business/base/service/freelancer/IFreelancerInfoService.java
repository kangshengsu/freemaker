/**
 * @filename:FreelancerInfoService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.freelancer;

import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(自由职业者信息服务层)
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
public interface IFreelancerInfoService extends Service<FreelancerInfo> {


    /**
     * 通过名字或电话查找数据 最多返回10条
     * @param str
     * @return
     */
    List<FreelancerInfo> findLikeNameOrPhone(String str);
}