/**
 * @filename:AttachmentInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.impl;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.IAttachmentInfoMapper;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.service.IAttachmentInfoService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Description:(附件服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Slf4j
@Service("attachmentInfoService")
public class AttachmentInfoServiceImpl extends AuditBaseService<IAttachmentInfoMapper, AttachmentInfo> implements IAttachmentInfoService {

    @Override
    public List<AttachmentInfo> getByCodeAndType(String businessCode, AttachmentBusinessType type) {
        if (StringUtils.isBlank(businessCode) || type == null) {
            return Collections.emptyList();
        }
        return getBaseMapper().selectList(Wrappers.lambdaQuery(AttachmentInfo.class).eq(AttachmentInfo::getBusinessCode, businessCode)
                .eq(AttachmentInfo::getBusinessType, type.getCode()));
    }

    @Override
    public List<AttachmentInfo> getByCodeAndType(Collection<String> businessCodes, AttachmentBusinessType type) {
        if (CollectionUtils.isEmpty(businessCodes) || type == null) {
            return Collections.emptyList();
        }
        return getBaseMapper().selectList(Wrappers.lambdaQuery(AttachmentInfo.class).in(AttachmentInfo::getBusinessCode, businessCodes)
                .eq(AttachmentInfo::getBusinessType, type.getCode()));
    }

    /**
     * 业务编码
     *
     * @param businessCode
     * @return
     */
    @Override
    public boolean deleteByBusinessCode(String businessCode) {
        return getBaseMapper().delete(Wrappers.lambdaQuery(AttachmentInfo.class)
                .eq(AttachmentInfo::getBusinessCode,businessCode))>0;
    }

}
