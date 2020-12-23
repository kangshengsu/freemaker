package com.fm.api.gw.vo.collect;

import com.fm.api.gw.vo.demand.DemandInfoVO;
import com.fm.api.gw.vo.production.view.ProductionViewVO;
import com.fm.framework.core.query.Page;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;


/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/21 18:45
 */
@Data
public class CollectInfoVO extends VO implements Serializable {
    private static final long serialVersionUID = 3728371364911718106L;



    /**
     *用户主键
     */
    private Long userId;

    /**
     * 收藏信息主键
     */
    private Long collect;

    /**
     * 收藏类型(10-作品  20-需求)
     */
    private Long collectType;

    /**
     * 收藏状态(10-收藏 20-取消)
     */
    private Integer status;

    /**
     *收藏作品信息
     */
    private transient Page<ProductionViewVO> productionInfo;

    /**
     * 收藏需求信息
     */
    private transient Page<DemandInfoVO> demandInfo;

    /**
     * 收藏需求数量
     */
    private transient Map<String,Integer> demandInfoCount;

}
