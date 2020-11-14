package com.fm.api.web.controller.evaluation;

import com.fm.api.web.vo.evaluation.EvaluationInfoVO;
import com.fm.api.web.convert.EvaluationConvert;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.service.evaluation.IEvaluationInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * 评价信息API
 *
 * @author zhangleqi
 * @date 2020-09-21 7:21 下午
 */
@RestController
@RequestMapping("/evaluation")
public class EvaluationInfoController extends BaseController<EvaluationInfo, EvaluationInfoVO> {

    @Autowired
    private IEvaluationInfoService evaluationInfoService;

    @RequestMapping(value = "/findByOrderId", method = RequestMethod.GET)
    public ApiResponse<EvaluationInfoVO> findByOrderId(@RequestParam("orderId") Long orderId) {
        if (orderId == null) {
            return failed("请选择订单");
        }
        EvaluationInfo evaluationInfo = evaluationInfoService.findByOrderId(orderId);
        return success(convert(evaluationInfo));
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody EvaluationInfoVO form) {
        return super.create(form);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody EvaluationInfoVO form) {
        return super.update(form);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {
        return super.delete(id);
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<EvaluationInfoVO>> list(@RequestBody QueryRequest queryRequest){
        return super.list(queryRequest);
    }


    @Override
    protected Service<EvaluationInfo> service() {
        return evaluationInfoService;
    }

    @Override
    protected EvaluationInfoVO convert(EvaluationInfo model) {
        return EvaluationConvert.INSTANCE.to(model);
    }
}
