package com.fm.api.gw.vo;

import lombok.Data;

@Data
public class PublishStatusVo {
    /**
     * 是否发布作品
     */
    private boolean hasProduction;

    /**
     * 是否设置公司
     */
    private boolean hasCompany;
}
