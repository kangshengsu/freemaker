package com.fm.api.gw.vo.conf;

import com.fm.api.gw.vo.production.list.ProductionListVO;
import com.fm.api.gw.vo.production.req.ProductionApiVO;
import com.fm.framework.core.query.Page;
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

    private List<JobCateDisplayVO> firstLevelJobs;

    private List<JobCateDisplayVO> secondLevelJobs;

    private List<ProductionListVO> recommendProductInfos;

    private Page<ProductionListVO> productionListInfo;

}
