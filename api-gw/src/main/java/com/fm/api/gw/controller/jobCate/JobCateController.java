package com.fm.api.gw.controller.jobCate;

import com.fm.api.gw.vo.jobCate.JobCateDetailVO;
import com.fm.api.gw.vo.jobCate.mapper.JobCateDetailMapper;
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
@Api(value = "/v1/jobCate",description ="类目查询接口")
public class JobCateController extends BaseController<BdJobCateDetail, JobCateDetailVO> {
    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IBdJobCateDetailService bdJobCateDetailService;

    @Autowired
    private JobCateDetailMapper jobCateDetailMapper;

    @RequestMapping(value = "getHomeShowFirstJobCate",method = RequestMethod.GET)
    @ApiOperation(value = "获取首页一级类目")
    public ApiResponse<List<JobCateDetailVO>> getHomeShowFirstJobCate(){
        return success(bdJobCateDetailService.getHomeShowFirstJobCate().stream().map(jobCateDetailMapper::toJobCateDetailVO).collect(Collectors.toList()));
    }

    @RequestMapping(value = "getFirstJobCate",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有一级类目")
    public ApiResponse<List<JobCateDetailVO>> getFirstJobCate(){
            return success(bdJobCateDetailService.getFirstJobCateAndDetail().stream().map(jobCateDetailMapper::toJobCateDetailVO).collect(Collectors.toList()));
    }

    @RequestMapping(value = "getSecondJobCate",method = RequestMethod.GET)
    @ApiOperation("根据一级类目获取二级类目")
    public ApiResponse<List<JobCateDetailVO>> getSecondJobCate(@RequestParam("cateJobId") Long cateJobId){
        if (Objects.isNull(cateJobId)){
            return failed("请选择类目");
        }
       return success( bdJobCateDetailService.getSecondJobCate(bdJobCateService.getSecondJobCate(cateJobId)).stream().map(jobCateDetailMapper::toJobCateDetailVO).collect(Collectors.toList()));
    }

    

    @Override
    protected Service<BdJobCateDetail> service() {
        return bdJobCateDetailService;
    }
}
