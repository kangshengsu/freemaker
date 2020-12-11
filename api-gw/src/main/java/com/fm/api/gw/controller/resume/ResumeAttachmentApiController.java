package com.fm.api.gw.controller.resume;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fm.api.gw.vo.resume.ResumeAttachmentVO;
import com.fm.api.gw.vo.resume.mapper.ResumeAttachmentMapper;
import com.fm.business.base.model.resume.ResumeAttachmentInfo;
import com.fm.business.base.service.resume.IResumeAttachmentInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/9 10:19
 */
@RestController
@RequestMapping(value = "/v1/resumeAttachment")
@Api(description = "简历接口")
public class ResumeAttachmentApiController extends BaseController<ResumeAttachmentInfo, ResumeAttachmentVO> {

    @Autowired
    private IResumeAttachmentInfoService resumeAttachmentInfoService;

    @Autowired
    private ResumeAttachmentMapper resumeAttachmentMapper;

    @RequestMapping(value = "/getResumeAttachment", method = RequestMethod.GET)
    @ApiOperation(value = "根据自由职业者获取简历列表")
    public ApiResponse<List<ResumeAttachmentVO>> getResumeAttachment() {
        Long freelancerId = Context.getCurrFreelancerId();
        if (ObjectUtil.isNotNull(resumeAttachmentInfoService)) {
            return success(resumeAttachmentInfoService.getResumeByFreelancerId(freelancerId).stream().map(resumeAttachmentInfo -> resumeAttachmentMapper.toResumeAttachmentVO(resumeAttachmentInfo)).collect(Collectors.toList()));
        }
        return null;
    }

    /**
     * TODO doc处理  else if ("doc".equals(resumeAttachmentVO.getName().substring(resumeAttachmentVO.getName().toLowerCase().lastIndexOf(".") + 1)) ||
     *                     "docx".equals(resumeAttachmentVO.getName().substring(resumeAttachmentVO.getName().toLowerCase().lastIndexOf(".") + 1))) {
     *                 resumeAttachmentInfoService.doc2Image(resumeAttachmentVO.getPath());
     *                 return super.create(resumeAttachmentVO);
     *             }
     * @param resumeAttachmentVO
     * @return
     */
    @RequestMapping(value = "/creat", method = RequestMethod.POST)
    @ApiOperation(value = "保存简历")
    public ApiResponse<Boolean> creatResumeAttachment(@RequestBody ResumeAttachmentVO resumeAttachmentVO) {
        if (ObjectUtil.isNotNull(resumeAttachmentVO)) {
            if ("pdf".equals(resumeAttachmentVO.getName().substring(resumeAttachmentVO.getName().toLowerCase().lastIndexOf(".") + 1))) {
                String path = resumeAttachmentVO.getPath().startsWith("http") ? resumeAttachmentVO.getPath().substring(resumeAttachmentVO.getPath().lastIndexOf(".com/") + 5) : resumeAttachmentVO.getPath();
                resumeAttachmentInfoService.pdf2Image(path,null);
            }
            return super.create(resumeAttachmentVO);
        }
        return failed("上传数据错误");
    }

    @RequestMapping(value = "/delById", method = RequestMethod.POST)
    @ApiOperation(value = "删除简历")
    @Transactional(rollbackFor = RuntimeException.class)
    public ApiResponse<Boolean> delResumeAttachment(@RequestBody ResumeAttachmentVO resumeAttachmentVO) {
        if (ObjectUtil.isNotNull(resumeAttachmentVO.getId())) {
            return super.delete(resumeAttachmentVO.getId());
        }
        return failed("删除失败");
    }

    @RequestMapping(value = "/preview", method = RequestMethod.GET)
    @ApiOperation(value = "预览简历")
    public ApiResponse<ResumeAttachmentVO> previewResume(@RequestParam("id") Long id) {
        if (ObjectUtil.isNotNull(id)) {
            ResumeAttachmentInfo resumeAttachmentInfo = resumeAttachmentInfoService.get(id);
            if (ObjectUtil.isNotNull(resumeAttachmentInfo)) {
                return success(resumeAttachmentMapper.toResumeAttachmentVO(resumeAttachmentInfo));
            }
        }
        return failed("参数错误，无法预览");
    }


    @Override
    protected Service<ResumeAttachmentInfo> service() {
        return resumeAttachmentInfoService;
    }
}
