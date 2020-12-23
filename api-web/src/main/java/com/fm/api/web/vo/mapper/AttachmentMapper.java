package com.fm.api.web.vo.mapper;

import com.fm.api.web.vo.AttachmentInfoVO;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.framework.core.service.FileService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * liuduo
 * <p>
 * 作品相关映射
 */
@Mapper(componentModel = "spring")
public abstract class AttachmentMapper {

    @Autowired
    private FileService fileService;

    @Mappings({
            @Mapping(source = "path", target = "fullPath", qualifiedByName="fullPath"),
            @Mapping(source = "otherPath", target = "fullOtherPath", qualifiedByName="fullPath")
    })
    public abstract AttachmentInfoVO toAttachmentVO(AttachmentInfo attachmentInfo);

    public abstract  AttachmentInfo toAttachment(AttachmentInfoVO attachmentInfoVO);


    /**
     * 补全路径
     * @param path
     * @return
     */
    @Named("fullPath")
    String fullPath(String path) {
        if (!StringUtils.isEmpty(path)) {
            return fileService.getFullPath(path);
        }
        return null;
    }
}
