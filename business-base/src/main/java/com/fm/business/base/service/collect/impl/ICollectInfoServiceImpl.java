package com.fm.business.base.service.collect.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.collect.ICollectInfoMapper;
import com.fm.business.base.enums.CollectType;
import com.fm.business.base.model.collect.CollectInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.collect.ICollectInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/21 18:47
 */
@Service
public class ICollectInfoServiceImpl extends AuditBaseService<ICollectInfoMapper, CollectInfo> implements ICollectInfoService {
    @Override
    public List<Long> getProductionId(Long userId) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(CollectInfo.class).eq(CollectInfo::getUserId,userId).eq(CollectInfo::getCollectType,CollectType.PRODUCTION.getCode()))
                .stream().map(CollectInfo::getCollect).collect(Collectors.toList());
    }

    @Override
    public List<Long> getDemandId(Long userId) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(CollectInfo.class).eq(CollectInfo::getUserId,userId).eq(CollectInfo::getCollectType,CollectType.DEMAND.getCode()))
                .stream().map(CollectInfo::getCollect).collect(Collectors.toList());
    }

    @Override
    public CollectInfo getCollectInfo(Long userId, Long collect,Long collectType) {
        return  getBaseMapper().selectOne(Wrappers.lambdaQuery(CollectInfo.class).eq(CollectInfo::getUserId,userId).eq(CollectInfo::getCollect,collect).eq(CollectInfo::getCollectType,collectType));

    }
}
