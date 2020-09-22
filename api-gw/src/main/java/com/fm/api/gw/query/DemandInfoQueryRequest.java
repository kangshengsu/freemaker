package com.fm.api.gw.query;

import lombok.Data;

/**
 * 需求信息查询页面
 */
@Data
public class DemandInfoQueryRequest {
    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer currPage;

    /**
     * 雇佣者主键
     */
    private Long employerId;
}
