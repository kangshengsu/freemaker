package com.fm.api.web.controller.demand;

import cn.hutool.core.util.ObjectUtil;
import com.fm.api.web.vo.demand.DemandInfoVO;
import com.fm.business.base.enums.DemandAttestationType;
import com.fm.business.base.enums.DemandType;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.demand.DemandRemarkInfo;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.demand.IDemandRemarkInfoService;
import com.fm.framework.core.query.*;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/14 17:09
 */
@RequestMapping("/demand/demandReward")
@RestController
public class DemandRewardController extends BaseController<DemandInfo, DemandInfoVO> {

    @Autowired
    private IDemandInfoService demandInfoService;

    @Autowired
    private IDemandRemarkInfoService demandRemarkInfoService;


    @PostMapping("list")
    public ApiResponse<Page<DemandInfoVO>> list(@RequestBody QueryRequest queryRequest){
        OrderItem orderItem = new OrderItem(OrderType.desc, "createTime");
        queryRequest.setOrderItem(orderItem);
        QueryItem item = new QueryItem();
        item.setQueryField("demandType");
        item.setType(QueryType.eq);
        item.setValue(DemandType.A_REWARD.getCode());
        queryRequest.getQueryItems().add(item);
        Page<DemandInfoVO> data = super.list(queryRequest).getData();
        data.getData().forEach(demandInfoVO -> {
            demandInfoVO.setAttestationName(DemandAttestationType.get(demandInfoVO.getAttestation()).getName());
            DemandRemarkInfo demandRemarkInfo = demandRemarkInfoService.getRemarkInfoByDemandId(demandInfoVO.getId());
            if (ObjectUtil.isNotNull(demandRemarkInfo)) {
                demandInfoVO.setRemarkInfo(demandRemarkInfo.getRemarkInfo());
                demandInfoVO.setNextTime(demandRemarkInfo.getNextTime());
            }
        });
        PageInfo<DemandInfoVO> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(data.getCurrentPage());
        pageInfo.setPageSize(data.getPageSize());
        pageInfo.setTotal(data.getTotal());
        pageInfo.setData(data.getData());
        return success(pageInfo);
    }

    @Override
    protected Service<DemandInfo> service() {
        return demandInfoService;
    }
}
