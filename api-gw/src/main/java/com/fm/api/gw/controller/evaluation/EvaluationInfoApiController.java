package com.fm.api.gw.controller.evaluation;

import com.fm.api.gw.vo.evaluation.EvaluationInfoVO;
import com.fm.api.gw.vo.evaluation.OverallEvaluationVO;
import com.fm.api.gw.vo.evaluation.mapper.EvaluationMapper;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.evaluation.IEvaluationInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 评价信息API
 *
 * @author zhangleqi
 * @date 2020-09-21 7:21 下午
 */
@RestController
@RequestMapping("/v1/evaluation")
public class EvaluationInfoApiController extends BaseController<EvaluationInfo, EvaluationInfoVO> {
    private static String DEFAULT_DESCRIPTION = "没有评价描述";

    @Autowired
    private IEvaluationInfoService evaluationInfoService;

    @Autowired
    private EvaluationMapper evaluationMapper;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public ApiResponse<Boolean> publish(@RequestBody @Validated EvaluationInfoVO evaluationInfoVO) {
        EvaluationInfo evaluationInfo = convert(evaluationInfoVO);
        if (StringUtils.isEmpty(evaluationInfo.getDescription())) {
            evaluationInfo.setDescription(DEFAULT_DESCRIPTION);
        }

        evaluationInfoService.save(evaluationInfo);
        return success(Boolean.TRUE);
    }

    @RequestMapping(value = "/findByOrderId", method = RequestMethod.GET)
    public ApiResponse<EvaluationInfoVO> findByOrderId(@RequestParam("orderId") Long orderId) {
        if (orderId == null) {
            return failed("请选择订单");
        }
        EvaluationInfo evaluationInfo = evaluationInfoService.findByOrderId(orderId);
        EvaluationInfoVO evaluationInfoVO = evaluationMapper.toEvaluationListVO(evaluationInfo);
        return success(evaluationInfoVO);
    }

    @RequestMapping(value = "/findByProductionId", method = RequestMethod.GET)
    public ApiResponse<Page<EvaluationInfoVO>> findByProductionId(@RequestParam("productionId") Long productionId,
                                                                       @RequestParam(value = "recent", required = false) Integer recent,
                                                                       @RequestParam(value = "currentPage") Integer currentPage,
                                                                       @RequestParam(value = "pageSize") Integer pageSize,
                                                                       @RequestParam(value = "storeSort",required = false)  Integer storeSort,
                                                                       @RequestParam(value = "timeSort" ,required = false)  Integer timeSort) {
        if (productionId == null) {
            return failed("请选择作品");
        }
        if (recent != null && (recent <= 0 || recent > 50)) {
            return failed("最近查看数范围为1到50");
        }
        Page<EvaluationInfo> evaluationInfos = evaluationInfoService.findByProductionIdPage(productionId, recent, currentPage, pageSize,storeSort,timeSort);
        List<EvaluationInfo> evaluationInfoList = evaluationInfos.getData();
        PageInfo<EvaluationInfoVO> evaluationInfoVOPageInfo = new PageInfo<>();
        ArrayList<EvaluationInfoVO> evaluationInfoVOList = new ArrayList<>();
        evaluationInfoVOPageInfo.setCurrentPage(evaluationInfos.getCurrentPage());
        evaluationInfoVOPageInfo.setPageSize(evaluationInfos.getPageSize());
        evaluationInfoVOPageInfo.setTotal(evaluationInfos.getTotal());

        evaluationInfoList.forEach(evaluationInfo -> {
            EvaluationInfoVO evaluationInfoVO = evaluationMapper.toEvaluationListVO(evaluationInfo);
            evaluationInfoVOList.add(evaluationInfoVO);
        });
        evaluationInfoVOPageInfo.setData(evaluationInfoVOList);
        return ApiResponse.ofSuccess(evaluationInfoVOPageInfo);
    }

    @RequestMapping(value = "/findOverallEvaluationByProductionId", method = RequestMethod.GET)
    public ApiResponse<OverallEvaluationVO> findOverallEvaluationByProductionId(@RequestParam("productionId") Long productionId) {
        if (productionId == null) {
            return failed("请选择作品");
        }
        return success(evaluationMapper.toOverallEvaluationVO(evaluationInfoService.findOverallEvaluationByCateAndFreelancer(productionId)));
    }

    @Override
    protected EvaluationInfo convert(EvaluationInfoVO form) {
        return evaluationMapper.toEvaluation(form);
    }

    @Override
    protected Service<EvaluationInfo> service() {
        return evaluationInfoService;
    }
}
