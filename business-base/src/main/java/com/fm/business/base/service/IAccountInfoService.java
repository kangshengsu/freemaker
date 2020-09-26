package com.fm.business.base.service;

import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.sys.SysUser;

public interface IAccountInfoService {

    /**
     * 创建账号
     */
    void createAccount(FreelancerInfo freelancerInfo, EmployerInfo employerInfo);

    /**
     * 更新账号
     */
    void updateAccount(FreelancerInfo freelancerInfo, EmployerInfo employerInfo);
}
