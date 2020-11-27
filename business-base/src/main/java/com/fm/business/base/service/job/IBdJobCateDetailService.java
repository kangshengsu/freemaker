package com.fm.business.base.service.job;

import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobCateDetail;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.request.QueryRequest;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/20 18:58
 */
public interface IBdJobCateDetailService extends Service<BdJobCateDetail> {

    Collection<BdJobCateDetail> getByJobCateIds(HashSet<Long> bdJobCateIds);

    void updateJobCateDetail(BdJobCateDetail bdJobCateDetail);

    List<BdJobCateDetail> getJobCateIdsByIsNew(QueryItem queryItem);

    List<BdJobCateDetail> getJobCateIdsByIsHot(QueryItem queryItem);

    List<BdJobCateDetail> getJobCateIdsByCategoryShow(QueryItem queryItem);

    List<BdJobCateDetail> getHomeShowFirstJobCate();

    List<BdJobCateDetail> getFirstJobCateAndDetail();


    List<BdJobCateDetail> getSecondJobCate(List<Long> bdJobCateId);
}
