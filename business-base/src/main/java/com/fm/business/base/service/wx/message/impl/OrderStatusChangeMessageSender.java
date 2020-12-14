package com.fm.business.base.service.wx.message.impl;

import com.fm.business.base.enums.OrderStatus;
import com.fm.business.base.enums.WxMessageTemplate;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.demand.IDemandInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.business.base.service.wx.message.MessageSenderService;
import com.fm.business.base.service.wx.message.message.WxMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangleqi
 * @date 2020-10-14 4:46 下午
 */
@Service
public class OrderStatusChangeMessageSender {

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
    private IFreelancerInfoService freelancerInfoService;
    @Autowired
    private IOrderInfoService orderInfoService;
    @Autowired
    private IOrderInfoDetailService orderInfoDetailService;
    @Autowired
    private ISysUserService sysUserService;

    public void sendStatusChangeMessage(OrderInfo orderInfo) {
        OrderInfo orderInfo1 = orderInfoService.get(orderInfo.getId());
        if(orderInfo.getStatus() != null){
            orderInfo1.setStatus(orderInfo.getStatus());
        }else {
            orderInfo = orderInfo1;
        }
        List<OrderInfoDetail> orderInfoDetails = orderInfoDetailService.getOrderDetailByOrderIds(Arrays.asList(orderInfo.getId()));
        if (CollectionUtils.isEmpty(orderInfoDetails)) {
            return;
        }
        EmployerInfo employerInfo = employerInfoService.get(orderInfo.getEmployerId());
        FreelancerInfo freelancerInfo = freelancerInfoService.get(orderInfo.getFreelancerId());
        this.sendStatusChangeMessageToEmployer(orderInfo,employerInfo,freelancerInfo,orderInfoDetails.get(0));
        this.sendStatusChangeMessageToFreelancer(orderInfo,employerInfo,freelancerInfo,orderInfoDetails.get(0));
    }

    private void sendStatusChangeMessageToEmployer(OrderInfo orderInfo,EmployerInfo employerInfo,
                                                   FreelancerInfo freelancerInfo,OrderInfoDetail orderInfoDetail) {
        if (employerInfo == null || employerInfo.getUserId() == null) {
            return;
        }
        SysUser sysUser = sysUserService.get(employerInfo.getUserId());
        if (sysUser == null) {
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(orderInfo.getUpdateTime());
        String desc = this.getDescToEmployer(orderInfo,employerInfo,freelancerInfo);
        WxMessage wxMessage = WxMessage.builder()
                .addToUser(sysUser.getCode())
                .addTemplate(WxMessageTemplate.ORDER_STATUS_CHANGE_MESSAGE)
                .addPage("pages/orderDetails/orderDetails?orderId="+orderInfo.getId())
                .addMiniprogramState(state)
                .addData("thing5", orderInfoDetail.getSummarize())
                .addData("phrase2", OrderStatus.get(orderInfo.getStatus()).getName())
                .addData("amount8", String.valueOf(orderInfo.getOrderMny()))
                .addData("date3", date)
                .addData("thing4",desc)
                .build();
        if (desc == null) {
            return;
        }
        messageSenderService.sendMessage(wxMessage);

    }
    private void sendStatusChangeMessageToFreelancer(OrderInfo orderInfo,EmployerInfo employerInfo,
                                                     FreelancerInfo freelancerInfo,OrderInfoDetail orderInfoDetail) {
        if (freelancerInfo == null || freelancerInfo.getUserId() == null) {
            return;
        }
        SysUser sysUser = sysUserService.get(freelancerInfo.getUserId());
        if (sysUser == null) {
            return;
        }
        String desc = this.getDescToFreelancer(orderInfo,employerInfo,freelancerInfo);
        if (desc == null) {
            return;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String date = formatter.format(orderInfo.getUpdateTime());
        WxMessage wxMessage = WxMessage.builder()
                .addToUser(sysUser.getCode())
                .addTemplate(WxMessageTemplate.ORDER_STATUS_CHANGE_MESSAGE)
                .addPage("pages/orderDetails/orderDetails?orderId="+orderInfo.getId())
                .addMiniprogramState(state)
                .addData("thing5", orderInfoDetail.getSummarize())
                .addData("phrase2", OrderStatus.get(orderInfo.getStatus()).getName())
                .addData("amount8", String.valueOf(orderInfo.getOrderMny()))
                .addData("date3", date)
                .addData("thing4",desc)
                .build();
        messageSenderService.sendMessage(wxMessage);
    }

    private String getDescToEmployer(OrderInfo orderInfo,EmployerInfo employerInfo,FreelancerInfo freelancerInfo) {
        switch (OrderStatus.get(orderInfo.getStatus())) {
            case WAITING_20:
                return String.format("您已下单成功，请等待人才接单。");
            case TAKING_40:
                return String.format("您的订单已经被人才接单成功，请前往支付！");
            case REJECT_30:
                return String.format("很遗憾！您的订单已被人才取消，进入小程序可查看原因。");
            case UPDATEPRICE_35:
                return String.format("您的订单已经改价成功，请前往支付，谢谢！");
            case PAID_50:
                return String.format("您的订单已支付成功，人才马上开始工作。");
            case CHECKING_60:
                return String.format("您的订单已经交付成功，请您尽快验收吧！");
            case FINISHED_80:
                return String.format("订单已经完成，期待您的评价。");
            case CHECK_FAIL_70:
                return String.format("抱歉！订单验收不通过，请等待人才与您沟通。");
            case EVALUATED_90:
                return String.format("已评价，感谢您对平台的支持！");
        }
        return null;
    }

    private String getDescToFreelancer(OrderInfo orderInfo,EmployerInfo employerInfo,
                                                  FreelancerInfo freelancerInfo) {
        switch (OrderStatus.get(orderInfo.getStatus())) {
            case WAITING_20:
                return String.format("您已收到订单,快去确认接单吧！");
            case UPDATEPRICE_35:
                return String.format("您的订单已经改价成功！");
            case TAKING_40:
                return String.format("您的订单已经接单成功了，请等待雇主支付。");
            case REJECT_30:
                return String.format("您的订单已取消成功，进入小程序可查看原因。");
            case PAID_50:
                return String.format("订单已经付款成功，您可以开始工作了。");
            case CHECKING_60:
                return String.format("订单已经完成交付，请您等待验收。");
            case FINISHED_80:
                return String.format("恭喜！订单验收成功，请耐心等待平台发薪吧！");
            case CHECK_FAIL_70:
                return String.format("很遗憾！订单验收不通过，进入小程序可查看原因。");
            case EVALUATED_90:
                return String.format("您的订单已经获得雇主评价，快去看看吧。");
            case CANCELD_100:
                return String.format("很遗憾，订单已被雇主取消。");
        }
        return null;
    }
}
