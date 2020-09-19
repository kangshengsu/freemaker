/**
 * @filename:BdJobCateServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.job.IBdJobCateMapper;
import com.fm.business.base.enums.JobNodeType;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.List;

/**   
 * @Description:(岗位服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("bdJobCateService")
public class BdJobCateServiceImpl extends AuditBaseService<IBdJobCateMapper, BdJobCate> implements IBdJobCateService {


    /**
     * 获取全部领域 暂时不限制条数
     * @param keyword 名称或编码
     * @return
     */
    @Override
    public List<BdJobCate> findJobCateDomain(String keyword) {
        LambdaQueryWrapper<BdJobCate> wrapper = Wrappers.lambdaQuery(BdJobCate.class)
                .eq(BdJobCate::getCateType, JobNodeType.JOB.getType());

        if(!StringUtils.isEmpty(keyword)){
            wrapper.like(BdJobCate::getCateName, keyword)
                    .or()
                    .like(BdJobCate::getCateCode, keyword);
        }
        return getBaseMapper().selectList(wrapper);
    }

    /**
     * 获取领域下岗位
     * @param DomainId 所属领域
     * @param keyword  名称或编码
     * @return
     */
    @Override
    public List<BdJobCate> findJobCatePost(Long DomainId, String keyword) {
        LambdaQueryWrapper<BdJobCate> wrapper = Wrappers.lambdaQuery(BdJobCate.class)
                .eq(BdJobCate::getParentId, DomainId)
                .eq(BdJobCate::getCateType, JobNodeType.POST.getType());

        if(!StringUtils.isEmpty(keyword)){
            wrapper.like(BdJobCate::getCateName, keyword)
                    .or()
                    .like(BdJobCate::getCateCode, keyword);
        }
        return getBaseMapper().selectList(wrapper);
    }
}