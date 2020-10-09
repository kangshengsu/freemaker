package com.fm.api.gw.controller.evaluation;

import com.fm.api.gw.vo.evaluation.EvaluationInfoVO;
import com.fm.api.gw.vo.evaluation.OverallEvaluationVO;
import com.fm.api.gw.vo.evaluation.mapper.EvaluationMapper;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.evaluation.IEvaluationInfoService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private IEvaluationInfoService evaluationInfoService;

    @Autowired
    private EvaluationMapper evaluationMapper;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public ApiResponse<Boolean> publish(@RequestBody EvaluationInfoVO evaluationInfoVO) {
        EvaluationInfo evaluationInfo = convert(evaluationInfoVO);
        evaluationInfoService.save(evaluationInfo);
        return success(Boolean.TRUE);
    }

    @RequestMapping(value = "/findByOrderId", method = RequestMethod.GET)
    public ApiResponse<EvaluationInfoVO> findByOrderId(@RequestParam("orderId") Long orderId) {
        if (orderId == null) {
            return failed("请选择订单");
        }
        EvaluationInfo evaluationInfo = evaluationInfoService.findByOrderId(orderId);
        return success(evaluationMapper.toEvaluationListVO(evaluationInfo));
    }

    @RequestMapping(value = "/findByCateAndFreelancer", method = RequestMethod.GET)
    public ApiResponse<List<EvaluationInfoVO>> findByCateAndFreelancer(@RequestParam("jobCateId") Long jobCateId,
                                                                       @RequestParam("freelancerId") Long freelancerId,
                                                                       @RequestParam(value = "recent", required = false) Integer recent) {
        if (jobCateId == null) {
            return failed("请选择岗位信息");
        }
        if (freelancerId == null) {
            return failed("请选择作者");
        }
        if (recent != null && (recent <= 0 || recent > 10)) {
            return failed("最近查看数范围为1到10");
        }
        List<EvaluationInfo> evaluationInfos = evaluationInfoService.findByCateAndFreelancer(jobCateId, freelancerId, recent);
        return success(evaluationInfos.stream().map(evaluationInfo ->
                evaluationMapper.toEvaluationListVO(evaluationInfo)).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/findOverallEvaluationByCateAndFreelancer", method = RequestMethod.GET)
    public ApiResponse<OverallEvaluationVO> findOverallEvaluationByCateAndFreelancer(@RequestParam("jobCateId") Long jobCateId,
                                                                                     @RequestParam("freelancerId") Long freelancerId) {
        if (jobCateId == null) {
            return failed("请选择岗位信息");
        }
        if (freelancerId == null) {
            return failed("请选择作者");
        }
        return success(evaluationMapper.toOverallEvaluationVO(evaluationInfoService.findOverallEvaluationByCateAndFreelancer(jobCateId, freelancerId)));
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
