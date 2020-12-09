package com.fm.business.base.service.educationInfo;

import com.fm.business.base.model.educationInfo.EducationInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

public interface EducationInfoService extends Service<EducationInfo> {

    /**
     * 根据freelancerId查询
     * @param id
     * @return
     */
    List<EducationInfo> getByFreelancerId(Long id);
}
