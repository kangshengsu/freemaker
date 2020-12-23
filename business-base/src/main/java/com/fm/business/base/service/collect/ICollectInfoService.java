package com.fm.business.base.service.collect;

import com.fm.business.base.dao.collect.ICollectInfoMapper;
import com.fm.business.base.model.collect.CollectInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.production.ProductionReviewInfo;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/21 18:44
 */
public interface ICollectInfoService extends Service<CollectInfo> {
    List<Long> getProductionId(Long userId);

    List<Long> getDemandId(Long userId);

    CollectInfo getCollectInfo(Long userId, Long collect,Long collectType);
}
