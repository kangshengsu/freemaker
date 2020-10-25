package com.fm.api.gw.controller;

import com.fm.api.gw.vo.DemandInfoVO;
import com.fm.business.base.enums.BudgetType;
import com.fm.business.base.enums.DeliveryType;
import com.fm.business.base.enums.DemandStatus;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.CodeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhangleqi
 * @date 2020-09-21 7:21 下午
 */
@RestController
@RequestMapping("/v1/demandApi")
@Api(value = "需求接口")
public class DemandApiController extends BaseController<DemandInfo, DemandInfoVO> {

    @Autowired
    private IDemandInfoService demandInfoService;

    @Autowired
    private IEmployerInfoService iEmployerInfoService;

    @Autowired
    private IBdJobCateService iBdJobCateService;

    @Autowired
    private IOrderInfoService iOrderInfoService;

    @ApiOperation(value = "获取需求分页信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query")})
    @RequestMapping(value = "getPageByEmployerId", method = RequestMethod.GET)
    public ApiResponse<Page<DemandInfoVO>> getPageByEmployerId(@RequestParam("currentPage") Integer currentPage,
                                                               @RequestParam("pageSize") Integer pageSize,
                                                               @RequestParam(value = "status", required = false) Integer status) {
        Long currEmployerId = Context.getCurrEmployerId();
        Page<DemandInfoVO> result = new PageInfo<>();
        Page<DemandInfo> demandInfoPage = demandInfoService.gePageByEmployerId(currentPage, pageSize, currEmployerId, status);
        if (demandInfoPage.getData().size() == 0) {
            return ApiResponse.ofSuccess(result);
        }
        return success(this.convert(demandInfoPage));
    }

    @ApiOperation(value = "按领域获取已经发布的需求分页信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query")})
    @RequestMapping(value = "getPageByJobCateId", method = RequestMethod.GET)
    public ApiResponse<Page<DemandInfoVO>> getPageByJobCateId(@RequestParam("currentPage") Integer currentPage,
                                                               @RequestParam("pageSize") Integer pageSize,
                                                               @RequestParam(value = "jobCateId", required = false) Integer jobCateId) {
        Long currEmployerId = Context.getCurrEmployerId();
        Page<DemandInfoVO> result = new PageInfo<>();
        Page<DemandInfo> demandInfoPage = demandInfoService.gePageByStatusJobCateId(currentPage, pageSize,
                currEmployerId, DemandStatus.RELEASE.getCode(),jobCateId);
        if (demandInfoPage.getData().size() == 0) {
            return ApiResponse.ofSuccess(result);
        }
        return success(this.convert(demandInfoPage));
    }

    @ApiOperation(value = "获取不同状态下的需求总数")
    @RequestMapping(value = "getDemandGroupCount", method = RequestMethod.GET)
    public ApiResponse<Map<String, Integer>> getDemandGroupCount() {
        Long currEmployerId = Context.getCurrEmployerId();
        Integer openedCount = demandInfoService.getDemandCountByStatus(currEmployerId, DemandStatus.RELEASE.getCode());
        Integer closedCount = demandInfoService.getDemandCountByStatus(currEmployerId, DemandStatus.CANCEL.getCode());

        Map<String, Integer> groupCount = new HashMap<>();
        groupCount.put("total", openedCount + closedCount);
        groupCount.put("opened", openedCount);
        groupCount.put("closed", closedCount);

        return success(groupCount);
    }

    @ApiOperation(value = "根据需求编码更新需求状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demandCode", value = "需求编码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", dataType = "Integer", paramType = "query")})
    @RequestMapping(value = "updateStatus", method = RequestMethod.GET)
    public ApiResponse<Boolean> updateStatus(@RequestParam("demandCode") String demandCode, @RequestParam("status") Integer status) {
        demandInfoService.updateStatusByCode(demandCode, status);
        return success(Boolean.TRUE);
    }

    @ApiOperation(value = "根据需求编码获取需求明细信息")
    @ApiImplicitParam(name = "demandCode", value = "需求编码", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "getByCode", method = RequestMethod.GET)
    public ApiResponse<DemandInfoVO> getByCode(@RequestParam("demandCode") String demandCode) {
        if (StringUtils.isEmpty(demandCode)) {
            return ApiResponse.ofFailed("需求编号不能为空");
        }
        DemandInfo demandInfo = demandInfoService.getByCode(demandCode);
        return success(this.convert(demandInfo));
    }

    @ApiOperation(value = "发布新需求")
    @RequestMapping(value = "publish", method = RequestMethod.POST)
    public ApiResponse<String> publish(@RequestBody DemandInfoVO form) {
        form.setCode(CodeUtil.generateNewCode2yyMMddHH());
        form.setEmployerId(Context.getCurrEmployerId());
        ApiResponse<Boolean> booleanApiResponse = super.create(form);
        if (ApiStatus.SUCCESS.getCode() == booleanApiResponse.getCode()) {
            return ApiResponse.ofSuccess(form.getCode());
        }
        return success(booleanApiResponse.getMessage());

    }

    @ApiOperation(value = "根据需求编码更新需求")
    @RequestMapping(value = "updateByCode", method = RequestMethod.POST)
    public ApiResponse<Boolean> updateByCode(@RequestBody DemandInfoVO demandInfoVO) {
        if (StringUtils.isEmpty(demandInfoVO.getCode())) {
            return ApiResponse.ofFailed("需求编号不能为空");
        }
        DemandInfo demandInfo = this.convert(demandInfoVO);
        demandInfoService.updateByCode(demandInfo);
        return success(Boolean.TRUE);
    }


    @Override
    protected Service<DemandInfo> service() {
        return demandInfoService;
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


}
