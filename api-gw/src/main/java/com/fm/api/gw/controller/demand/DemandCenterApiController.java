package com.fm.api.gw.controller.demand;

import cn.hutool.core.util.ObjectUtil;
import com.fm.api.gw.vo.demand.DemandInfoVO;
import com.fm.api.gw.vo.demand.mapper.DemandInfoMapper;
import com.fm.business.base.enums.*;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.collect.CollectInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.collect.ICollectInfoService;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandCenterInfoService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController
@RequestMapping("/v1/demandCenterApi")
@Api(value = "需求中心接口")
public class DemandCenterApiController extends BaseController<DemandInfo, DemandInfoVO> {

    @Autowired
    private IDemandCenterInfoService demandCenterInfoService;

    @Autowired
    private IEmployerInfoService iEmployerInfoService;

    @Autowired
    private IBdJobCateService iBdJobCateService;

    @Autowired
    private IOrderInfoService iOrderInfoService;

    @Autowired
    private DemandInfoMapper demandInfoMapper;

    @Autowired
    private ICollectInfoService collectInfoService;

    /**
     * @param currentPage
     * @param pageSize
     * @param jobCateId
     * @return
     */
    @ApiOperation(value = "需求中心信息分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "jobCateId", value = "领域id", dataType = "Integer", paramType = "query")})
    @RequestMapping(value = "getDemandCenterPage", method = RequestMethod.GET)
    public ApiResponse<Page<DemandInfoVO>> getDemandCenterPage(@RequestParam("currentPage") Integer currentPage,
                                                               @RequestParam("pageSize") Integer pageSize,
                                                               @RequestParam(value = "attestation", required = false) Integer attestation,
                                                               @RequestParam(value = "jobCateId", required = false) Integer jobCateId) {
        Page<DemandInfoVO> result = new PageInfo<>();
        Page<DemandInfo> demandInfoPage = demandCenterInfoService.getDemandCenterPage(currentPage, pageSize, attestation, jobCateId);
        if (demandInfoPage.getData().size() == 0) {
            return ApiResponse.ofSuccess(result);
        }
        return success(this.convert(demandInfoPage));
    }

    /**
     * @param code
     * @return
     */
    @ApiOperation(value = "按需求编码获取需求中心详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "需求编码", dataType = "String", paramType = "query")})
    @RequestMapping(value = "getDemandCenterDtlByCode", method = RequestMethod.GET)
    public ApiResponse<DemandInfoVO> getDemandCenterDtlByCode(@RequestParam(value = "code", required = false) String code, HttpServletRequest request) {
        DemandInfo demandInfo = demandCenterInfoService.getDemandCenterDtlByCode(code);
        Boolean isNeedValid = Boolean.valueOf(request.getHeader("isNeedValid"));
        Long userId = null;
        if (isNeedValid) {
            userId = Context.getCurrUserId();
        }
        if (userId != null && ObjectUtil.isNotNull(userId)) {
            CollectInfo collectInfo = collectInfoService.getCollectInfo(userId, demandInfo.getId(), (long) CollectType.DEMAND.getCode());
            if (ObjectUtil.isNotNull(collectInfo) && collectInfo.getStatus() == CollectStatus.COLLECT.getCode()) {
                demandInfo.setIsCollect(Boolean.TRUE);
            }else{
                demandInfo.setIsCollect(Boolean.FALSE);
            }
        }else{
            demandInfo.setIsCollect(Boolean.FALSE);
        }
        return success(this.fill(demandInfo));
    }

    @Override
    protected Service<DemandInfo> service() {
        return demandCenterInfoService;
    }

    @Override
    protected DemandInfoVO convert(DemandInfo model) {
        if (Objects.isNull(model)) {
            return null;
        }
        DemandInfoVO form = super.convert(model);
        //转换枚举值
        form.setStatusName(DemandStatus.get(model.getStatus()).getName());
        form.setDeliveryTypeName(DeliveryType.getNameByCode(model.getDeliveryType()));
        form.setBudgetTypeName(BudgetType.getNameByCode(model.getBudgetType()));
        //获取作者数据
        EmployerInfo employerInfo = iEmployerInfoService.get(model.getEmployerId());
        if (employerInfo != null) {
            form.setEmployerName(employerInfo.getName());
        }
        //获取需求信息
        BdJobCate bdJobCate = iBdJobCateService.get(model.getJobCateId());
        if (bdJobCate != null) {
            form.setJobCateIdName(bdJobCate.getCateName());
        }
        form.setOrderCount(iOrderInfoService.getOrderCountByDemandId(form.getId()));
        return form;
    }

    /**
     * 额外填充个人信息头像电话等信息
     *
     * @param model
     * @return
     */
    protected DemandInfoVO fill(DemandInfo model) {
        if (Objects.isNull(model)) {
            return null;
        }
        DemandInfoVO form = demandInfoMapper.toDemandInfoVO(model);
        //转换枚举值
        form.setStatusName(DemandStatus.get(model.getStatus()).getName());
        form.setDeliveryTypeName(DeliveryType.getNameByCode(model.getDeliveryType()));
        form.setBudgetTypeName(BudgetType.getNameByCode(model.getBudgetType()));
        //获取作者数据
        EmployerInfo employerInfo = iEmployerInfoService.get(model.getEmployerId());
        if (employerInfo != null) {
            form.setEmployerName(employerInfo.getName());
        }
        //获取需求信息
        BdJobCate bdJobCate = iBdJobCateService.get(model.getJobCateId());
        if (bdJobCate != null) {
            form.setJobCateIdName(bdJobCate.getCateName());
        }
        form.setOrderCount(iOrderInfoService.getOrderCountByDemandId(form.getId()));

        Long currUserId = Context.getCurrUserId();
        if (currUserId != null) {
            EmployerInfo userEmployerInfo = iEmployerInfoService.getByUserId(currUserId);
            form.setUserEmployerId(userEmployerInfo.getId());
        }
        return form;
    }

}
