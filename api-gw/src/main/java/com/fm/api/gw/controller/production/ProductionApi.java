/**
* @filename:ProductionInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller.production;

import com.fm.api.gw.vo.production.ProductionApiVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
*
* <p>说明： 作品API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/
@Api(value = "作品接口")
@RestController
@RequestMapping("/v1/productionApi")
public class ProductionApi extends BaseController<ProductionInfo,ProductionApiVO>{

    @Autowired
    private IProductionInfoService productionInfoService;

    /**
     * 发布作品
     *
     * 样例报文：{"id":"","code":"","title":"样例标题","summarize":"样例描述","hourlyWage":998,"freelancerId":3,"needReview":true,"jobs":[[8000,8001,16002],[8000,8001,18000],[8000,8001,20007]],"attachmentInfoPaths":["test/00001.jpg","test/00001.jpg"]}
     *
     * @param apiVO
     * @return
     */
    @PostMapping("/release")
    @ApiOperation(value="发布作品")
    @ApiImplicitParam(name = "apiVO", value = "作品相关属性", dataType = "ProductionApiVO")
    public ApiResponse<Boolean> release(@RequestBody ProductionApiVO apiVO){

        productionInfoService.save(convert(apiVO));

        return ApiResponse.ofSuccess(Boolean.TRUE);
    }

    /**
     * 修改作品
     *
     * 样例报文：{"id":"1","code":"","title":"样例标题","summarize":"样例描述","hourlyWage":998,"freelancerId":3,"needReview":true,"jobs":[[8000,8001,16002],[8000,8001,18000],[8000,8001,20007]],"attachmentInfoPaths":["test/00001.jpg","test/00001.jpg"]}
     * @param apiVO
     * @return
     */
    @PostMapping("/modify")
    @ApiOperation(value="修改作品")
    @ApiImplicitParam(name = "apiVO", value = "作品相关属性", dataType = "ProductionApiVO")
    public ApiResponse<Boolean> modify(@RequestBody ProductionApiVO apiVO){

        productionInfoService.update(convert(apiVO));

        return ApiResponse.ofSuccess(Boolean.TRUE);
    }

    @GetMapping("/getByCode")
    @ApiOperation(value="根据作品编码查看作品详情")
    @ApiImplicitParam(name = "code", value = "作品编码", dataType = "String")
    public ApiResponse<ProductionApiVO> getByCode(@RequestParam("code") String productionCode){
        Set<String> productionCodes = new HashSet<>();
        productionCodes.add(productionCode);
        List<ProductionInfo> productionInfos = productionInfoService.get(productionCodes);
        if(CollectionUtils.isEmpty(productionInfos)){
            return failed(String.format("未获取到%s作品数据",productionCode));
        }else if(productionInfos.size() > 1){
            return failed(String.format("获取到多个%s作品数据",productionCode));
        }
        return success(convert(productionInfos.get(0)));
    }

    @GetMapping("/getByCateDomain")
    @ApiOperation(value="根据领域获取作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="cateDomain",value="领域ID",dataType="Long"),
            @ApiImplicitParam(name="currentPage",value="当前页码",dataType="Integer"),
            @ApiImplicitParam(name="pageSize",value="每页数量",dataType="Integer")})
    public ApiResponse<Page<ProductionApiVO>> getByCateDomain(@RequestParam("currentPage") Integer currentPage,
                                                                    @RequestParam("pageSize") Integer pageSize,
                                                                    @RequestParam("cateDomain") Long cateDomain){

        return success(convert(productionInfoService.findByCateDomain(currentPage,pageSize,cateDomain)));

    }

    @GetMapping("/getByCatePost")
    @ApiOperation(value="根据岗位获取作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="catePost",value="岗位ID",dataType="Long"),
            @ApiImplicitParam(name="currentPage",value="当前页码",dataType="Integer"),
            @ApiImplicitParam(name="pageSize",value="每页数量",dataType="Integer")})
    public ApiResponse<Page<ProductionApiVO>> getByCatePost(@RequestParam("currentPage") Integer currentPage,
                                                              @RequestParam("pageSize") Integer pageSize,
                                                              @RequestParam("catePost") Long catePost){

        return success(convert(productionInfoService.findByCatePost(currentPage,pageSize,catePost)));

    }
    @GetMapping("/getByCateSkill")
    @ApiOperation(value="根据技能获取作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="cateSkill",value="技能ID",dataType="Long"),
            @ApiImplicitParam(name="currentPage",value="当前页码",dataType="Integer"),
            @ApiImplicitParam(name="pageSize",value="每页数量",dataType="Integer")})
    public ApiResponse<Page<ProductionApiVO>> getByCateSkill(@RequestParam("currentPage") Integer currentPage,
                                                            @RequestParam("pageSize") Integer pageSize,
                                                            @RequestParam("cateSkill") Long cateSkill){

        return success(convert(productionInfoService.findByCateSkill(currentPage,pageSize,cateSkill)));

    }



    @GetMapping("/delStatusByCode")
    @ApiOperation(value="删除作品（变更作品状态为已删除）")
    @ApiImplicitParam(paramType="get", name = "code", value = "作品编码", required = true, dataType = "String")
    public ApiResponse<Boolean> delStatusByCode(@RequestParam("code") String productionCode){
        ProductionInfo updateParam = new ProductionInfo();
        updateParam.setCode(productionCode);
        updateParam.setStatus(ProductionStatus.DELETED.getCode());
        if(productionInfoService.updateStatus(updateParam)){
            return failed(String.format("删除%s作品失败",productionCode));
        }
        return success(Boolean.TRUE);
    }


    @Override
    protected Service<ProductionInfo> service() {
        return productionInfoService;
    }
}

