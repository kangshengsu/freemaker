package com.fm.business.base.service.educationInfo.impl;

import com.fm.business.base.dao.educationInfo.EducationInfoMapper;
import com.fm.business.base.model.educationInfo.EducationInfo;
import com.fm.business.base.service.educationInfo.EducationInfoService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("educationInfoService")
public class EducationInfoServiceImpl extends AuditBaseService<EducationInfoMapper, EducationInfo> implements EducationInfoService {
}
