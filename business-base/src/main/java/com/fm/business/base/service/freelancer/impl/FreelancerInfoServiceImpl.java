/**
 * @filename:FreelancerInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.freelancer.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.freelancer.IFreelancerInfoMapper;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.sys.SysBaseDict;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**   
 * @Description:(自由职业者信息服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("freelancerInfoService")
public class FreelancerInfoServiceImpl extends AuditBaseService<IFreelancerInfoMapper, FreelancerInfo> implements IFreelancerInfoService {


    /**
     * 通过名字或电话查找数据 最多返回10条
     * @param str
     * @return
     */
    @Override
    public List<FreelancerInfo> findLikeNameOrPhone(String str) {

        if(StringUtils.isEmpty(str)){
            return Collections.emptyList();
        }

        return getBaseMapper().selectList(Wrappers.lambdaQuery(FreelancerInfo.class)
                .like(FreelancerInfo::getName,str)
                .or()
                .like(FreelancerInfo::getPhone,str)
                .orderByAsc(FreelancerInfo::getName,FreelancerInfo::getPhone)
                .last("limit 10"));
    }
}