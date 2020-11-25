package com.fm.business.base.service.partner;

import com.fm.business.base.model.partner.PartnerInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

public interface PartnerInfoService extends Service<PartnerInfo> {

    /**
     * 查询没有发布过作品的人员信息
     * @param ids
     * @return
     */
    List<PartnerInfo> findNotExistProduction(List<Long> ids);

    boolean setPartner(List<Long> list, Long id);

}
