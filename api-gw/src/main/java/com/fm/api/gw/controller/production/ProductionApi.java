/**
* @filename:ProductionInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller.production;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.production.AttachmentInfoApiVO;
import com.fm.api.gw.vo.production.ProductionApiVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.production.ProductionSkillRelation;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.JsonUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
*
* <p>说明： 作品API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/
@Api(value = "作品接口",tags={"作品操作相关接口"})
@RestController
@RequestMapping("/v1/productionApi")
@Validated
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
    public ApiResponse<Boolean> release(@RequestBody @Validated(value = {ProductionApiVO.Release.class}) ProductionApiVO apiVO){

        //获取发布作者
        apiVO.setFreelancerId(Context.getCurrUser());

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
    public ApiResponse<Boolean> modify(@RequestBody @Validated(value = {ProductionApiVO.Modify.class}) ProductionApiVO apiVO){

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
                                                            @RequestParam("cateSkill") @Validated() Long cateSkill){

        return success(convert(productionInfoService.findByCateSkill(currentPage,pageSize,cateSkill)));

    }



    @PostMapping("/delStatusByCode")
    @ApiOperation(value="删除作品（变更作品状态为已删除）")
    @ApiImplicitParam(paramType="get", name = "code", value = "作品编码", required = true, dataType = "String")
    public ApiResponse<Boolean> delStatusByCode(@RequestBody @Validated(value = {ProductionApiVO.DelStatusByCode.class}) ProductionApiVO apiVO){
        ProductionInfo updateParam = new ProductionInfo();
        updateParam.setCode(apiVO.getCode());
        updateParam.setStatus(ProductionStatus.DELETED.getCode());
        if(productionInfoService.updateStatus(updateParam)){
            return failed(String.format("删除%s作品失败",apiVO.getCode()));
        }
        return success(Boolean.TRUE);
    }


    @Override
    protected Service<ProductionInfo> service() {
        return productionInfoService;
    }


    @Override
    protected ProductionApiVO convert(ProductionInfo model) {
        ProductionApiVO form = super.convert(model);
        //转换枚举值
        form.setStatusName(ProductionStatus.get(model.getStatus()).getName());
        //岗位名称
        BdJobCate bdJobCate = model.getBdJobCate();
        if (bdJobCate != null) {
            form.setJobCateName(bdJobCate.getCateName());
        }
        //技能标签 树路径
        if(!CollectionUtils.isEmpty(model.getProductionSkillRelations())){
            form.setJobs(model.getProductionSkillRelations().stream().map(productionSkillRelation ->
                    JsonUtil.string2Obj(productionSkillRelation.getSkillTreePath(),new TypeReference<List<Long>>(){}))
                    .collect(Collectors.toList()));
        }
        //附件列表
        if(!CollectionUtils.isEmpty(model.getAttachmentInfos())){
            form.setAttachmentInfos(model.getAttachmentInfos().stream().map(attachmentInfo ->{
                        AttachmentInfoApiVO attachmentInfoApiVO = new AttachmentInfoApiVO();
                        BeanUtils.copyProperties(attachmentInfo,attachmentInfoApiVO);
                        return attachmentInfoApiVO;
                    }).collect(Collectors.toList()));
        }
        //作者 自由职业者
        if(model.getFreelancerInfo()!=null){
            FreelancerInfoApiVO freelancerInfoApiVO = new FreelancerInfoApiVO();
            BeanUtils.copyProperties(model.getFreelancerInfo(),freelancerInfoApiVO);
            form.setFreelancerInfo(freelancerInfoApiVO);
        }

        return form;
    }

    @Override
    protected ProductionInfo convert(ProductionApiVO form) {
        ProductionInfo productionInfo = super.convert(form);
        //现场景只允许选择同一个岗位下的技能
        List<List<Long>> jobs = form.getJobs();
        //获取岗位id
        Long jobCateId = 0L;
        //获取技能
        List<ProductionSkillRelation> productionSkillRelations = new ArrayList<>();
        productionInfo.setProductionSkillRelations(productionSkillRelations);
        for( List<Long> job : jobs ){

            ProductionSkillRelation productionSkillRelation = new ProductionSkillRelation();
            productionSkillRelation.setJobSkillId(job.get(job.size() - 1));
            productionSkillRelation.setSkillTreePath(JsonUtil.obj2String(job));
            productionSkillRelations.add(productionSkillRelation);
            //现阶段只支持 一个岗位下的技能数据
            jobCateId = job.get(job.size() - 2);
        };
        productionInfo.setJobCateId(jobCateId);



        return productionInfo;
    }
}

