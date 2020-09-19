/**
 * @filename:BdJobCateServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.fm.business.base.dao.job.IBdJobCateMapper;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(岗位服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("bdJobCateService")
public class BdJobCateServiceImpl extends AuditBaseService<IBdJobCateMapper, BdJobCate> implements IBdJobCateService {


}