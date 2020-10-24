package com.fm.business.base.service.account;

import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.service.IAccountInfoService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IAccountInfoServiceImpl implements IAccountInfoService {

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private IFreelancerInfoService iFreelancerInfoService;

    @Autowired
    private IEmployerInfoService iEmployerInfoService;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void createAccount(FreelancerInfo freelancerInfo, EmployerInfo employerInfo) {

        iFreelancerInfoService.save(freelancerInfo);

        iEmployerInfoService.save(employerInfo);
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateAccount(FreelancerInfo freelancerInfo, EmployerInfo employerInfo) {
        iFreelancerInfoService.update(freelancerInfo);

        iEmployerInfoService.update(employerInfo);
    }
}
