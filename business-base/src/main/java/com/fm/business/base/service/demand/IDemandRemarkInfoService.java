package com.fm.business.base.service.demand;

import com.fm.business.base.model.demand.DemandRemarkInfo;
import com.fm.framework.core.service.Service;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/12 11:01
 */
public interface IDemandRemarkInfoService extends Service<DemandRemarkInfo> {

    DemandRemarkInfo getRemarkInfoByDemandId(Long id);

}
