package com.fm.business.base.service.workInfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fm.business.base.dao.workInfo.WorkInfoMapper;
import com.fm.business.base.model.workInfo.WorkInfo;
import com.fm.business.base.service.workInfo.WorkInfoService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("workInfoService")
public class WorkInfoServiceImpl extends AuditBaseService<WorkInfoMapper, WorkInfo> implements WorkInfoService {

    @Override
    public List<WorkInfo> getByFreelancerId(Long id) {
        QueryWrapper<WorkInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("freelancer_id", id);
        queryWrapper.orderByAsc("start_time");
        return getBaseMapper().selectList(queryWrapper);
    }
}
