package com.fm.business.base.service.wx.message.impl;

import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.enums.WxMessageTemplate;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.business.base.service.wx.message.MessageSenderService;
import com.fm.business.base.service.wx.message.message.WxMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;

/**
 * @author G
 * @date 2020/12/16 下午7:07
 */
public class ProductionStatusSender {
    @Value("${wx.miniapp.state}")
    private String state;

    @Autowired
    private IFreelancerInfoService freelancerInfoService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private MessageSenderService messageSenderService;

    public void sendStatusChangeMessage(ProductionInfo productionInfo) {
        FreelancerInfo freelancerInfo = freelancerInfoService.get(productionInfo.getFreelancerId());
        SysUser sysUser = sysUserService.get(freelancerInfo.getUserId());
        this.sendStatusChangeMessageToEmployer(productionInfo, sysUser);

    }

    private void sendStatusChangeMessageToEmployer(ProductionInfo productionInfo, SysUser sysUser) {
        if (productionInfo == null || sysUser == null) {
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(productionInfo.getUpdateTime());
        String desc = this.getDescToEmployer(productionInfo);
        WxMessage wxMessage = WxMessage.builder()
                .addToUser(sysUser.getCode())
                .addTemplate(WxMessageTemplate.EXAMINE_MESSAGE)
                .addPage("packageMine/pages/myproductDetails/myproductDetails?prodId=" + productionInfo.getId())
                .addMiniprogramState(state)
                .addData("thing10", desc)
                .addData("time9", date)
                .build();
        if (desc == null) {
            return;
        }
        messageSenderService.sendMessage(wxMessage);

    }

    private String getDescToEmployer(ProductionInfo productionInfo) {
        switch (ProductionStatus.get(productionInfo.getStatus())) {
            case RELEASE:
                return String.format("恭喜！您的服务已经审核通过！");
            case REVIEW_NOT_PASS:
                return String.format("您的服务审核未通过，进入小程序查看原因。");
        }
        return null;
    }
}
