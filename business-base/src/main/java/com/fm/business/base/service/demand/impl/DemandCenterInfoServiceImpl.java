package com.fm.business.base.service.demand.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.IDemandInfoMapper;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.demand.IDemandCenterInfoService;
import com.fm.framework.core.enums.DeleteEnum;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("demandCenterInfoService")
public class DemandCenterInfoServiceImpl extends AuditBaseService<IDemandInfoMapper, DemandInfo> implements IDemandCenterInfoService {

    @Override
    public Page<DemandInfo> getDemandCenterPage(Integer currentPage, Integer pageSize, Integer status , Integer jobCateId) {
        return toPage(
                getBaseMapper().selectPage(
                        new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
                        getQueryWrapper().lambda()
                                .eq(DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                                .eq(status != 0, DemandInfo::getStatus, status)
                                .eq(jobCateId!=null, DemandInfo::getJobCateId, jobCateId)
                                .orderByDesc(DemandInfo::getCreateTime)));
    }

    @Override
    public DemandInfo getDemandCenterDtlByCode(String code) {
        return getBaseMapper().selectOne(Wrappers.lambdaQuery(DemandInfo.class).eq(DemandInfo::getCode,code));
    }
}
