package com.fm.business.base.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.job.IBdJoBCateDetailMapper;
import com.fm.business.base.enums.JobCateCategoryShow;
import com.fm.business.base.enums.JobCateHomeShow;
import com.fm.business.base.enums.JobNodeType;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobCateDetail;
import com.fm.business.base.service.job.IBdJobCateDetailService;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.service.AuditBaseService;
import com.fm.framework.web.request.QueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/20 19:23
 */
@Service
public class BdJobCateDetailServiceImpl extends AuditBaseService<IBdJoBCateDetailMapper, BdJobCateDetail> implements IBdJobCateDetailService {
    @Autowired
    private IBdJobCateService bdJobCateService;

    @Override
    public Collection<BdJobCateDetail> getByJobCateIds(HashSet<Long> bdJobCateIds) {
        List<BdJobCateDetail> bdJobCateDetailList = bdJobCateIds.stream().map(bdJobCateId -> getBaseMapper().selectOne(Wrappers.lambdaQuery(BdJobCateDetail.class).eq(BdJobCateDetail::getJobCateId, bdJobCateId))).collect(Collectors.toList());
        return bdJobCateDetailList;
    }

    @Override
    public void updateJobCateDetail(BdJobCateDetail bdJobCateDetail) {
        getBaseMapper().update(bdJobCateDetail, Wrappers.lambdaUpdate(BdJobCateDetail.class).eq(BdJobCateDetail::getJobCateId,bdJobCateDetail.getJobCateId()));
    }

    @Override
    public List<BdJobCateDetail> getJobCateIdsByIsNew(QueryItem queryItem) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(BdJobCateDetail.class).eq(BdJobCateDetail::getIsNew,queryItem.getValue()));
    }

    @Override
    public List<BdJobCateDetail> getJobCateIdsByIsHot(QueryItem queryItem) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(BdJobCateDetail.class).eq(BdJobCateDetail::getIsHot,queryItem.getValue()));
    }

    @Override
    public List<BdJobCateDetail> getJobCateIdsByCategoryShow(QueryItem queryItem) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(BdJobCateDetail.class).eq(BdJobCateDetail::getCategoryShow,queryItem.getValue()));
    }

    @Override
    public List<BdJobCateDetail> getHomeShowFirstJobCate() {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(BdJobCateDetail.class)
                .eq(BdJobCateDetail::getCateType, JobNodeType.JOB.getType())
                .eq(BdJobCateDetail::getIsHomeShow, JobCateHomeShow.SHOW.getCode())
                .orderByAsc(BdJobCateDetail::getHomeShowOrder));

    }

    @Override
    public List<BdJobCateDetail> getFirstJobCateAndDetail() {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(BdJobCateDetail.class)
                .eq(BdJobCateDetail::getCateType, JobNodeType.JOB.getType())
                .eq(BdJobCateDetail::getCategoryShow, JobCateCategoryShow.SHOW.getCode())
                .orderByAsc(BdJobCateDetail::getCategoryShowOrder));
    }

    @Override
    public List<BdJobCateDetail> getSecondJobCate(List<Long> bdJobCateId) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(BdJobCateDetail.class)
                .in(BdJobCateDetail::getJobCateId, bdJobCateId)
                .eq(BdJobCateDetail::getCategoryShow, JobCateCategoryShow.SHOW.getCode())
                .orderByAsc(BdJobCateDetail::getCategoryShowOrder));

    }


}
