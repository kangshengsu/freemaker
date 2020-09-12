/**
 * @filename:AttachmentInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.fm.business.base.mapper.IAttachmentInfoMapper;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.service.IAttachmentInfoService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Description:(附件服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("attachmentInfoService")
public class AttachmentInfoServiceImpl extends BaseService<IAttachmentInfoMapper, AttachmentInfo> implements IAttachmentInfoService {

}