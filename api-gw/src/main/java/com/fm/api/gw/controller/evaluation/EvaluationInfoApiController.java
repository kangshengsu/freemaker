package com.fm.api.gw.controller.evaluation;

import com.fm.api.gw.vo.evaluation.EvaluationInfoVO;
import com.fm.api.gw.vo.evaluation.mapper.EvaluationMapper;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.service.evaluation.IEvaluationInfoService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/findByCateAndFreelancer", method = RequestMethod.GET)
    public ApiResponse<List<EvaluationInfoVO>> findByCateAndFreelancer(@RequestParam("jobCateId") Long jobCateId,
                                                                   @RequestParam("freelancerId") Long freelancerId) {
        if (jobCateId == null) {
            return failed("请选择岗位信息");
        }
        if (freelancerId == null) {
            return failed("请选择作者");
        }
        List<EvaluationInfo> evaluationInfos = evaluationInfoService.findByCateAndFreelancer(jobCateId, freelancerId);
        return success(evaluationInfos.stream().map(evaluationInfo ->
                evaluationMapper.toEvaluationListVO(evaluationInfo)).collect(Collectors.toList()));
    }


    @Override
    protected Service<EvaluationInfo> service() {
        return evaluationInfoService;
    }
}
