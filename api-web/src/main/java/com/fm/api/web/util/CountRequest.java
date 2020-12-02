package com.fm.api.web.util;

import com.fm.api.web.vo.production.ProductionInfoVO;
import com.fm.framework.core.query.Page;
import lombok.Data;

@Data
public class CountRequest {

    private Page<ProductionInfoVO> data;

    private int count;
}
