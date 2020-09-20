package com.fm.api.gw.vo.conf;

import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 展现配置聚合VO
 * @author hubo
 * @version 1.0.0
 **/
@Data
public class AggDisplayConfigVO implements Serializable {

    private List<BdJobCate> firstLevelJobs;

    private List<BdJobCate> secondLevelJobs;

    private List<ProductionInfo> recommendProductInfos;

}
