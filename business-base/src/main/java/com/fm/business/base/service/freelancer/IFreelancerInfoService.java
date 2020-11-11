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
import java.util.Map;

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

    FreelancerInfo getByUserId(Long currUser);

    /**
     * 通过userId生成小程序码
     */
    String createReferralCode();

    Long getRecommended(Long currUserId);

    Long getPublishProduction(Long currUserId);

    Long getProductionPass(Long currUserId);

    List<FreelancerInfo> findLikeNameOrUserId(String keyword);

    List<FreelancerInfo> getFreelancerName(List<Long> referrers);
}