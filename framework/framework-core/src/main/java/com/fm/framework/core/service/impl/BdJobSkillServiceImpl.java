/**
 * @filename:BdJobSkillServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.framework.core.service.impl;

import com.fm.framework.core.model.BdJobSkill;
import com.fm.framework.core.mapper.IBdJobSkillMapper;
import com.fm.framework.core.service.IBdJobSkillService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BdJobSkillServiceImpl extends BaseService<IBdJobSkillMapper, BdJobSkill> implements IBdJobSkillService  {

  @Autowired
  private IBdJobSkillMapper bdJobSkillMapper;
}