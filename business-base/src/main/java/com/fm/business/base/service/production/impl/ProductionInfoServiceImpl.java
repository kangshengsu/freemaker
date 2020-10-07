/**
 * @filename:ProductionInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.production.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.production.IProductionInfoMapper;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.enums.AttachmentType;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.demand.DemandInfo;
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
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.AuditBaseService;
import com.fm.framework.core.utils.CodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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


    @Override
    protected void beforeSave(ProductionInfo model) {
        super.beforeSave(model);
        //生成code
        model.setCode(CodeUtil.generateNewCode());
        if (model.getStatus() == null) {
            model.setStatus(ProductionStatus.REVIEW.getCode());
        }
    }

    @Override
    protected void afterSave(ProductionInfo model) {
        super.afterSave(model);
        //保存 作品技能关系数据
        saveSkills(model);
        //保存 附件数据
        saveAttachments(model);

    }

    @Override
    protected void afterUpdate(ProductionInfo model) {
        super.afterUpdate(model);
        //移除所有技能和附件并重新保存
        productionSkillRelationService.deleteByProductionId(model.getId());
        //保存 作品技能关系数据
        saveSkills(model);

        attachmentInfoService.deleteByBusinessCode(model.getCode());

        //保存 附件数据
        saveAttachments(model);


    }

    /**
     * @param codes 作品编码集合
     * @return
     */
    @Override
    public List<ProductionInfo> get(Collection<String> codes) {

        if (CollectionUtils.isEmpty(codes)) {
            return Collections.emptyList();
        }

        List<ProductionInfo> result = list(Wrappers.lambdaQuery(ProductionInfo.class).in(ProductionInfo::getCode, codes));

        fillProductInfoRelation(result);

        return result;
    }

    @Override
    public List<ProductionInfo> getFullInfo(Collection<Long> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }

        List<ProductionInfo> result = getByIds(ids);

        fillProductInfoRelation(result);

        return result;
    }

    /**
     * 变更审核状态
     *
     * @param productionInfo
     * @return
     */
    @Override
    public boolean updateStatus(ProductionInfo productionInfo) {
        if (productionInfo.getId() == null && productionInfo.getCode() == null) {
            return false;
        }
        LambdaUpdateWrapper<ProductionInfo> wrapper = Wrappers.lambdaUpdate(ProductionInfo.class)
                .set(ProductionInfo::getStatus, productionInfo.getStatus());
        if (productionInfo.getId() != null) {
            wrapper.eq(ProductionInfo::getId, productionInfo.getId());
        }
        if (productionInfo.getCode() != null) {
            wrapper.eq(ProductionInfo::getCode, productionInfo.getCode());
        }
        return getBaseMapper().update(productionInfo, wrapper) > 0;
    }

    /**
     * 分页获取领域下的所有作品
     *
     * @param currentPage
     * @param pageSize
     * @param cateDomain  领域ID
     * @return 只返回已发布作品
     */
    @Override
    public Page<ProductionInfo> findByCateDomain(Integer currentPage, Integer pageSize, Long cateDomain) {
        //获取领域下所有岗位
        List<BdJobCate> catePosts = bdJobCateService.findJobCatePost(cateDomain, null);
        if (CollectionUtils.isEmpty(catePosts)) {
            return new PageInfo<>();
        }

        //根据岗位获取作品数据
        Wrapper queryWrapper = Wrappers.lambdaQuery(ProductionInfo.class).eq(ProductionInfo::getStatus, ProductionStatus.RELEASE.getCode())
                .in(ProductionInfo::getJobCateId, catePosts.stream().map(bdJobCate -> bdJobCate.getId()).collect(Collectors.toSet()));

        return toPage(getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize), queryWrapper));
    }

    /**
     * 分页获取岗位下的所有作品
     *
     * @param currentPage
     * @param pageSize
     * @param catePost    岗位ID
     * @return 只返回已发布作品
     */
    @Override
    public Page<ProductionInfo> findByCatePost(Integer currentPage, Integer pageSize, Long catePost) {
        //根据岗位获取作品数据
        Wrapper queryWrapper = Wrappers.lambdaQuery(ProductionInfo.class)
                .eq(ProductionInfo::getStatus, ProductionStatus.RELEASE.getCode())
                //todo zyc 验证入参 是否有"null"
                .eq(Objects.nonNull(catePost),ProductionInfo::getJobCateId, catePost);

        return toPage(getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize), queryWrapper));
    }

    /**
     * 分页获取技能下的所有作品
     *
     * @param currentPage
     * @param pageSize
     * @param cateSkill   技能ID
     * @return 只返回已发布作品
     */
    @Override
    public Page<ProductionInfo> findByCateSkill(Integer currentPage, Integer pageSize, Long cateSkill) {
        //获取技能下的分页作品ID
        Page<ProductionSkillRelation> productionSkillRelationPage = productionSkillRelationService.findByCateSkill(currentPage, pageSize, cateSkill);
        if (CollectionUtils.isEmpty(productionSkillRelationPage.getData())) {
            return new PageInfo<>();
        }
        //获取作品id集合

        List<Long> productionIds = productionSkillRelationPage.getData().stream().map(productionSkillRelation ->
                productionSkillRelation.getProductionId()).collect(Collectors.toList());

        List<ProductionInfo> productionInfos = getBaseMapper().selectBatchIds(productionIds);
        //补全数据
        fillProductInfoRelation(productionInfos);

        //组装新的分页对象
        PageInfo<ProductionInfo> result = new PageInfo<>();
        BeanUtils.copyProperties(productionSkillRelationPage, result);
        result.setData(productionInfos);

        return result;
    }

    /**
     * 分页获取作者下的所有作品
     *
     * @param currentPage
     * @param pageSize
     * @param freelancerId 自由职业者ID
     * @return
     */
    @Override
    public Page<ProductionInfo> findByFreelancer(Integer currentPage, Integer pageSize, Long freelancerId, Collection<Integer> statuses) {
        //根据岗位获取作品数据
        LambdaQueryWrapper<ProductionInfo> queryWrapper = Wrappers.lambdaQuery(ProductionInfo.class)
                .eq(ProductionInfo::getFreelancerId, freelancerId)
                .ne(ProductionInfo::getStatus, ProductionStatus.DELETED.getCode())
                .in(!CollectionUtils.isEmpty(statuses), ProductionInfo::getStatus, statuses);

        return toPage(getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage, pageSize), queryWrapper));
    }

    /**
     * 分页查询
     * <p>
     * 完善补全信息
     *
     * @param mybatisPlusPage
     * @return
     */
    @Override
    protected Page<ProductionInfo> toPage(com.baomidou.mybatisplus.extension.plugins.pagination.Page<ProductionInfo> mybatisPlusPage) {
        Page<ProductionInfo> productionInfoPage = super.toPage(mybatisPlusPage);
        if (productionInfoPage.getData() != null && !productionInfoPage.getData().isEmpty()) {
            //补全信息
            fillProductInfoRelation(productionInfoPage.getData());
        }
        return productionInfoPage;
    }


    /**
     * 补全数据
     *
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

        Map<Long, BdJobCate> postCateMap = bdJobCateService.getByIds(jobCateIds)
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


        Map<Long, BdJobCate> domainCateMap = bdJobCateService.findJobCateDomain(null)
                .stream().collect(Collectors.toMap(BdJobCate::getId, Function.identity(), (v1, v2) -> v2));


        productionInfos.forEach(productionInfo -> {

            if (freelancerInfoMap.containsKey(productionInfo.getFreelancerId())) {
                productionInfo.setFreelancerInfo(freelancerInfoMap.get(productionInfo.getFreelancerId()));
            }

            if (postCateMap.containsKey(productionInfo.getJobCateId())) {
                productionInfo.setPostCate(postCateMap.get(productionInfo.getJobCateId()));

                if (domainCateMap.containsKey(productionInfo.getPostCate().getParentId())) {
                    productionInfo.setDomainCate(domainCateMap.get(productionInfo.getPostCate().getParentId()));
                }

            }

            if (attachmentMap.containsKey(productionInfo.getCode())) {
                productionInfo.setAttachmentInfos(attachmentMap.get(productionInfo.getCode()));
            }

            if (proSkillRMap.containsKey(productionInfo.getId())) {
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
        productionInfo.setPostCate(bdJobCateService.get(productionInfo.getJobCateId()));

        productionInfo.setDomainCate(bdJobCateService.get(productionInfo.getPostCate().getParentId()));

        //获取附件列表
        productionInfo.setAttachmentInfos(attachmentInfoService.getByCodeAndType(productionInfo.getCode(), AttachmentBusinessType.PRODUCTION));
    }

    /**
     * 保存关联技能
     *
     * @param model
     * @return
     */
    private boolean saveSkills(ProductionInfo model) {
        List<ProductionSkillRelation> productionSkillRelations = model.getProductionSkillRelations();

        if (!CollectionUtils.isEmpty(productionSkillRelations)) {
            for (ProductionSkillRelation productionSkillRelation : productionSkillRelations) {
                productionSkillRelation.setProductionId(model.getId());
            }
            return productionSkillRelationService.save(productionSkillRelations);

        }
        return true;
    }

    /**
     * 保存附件
     *
     * @param model
     * @return
     */
    private boolean saveAttachments(ProductionInfo model) {
        List<AttachmentInfo> attachmentInfos = model.getAttachmentInfos();
        if (!CollectionUtils.isEmpty(attachmentInfos)) {
            for (AttachmentInfo attachmentInfo : attachmentInfos) {
                attachmentInfo.setBusinessCode(model.getCode());
                attachmentInfo.setBusinessType(AttachmentBusinessType.PRODUCTION.getCode());
                attachmentInfo.setType(AttachmentType.PICTURE.getCode());
            }
            return attachmentInfoService.save(attachmentInfos);
        }
        return true;
    }

    @Override
    public int updateByCode(ProductionInfo model) {
        UpdateWrapper<ProductionInfo> updateWrapper = Wrappers.update();
        updateWrapper.eq("code", model.getCode());
        return this.getBaseMapper().update(model, updateWrapper);
    }

    @Override
    public List<ProductionInfo> query(String title) {

        LambdaQueryWrapper<ProductionInfo> queryWrapper = Wrappers.lambdaQuery(ProductionInfo.class);
        queryWrapper.like(ProductionInfo::getTitle, title);
        queryWrapper.eq(ProductionInfo::getStatus, ProductionStatus.RELEASE.getCode());

        return this.getBaseMapper()
                .selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(1, 100), queryWrapper).getRecords();
    }

}
