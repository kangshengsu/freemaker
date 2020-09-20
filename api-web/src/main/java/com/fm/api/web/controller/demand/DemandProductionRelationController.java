/**
* @filename:DemandProductionRelationController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.demand;

import com.fm.api.web.vo.demand.DemandProductionRelationVO;
import com.fm.api.web.vo.demand.RecommendVO;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.demand.IDemandProductionRelationService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.constants.SymbolConstants;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.SubModelCompareResult;
import com.fm.framework.core.utils.UpdateUtils;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
*
* <p>说明： 需求作品关系API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/demandProductionRelation")
public class DemandProductionRelationController extends BaseController<DemandProductionRelation, DemandProductionRelationVO> {

    @Autowired
    private IDemandProductionRelationService demandProductionRelationService;

    @Autowired
    private IProductionInfoService iProductionInfoService;

    @Autowired
    private IFreelancerInfoService iFreelancerInfoService;

    @RequestMapping(value = "getRelationByDemandId",method = RequestMethod.GET)
    public ApiResponse<List<DemandProductionRelationVO>> getRelationByDemandId(Long demandId) {

        List<DemandProductionRelationVO> datas = demandProductionRelationService.getByDemandId(demandId).stream().map(this::convert).collect(Collectors.toList());
        return ApiResponse.ofSuccess(datas);
    }


    @RequestMapping(value = "recommend",method = RequestMethod.POST)
    public ApiResponse<Boolean> recommend(@RequestBody RecommendVO recommendVO) {
        demandProductionRelationService.recommend(recommendVO.getDemandId(),recommendVO.getProductionIds());
        return ApiResponse.ofSuccess(Boolean.TRUE);
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody DemandProductionRelationVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody DemandProductionRelationVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<DemandProductionRelationVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<DemandProductionRelation> service() {
        return demandProductionRelationService;
    }

    @Override
    protected DemandProductionRelation convert(DemandProductionRelationVO form) {
        DemandProductionRelation model = new DemandProductionRelation();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected DemandProductionRelationVO convert(DemandProductionRelation model) {
        DemandProductionRelationVO form = super.convert(model);
        ProductionInfo productionInfo = iProductionInfoService.get(form.getProductionId());
        if (productionInfo != null) {
            form.setProductionName(productionInfo.getTitle());
            FreelancerInfo freelancerInfo = iFreelancerInfoService.get(productionInfo.getFreelancerId());
            if (freelancerInfo != null) {
                form.setFreelancerName(freelancerInfo.getName());
            }
        }
        return form;
    }

}
