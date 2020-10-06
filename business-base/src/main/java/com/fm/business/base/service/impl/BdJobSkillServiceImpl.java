/**
 * @filename:BdJobSkillServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.job.IBdJobSkillMapper;
import com.fm.business.base.model.job.BdJobSkill;
import com.fm.business.base.service.IBdJobSkillService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**   
 * @Description:(岗位技能服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("bdJobSkillService")
public class BdJobSkillServiceImpl extends AuditBaseService<IBdJobSkillMapper, BdJobSkill> implements IBdJobSkillService {


    /**
     * 获取岗位下所有技能
     *
     * @param cateId
     * @return
     */
    @Override
    public List<BdJobSkill> findByCateId(Long cateId) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(BdJobSkill.class).eq(BdJobSkill::getJobCateId,cateId));
    }
}