package com.fm.api.gw.vo.order.mapper;

import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.api.gw.vo.attachment.mapper.AttachmentMapper;
import com.fm.api.gw.vo.order.OrderOperateInfoVO;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.order.OrderOperateInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * liuduo
 * <p>
 * 作品相关映射
 */
@Mapper(componentModel = "spring")
public abstract class OrderOperateMapper {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Mapping(source = "attachmentInfos", target = "images")
    public abstract OrderOperateInfoVO toOrderOperateInfoVO(OrderOperateInfo orderOperateInfo);


    List<AttachmentVO> toAttachmentVO(List<AttachmentInfo> attachmentInfos){

        if(CollectionUtils.isEmpty(attachmentInfos)){
            return Collections.EMPTY_LIST;
        }

        return attachmentInfos.stream().map(attachmentInfo -> attachmentMapper.toAttachmentVO(attachmentInfo)).collect(Collectors.toList());
    }


}
