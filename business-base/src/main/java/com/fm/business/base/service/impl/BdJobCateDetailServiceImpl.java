package com.fm.business.base.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.job.IBdJoBCateDetailMapper;
import com.fm.business.base.model.job.BdJobCateDetail;
import com.fm.business.base.service.job.IBdJobCateDetailService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/20 19:23
 */
@Service
public class BdJobCateDetailServiceImpl extends AuditBaseService<IBdJoBCateDetailMapper, BdJobCateDetail> implements IBdJobCateDetailService {
    @Override
    public Collection<BdJobCateDetail> getByJobCateIds(HashSet<Long> bdJobCateIds) {
        List<BdJobCateDetail> bdJobCateDetailList = bdJobCateIds.stream().map(bdJobCateId -> getBaseMapper().selectOne(Wrappers.lambdaQuery(BdJobCateDetail.class).eq(BdJobCateDetail::getJobCateId, bdJobCateId))).collect(Collectors.toList());
        return bdJobCateDetailList;
    }

    @Override
    public void updateJobCateDetail(BdJobCateDetail bdJobCateDetail) {
        getBaseMapper().update(bdJobCateDetail, Wrappers.lambdaUpdate(BdJobCateDetail.class).eq(BdJobCateDetail::getJobCateId,bdJobCateDetail.getJobCateId()));
    }
}
