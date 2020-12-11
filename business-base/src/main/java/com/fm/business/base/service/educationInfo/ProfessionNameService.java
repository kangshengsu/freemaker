package com.fm.business.base.service.educationInfo;

import com.fm.business.base.model.educationInfo.ProfessionNameInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

public interface ProfessionNameService extends Service<ProfessionNameInfo> {

    List<ProfessionNameInfo> findLikeProfessionName(String str);
}
