/**
 * @filename:ProductionInfoController 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.gw.controller.production;

import com.fm.api.gw.vo.production.mapper.ProductionMapper;
import com.fm.api.gw.vo.production.req.ProductionApiVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
 * @time 2020年09月11日
 *
 */
@Api(value = "/v1/productionApi", description = "作品操作相关接口")
@RestController
@RequestMapping("/v1/productionApi")
@Validated
public class ProductionApi extends BaseController<ProductionInfo, ProductionApiVO> {

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
    @ApiOperation(value = "发布作品")
    @ApiImplicitParam(name = "apiVO", value = "作品相关属性", dataType = "ProductionApiVO", paramType = "body")
    public ApiResponse<Boolean> release(@RequestBody @Validated(value = {ProductionApiVO.Release.class}) ProductionApiVO apiVO) {
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
    @ApiOperation(value = "修改作品")
    @ApiImplicitParam(name = "apiVO", value = "作品相关属性", dataType = "ProductionApiVO", paramType = "body")
    public ApiResponse<Boolean> modify(@RequestBody @Validated(value = {ProductionApiVO.Modify.class}) ProductionApiVO apiVO) {
        ProductionInfo productionInfo = convert(apiVO);
        productionInfo.setStatus(ProductionStatus.REVIEW.getCode());
        //防止多传入字段 移除不关心字段
        removeUpdateNoCareFiled(apiVO);

        if (productionInfoService.update(productionInfo)) {
            return ApiResponse.ofSuccess(Boolean.TRUE);
        }
        return ApiResponse.ofSuccess(Boolean.FALSE);

    }

    @PostMapping("/delStatusById")
    @ApiOperation(value = "删除作品（彻底删除作品）")
    @ApiImplicitParam(paramType = "body", name = "apiVO", value = "作品", required = true, dataType = "String")
    public ApiResponse<Boolean> delStatusById(@RequestBody @Validated(value = {ProductionApiVO.DelStatusById.class}) ProductionApiVO apiVO) {
        if (!productionInfoService.delete(apiVO.getId())) {
            return failed(String.format("删除%s作品失败", apiVO.getCode()));
        }
        return success(Boolean.TRUE);
    }

    @PostMapping("/cancelReleaseById")
    @ApiOperation(value = "取消发布作品（变更作品状态为未发布）")
    @ApiImplicitParam(paramType = "body", name = "apiVO", value = "作品", required = true, dataType = "String")
    public ApiResponse<Boolean> cancelReleaseById(@RequestBody @Validated(value = {ProductionApiVO.CancelReleaseById.class}) ProductionApiVO apiVO) {

        ProductionInfo productionInfo = productionInfoService.get(apiVO.getId());
        List<Integer> statuses = Arrays.asList(ProductionStatus.RELEASE.getCode());
        if (!statuses.contains(productionInfo.getStatus())) {
            return failed(String.format("不允许取消发布此作品，只允许取消发布【%s】状态的作品", ProductionStatus.RELEASE, apiVO.getCode()));
        }
        ProductionInfo updateParam = new ProductionInfo();
        updateParam.setId(apiVO.getId());
        updateParam.setStatus(ProductionStatus.NOT_RELEASE.getCode());
        if (!productionInfoService.updateStatus(updateParam)) {
            return failed(String.format("取消发布作品%s作品失败", apiVO.getCode()));
        }
        return success(Boolean.TRUE);
    }

    @PostMapping("/reReleaseById")
    @ApiOperation(value = "重新发布作品（变更作品状态为审核中）")
    @ApiImplicitParam(paramType = "body", name = "apiVO", value = "作品", required = true, dataType = "String")
    public ApiResponse<Boolean> reReleaseById(@RequestBody @Validated(value = {ProductionApiVO.ReReleaseById.class}) ProductionApiVO apiVO) {

        ProductionInfo productionInfo = productionInfoService.get(apiVO.getId());
        List<Integer> statuses = Arrays.asList(ProductionStatus.NOT_RELEASE.getCode());
        if (!statuses.contains(productionInfo.getStatus())) {
            return failed(String.format("不允许重新发布此作品，只允许重新发布【%s】状态的作品", ProductionStatus.NOT_RELEASE, apiVO.getCode()));
        }
        ProductionInfo updateParam = new ProductionInfo();
        updateParam.setId(apiVO.getId());
        updateParam.setStatus(ProductionStatus.REVIEW.getCode());
        if (!productionInfoService.updateStatus(updateParam)) {
            return failed(String.format("重新发布作品%s作品失败", apiVO.getCode()));
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

    /**
     * 移除修改时不关心字段
     * @param form
     */
    protected void removeUpdateNoCareFiled(ProductionApiVO form) {

        form.setTs(null);

        if (!CollectionUtils.isEmpty(form.getImages())) {
            form.getImages().stream().forEach(attachmentVO -> attachmentVO.setId(null));
        }
        if (!CollectionUtils.isEmpty(form.getSkills())) {
            form.getSkills().stream().forEach(skillRelationVO -> skillRelationVO.setId(null));
        }

    }

    @GetMapping("/hasProductionById")
    @ApiOperation(value = "通过作者id查看是否发布过作品")
    public ApiResponse<Boolean> hasProductionById() {
        Long currFreelancerId = Context.getCurrFreelancerId();
        Page<ProductionInfo> byFreelancer = productionInfoService.findByFreelancer(1, 20, currFreelancerId, 40);
        if(byFreelancer.getTotal() != 0){
            return ApiResponse.ofSuccess(Boolean.TRUE);
        }
        return failed("用户没有发布过作品");
    }

}

