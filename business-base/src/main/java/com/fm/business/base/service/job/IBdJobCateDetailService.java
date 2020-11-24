package com.fm.business.base.service.job;

import com.fm.business.base.model.job.BdJobCateDetail;
import com.fm.framework.core.service.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/20 18:58
 */
public interface IBdJobCateDetailService extends Service<BdJobCateDetail> {

    Collection<BdJobCateDetail> getByJobCateIds(HashSet<Long> bdJobCateIds);

    void updateJobCateDetail(BdJobCateDetail bdJobCateDetail);
}
