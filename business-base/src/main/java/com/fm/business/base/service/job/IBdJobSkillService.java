/**
 * @filename:BdJobSkillService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.job;

import com.fm.business.base.model.job.BdJobSkill;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(岗位技能服务层)
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
public interface IBdJobSkillService extends Service<BdJobSkill> {

    /**
     * 获取岗位下所有技能
     * @param cateId
     * @return
     */
    List<BdJobSkill> findByCateId(Long cateId);
}