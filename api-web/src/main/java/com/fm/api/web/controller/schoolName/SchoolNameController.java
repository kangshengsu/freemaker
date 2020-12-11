package com.fm.api.web.controller.schoolName;

import com.fm.api.web.vo.educationInfo.SchoolNameInfoVO;
import com.fm.api.web.vo.freelancer.FreelancerInfoVO;
import com.fm.business.base.model.educationInfo.SchoolNameInfo;
import com.fm.business.base.service.educationInfo.SchoolNameService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schoolName/schoolNameInfo")
public class SchoolNameController extends BaseController<SchoolNameInfo, SchoolNameInfoVO> {

    @Autowired
    private SchoolNameService schoolNameService;

    @Override
    protected Service<SchoolNameInfo> service() {
        return schoolNameService;
    }

    @RequestMapping(value = "/findLikeSchoolName",method = RequestMethod.POST)
    public ApiResponse<List<SchoolNameInfoVO>> findLikeSchoolName(@RequestBody FreelancerInfoVO form) {

        List<SchoolNameInfo> schoolNameInfos = schoolNameService.findLikeSchoolName(form.getKeyword());

        return success(convert(schoolNameInfos));

    }
}
