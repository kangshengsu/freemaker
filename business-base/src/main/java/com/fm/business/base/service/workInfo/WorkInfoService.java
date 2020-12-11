package com.fm.business.base.service.workInfo;

import com.fm.business.base.model.workInfo.WorkInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

public interface WorkInfoService extends Service<WorkInfo> {

    /**
     * 根据freelancerId查询
     * @param id
     * @return
     */
    List<WorkInfo> getByFreelancerId(Long id);

    /**
     * 根据freelancerId删除工作经历
     * @param freelancerId
     * @return
     */
    boolean deleteByFreelancerId(Long freelancerId);
}
