package com.fm.business.base.service.resume;

import com.fm.business.base.model.resume.ResumeAttachmentInfo;
import com.fm.framework.core.service.Service;
import sun.rmi.log.LogInputStream;

import java.util.List;
import java.util.Set;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/2 17:39
 */
public interface IResumeAttachmentInfoService extends Service<ResumeAttachmentInfo> {
     void pdf2Image(String filePath);

     void doc2Image(String path);

    List<ResumeAttachmentInfo> getResumeByFreelancerId(Long freelancerId);
}
