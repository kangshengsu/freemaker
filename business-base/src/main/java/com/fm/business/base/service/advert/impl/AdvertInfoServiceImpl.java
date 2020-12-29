package com.fm.business.base.service.advert.impl;

import com.fm.business.base.dao.advert.AdvertInfoMapper;
import com.fm.business.base.enums.TagStatus;
import com.fm.business.base.model.advert.AdvertInfo;
import com.fm.business.base.service.advert.AdvertInfoService;
import com.fm.framework.core.enums.DeleteEnum;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author G
 * @date 2020/12/24 下午2:15
 */
@Slf4j
@Service("advertInfoService")
public class AdvertInfoServiceImpl extends AuditBaseService<AdvertInfoMapper, AdvertInfo> implements AdvertInfoService {
    @Override
    public List<AdvertInfo> findAll() {
        return getBaseMapper().selectList(
                getQueryWrapper().lambda()
                        .eq(AdvertInfo::getIsDelete, DeleteEnum.VALID.getValue())
                        .eq(AdvertInfo::getStatus, TagStatus.ENABLE.getCode()));
    }

    @Override
    public Integer findValidCount() {
        return getBaseMapper().selectCount(
                getQueryWrapper().lambda()
                        .eq(AdvertInfo::getIsDelete, DeleteEnum.VALID.getValue())
                        .eq(AdvertInfo::getStatus, TagStatus.ENABLE.getCode()));
    }
}
