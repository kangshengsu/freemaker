package com.fm.business.base.service.demand.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.IDemandRemarkInfoMapper;
import com.fm.business.base.model.demand.DemandRemarkInfo;
import com.fm.business.base.service.demand.IDemandRemarkInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;


/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/12 11:02
 */
@Service
public class DemandRemarkInfoServiceImpl extends AuditBaseService<IDemandRemarkInfoMapper, DemandRemarkInfo> implements IDemandRemarkInfoService {

    @Override
    public DemandRemarkInfo getRemarkInfoByDemandId(Long id) {
        return getBaseMapper().selectOne(Wrappers.lambdaQuery(DemandRemarkInfo.class).eq(DemandRemarkInfo::getDemandId,id).last("limit 1"));
    }

}
