package com.fm.api.gw.query;

import lombok.Data;

/**
 * 订单信息查询页面
 */
@Data
public class RecommendQueryRequest {
    /**
     * 需求ID
     */
    private Long demandId;

    private Integer pageSize;

    private Integer currPage;
}
