package com.fm.business.base.service.partner;

import com.fm.business.base.model.partner.PartnerInfo;
import com.fm.framework.core.service.Service;

import java.util.List;
import java.util.Set;

public interface PartnerInfoService extends Service<PartnerInfo> {

    /**
     * 查询没有发布过作品的人员信息
     * @param ids
     * @return
     */
    List<PartnerInfo> findNotExistProduction(List<Long> ids);

    boolean setPartner(List<Long> list, Long id);

    List<PartnerInfo> findByBelongId(Long id);

    List<PartnerInfo> findByBelongIds(List<Long> id);

    List<PartnerInfo> findByFreelancerIds(Set<Long> id);

}
