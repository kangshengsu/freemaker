/**
* @filename:ProductionInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller.production;

import com.fm.api.gw.vo.production.mapper.ProductionMapper;
import com.fm.api.gw.vo.production.relation.AttachmentVO;
import com.fm.api.gw.vo.production.req.ProductionApiVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.production.ProductionSkillRelation;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.JsonUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
*
* <p>说明： 作品API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/
@Api(value = "/v1/productionApi",description ="作品操作相关接口")
@RestController
@RequestMapping("/v1/productionApi")
@Validated
public class ProductionApi extends BaseController<ProductionInfo,ProductionApiVO>{

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private ProductionMapper productionMapper;
    /**
     * 发布作品
     *
     * {"id":null,"code":null,"title":"刘铎测试8","summarize":"阿斯达","hourlyWage":2312,"freelancerId":10000,"jobCateId":10006,"images":[{"name":"test1","path":"test/00001.jpg","otherPath":"test/00001.jpg"},{"name":"test2","path":"test/00001.jpg","otherPath":"test/00001.jpg"}],"skills":[{"jobSkillId":22006},{"jobSkillId":44001}]}
     * @param apiVO
     * @return
     */
    @PostMapping("/release")
    @ApiOperation(value="发布作品")
    @ApiImplicitParam(name = "apiVO", value = "作品相关属性", dataType = "ProductionApiVO",paramType = "body")
    public ApiResponse<Boolean> release(@RequestBody @Validated(value = {ProductionApiVO.Release.class}) ProductionApiVO apiVO){
        ProductionInfo productionInfo = convert(apiVO);
        //获取发布作者
        productionInfo.setFreelancerId(Context.getCurrFreelancerId());

        productionInfoService.save(productionInfo);

        return ApiResponse.ofSuccess(Boolean.TRUE);
    }

    /**
     * 修改作品
     *
     * {"id":1,"code":null,"title":"刘铎测试8","summarize":"阿斯达","hourlyWage":2312,"freelancerId":10000,"jobCateId":10006,"images":[{"name":"test1","path":"test/00001.jpg","otherPath":"test/00001.jpg"},{"name":"test2","path":"test/00001.jpg","otherPath":"test/00001.jpg"}],"skills":[{"jobSkillId":22006},{"jobSkillId":44001}]}
     * @param apiVO
     * @return
     */
    @PostMapping("/modify")
    @ApiOperation(value="修改作品")
    @ApiImplicitParam(name = "apiVO", value = "作品相关属性", dataType = "ProductionApiVO",paramType = "body")
    public ApiResponse<Boolean> modify(@RequestBody @Validated(value = {ProductionApiVO.Modify.class}) ProductionApiVO apiVO){

        if(productionInfoService.update(convert(apiVO))){
            return ApiResponse.ofSuccess(Boolean.TRUE);
        }
        return ApiResponse.ofSuccess(Boolean.FALSE);

    }


    @PostMapping("/delStatusByCode")
    @ApiOperation(value="删除作品（变更作品状态为已删除）")
    @ApiImplicitParam(paramType="body", name = "apiVO", value = "作品编码", required = true, dataType = "String")
    public ApiResponse<Boolean> delStatusByCode(@RequestBody @Validated(value = {ProductionApiVO.DelStatusByCode.class}) ProductionApiVO apiVO){
        ProductionInfo updateParam = new ProductionInfo();
        updateParam.setCode(apiVO.getCode());
        updateParam.setStatus(ProductionStatus.DELETED.getCode());
        if(!productionInfoService.updateStatus(updateParam)){
            return failed(String.format("删除%s作品失败",apiVO.getCode()));
        }
        return success(Boolean.TRUE);
    }


    @Override
    protected Service<ProductionInfo> service() {
        return productionInfoService;
    }


    @Override
    protected ProductionInfo convert(ProductionApiVO form) {
        return productionMapper.toProduction(form);
    }
}

