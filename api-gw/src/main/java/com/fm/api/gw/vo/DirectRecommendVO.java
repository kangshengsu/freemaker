package com.fm.api.gw.vo;

import lombok.Data;

import java.util.List;

/**
 * @author zhangleqi
 * @date 2020-09-20 7:30 上午
 */
@Data
public class DirectRecommendVO {
    private Long demandId;
    private List<Long> productionIds;
}
