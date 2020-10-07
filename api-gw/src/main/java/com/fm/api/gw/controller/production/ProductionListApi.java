/**
 * @filename:ProductionInfoController 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.gw.controller.production;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fm.api.gw.vo.production.list.ProductionListVO;
import com.fm.api.gw.vo.production.mapper.ProductionMapper;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.FileService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 *
 * <p>说明： 作品API接口层</p>
 * @version: V1.0
 * @author: LiuDuo
 * @time    2020年09月11日
 *
 */
@Api(value = "/v1/productionListApi",description ="作品列表相关接口")
@RestController
@RequestMapping("/v1/productionListApi")
@Validated
public class ProductionListApi extends BaseController<ProductionInfo,ProductionListVO>{

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private ProductionMapper productionMapper;
    @Autowired
    private FileService fileService;


    @GetMapping("/getByCateDomain")
    @ApiOperation(value="根据领域获取作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="cateDomain",value="领域ID",dataType="Long",paramType = "query"),
            @ApiImplicitParam(name="currentPage",value="当前页码",dataType="Integer",paramType = "query"),
            @ApiImplicitParam(name="pageSize",value="每页数量",dataType="Integer",paramType = "query")})
    public ApiResponse<Page<ProductionListVO>> getByCateDomain(@RequestParam("currentPage") Integer currentPage,
                                                               @RequestParam("pageSize") Integer pageSize,
                                                               @RequestParam("cateDomain") Long cateDomain){


        return success(convert(productionInfoService.findByCateDomain(currentPage,pageSize,cateDomain)));

    }

    @GetMapping("/getByCatePost")
    @ApiOperation(value="根据岗位获取作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="catePost",value="岗位ID",dataType="Long",paramType = "query"),
            @ApiImplicitParam(name="currentPage",value="当前页码",dataType="Integer",paramType = "query"),
            @ApiImplicitParam(name="pageSize",value="每页数量",dataType="Integer",paramType = "query")})
    public ApiResponse<Page<ProductionListVO>> getByCatePost(@RequestParam("currentPage") Integer currentPage,
                                                             @RequestParam("pageSize") Integer pageSize,
                                                             @RequestParam("catePost") Long catePost){

        return success(convert(productionInfoService.findByCatePost(currentPage,pageSize,catePost)));

    }

    @GetMapping("/getByCateSkill")
    @ApiOperation(value="根据技能获取作品（暂时作废，小程序无此诉求，如继续需使用请处理主子表依赖子表状态分页问题）")
    @ApiImplicitParams({
            @ApiImplicitParam(name="cateSkill",value="技能ID",dataType="Long",paramType = "query"),
            @ApiImplicitParam(name="currentPage",value="当前页码",dataType="Integer",paramType = "query"),
            @ApiImplicitParam(name="pageSize",value="每页数量",dataType="Integer",paramType = "query")})
    @Deprecated
    public ApiResponse<Page<ProductionListVO>> getByCateSkill(@RequestParam("currentPage") Integer currentPage,
                                                              @RequestParam("pageSize") Integer pageSize,
                                                              @RequestParam("cateSkill") Long cateSkill){

        return success(convert(productionInfoService.findByCateSkill(currentPage,pageSize,cateSkill)));

    }

    @GetMapping("/getByFreelancer")
    @ApiOperation(value="根据作者获取作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="freelancerId",value="自由职业者ID",dataType="Long",paramType = "query"),
            @ApiImplicitParam(name="currentPage",value="当前页码",dataType="Integer",paramType = "query"),
            @ApiImplicitParam(name="pageSize",value="每页数量",dataType="Integer",paramType = "query")})
    public ApiResponse<Page<ProductionListVO>> getByFreelancer(@RequestParam("currentPage") Integer currentPage,
                                                              @RequestParam("pageSize") Integer pageSize){
        //所有状态都要查出来 注释了先
//        Integer[] statues = {ProductionStatus.RELEASE.getCode()};
        return success(convert(productionInfoService.findByFreelancer(currentPage,pageSize,Context.getCurrFreelancerId(),null)));

    }

    @Override
    protected Service<ProductionInfo> service() {
        return productionInfoService;
    }

    @Override
    protected ProductionListVO convert(ProductionInfo model) {
        ProductionListVO productionListVO = productionMapper.toProductionListVO(model);
        return productionListVO;

    }
}

