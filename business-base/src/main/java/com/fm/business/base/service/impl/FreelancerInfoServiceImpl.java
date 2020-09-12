/**
 * @filename:FreelancerInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.fm.business.base.dao.IFreelancerInfoMapper;
import com.fm.business.base.model.FreelancerInfo;
import com.fm.business.base.service.IFreelancerInfoService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(自由职业者信息服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("freelancerInfoService")
public class FreelancerInfoServiceImpl extends BaseService<IFreelancerInfoMapper, FreelancerInfo> implements IFreelancerInfoService {


}