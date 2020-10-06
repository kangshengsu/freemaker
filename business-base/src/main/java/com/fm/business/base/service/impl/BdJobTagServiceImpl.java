/**
 * @filename:BdJobSkillServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.fm.business.base.dao.job.IBdJobTagMapper;
import com.fm.business.base.model.job.BdJobTag;
import com.fm.business.base.service.IBdJobTagService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**   
 * @Description:(岗位技能服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("bdJobTagService")
public class BdJobTagServiceImpl extends AuditBaseService<IBdJobTagMapper, BdJobTag> implements IBdJobTagService {


}