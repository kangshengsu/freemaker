package com.fm.api.web.controller.job;

import com.fm.api.web.vo.AttachmentInfoVO;
import com.fm.api.web.vo.job.BdJobCateVO;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.enums.AttachmentType;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.impl.AttachmentInfoServiceImpl;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/job/bdJobCateDefaultImage")
public class BdJobCateDefaultImageController extends BaseController<BdJobCate, BdJobCateVO> {

    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private AttachmentInfoServiceImpl attachmentInfoService;


    @RequestMapping(value = "saveDefaultImage",method = RequestMethod.POST)
    public ApiResponse<Boolean> saveDefaultImage(@RequestBody BdJobCateVO form){
        return super.update(form);
    }

    @RequestMapping(value = "getImage",method = RequestMethod.GET)
    public ApiResponse<List<AttachmentInfoVO>> getImage(@RequestParam("cateCode") String cateCode){
        List<AttachmentInfoVO> attachmentInfoVOList = attachmentInfoService.getByCodeAndType(cateCode, AttachmentBusinessType.JOB_DEFAULT_IMAGE).stream().map(this::convert).collect(Collectors.toList());
        return ApiResponse.ofSuccess(attachmentInfoVOList);
    }

    protected AttachmentInfoVO convert(AttachmentInfo model){
        AttachmentInfoVO attachmentInfoVO = new AttachmentInfoVO();
        BeanUtils.copyProperties(model, attachmentInfoVO);
        return attachmentInfoVO;
    }


    @Override
    protected Service<BdJobCate> service() {
        return bdJobCateService;
    }
}
