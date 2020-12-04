package com.fm.business.base.service.workInfo.impl;

import com.fm.business.base.dao.workInfo.WorkInfoMapper;
import com.fm.business.base.model.workInfo.WorkInfo;
import com.fm.business.base.service.workInfo.WorkInfoService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("workInfoService")
public class WorkInfoServiceImpl extends AuditBaseService<WorkInfoMapper, WorkInfo> implements WorkInfoService {
}
