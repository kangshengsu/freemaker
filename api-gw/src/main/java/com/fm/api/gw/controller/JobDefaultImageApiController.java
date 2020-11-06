package com.fm.api.gw.controller;

import com.fm.api.gw.vo.JobCateVO;
import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.api.gw.vo.attachment.mapper.AttachmentMapper;
import com.fm.api.gw.vo.evaluation.relation.BdJobTagVO;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.IAttachmentInfoService;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/JobDefaultImage")
@Api(value = "岗位默认图片接口")
public class JobDefaultImageApiController extends BaseController<BdJobCate, JobCateVO> {
    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IAttachmentInfoService attachmentInfoService;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @RequestMapping(value = "getDefaultImage",method = RequestMethod.GET)
    @ApiOperation(value = "通过岗位编码获取默认图片")
    public ApiResponse<List<AttachmentVO>> getDefaultImage(@RequestParam("cateCode") String cateCode){
        List<AttachmentVO> attachmentVOList = attachmentInfoService.getByCodeAndType(cateCode, AttachmentBusinessType.JOB_DEFAULT_IMAGE)
                .stream().map(attachmentInfo -> attachmentMapper.toAttachmentVO(attachmentInfo)).collect(Collectors.toList());
        return ApiResponse.ofSuccess(attachmentVOList);


    }

    protected AttachmentVO convert(AttachmentInfo model) {
        AttachmentVO attachmentVO = new AttachmentVO();
        BeanUtils.copyProperties(model, attachmentVO);
        return attachmentVO;
    }


    @Override
    protected Service<BdJobCate> service() {
        return bdJobCateService;
    }
}
