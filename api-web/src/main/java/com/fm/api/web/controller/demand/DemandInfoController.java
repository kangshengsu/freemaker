/**
* @filename:DemandInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.demand;

import com.fm.api.web.vo.demand.DemandInfoVO;
import com.fm.business.base.enums.DemandAttestationType;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.framework.core.query.OrderItem;
import com.fm.framework.core.query.OrderType;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
*
* <p>说明： 需求API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/demand/demandInfo")
public class DemandInfoController extends BaseController<DemandInfo, DemandInfoVO> {

    @Autowired
    private IDemandInfoService demandInfoService;

    @Autowired
    private IEmployerInfoService iEmployerInfoService;

    @Autowired
    private IBdJobCateService iBdJobCateService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody DemandInfoVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody DemandInfoVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<DemandInfoVO>> list(@RequestBody QueryRequest queryRequest) {
        OrderItem orderItem = new OrderItem(OrderType.desc, "createTime");
        queryRequest.setOrderItem(orderItem);
        return super.list(queryRequest);
    }

    @RequestMapping(value="getDemandInfoLikeNameOrCode", method = RequestMethod.GET)
    public ApiResponse<List<DemandInfoVO>> getDemandInfoLikeNameOrCode(@RequestParam("keyword") String keyword) {
        return super.success(this.convert(this.demandInfoService.findDemandInfoLikeNameOrCode(keyword)));
    }

    @RequestMapping(value="setDemandAttestation", method = RequestMethod.POST)
    public ApiResponse<Boolean> setDemandAttestation(@RequestBody DemandInfoVO form) {
        if(form.getAttestation() == 0){
            form.setAttestation(DemandAttestationType.YES_ATTESTATION.getCode());
        }else {
            form.setAttestation(DemandAttestationType.NO_ATTESTATION.getCode());
        }
        return super.update(form);
    }

    @Override
    protected Service<DemandInfo> service() {
        return demandInfoService;
    }

    @Override
    protected DemandInfo convert(DemandInfoVO form) {
        DemandInfo model = new DemandInfo();
        BeanUtils.copyProperties(form,model);
        return model;
    }


}
