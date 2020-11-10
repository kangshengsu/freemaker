package com.fm.business.base.service.demand.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.IDemandInfoMapper;
import com.fm.business.base.enums.TreeCodeType;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandCenterInfoService;
import com.fm.business.base.service.impl.EmployerInfoServiceImpl;
import com.fm.framework.core.enums.DeleteEnum;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("demandCenterInfoService")
public class DemandCenterInfoServiceImpl extends AuditBaseService<IDemandInfoMapper, DemandInfo> implements IDemandCenterInfoService {

    @Autowired
    private IEmployerInfoService employerInfoService;

    @Override
    public Page<DemandInfo> getDemandCenterPage(Integer currentPage, Integer pageSize, Integer attestation, Integer jobCateId) {
        String jobId = "";
        if(jobCateId != null){
            jobId = TreeCodeType.get(jobCateId).getCateTreeNode();
        }

        return toPage(
                getBaseMapper().selectPage(
                        new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize),
                        getQueryWrapper().lambda()
                                .eq(DemandInfo::getIsDelete, DeleteEnum.VALID.getValue())
                                .eq(attestation != 0, DemandInfo::getAttestation, attestation)
                                .likeRight(jobCateId != null, DemandInfo::getCateTreeCode, jobId)
                                .orderByDesc(DemandInfo::getCreateTime)));
    }

    @Override
    public DemandInfo getDemandCenterDtlByCode(String code) {
        DemandInfo demandInfo =getBaseMapper().selectOne(Wrappers.lambdaQuery(DemandInfo.class).eq(DemandInfo::getCode,code));
        fillInfo(demandInfo);
        return demandInfo;
    }

    private void fillInfo(DemandInfo demandInfo){
        if(demandInfo == null){
            return;
        }
        demandInfo.setEmployerInfo(employerInfoService.getById(demandInfo.getEmployerId()));
    }
}
