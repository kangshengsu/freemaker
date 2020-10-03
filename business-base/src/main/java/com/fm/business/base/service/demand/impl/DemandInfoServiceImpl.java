/**
 * @filename:DemandInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.demand.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.IDemandInfoMapper;
import com.fm.business.base.enums.DemandStatus;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.framework.core.enums.DeleteEnum;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import com.fm.framework.core.utils.CodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Description:(需求服务实现)
 * @version: V1.0
 * @author: LiuDuo
 */
@Slf4j
@Service("demandInfoService")
public class DemandInfoServiceImpl extends AuditBaseService<IDemandInfoMapper, DemandInfo> implements IDemandInfoService {


    @Override
    public int updateRecommendCountById(Long id, Integer recommendCount) {
        DemandInfo demandInfo = new DemandInfo();
        demandInfo.setId(id);
        demandInfo.setRecommendCount(recommendCount);
        return this.getBaseMapper().updateById(demandInfo);
    }

    @Override
    public Integer getDemandCountByStatus(Long employerId, Integer status) {
        return getBaseMapper().selectCount(
                getQueryWrapper().lambda()
                        .groupBy()
                        .eq(DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                        .eq(DemandInfo::getEmployerId, employerId)
                        .eq(status != null, DemandInfo::getStatus, status));
    }

    @Override
    public Page<DemandInfo> gePageByEmployerId(Integer currentPage, Integer pageSize, Long employerId, Integer status) {
        return toPage(
                getBaseMapper().selectPage(
                        new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
                        getQueryWrapper().lambda()
                                .eq(DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                                .eq(DemandInfo::getEmployerId, employerId)
                                .eq(status != 0, DemandInfo::getStatus, status)));
    }

    @Override
    public int updateStatusByCode(String code, Integer status) {
        if (DemandStatus.get(status) == null) {
            return 0;
        }
        UpdateWrapper<DemandInfo> updateWrapper = Wrappers.update();
        updateWrapper.set("status", status).eq("code", code);
        return this.getBaseMapper().update(null, updateWrapper);
    }

    @Override
    public int updateByCode(DemandInfo demandInfo) {
        UpdateWrapper<DemandInfo> updateWrapper = Wrappers.update();
        updateWrapper.eq("code", demandInfo.getCode());
        return this.getBaseMapper().update(demandInfo, updateWrapper);
    }

    @Override
    public DemandInfo getByCode(String code) {
        QueryWrapper<DemandInfo> queryWrapper = getQueryWrapper().eq("code", code);
        return this.getBaseMapper().selectOne(queryWrapper);
    }

    @Override
    protected void beforeSave(DemandInfo model) {
        super.beforeSave(model);
        if (StringUtils.isEmpty(model.getCode())) {
            //生成code
            model.setCode(CodeUtil.generateNewCode());
        }
        if (model.getStatus() == null) {
            model.setStatus(DemandStatus.RELEASE.getCode());
        }
    }

    /**
     * 通过名字或电话查找数据 最多返回10条
     * @param str
     * @return
     */
    @Override
    public List<DemandInfo> findDemandInfoLikeNameOrCode(String str) {

        if(StringUtils.isEmpty(str)){
            return Collections.emptyList();
        }

        return getBaseMapper().selectList(Wrappers.lambdaQuery(DemandInfo.class)
                .like(DemandInfo::getCode,str)
                .or()
                .like(DemandInfo::getSummarize,str)
                .last("limit 10"));
    }
}
