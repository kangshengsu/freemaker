/**
 * @filename:EmployerInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.evaluation.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.constant.EvaluationConstants;
import com.fm.business.base.dao.evaluationinfo.IEvaluationInfoMapper;
import com.fm.business.base.enums.*;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.evaluation.EvaluationInfo;
import com.fm.business.base.model.evaluation.EvaluationInfoTag;
import com.fm.business.base.model.evaluation.OverallEvaluation;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobTag;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.service.*;
import com.fm.business.base.service.evaluation.IEvaluationInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import com.fm.framework.core.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:(雇佣者信息服务实现)
 * @version: V1.0
 * @author: LiuDuo
 */
@Slf4j
@Service("evaluationInfoService")
public class EvaluationInfoServiceImpl extends AuditBaseService<IEvaluationInfoMapper, EvaluationInfo> implements IEvaluationInfoService {

    @Autowired
    private IFreelancerInfoService freelancerInfoService;
    @Autowired
    private IEmployerInfoService employerInfoService;
    @Autowired
    private IOrderInfoService orderInfoService;
    @Autowired
    private IBdJobCateService bdJobCateService;
    @Autowired
    private IAttachmentInfoService attachmentInfoService;
    @Autowired
    private IEvaluationInfoTagService evaluationInfoTagService;
    @Autowired
    private IOrderInfoDetailService orderInfoDetailService;
    @Autowired
    private IBdJobTagService bdJobTagService;

    DecimalFormat decimalFormat = new DecimalFormat("#.00");

    @Override
    public Page<EvaluationInfo> findByCateAndFreelancerPage(Long jobCateId, Long freelancerId, Integer limit, Integer currentPage, Integer pageSize, Integer storeSort, Integer timeSort) {
        LambdaQueryWrapper<EvaluationInfo> wrapper = Wrappers.lambdaQuery(EvaluationInfo.class).eq(EvaluationInfo::getJobCateId,
                jobCateId).eq(EvaluationInfo::getFreelancerId, freelancerId).eq(EvaluationInfo::getStatus, EvaluationStatusEnum.AUDIT_PASS.getCode());
        MiniAppEvaluationEnum evaluationEnum = MiniAppEvaluationEnum.resolve(storeSort);
        switch (evaluationEnum){
            case ALL:
                break;
            case ASC:
                wrapper.orderByAsc(EvaluationInfo::getTotalScore);
                break;
            case DESC:
                wrapper.orderByDesc(EvaluationInfo::getTotalScore);
                break;
        }
        MiniAppEvaluationTimeEnum evaluationTimeEnum = MiniAppEvaluationTimeEnum.resolve(timeSort);
        switch (evaluationTimeEnum){
            case ALL:
                break;
            case ASC:
                wrapper.orderByAsc(EvaluationInfo::getUpdateTime);
                break;
            case DESC:
                wrapper.orderByDesc(EvaluationInfo::getUpdateTime);
                break;
        }
            wrapper.orderByDesc(EvaluationInfo::getId);

        if (limit != null) {
            wrapper = wrapper.last(" limit " + limit);
        }

        Page<EvaluationInfo> evaluationInfos = toPage(getBaseMapper().selectPage(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(currentPage,pageSize),wrapper));
        List<EvaluationInfo> evaluationInfoList = evaluationInfos.getData();
        evaluationInfoList.forEach(evaluationInfo -> {
            evaluationInfo.setTotalScore(evaluationInfo.getTotalScore());
            evaluationInfo.setResponseSpeed(evaluationInfo.getResponseSpeed());
            evaluationInfo.setCommunicateCapacity(evaluationInfo.getCommunicateCapacity());
            evaluationInfo.setCompletionTime(evaluationInfo.getCompletionTime());
            evaluationInfo.setAccomplishQuality(evaluationInfo.getAccomplishQuality());
            evaluationInfo.setRecommendScore(evaluationInfo.getRecommendScore());
        });
        //补其他字段信息
        fillEvaluationInfo(evaluationInfoList);
        return evaluationInfos;
    }

    /**
     * 统计评价分数
     * <p>
     * 如果评价数据样本小于一定数量 则 按一定比例稀释数据
     *
     * @param jobCateId
     * @param freelancerId
     * @return
     */
    @Override
    public OverallEvaluation findOverallEvaluationByCateAndFreelancer(Long jobCateId, Long freelancerId) {

        OverallEvaluation overallEvaluation = this.getBaseMapper().findOverallEvaluationByCateAndFreelancer(jobCateId, freelancerId, EvaluationConstants.EVALUATION_DEFAULT_COUNT, EvaluationStatusEnum.AUDIT_PASS.getCode());

        // 取出评价总分 以及 评价数量  如果评价数量小于最低要求评价数量 则补充满分样本数据， 无评价数量则返回满分
        BigDecimal totalScore = null;
        BigDecimal responseSpeed;
        BigDecimal communicateCapacity;
        BigDecimal completionTime;
        BigDecimal accomplishQuality;
        BigDecimal recommendScore;

        if (overallEvaluation == null || overallEvaluation.getEvaluationCount().equals(Integer.valueOf(0))) {
            overallEvaluation = new OverallEvaluation();
            //无样本数据 返回满分
            totalScore = EvaluationConstants.TOTAL_SCORE_MAX;
            responseSpeed = EvaluationConstants.RESPONSE_SPEED_MAX;
            communicateCapacity = EvaluationConstants.COMMUNICATE_CAPACITY_MAX;
            completionTime = EvaluationConstants.COMPLETION_TIME_MAX;
            accomplishQuality = EvaluationConstants.ACCOMPLISH_QUALITY_MAX;
            recommendScore = EvaluationConstants.RECOMMEND_SCORE_MAX;
        } else if (EvaluationConstants.EVALUATION_DEFAULT_COUNT.compareTo(overallEvaluation.getEvaluationCount()) > 0) {
            //样本数据不足  补充满分样本数据
            BigDecimal diff = BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT - overallEvaluation.getEvaluationCount());
            totalScore = (EvaluationConstants.TOTAL_SCORE_MAX.multiply(diff).add(overallEvaluation.getTotalScoreSum())).divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
            responseSpeed = (EvaluationConstants.RESPONSE_SPEED_MAX.multiply(diff).add( overallEvaluation.getResponseSpeedSum())).divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT)) ;
            communicateCapacity = (EvaluationConstants.COMMUNICATE_CAPACITY_MAX.multiply(diff).add(overallEvaluation.getCommunicateCapacitySum())).divide( BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
            completionTime = (EvaluationConstants.COMPLETION_TIME_MAX.multiply(diff).add(overallEvaluation.getCompletionTimeSum())).divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
            accomplishQuality = (EvaluationConstants.ACCOMPLISH_QUALITY_MAX.multiply(diff).add(overallEvaluation.getAccomplishQualitySum())).divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
            recommendScore = (EvaluationConstants.RECOMMEND_SCORE_MAX.multiply(diff).add(overallEvaluation.getRecommendScoreSum())).divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
        } else {
            totalScore = overallEvaluation.getTotalScoreSum().divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
            responseSpeed = overallEvaluation.getResponseSpeedSum().divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
            communicateCapacity = overallEvaluation.getCommunicateCapacitySum().divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
            completionTime = overallEvaluation.getCompletionTimeSum().divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
            accomplishQuality = overallEvaluation.getAccomplishQualitySum().divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
            recommendScore = overallEvaluation.getRecommendScoreSum().divide(BigDecimal.valueOf(EvaluationConstants.EVALUATION_DEFAULT_COUNT));
        }

        overallEvaluation.setCommunicateCapacity(NumberUtil.formantBigDecimal(communicateCapacity));
        overallEvaluation.setRecommendScore(NumberUtil.formantBigDecimal(recommendScore));
        overallEvaluation.setTotalScore(NumberUtil.formantBigDecimal(totalScore));
        overallEvaluation.setResponseSpeed(NumberUtil.formantBigDecimal(responseSpeed));
        overallEvaluation.setCompletionTime(NumberUtil.formantBigDecimal(completionTime));
        overallEvaluation.setAccomplishQuality(NumberUtil.formantBigDecimal(accomplishQuality));
        return overallEvaluation;
    }

    @Override
    public EvaluationInfo findByOrderId(Long orderId) {
        EvaluationInfo evaluationInfo = getBaseMapper().selectOne(Wrappers.lambdaQuery(EvaluationInfo.class).eq(EvaluationInfo::getOrderId,
                orderId).eq(EvaluationInfo::getStatus, EvaluationStatusEnum.AUDIT_PASS.getCode()).orderByDesc(EvaluationInfo::getId).last("limit 1"));
        if (evaluationInfo == null) {
            return null;
        }
        evaluationInfo.setTotalScore(evaluationInfo.getTotalScore());
        evaluationInfo.setResponseSpeed(evaluationInfo.getResponseSpeed());
        evaluationInfo.setCommunicateCapacity(evaluationInfo.getCommunicateCapacity());
        evaluationInfo.setCompletionTime(evaluationInfo.getCompletionTime());
        evaluationInfo.setAccomplishQuality(evaluationInfo.getAccomplishQuality());
        evaluationInfo.setRecommendScore(evaluationInfo.getRecommendScore());
        fillEvaluationInfo(Arrays.asList(evaluationInfo));
        return evaluationInfo;
    }


    @Override
    protected void beforeSave(EvaluationInfo evaluationInfo) {
        super.beforeSave(evaluationInfo);
        OrderInfo orderInfo = orderInfoService.get(evaluationInfo.getOrderId());
        if (orderInfo == null) {
            throw new BusinessException("评价失败,订单信息不存在");
        }
        evaluationInfo.setJobCateId(orderInfo.getJobCateId());
        evaluationInfo.setCateTreeCode(orderInfo.getCateTreeCode());
        evaluationInfo.setEmployerId(orderInfo.getEmployerId());
        evaluationInfo.setFreelancerId(orderInfo.getFreelancerId());
    }

    @Override
    protected void afterSave(EvaluationInfo evaluationInfo) {
        super.afterSave(evaluationInfo);
        saveTags(evaluationInfo);
        saveAttachments(evaluationInfo);
        updateOrderStatus(evaluationInfo);
    }

    private void updateOrderStatus(EvaluationInfo evaluationInfo) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(evaluationInfo.getOrderId());
        orderInfo.setStatus(OrderStatus.EVALUATED_90.getCode());
        orderInfoService.update(orderInfo);
    }

    /**
     * 保存标签
     *
     * @param evaluationInfo
     */
    private void saveTags(EvaluationInfo evaluationInfo) {
        List<BdJobTag> bdJobTags = evaluationInfo.getBdJobTags();
        List<EvaluationInfoTag> evaluationInfoTags = new ArrayList<>(bdJobTags.size());
        if (!CollectionUtils.isEmpty(bdJobTags)) {
            for (BdJobTag bdJobTag : bdJobTags) {
                EvaluationInfoTag evaluationInfoTag = new EvaluationInfoTag();
                evaluationInfoTag.setEvaluationInfoId(evaluationInfo.getId());
                evaluationInfoTag.setTagId(bdJobTag.getId());
                evaluationInfoTags.add(evaluationInfoTag);
            }
            evaluationInfoTagService.save(evaluationInfoTags);
        }
    }

    /**
     * 保存附件
     *
     * @param evaluationInfo
     */
    private void saveAttachments(EvaluationInfo evaluationInfo) {
        List<AttachmentInfo> attachmentInfos = evaluationInfo.getAttachmentInfos();
        if (!CollectionUtils.isEmpty(attachmentInfos)) {
            for (AttachmentInfo attachmentInfo : attachmentInfos) {
                attachmentInfo.setBusinessCode(String.valueOf(evaluationInfo.getId()));
                attachmentInfo.setBusinessType(AttachmentBusinessType.ORDER_EVALUATION.getCode());
                attachmentInfo.setType(AttachmentType.PICTURE.getCode());
            }
            attachmentInfoService.save(attachmentInfos);
        }
    }


    /**
     * 补充评价信息
     *
     * @param
     */
    private void fillEvaluationInfo(Collection<EvaluationInfo> evaluationInfos) {

        if (CollectionUtils.isEmpty(evaluationInfos)) {
            return;
        }

        Set<Long> evaluationIds = new HashSet<>();
        Set<Long> freelancerIds = new HashSet<>();
        Set<Long> employerIds = new HashSet<>();
        Set<Long> jobCateIds = new HashSet<>();
        Set<Long> orderIds = new HashSet<>();
        Set<String> attachmentCodes = new HashSet<>();

        evaluationInfos.forEach(evaluationInfo -> {
            evaluationIds.add(evaluationInfo.getId());
            freelancerIds.add(evaluationInfo.getFreelancerId());
            employerIds.add(evaluationInfo.getEmployerId());
            jobCateIds.add(evaluationInfo.getJobCateId());
            orderIds.add(evaluationInfo.getOrderId());
            attachmentCodes.add(String.valueOf(evaluationInfo.getId()));
        });

        Map<Long, FreelancerInfo> freelancerInfoMap = freelancerInfoService.getByIds(freelancerIds)
                .stream().collect(Collectors.toMap(FreelancerInfo::getId, Function.identity(), (v1, v2) -> v2));
        Map<Long, EmployerInfo> employerInfoMap = employerInfoService.getByIds(employerIds)
                .stream().collect(Collectors.toMap(EmployerInfo::getId, Function.identity(), (v1, v2) -> v2));
        Map<Long, OrderInfo> orderInfoMap = orderInfoService.getByIds(orderIds)
                .stream().collect(Collectors.toMap(OrderInfo::getId, Function.identity(), (v1, v2) -> v2));
        Map<Long, OrderInfoDetail> orderDetailInfoMap = orderInfoDetailService.getOrderDetailByOrderIds(orderIds)
                .stream().collect(Collectors.toMap(OrderInfoDetail::getOrderId, Function.identity(), (v1, v2) -> v2));
        Map<Long, BdJobCate> bdJobCateMap = bdJobCateService.getByIds(jobCateIds)
                .stream().collect(Collectors.toMap(BdJobCate::getId, Function.identity(), (v1, v2) -> v2));

        List<EvaluationInfoTag> evaluationInfoTags = evaluationInfoTagService.getTagsByEvaluationIds(evaluationIds);

        List<Long> tagIds = evaluationInfoTags.stream().map(EvaluationInfoTag::getTagId).collect(Collectors.toList());
        Map<Long, BdJobTag> bdJobTagMap = bdJobTagService.getByIds(tagIds)
                .stream().collect(Collectors.toMap(BdJobTag::getId, Function.identity(), (v1, v2) -> v2));

        Map<Long, List<BdJobTag>> tagMap =
                evaluationInfoTags.stream().collect(Collectors.toMap(EvaluationInfoTag::getEvaluationInfoId, v -> {
                    List<BdJobTag> list = new ArrayList<>();
                    if (bdJobTagMap.containsKey(v.getTagId())) {
                        list.add(bdJobTagMap.get(v.getTagId()));
                    }
                    return list;
                }, (v1, v2) -> {
                    v1.addAll(v2);
                    return v1;
                }));


        Map<String, List<AttachmentInfo>> attachmentMap = attachmentInfoService.getByCodeAndType(attachmentCodes, AttachmentBusinessType.ORDER_EVALUATION)
                .stream().collect(Collectors.toMap(AttachmentInfo::getBusinessCode, v -> {
                    List<AttachmentInfo> list = new ArrayList<>();
                    list.add(v);
                    return list;
                }, (v1, v2) -> {
                    v1.addAll(v2);
                    return v1;
                }));
        evaluationInfos.forEach(evaluationInfo -> {
            if (freelancerInfoMap.containsKey(evaluationInfo.getFreelancerId())) {
                evaluationInfo.setFreelancerInfo(freelancerInfoMap.get(evaluationInfo.getFreelancerId()));

            }
            if (employerInfoMap.containsKey(evaluationInfo.getEmployerId())) {
                evaluationInfo.setEmployerInfo(employerInfoMap.get(evaluationInfo.getEmployerId()));
            }
            if (orderDetailInfoMap.containsKey(evaluationInfo.getOrderId())) {
                evaluationInfo.setOrderInfoDetail(orderDetailInfoMap.get(evaluationInfo.getOrderId()));
            }
            if (bdJobCateMap.containsKey(evaluationInfo.getJobCateId())) {
                evaluationInfo.setBdJobCate(bdJobCateMap.get(evaluationInfo.getJobCateId()));
            }
            if (tagMap.containsKey(evaluationInfo.getId())) {
                evaluationInfo.setBdJobTags(tagMap.get(evaluationInfo.getId()));
            }
            if (attachmentMap.containsKey(evaluationInfo.getId().toString())) {
                evaluationInfo.setAttachmentInfos(attachmentMap.get(evaluationInfo.getId().toString()));
            }
        });
    }

}
