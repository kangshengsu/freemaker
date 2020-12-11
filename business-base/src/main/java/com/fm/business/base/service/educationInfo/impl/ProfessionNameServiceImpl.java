package com.fm.business.base.service.educationInfo.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.educationInfo.ProfessionNameMapper;
import com.fm.business.base.model.educationInfo.ProfessionNameInfo;
import com.fm.business.base.service.educationInfo.ProfessionNameService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service("professionNameService")
public class ProfessionNameServiceImpl extends AuditBaseService<ProfessionNameMapper, ProfessionNameInfo> implements ProfessionNameService {
    @Override
    public List<ProfessionNameInfo> findLikeProfessionName(String str) {
        if(StringUtils.isEmpty(str)){
            return Collections.emptyList();
        }

        return getBaseMapper().selectList(Wrappers.lambdaQuery(ProfessionNameInfo.class)
                .like(ProfessionNameInfo::getName,str)
                .orderByAsc(ProfessionNameInfo::getName)
                .last("limit 10"));
    }
}
