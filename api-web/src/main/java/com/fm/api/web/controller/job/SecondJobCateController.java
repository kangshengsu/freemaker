package com.fm.api.web.controller.job;

import com.fm.api.web.vo.job.BdJobCateVO;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobCateDetail;
import com.fm.business.base.service.job.IBdJobCateDetailService;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/24 17:37
 */
@RestController
@RequestMapping(value = "/job/secondJobCate")
public class SecondJobCateController extends BaseController<BdJobCate, BdJobCateVO> {
    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IBdJobCateDetailService bdJobCateDetailService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ApiResponse<Page<BdJobCateVO>> getSecondJobCateDetail(@RequestBody QueryRequest queryRequest) {
        queryRequest.getQueryItems().forEach(queryItem -> {
            if (queryItem.getQueryField().equals("isNew")){
               List<BdJobCateDetail> jobCateDetails = bdJobCateDetailService.getJobCateIdsByIsNew(queryItem);
               if (CollectionUtils.isEmpty(jobCateDetails)){
                   queryItem.setQueryField("id");
                   queryItem.setValue("");
                   queryItem.setType(QueryType.eq);
               }else{
                   List<Long> jobCateIds = jobCateDetails.stream().map(BdJobCateDetail::getJobCateId).collect(Collectors.toList());
                   queryItem.setQueryField("id");
                   queryItem.setValue(jobCateIds);
                   queryItem.setType(QueryType.in);
               }
            }
            if (queryItem.getQueryField().equals("isHot")){
                List<BdJobCateDetail> jobCateDetails = bdJobCateDetailService.getJobCateIdsByIsHot(queryItem);
                if (CollectionUtils.isEmpty(jobCateDetails)){
                    queryItem.setQueryField("id");
                    queryItem.setValue("");
                    queryItem.setType(QueryType.eq);
                }else{
                    List<Long> jobCateIds = jobCateDetails.stream().map(BdJobCateDetail::getJobCateId).collect(Collectors.toList());
                    queryItem.setQueryField("id");
                    queryItem.setValue(jobCateIds);
                    queryItem.setType(QueryType.in);
                }
            }
            if (queryItem.getQueryField().equals("categoryShow")){
                List<BdJobCateDetail> jobCateDetails = bdJobCateDetailService.getJobCateIdsByCategoryShow(queryItem);
                if (CollectionUtils.isEmpty(jobCateDetails)){
                    queryItem.setQueryField("id");
                    queryItem.setValue("");
                    queryItem.setType(QueryType.eq);
                }else{
                    List<Long> jobCateIds = jobCateDetails.stream().map(BdJobCateDetail::getJobCateId).collect(Collectors.toList());
                    queryItem.setQueryField("id");
                    queryItem.setValue(jobCateIds);
                    queryItem.setType(QueryType.in);
                }
            }
        });
        ApiResponse<Page<BdJobCateVO>> list = super.list(queryRequest);
        return list;
    }

    @Override
    protected Service<BdJobCate> service() {
        return bdJobCateService;
    }
}
