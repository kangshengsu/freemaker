package com.fm.api.web.controller.evaluation;

import com.fm.api.web.vo.evaluation.EvaluationReviewVo;
import com.fm.business.base.enums.EvaluationReviewStatus;
import com.fm.business.base.enums.EvaluationStatusEnum;
import com.fm.business.base.model.evaluation.EvaluationReviewInfo;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.service.evaluation.IEvaluationReviewInfoService;
import com.fm.business.base.service.sm.IUserService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 评价审核API接口
 *
 * @author qdl
 * @time 2020.11.17
 */
@RestController
@RequestMapping(value = "/evaluation/evaluationReviewInfo")
public class EvaluationReviewInfoController extends BaseController<EvaluationReviewInfo, EvaluationReviewVo> {

    @Autowired
    private IEvaluationReviewInfoService evaluationReviewInfoService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "reviewPass", method = RequestMethod.POST)
    public ApiResponse<Boolean> reviewPass(@Valid @RequestBody EvaluationReviewVo form) {
        boolean result = evaluationReviewInfoService.review(convert(form), EvaluationReviewStatus.REVIEW_PASS);
        if (!result) {
            return failed("操作失败");
        }
        return success(Boolean.TRUE);
    }

    @RequestMapping(value = "reviewNotPass", method = RequestMethod.POST)
    public ApiResponse<Boolean> reviewNotPass(@Valid @RequestBody EvaluationReviewVo form) {
        boolean result = evaluationReviewInfoService.review(convert(form), EvaluationReviewStatus.REVIEW_NOT_PASS);
        if (!result) {
            return failed("操作失败");
        }
        return success(Boolean.TRUE);
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<EvaluationReviewVo>> list(@RequestBody QueryRequest queryRequest){
        return super.list(queryRequest);
    }


    @Override
    protected Service<EvaluationReviewInfo> service() {
        return evaluationReviewInfoService;
    }

    @Override
    protected EvaluationReviewVo convert(EvaluationReviewInfo model) {
        EvaluationReviewVo form = super.convert(model);
        /**
         * 获取状态名称
         */
        form.setStatusName(EvaluationReviewStatus.get(model.getStatus()).getName());
        User user = userService.get(model.getReviewerId());
        if (user != null){
            form.setReviewerName(user.getName());
        }
        return form;
    }
}
