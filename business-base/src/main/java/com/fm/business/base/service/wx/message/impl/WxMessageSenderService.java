package com.fm.business.base.service.wx.message.impl;

import com.fm.business.base.enums.WxMessageTemplate;
import com.fm.business.base.service.wx.message.MessageSenderService;
import com.fm.business.base.service.wx.message.message.WxMessage;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author zhangleqi
 * @date 2020/10/14
 */
@Service
@Slf4j
public class WxMessageSenderService implements MessageSenderService {

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

    public void sendMessage(WxMessage message) {
        if (log.isDebugEnabled()) {
            log.debug("开始推送小程序消息:[{}]", message);
        }
        try {
            String accessToken = getAccessToken();

            String sendUrl = String.format(messageUrl, accessToken);

            ResponseEntity<String> response = restTemplate.postForEntity(sendUrl, message, String.class);
        } catch (RestClientException e) {
            String errorMessage = String.format("推送小程序消息[%s]失败", message);
            log.error(errorMessage, e);
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("推送小程序消息结束:[{}]", message);
            }
        }
    }

    private String getAccessToken() {
        String url = String.format(accessUrl, appid, secret);
        String json = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.get("access_token").toString();
    }

}
