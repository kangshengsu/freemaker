package com.fm.api.gw.controller.jobCate;

import com.fm.api.gw.vo.JobCateDetailVO;
import com.fm.api.gw.vo.JobCateVO;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobCateDetail;
import com.fm.business.base.service.job.IBdJobCateDetailService;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/26 19:55
 */
@RestController
@RequestMapping("/v1/jobCate")
public class JobCateController extends BaseController<BdJobCateDetail, JobCateDetailVO> {
    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IBdJobCateDetailService bdJobCateDetailService;

    @RequestMapping(value = "getHomeShowFirstJobCate",method = RequestMethod.POST)
    @ApiOperation(value = "获取首页一级类目")
    public ApiResponse<List<BdJobCateDetail>> getHomeShowFirstJobCate(){
        return success(bdJobCateDetailService.getHomeShowFirstJobCate());
    }

    @RequestMapping(value = "getFirstJobCate",method = RequestMethod.POST)
    @ApiOperation(value = "获取所有一级类目")
    public ApiResponse<List<BdJobCateDetail>> getFirstJobCate(){
            return success(bdJobCateDetailService.getFirstJobCateAndDetail());
    }

    @RequestMapping(value = "getSecondJobCate",method = RequestMethod.POST)
    @ApiOperation("根据一级类目获取二级类目")
    public ApiResponse<List<BdJobCateDetail>> getSecondJobCate(@RequestParam("cateJobId") Long cateJobId){
        if (Objects.isNull(cateJobId)){
            return failed("请选择类目");
        }
       return success( bdJobCateDetailService.getSecondJobCate(bdJobCateService.getSecondJobCate(cateJobId)));
    }

    

    @Override
    protected Service<BdJobCateDetail> service() {
        return bdJobCateDetailService;
    }
}
