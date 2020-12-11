package com.fm.api.gw.vo.resume.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.resume.ResumeAttachmentVO;
import com.fm.business.base.model.resume.ResumeAttachmentInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/9 10:44
 */
@Mapper(componentModel = "spring")
public abstract class ResumeAttachmentMapper extends CommonMapper {
    @Mappings({
            @Mapping(target = "path",source = "path",qualifiedByName = "fullPath"),
            @Mapping(target = "otherPath",source = "otherPath",qualifiedByName = "fullPath")
    })
    public abstract ResumeAttachmentVO toResumeAttachmentVO(ResumeAttachmentInfo resumeAttachmentInfo);
}
