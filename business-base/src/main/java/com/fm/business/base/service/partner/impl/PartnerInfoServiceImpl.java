package com.fm.business.base.service.partner.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fm.business.base.dao.partner.PartnerInfoMapper;
import com.fm.business.base.enums.DistributionStatus;
import com.fm.business.base.model.partner.PartnerInfo;
import com.fm.business.base.service.partner.PartnerInfoService;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("partnerInfoService")
public class PartnerInfoServiceImpl extends AuditBaseService<PartnerInfoMapper, PartnerInfo> implements PartnerInfoService {
    @Override
    public List<PartnerInfo> findNotExistProduction(List<Long> ids) {
        QueryWrapper<PartnerInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct freelancer_Id")
                .notIn("freelancer_Id", ids);
        return getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public boolean setPartner(List<Long> list, Long id) {
        UpdateWrapper<PartnerInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("belong_id",id).in("freelancer_id", list);
        updateWrapper.set("distribution_status", DistributionStatus.YES_DISTRIBUTION.getCode()).in("freelancer_id", list);
        return super.update(updateWrapper);
    }
}
