/**
* @filename:ProductionInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller.production;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fm.api.gw.vo.production.mapper.ProductionMapper;
import com.fm.api.gw.vo.production.view.ProductionViewVO;
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
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
*
* <p>说明： 作品API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/
@Api(value = "/v1/productionViewApi",description ="作品详情相关接口")
@RestController
@RequestMapping("/v1/productionViewApi")
@Validated
public class ProductionViewApi extends BaseController<ProductionInfo, ProductionViewVO>{

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private ProductionMapper productionMapper;
    @Autowired
    private FileService fileService;
    @GetMapping("/getByCode")
    @ApiOperation(value="根据作品编码查看作品详情")
    @ApiImplicitParam(name = "code", value = "作品编码", dataType = "String",paramType = "query")
    public ApiResponse<ProductionViewVO> getByCode(@RequestParam("code") String productionCode){
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


    @GetMapping("/getByLoginUser")
    @ApiOperation(value="获取当前登录人获取作品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="currentPage",value="当前页码",dataType="Integer",paramType = "query"),
            @ApiImplicitParam(name="pageSize",value="每页数量",dataType="Integer",paramType = "query")})
    public ApiResponse<Page<ProductionViewVO>> getByLoginUser(@RequestParam("currentPage") Integer currentPage,
                                                              @RequestParam("pageSize") Integer pageSize){
        return success(convert(productionInfoService.findByFreelancer(currentPage,pageSize,Context.getCurrFreelancerId(),null)));

    }


    @Override
    protected Service<ProductionInfo> service() {
        return productionInfoService;
    }

    @Override
    protected ProductionViewVO convert(ProductionInfo model) {
        ProductionViewVO productionViewVO = productionMapper.toProductionViewVO(model);
        productionViewVO.getImages().forEach(attachmentInfo -> {
            if(StringUtils.isNotBlank(attachmentInfo.getPath())) {
                attachmentInfo.setPath(fileService.getFullPath(attachmentInfo.getPath()));
                attachmentInfo.setOtherPath(fileService.getFullPath(attachmentInfo.getOtherPath()));
            }
        });
        return productionViewVO;

    }

}

