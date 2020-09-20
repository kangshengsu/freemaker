package com.fm.api.web.vo.demand;

import lombok.Data;

import java.util.List;

/**
 * @author zhangleqi
 * @date 2020-09-20 7:30 上午
 */
@Data
public class RecommendVO {
    private Long demandId;
    private List<Long> productionIds;
}
