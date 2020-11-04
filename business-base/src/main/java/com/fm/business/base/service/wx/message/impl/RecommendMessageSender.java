package com.fm.business.base.service.wx.message.impl;

import com.fm.business.base.enums.WxMessageTemplate;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.freelancer.FreelancerInfo;
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
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashMap;
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

    public void sendMessage(Collection<DemandProductionRelation> demandProductionRelation) {

        List<Long> productionIds =
                demandProductionRelation.stream().map(DemandProductionRelation::getProductionId).collect(Collectors.toList());
        List<ProductionInfo> productionInfos = productionInfoService.getByIds(productionIds);
        if (CollectionUtils.isEmpty(productionInfos)) {
            return;
        }
        Long demandId = demandProductionRelation.iterator().next().getDemandId();
        DemandInfo demandInfo = demandInfoService.get(demandId);
        if (demandInfo == null || demandInfo.getEmployerId() == null) {
            return;
        }
        EmployerInfo employerInfo = employerInfoService.get(demandInfo.getEmployerId());
        if (employerInfo == null) {
            return;
        }
        SysUser sysUser = sysUserService.get(employerInfo.getUserId());
        if (sysUser == null) {
            return;
        }
        //雇主姓名
        String employerName = employerInfo.getName();
        //需求名称
        String summarize = demandInfo.getSummarize();
        //获取作品名称
        String productionNames = productionInfos.stream().map(ProductionInfo::getTitle).collect(Collectors.joining(","));
        String message = String.format("平台已为需求推荐人才，请选择人才下单吧！");

        WxMessage wxMessage = WxMessage.builder().addToUser(sysUser.getCode()).addPage("pages/demandDetails" +
                "/demandDetails?demandCode="+demandInfo.getCode())
                .addMiniprogramState(state)
                .addTemplate(WxMessageTemplate.RECOMMEND_MESSAGE)
                .addData("number1", String.valueOf(productionInfos.size())).addData("thing2", message).build();
        messageSenderService.sendMessage(wxMessage);

    }
}
