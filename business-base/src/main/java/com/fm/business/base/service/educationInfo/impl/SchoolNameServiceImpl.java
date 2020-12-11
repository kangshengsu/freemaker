package com.fm.business.base.service.educationInfo.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.educationInfo.SchoolNameMapper;
import com.fm.business.base.model.educationInfo.SchoolNameInfo;
import com.fm.business.base.service.educationInfo.SchoolNameService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service("schoolNameService")
public class SchoolNameServiceImpl extends AuditBaseService<SchoolNameMapper, SchoolNameInfo> implements SchoolNameService {
    @Override
    public List<SchoolNameInfo> findLikeSchoolName(String str) {
        if(StringUtils.isEmpty(str)){
            return Collections.emptyList();
        }

        return getBaseMapper().selectList(Wrappers.lambdaQuery(SchoolNameInfo.class)
                .like(SchoolNameInfo::getName,str)
                .orderByAsc(SchoolNameInfo::getName)
                .last("limit 10"));
    }
}
