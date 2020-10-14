package com.fm.business.base.service.wx.message.impl;

import com.fm.business.base.enums.WxMessageTemplate;
import com.fm.business.base.service.wx.message.MessageSenderService;
import com.fm.business.base.service.wx.message.message.WxMessage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author zhangleqi
 * @date 2020/10/14
 */
@Service
public class MessageSenderServiceImpl implements MessageSenderService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${wx.miniapp.appid}")
    private String appid;

    @Value("${wx.miniapp.secret}")
    private String secret;

    @Value("${wx.miniapp.accessUrl}")
    private String accessUrl;

    @Value("${wx.miniapp.messageUrl}")
    private String messageUrl;

    public void sendMessage(String touser, WxMessageTemplate wxMessageTemplate, Map<String, WxMessage.TemplateData> data) {

        String accessToken = getAccessToken();

        String sendUrl = String.format(messageUrl,accessToken);

        //拼接推送的模版
        WxMessage wxMessage = new WxMessage();
        wxMessage.setTouser(touser);
        wxMessage.setTemplate_id(wxMessageTemplate.getCode());
        wxMessage.setData(data);
        ResponseEntity<String> response = restTemplate.postForEntity(sendUrl, wxMessage, String.class);
    }

    private String getAccessToken() {
        String url = String.format(accessUrl,appid,secret);
        String json = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.get("access_token").toString();
    }

}
