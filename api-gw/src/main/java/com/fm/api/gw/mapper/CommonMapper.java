package com.fm.api.gw.mapper;

import com.fm.api.gw.vo.employer.EmployerInfoApiVO;
import com.fm.api.gw.vo.employer.mapper.EmployerInfoMapper;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.freelancer.mapper.FreelancerInfoMapper;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.framework.core.service.FileService;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author ：liuduo
 * @description：TODO
 * @date ：2020/10/18 23:18
 */
@Mapper(componentModel = "spring")
public abstract class CommonMapper {

    private static String HTTP_STR = "http";

    @Autowired
    private FreelancerInfoMapper freelancerInfoMapper;

    @Autowired
    private EmployerInfoMapper employerInfoMapper;

    @Autowired
    private FileService fileService;

    @Named("convertFreelancerInfo")
    protected FreelancerInfoApiVO freelancerInfoConvert(FreelancerInfo freelancerInfo) {
        return freelancerInfoMapper.toFreelancerInfoApi(freelancerInfo);
    }

    @Named("employerInfoConvert")
    protected EmployerInfoApiVO employerInfoConvert(EmployerInfo employerInfo) {
        return employerInfoMapper.toEmployerInfoApi(employerInfo);
    }

    /**
     * 补全路径
     * @param path
     * @return
     */
    @Named("fullHeadImgPath")
    protected String fullHeadImgPath(String path) {
        if (!StringUtils.isEmpty(path) && !path.startsWith(HTTP_STR)) {
            return fileService.getFullPath(path);
        }
        return path;
    }

    /**
     * 补全路径
     * @param path
     * @return
     */
    @Named("fullPath")
    protected String fullPath(String path) {
        if (!StringUtils.isEmpty(path)) {
            return fileService.getFullPath(path);
        }
        return null;
    }

    /**
     * 添加百分号
     */
    @Named("addPercent")
    protected String addPercent(Integer serviceCharge) {
        if (serviceCharge != null) {
            return serviceCharge + "%";
        }
        return null;
    }
}
