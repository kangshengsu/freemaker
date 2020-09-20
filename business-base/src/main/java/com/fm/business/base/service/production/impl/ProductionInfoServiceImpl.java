/**
 * @filename:ProductionInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.production.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.production.IProductionInfoMapper;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.production.ProductionSkillRelation;
import com.fm.business.base.service.IAttachmentInfoService;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.production.IProductionSkillRelationService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:(作品服务实现)
 * @version: V1.0
 * @author: LiuDuo
 */
@Slf4j
@Service("productionInfoService")
public class ProductionInfoServiceImpl extends AuditBaseService<IProductionInfoMapper, ProductionInfo> implements IProductionInfoService {


    @Autowired
    private IFreelancerInfoService freelancerInfoService;

    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IAttachmentInfoService attachmentInfoService;

    @Autowired
    private IProductionSkillRelationService productionSkillRelationService;


    /**
     *
     * @param codes 作品编码集合
     * @return
     */
    @Override
    public List<ProductionInfo> get(Collection<String> codes) {

        if(CollectionUtils.isEmpty(codes)) {
            return Collections.emptyList();
        }

        List<ProductionInfo> result = list(Wrappers.lambdaQuery(ProductionInfo.class).in(ProductionInfo::getCode, codes));

        fillProductInfoRelation(result);

        return result;
    }

    /**
     * 分页查询
     *
     * 完善补全信息
     * @param mybatisPlusPage
     * @return
     */
    @Override
    protected Page<ProductionInfo> toPage(com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductionInfo> mybatisPlusPage) {
        Page<ProductionInfo> productionInfoPage = super.toPage(mybatisPlusPage);
        if(productionInfoPage.getData()!=null && !productionInfoPage.getData().isEmpty()){
            //补全信息
            fillProductInfoRelation(productionInfoPage.getData());
        }
        return productionInfoPage;
    }


    /**
     * 补全数据
     * @param productionInfos
     */
    private void fillProductInfoRelation(Collection<ProductionInfo> productionInfos) {

        if (CollectionUtils.isEmpty(productionInfos)) {
            return;
        }

        Set<Long> freelancerIds = new HashSet<>();

        Set<Long> jobCateIds = new HashSet<>();

        Set<String> attachmentCodes = new HashSet<>();

        Set<Long> productionIds = new HashSet<>();

        productionInfos.forEach(productionInfo -> {
            freelancerIds.add(productionInfo.getFreelancerId());
            jobCateIds.add(productionInfo.getJobCateId());
            attachmentCodes.add(productionInfo.getCode());
            productionIds.add(productionInfo.getId());
        });

        Map<Long, FreelancerInfo> freelancerInfoMap = freelancerInfoService.getByIds(freelancerIds)
                .stream().collect(Collectors.toMap(FreelancerInfo::getId, Function.identity(), (v1, v2) -> v2));

        Map<Long, BdJobCate> jobCateMap = bdJobCateService.getByIds(jobCateIds)
                .stream().collect(Collectors.toMap(BdJobCate::getId, Function.identity(), (v1, v2) -> v2));

        Map<String, List<AttachmentInfo>> attachmentMap = attachmentInfoService.getByCodeAndType(attachmentCodes, AttachmentBusinessType.PRODUCTION)
                .stream().collect(Collectors.toMap(AttachmentInfo::getBusinessCode, v -> {
                    List<AttachmentInfo> list = new ArrayList<>();
                    list.add(v);
                    return list;
                }, (v1, v2) -> {
                    v1.addAll(v2);
                    return v1;
                }));

        Map<Long, List<ProductionSkillRelation>> proSkillRMap = productionSkillRelationService.getByProductionIds(productionIds);


        productionInfos.forEach(productionInfo -> {

            if(freelancerInfoMap.containsKey(productionInfo.getFreelancerId())) {
                productionInfo.setFreelancerInfo(freelancerInfoMap.get(productionInfo.getFreelancerId()));
            }

            if(jobCateMap.containsKey(productionInfo.getJobCateId())) {
                productionInfo.setBdJobCate(jobCateMap.get(productionInfo.getJobCateId()));
            }

            if(attachmentMap.containsKey(productionInfo.getCode())) {
                productionInfo.setAttachmentInfos(attachmentMap.get(productionInfo.getCode()));
            }

            if(proSkillRMap.containsKey(productionInfo.getId())) {
                productionInfo.setProductionSkillRelations(proSkillRMap.get(productionInfo.getId()));
            }

        });

    }

    /**
     * 填充产品关联关系信息
     *
     * @param productionInfo 产品信息
     */
    private void fillProductInfoRelation(ProductionInfo productionInfo) {
        //获取作者数据
        productionInfo.setFreelancerInfo(freelancerInfoService.get(productionInfo.getFreelancerId()));
        //岗位信息
        productionInfo.setBdJobCate(bdJobCateService.get(productionInfo.getJobCateId()));
        //获取附件列表
        productionInfo.setAttachmentInfos(attachmentInfoService.getByCodeAndType(productionInfo.getCode(), AttachmentBusinessType.PRODUCTION));
    }


}