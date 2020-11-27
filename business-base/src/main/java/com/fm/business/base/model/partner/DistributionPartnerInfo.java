package com.fm.business.base.model.partner;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 批量分配合伙人实体类
 */
@Data
public class DistributionPartnerInfo implements Serializable{

    private static final long serialVersionUID = 1600497555102L;

    private List<PartnerInfo> partnerInfoList;

    private Long partnerId;

}
