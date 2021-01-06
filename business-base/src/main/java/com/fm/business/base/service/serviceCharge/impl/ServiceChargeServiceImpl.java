package com.fm.business.base.service.serviceCharge.impl;

import com.fm.business.base.dao.serviceCharge.ServiceChargeMapper;
import com.fm.business.base.model.serviceCharge.ServiceCharge;
import com.fm.business.base.service.serviceCharge.IServiceChargeService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/6 12:18
 */
@Service
public class ServiceChargeServiceImpl extends AuditBaseService<ServiceChargeMapper, ServiceCharge> implements IServiceChargeService  {
}
