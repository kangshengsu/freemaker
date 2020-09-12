/**
 * @filename:EmployerInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.fm.business.base.dao.IEmployerInfoMapper;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.service.IEmployerInfoService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(雇佣者信息服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("employerInfoService")
public class EmployerInfoServiceImpl extends BaseService<IEmployerInfoMapper, EmployerInfo> implements IEmployerInfoService {

}