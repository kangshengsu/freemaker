package com.fm.business.base.service.educationInfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fm.business.base.dao.educationInfo.EducationInfoMapper;
import com.fm.business.base.model.educationInfo.EducationInfo;
import com.fm.business.base.service.educationInfo.EducationInfoService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("educationInfoService")
public class EducationInfoServiceImpl extends AuditBaseService<EducationInfoMapper, EducationInfo> implements EducationInfoService {
    @Override
    public List<EducationInfo> getByFreelancerId(Long id) {
        QueryWrapper<EducationInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("freelancer_id", id);
        queryWrapper.orderByAsc("start_time");
        return getBaseMapper().selectList(queryWrapper);
    }
}
