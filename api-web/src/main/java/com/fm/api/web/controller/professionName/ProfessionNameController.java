package com.fm.api.web.controller.professionName;

import com.fm.api.web.vo.educationInfo.ProfessionNameInfoVO;
import com.fm.business.base.model.educationInfo.ProfessionNameInfo;
import com.fm.business.base.service.educationInfo.ProfessionNameService;
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
@RequestMapping("/professionName/professionNameInfo")
public class ProfessionNameController extends BaseController<ProfessionNameInfo, ProfessionNameInfoVO> {

    @Autowired
    private ProfessionNameService professionNameService;

    @Override
    protected Service<ProfessionNameInfo> service() {
        return professionNameService;
    }

    @RequestMapping(value = "/findLikeProfessionName",method = RequestMethod.POST)
    public ApiResponse<List<ProfessionNameInfoVO>> findLikeProfessionName(@RequestBody ProfessionNameInfoVO form) {

        List<ProfessionNameInfo> professionNameInfos = professionNameService.findLikeProfessionName(form.getKeyword());

        return success(convert(professionNameInfos));

    }
}
