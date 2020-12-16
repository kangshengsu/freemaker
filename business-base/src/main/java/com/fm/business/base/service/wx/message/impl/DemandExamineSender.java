package com.fm.business.base.service.wx.message.impl;

import com.fm.business.base.enums.DemandAttestationType;
import com.fm.business.base.enums.WxMessageTemplate;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.demand.DemandInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.business.base.service.wx.message.MessageSenderService;
import com.fm.business.base.service.wx.message.message.WxMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * @author G
 * @date 2020/12/16 下午4:53
 */
@Service
public class DemandExamineSender {

    @Value("${wx.miniapp.state}")
    private String state;

    @Autowired
    private IEmployerInfoService employerInfoService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private MessageSenderService messageSenderService;

    public void sendStatusChangeMessage(DemandInfo demandInfo) {
        EmployerInfo employerInfo = employerInfoService.get(demandInfo.getEmployerId());
        SysUser sysUser = sysUserService.get(employerInfo.getUserId());
        this.sendStatusChangeMessageToEmployer(demandInfo, employerInfo, sysUser);

    }

    private void sendStatusChangeMessageToEmployer(DemandInfo demandInfo, EmployerInfo employerInfo, SysUser sysUser) {
        if (demandInfo == null || employerInfo == null || sysUser == null) {
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(demandInfo.getUpdateTime());
        String desc = this.getDescToEmployer(demandInfo);
        WxMessage wxMessage = WxMessage.builder()
                .addToUser(sysUser.getCode())
                .addTemplate(WxMessageTemplate.EXAMINE_MESSAGE)
                .addPage("packageMine/pages/demandDetails/demandDetails?demandCode=" + demandInfo.getCode())
                .addMiniprogramState(state)
                .addData("thing10", desc)
                .addData("time9", date)
                .build();
        if (desc == null) {
            return;
        }
        messageSenderService.sendMessage(wxMessage);

    }

    private String getDescToEmployer(DemandInfo demandInfo) {
        switch (DemandAttestationType.get(demandInfo.getAttestation())) {
            case YES_ATTESTATION:
                return String.format("您的任务已认证成功，将尽快为您匹配人才。");
        }
        return null;
    }
}
