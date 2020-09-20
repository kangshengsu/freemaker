/**
 * @filename:BdJobSkillServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.fm.business.base.dao.job.IBdJobSkillMapper;
import com.fm.business.base.model.job.BdJobSkill;
import com.fm.business.base.service.IBdJobSkillService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

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


}