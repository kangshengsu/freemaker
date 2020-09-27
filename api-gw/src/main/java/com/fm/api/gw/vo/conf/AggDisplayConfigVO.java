package com.fm.api.gw.vo.conf;

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

    private List<ProductListVO> recommendProductInfos;

}
