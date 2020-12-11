package com.fm.api.web.controller.resume;

import com.fm.api.web.vo.resume.ResumeAttachmentInfoVO;
import com.fm.business.base.model.resume.ResumeAttachmentInfo;
import com.fm.business.base.service.resume.IResumeAttachmentInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/3 10:12
 */
@RestController
@RequestMapping(value = "/resume/resumeAttachmentInfo")
public class ResumeAttachmentInfoController extends BaseController<ResumeAttachmentInfo, ResumeAttachmentInfoVO> {

    @Autowired
    private IResumeAttachmentInfoService resumeAttachmentInfoService;


    @RequestMapping(value = "getFreelancerResumePageData", method = RequestMethod.POST)
    public ApiResponse<Page<ResumeAttachmentInfoVO>> getFreelancerResumePageData(@RequestBody QueryRequest form) {
        return super.list(form);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody ResumeAttachmentInfoVO form) {

        if ("jpg".equals(form.getName().substring(form.getName().toLowerCase().lastIndexOf(".") + 1)) ||
               "jpeg".equals(form.getName().substring(form.getName().toLowerCase().lastIndexOf(".") + 1))||
               "png".equals(form.getName().substring(form.getName().toLowerCase().lastIndexOf(".") + 1))) {
            return super.create(form);
        }

        if ("pdf".equals(form.getName().substring(form.getName().toLowerCase().lastIndexOf(".") + 1))) {
            resumeAttachmentInfoService.pdf2Image(form.getPath(),null);
            return super.create(form);
        }
//        if ("doc".equals(form.getName().substring(form.getName().toLowerCase().lastIndexOf(".") + 1)) ||
//                "docx".equals(form.getName().substring(form.getName().toLowerCase().lastIndexOf(".") + 1))){
//            resumeAttachmentInfoService.doc2Image(form.getPath());
//        return super.create(form);
//        }
        return ApiResponse.ofFailed("上传文件格式错误");
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody ResumeAttachmentInfoVO form) {
        return super.update(form);
    }

    @Override
    protected Service<ResumeAttachmentInfo> service() {
        return resumeAttachmentInfoService;
    }
}
