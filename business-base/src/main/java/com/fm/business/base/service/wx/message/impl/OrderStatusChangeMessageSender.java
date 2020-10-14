package com.fm.business.base.service.wx.message.impl;

import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.enums.WxMessageTemplate;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.demand.DemandProductionRelation;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.business.base.service.wx.message.MessageSenderService;
import com.fm.business.base.service.wx.message.message.WxMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangleqi
 * @date 2020-10-14 4:46 下午
 */
@Service
public class OrderStatusChangeMessageSender {
    @Autowired
    private MessageSenderService messageSenderService;
    @Autowired
    private IProductionInfoService productionInfoService;
    @Autowired
    private IDemandInfoService demandInfoService;
    @Autowired
    private IEmployerInfoService employerInfoService;
    @Autowired
    private IFreelancerInfoService freelancerInfoService;
    @Autowired
    private ISysUserService sysUserService;

    public void sendStatusChangeMessage(OrderInfo orderInfo) {
        EmployerInfo employerInfo = employerInfoService.get(orderInfo.getEmployerId());
        FreelancerInfo freelancerInfo = freelancerInfoService.get(orderInfo.getFreelancerId());
        DemandInfo demandInfo = demandInfoService.get(orderInfo.getDemandId());
        if (demandInfo == null) {
            return;
        }
        this.sendStatusChangeMessageToEmployer(orderInfo,employerInfo,freelancerInfo,demandInfo);
        this.sendStatusChangeMessageToFreelancer(orderInfo,employerInfo,freelancerInfo,demandInfo);
    }

    private void sendStatusChangeMessageToEmployer(OrderInfo orderInfo,EmployerInfo employerInfo,
                                                   FreelancerInfo freelancerInfo,DemandInfo demandInfo) {
        if (employerInfo == null || employerInfo.getUserId() == null) {
            return;
        }
        SysUser sysUser = sysUserService.get(employerInfo.getUserId());
        if (sysUser == null) {
            return;
        }
        String desc = this.getDescToEmployer(orderInfo,employerInfo,freelancerInfo,demandInfo);
        WxMessage wxMessage = WxMessage.builder()
                .addToUser(sysUser.getCode())
                .addTemplate(WxMessageTemplate.ORDER_STATUS_CHANGE_MESSAGE)
                .addPage("index")
                .addData("thing5", demandInfo.getSummarize())
                .addData("phrase2", OrderStatus.get(orderInfo.getStatus()).getName())
                .addData("amount8", String.valueOf(orderInfo.getOrderMny()))
                .addData("date3", String.valueOf(orderInfo.getUpdateTime()))
                .addData("thing4",desc)
                .build();
        if (desc == null) {
            return;
        }
        messageSenderService.sendMessage(wxMessage);

    }
    private void sendStatusChangeMessageToFreelancer(OrderInfo orderInfo,EmployerInfo employerInfo,
                                                     FreelancerInfo freelancerInfo,DemandInfo demandInfo) {
        if (freelancerInfo == null || freelancerInfo.getUserId() == null) {
            return;
        }
        SysUser sysUser = sysUserService.get(freelancerInfo.getUserId());
        if (sysUser == null) {
            return;
        }
        String desc = this.getDescToFreelancer(orderInfo,employerInfo,freelancerInfo,demandInfo);
        if (desc == null) {
            return;
        }
        WxMessage wxMessage = WxMessage.builder()
                .addToUser(sysUser.getCode())
                .addTemplate(WxMessageTemplate.ORDER_STATUS_CHANGE_MESSAGE)
                .addPage("index")
                .addData("thing5", demandInfo.getSummarize())
                .addData("phrase2", OrderStatus.get(orderInfo.getStatus()).getName())
                .addData("amount8", String.valueOf(orderInfo.getOrderMny()))
                .addData("date3", String.valueOf(orderInfo.getUpdateTime()))
                .addData("thing4",desc)
                .build();
        messageSenderService.sendMessage(wxMessage);
    }

    private String getDescToEmployer(OrderInfo orderInfo,EmployerInfo employerInfo,FreelancerInfo freelancerInfo, DemandInfo demandInfo) {
        switch (OrderStatus.get(orderInfo.getStatus())) {
            case WAITING_20:
                return String.format("尊敬的 %s，您的订单:%s,【%s】已下单成功，请您耐心等待 %s 接单吧。",employerInfo.getName(),
                        orderInfo.getCode()
                        ,demandInfo.getSummarize(),freelancerInfo.getName());
            case TAKING_40:
                return String.format("尊敬的 %s，您的订单:%s,【%s】已经被 %s 接单成功了，支付金额为 %s 元，请您在48h内完成支付！越早支付我们的人才就可以早点开工啦！",
                        employerInfo.getName(),orderInfo.getCode()
                        ,demandInfo.getSummarize(),freelancerInfo.getName(),orderInfo.getOrderMny());
            case REJECT_30:
                return String.format("很遗憾！订单:%s,【%s】已被 %s 取消,如有疑问请联系我们的人才 %s 进一步沟通。",
                        orderInfo.getCode(),demandInfo.getSummarize(),freelancerInfo.getName(),
                        freelancerInfo.getName());
            case PAID_50:
                return String.format("尊敬的 %s，订单:%s,【%s】已经支付成功，平台已经安排人才开足马力制作中，祝早日达成期望！",
                        employerInfo.getName(), orderInfo.getCode(),demandInfo.getSummarize());
            case CHECKING_60:
                return String.format("尊敬的 %s，订单:%s,【%s】已经交付成功，请您尽快验收吧！",
                        employerInfo.getName(), orderInfo.getCode(),demandInfo.getSummarize());
            case FINISHED_80:
                return String.format("尊敬的 %s，您的订单:%s,【%s】已经完成，期待您的评价，您的评价可以帮助平台更好的改善服务，谢谢您的支持！",
                        employerInfo.getName(), orderInfo.getCode(),demandInfo.getSummarize());
            case CHECK_FAIL_70:
                return String.format("非常抱歉！订单:%s,【%s】验收不通过。稍后客服会介入联系您。",
                        orderInfo.getCode(),demandInfo.getSummarize());
            case EVALUATED_90:
                return String.format("尊敬的 %s，订单:%s,【%s】已经收到您的评价，感谢您对平台的支持！",
                        employerInfo.getName(),orderInfo.getCode(),demandInfo.getSummarize());
        }
        return null;
    }

    private String getDescToFreelancer(OrderInfo orderInfo,EmployerInfo employerInfo,
                                                  FreelancerInfo freelancerInfo, DemandInfo demandInfo) {
        switch (OrderStatus.get(orderInfo.getStatus())) {
            case WAITING_20:
                return String.format("尊敬的%s，您已接收到新的订单:%s,【%s】，快去“我的订单”里确认接单吧！",freelancerInfo.getName(),
                        orderInfo.getCode()
                        ,demandInfo.getSummarize());
            case TAKING_40:
                return String.format("尊敬的%s，订单:%s,【%s】,已经接单成功了，支付金额 %s元，请耐心等待 %s 支付！温馨提醒：支付成功后再开始工作会更保险哦！",
                        freelancerInfo.getName(),orderInfo.getCode()
                        ,demandInfo.getSummarize(),orderInfo.getOrderMny(),employerInfo.getName());
            case REJECT_30:
                return String.format("拒单成功！订单:%s,【%s】已被取消",
                        orderInfo.getCode(),demandInfo.getSummarize());
            case PAID_50:
                return String.format("尊敬的 %s，恭喜！订单:%s,【%s】已经付款到平台了，请您按约定的时间交付吧！温馨提示：早交付可以早收到的薪金哦！",
                        freelancerInfo.getName(), orderInfo.getCode(),demandInfo.getSummarize());
            case CHECKING_60:
                return String.format("尊敬的 %s，订单:%s,【%s】已经交付成功，请您耐心等待【employer】验收吧！",
                        freelancerInfo.getName(), orderInfo.getCode(),demandInfo.getSummarize());
            case FINISHED_80:
                return String.format("尊敬的 %s 恭喜您！订单:%s,【%s】已经验收成功，请您耐心等待平台发薪吧！",
                        freelancerInfo.getName(), orderInfo.getCode(),demandInfo.getSummarize());
            case EVALUATED_90:
                return String.format("尊敬的 %s，订单:%s,【%s】已经获得 %s 的评价，快去看看吧。",
                        freelancerInfo.getName(),orderInfo.getCode(),demandInfo.getSummarize(),employerInfo.getName());
            case CANCELD_100:
                return String.format("很遗憾，订单:%s,【%s】已被雇主取消，不过还有更多的机会在等待你哟！加油！",
                        orderInfo.getCode(),demandInfo.getSummarize());
        }
        return null;
    }
}
