package com.fm.api.gw.vo.order.mapper;

import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.api.gw.vo.order.OrderOperateInfoVO;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.order.OrderOperateInfo;
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
public abstract class OrderOperateMapper {

    public abstract OrderOperateInfoVO toOrderOperateInfoVO(OrderOperateInfo orderOperateInfo);


}
