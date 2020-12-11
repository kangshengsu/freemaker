package com.fm.business.base.service.educationInfo;

import com.fm.business.base.model.educationInfo.SchoolNameInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

public interface SchoolNameService extends Service<SchoolNameInfo> {

    List<SchoolNameInfo> findLikeSchoolName(String str);
}
