package com.fm.business.base.service.rotation.impl;

import com.fm.business.base.dao.rotation.RotationMapper;
import com.fm.business.base.enums.TagStatus;
import com.fm.business.base.model.rotation.RotationInfo;
import com.fm.business.base.service.rotation.RotationService;
import com.fm.framework.core.enums.DeleteEnum;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author G
 * @date 2020/12/25 下午2:20
 */
@Slf4j
@Service("rotationService")
public class RotationServiceImpl extends AuditBaseService<RotationMapper, RotationInfo> implements RotationService {
    @Override
    public List<RotationInfo> findAll() {
        return getBaseMapper().selectList(
                getQueryWrapper().lambda()
                        .eq(RotationInfo::getIsDelete, DeleteEnum.VALID.getValue())
                        .eq(RotationInfo::getStatus, TagStatus.ENABLE.getCode()));
    }
}
