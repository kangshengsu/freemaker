package com.fm.business.base.service.demand;

import com.fm.business.base.model.demand.DemandInfo;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;

public interface IDemandCenterInfoService extends Service<DemandInfo> {

    /**
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @return 需求编码
     */
    Page<DemandInfo> getDemandCenterPage(Integer currentPage, Integer pageSize, Integer attestation, Integer jobCateId);

    DemandInfo getDemandCenterDtlByCode(String code);
}
