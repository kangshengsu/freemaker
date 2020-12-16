package com.fm.business.base.service.wx.message.impl;

import com.fm.business.base.enums.RecommendType;
import com.fm.business.base.enums.WxMessageTemplate;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.business.base.service.wx.message.MessageSenderService;
import com.fm.business.base.service.wx.message.message.WxMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangleqi
 * @date 2020-10-14 4:46 下午
 */
@Service
public class RecommendMessageSender {

    @Value("${wx.miniapp.state}")
    private String state;

    @Autowired
    private MessageSenderService messageSenderService;

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private IDemandInfoService demandInfoService;

    @Autowired
    private IEmployerInfoService employerInfoService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IFreelancerInfoService freelancerInfoService;

    public void sendMessage(Collection<DemandProductionRelation> demandProductionRelation) {

        List<Long> productionIds =
                demandProductionRelation.stream().map(DemandProductionRelation::getProductionId).collect(Collectors.toList());
        List<ProductionInfo> productionInfos = productionInfoService.getByIds(productionIds);
        if (CollectionUtils.isEmpty(productionInfos)) {
            return;
        }
        DemandProductionRelation d = demandProductionRelation.iterator().next();

        Long productionId = d.getProductionId();
        ProductionInfo productionInfo = productionInfoService.get(productionId);
        SysUser freelancer = sysUserService.get(productionInfo.getFreelancerId());
        Long demandId = d.getDemandId();
        DemandInfo demandInfo = demandInfoService.get(demandId);

        EmployerInfo employerInfo = employerInfoService.get(demandInfo.getEmployerId());

        SysUser employer = sysUserService.get(employerInfo.getUserId());

        sendToEmployer(d, productionInfos, demandInfo, employerInfo, employer);
        sendToFreelancer(d, productionInfos, demandInfo, employerInfo, freelancer);
    }

    private void sendToEmployer(DemandProductionRelation demandProductionRelation, List<ProductionInfo> productionInfos, DemandInfo demandInfo, EmployerInfo employerInfo, SysUser sysUser) {

        if (demandInfo == null || demandInfo.getEmployerId() == null) {
            return;
        }
        if (employerInfo == null) {
            return;
        }
        if (sysUser == null) {
            return;
        }

        //雇主姓名
        String employerName = employerInfo.getName();
        //需求名称
        String summarize = demandInfo.getSummarize();
        //获取作品名称
        String productionNames = productionInfos.stream().map(ProductionInfo::getTitle).collect(Collectors.joining(","));
        String message = getDescToEmployer(demandProductionRelation);

        WxMessage wxMessage = WxMessage.builder()
                .addToUser(sysUser.getCode())
                .addPage("packageMine/pages/demandDetails/demandDetails?demandCode=" + demandInfo.getCode())
                .addMiniprogramState(state)
                .addTemplate(WxMessageTemplate.RECOMMEND_MESSAGE)
                .addData("number1", String.valueOf(productionInfos.size())).addData("thing2", message).build();
        messageSenderService.sendMessage(wxMessage);

    }

    private void sendToFreelancer(DemandProductionRelation demandProductionRelation, List<ProductionInfo> productionInfos, DemandInfo demandInfo, EmployerInfo employerInfo, SysUser sysUser) {

        if (demandInfo == null || demandInfo.getEmployerId() == null) {
            return;
        }
        if (employerInfo == null) {
            return;
        }
        if (sysUser == null) {
            return;
        }

        //雇主姓名
        String employerName = employerInfo.getName();
        //需求名称
        String summarize = demandInfo.getSummarize();
        //获取作品名称
        String productionNames = productionInfos.stream().map(ProductionInfo::getTitle).collect(Collectors.joining(","));
        String message = getDescToFreelancer(demandProductionRelation);

        WxMessage wxMessage = WxMessage.builder()
                .addToUser(sysUser.getCode())
                .addPage("packageMine/pages/demandDetails/demandDetails?demandCode=" + demandInfo.getCode())
                .addMiniprogramState(state)
                .addTemplate(WxMessageTemplate.RECOMMEND_MESSAGE)
                .addData("number1", String.valueOf(productionInfos.size())).addData("thing2", message).build();
        messageSenderService.sendMessage(wxMessage);

    }

    private String getDescToEmployer(DemandProductionRelation demandProductionRelation) {
        switch (RecommendType.get(demandProductionRelation.getStatus())) {
            case MY_RECOMMEND:
                return String.format("已有人才主动接任务啦，请选择人才下单吧！");
            case SYSTEM_RECOMMEND:
                return String.format("平台已为任务匹配人才，请选择人才下单吧！");
        }
        return null;

    }

    private String getDescToFreelancer(DemandProductionRelation demandProductionRelation) {
        switch (RecommendType.get(demandProductionRelation.getStatus())) {
            case MY_RECOMMEND:
                return String.format("您已成功申请任务，请等待雇主与您沟通！");
            case SYSTEM_RECOMMEND:
                return String.format("平台已为您推荐任务，请尽快联系雇主吧！");
        }
        return null;

    }
}
