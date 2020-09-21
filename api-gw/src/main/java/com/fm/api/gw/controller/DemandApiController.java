package com.fm.api.gw.controller;

import com.fm.api.gw.vo.DemandInfoVO;
import com.fm.business.base.enums.DemandStatus;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.CodeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangleqi
 * @date 2020-09-21 7:21 下午
 */
@RestController
@RequestMapping("/aip/v1/demandApi")
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

    @Override
    @ApiOperation(value="获取需求分页信息")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<DemandInfoVO>> list(QueryRequest queryRequest) {
        return super.list(queryRequest);
    }


    @ApiOperation(value="根据需求编码更新需求状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name="demandCode",value="需求编码",dataType="String"),
            @ApiImplicitParam(name="status",value="状态",dataType="Integer")})
    @RequestMapping(value = "updateStatus",method = RequestMethod.POST)
    public ApiResponse<Boolean> updateStatus(String demandCode,Integer status) {
        demandInfoService.updateStatusByCode(demandCode, status);
        return ApiResponse.ofSuccess(Boolean.TRUE);
    }

    @ApiOperation(value="根据需求编码获取需求明细信息")
    @ApiImplicitParam(name = "demandCode", value = "需求编码", required = true, dataType = "String")
    @RequestMapping(value = "getByCode",method = RequestMethod.POST)
    public ApiResponse<DemandInfoVO> getByCode(String demandCode) {
        if (StringUtils.isEmpty(demandCode)) {
            return ApiResponse.ofFailed("需求编号不能为空");
        }
        DemandInfo demandInfo = demandInfoService.getByCode(demandCode);
        return ApiResponse.ofSuccess(this.convert(demandInfo));
    }

    @ApiOperation(value="发布新需求")
    @RequestMapping(value = "publish",method = RequestMethod.POST)
    public ApiResponse<String> publish(DemandInfoVO form) {
        form.setCode(CodeUtil.generateNewCode());
        ApiResponse<Boolean> booleanApiResponse = super.create(form);
        if (ApiStatus.SUCCESS.equals(booleanApiResponse.getCode())) {
            return ApiResponse.ofSuccess(form.getCode());
        }
        return ApiResponse.ofFailed(booleanApiResponse.getMessage());

    }

    @ApiOperation(value="根据需求编码更新需求")
    @RequestMapping(value = "updateByCode",method = RequestMethod.POST)
    public ApiResponse<Boolean> updateByCode(DemandInfoVO demandInfoVO) {
        if (StringUtils.isEmpty(demandInfoVO.getCode())) {
            return ApiResponse.ofFailed("需求编号不能为空");
        }
        DemandInfo demandInfo = this.convert(demandInfoVO);
        demandInfoService.updateByCode(demandInfo);
        return ApiResponse.ofSuccess(Boolean.TRUE);
    }


    @Override
    protected Service<DemandInfo> service() {
        return demandInfoService;
    }

    @Override
    protected DemandInfoVO convert(DemandInfo model) {
        DemandInfoVO form = super.convert(model);
        //转换枚举值
        form.setStatusName(DemandStatus.get(model.getStatus()).getName());
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
