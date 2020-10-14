package com.fm.business.base.service.wx.message;

import com.fm.business.base.enums.WxMessageTemplate;
import com.fm.business.base.service.wx.message.message.WxMessage;

import java.util.Map;

/**
 * @author zhangleqi
 * @date 2020/10/14
 */
public interface MessageSenderService {
    void sendMessage(String touser, WxMessageTemplate wxMessageTemplate, Map<String, WxMessage.TemplateData> data);
}
