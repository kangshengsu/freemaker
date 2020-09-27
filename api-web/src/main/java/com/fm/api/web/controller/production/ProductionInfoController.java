/**
* @filename:ProductionInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.production;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fm.api.web.vo.AttachmentInfoVO;
import com.fm.api.web.vo.production.ProductionInfoVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.production.ProductionSkillRelation;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.JsonUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.nodes.CollectionNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
*
* <p>说明： 作品API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/production/productionInfo")
public class ProductionInfoController extends BaseController<ProductionInfo, ProductionInfoVO> {

    @Autowired
    private IProductionInfoService productionInfoService;


    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody ProductionInfoVO form) {

        return super.create(form);

    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "/deleteByIds",method = RequestMethod.POST)
    public ApiResponse<Boolean> deleteByIds(@RequestBody ProductionInfoVO form) {
        //转换批量ID
        if(CollectionUtils.isEmpty(form.getIds())){
            return failed("无删除数据");
        }

        return success(service().delete( form.getIds().stream().map(id -> {
            ProductionInfo productionInfo = new ProductionInfo();
            productionInfo.setId(id);
            return productionInfo;
        }).collect(Collectors.toList())));

    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody ProductionInfoVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ApiResponse<Page<ProductionInfoVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<ProductionInfo> service() {
        return productionInfoService;
    }


    @Override
    protected ProductionInfoVO convert(ProductionInfo model) {
        ProductionInfoVO form = super.convert(model);
        //转换枚举值
        form.setStatusName(ProductionStatus.get(model.getStatus()).getName());
        //岗位名称
        BdJobCate bdJobCate = model.getPostCate();
        if (bdJobCate != null) {
            form.setJobCateName(bdJobCate.getCateName());
        }
        //技能标签 树路径
        if(!CollectionUtils.isEmpty(model.getProductionSkillRelations())){
            form.setJobs(model.getProductionSkillRelations().stream().map(productionSkillRelation ->
                    JsonUtil.string2Obj(productionSkillRelation.getSkillTreePath(),new TypeReference<List<Long>>(){}))
                    .collect(Collectors.toList()));
        }

        return form;
    }

    @Override
    protected ProductionInfo convert(ProductionInfoVO form) {
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
        //不需要审核时直接发布状态
        if(!form.getNeedReview()){
            productionInfo.setStatus(ProductionStatus.RELEASE.getCode());
        }

        return productionInfo;
    }
}

