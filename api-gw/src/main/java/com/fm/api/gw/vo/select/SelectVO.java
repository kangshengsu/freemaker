package com.fm.api.gw.vo.select;

import com.fm.api.gw.vo.demand.DemandInfoVO;
import com.fm.api.gw.vo.production.view.ProductionViewVO;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.framework.core.query.Page;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/23 14:47
 */
@Data
public class SelectVO extends VO implements Serializable {
    private static final long serialVersionUID = -2036143260161040625L;

    /**
     * 搜索作品结果
     */
    private Page<ProductionViewVO> productionViewVO;

    /**
     * 搜索需求结果
     */
    private Page<DemandInfoVO> demandInfoVO;
}
