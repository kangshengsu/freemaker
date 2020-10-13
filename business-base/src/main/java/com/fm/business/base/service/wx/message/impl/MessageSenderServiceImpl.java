package com.fm.business.base.service.wx.message.impl;

import com.fm.business.base.service.wx.message.MessageSenderService;
import com.fm.business.base.service.wx.message.message.WxMessage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public void sendMessage() {

        String accessToken = getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken;

        //拼接推送的模版
        WxMessage wxMessage = new WxMessage();
        wxMessage.setTouser("o9kHZ5biqMlTd7yWesFjip984v34");
        wxMessage.setTemplate_id("cv5hTnU_ABBjp8spFDvQacYttU2ZC3guvvJAoGKC8bA");
        WxMessage.Data data = new WxMessage.Data();
        data.setNumber1("1");
        data.setThing2("啥玩应都是");
        if(restTemplate==null){
            restTemplate = new RestTemplate();
        }

        restTemplate.postForEntity(url, wxMessage, String.class);
    }

    private String getAccessToken() {
        String url = String.format(accessUrl,appid,secret);
        String json = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.get("access_token").toString();
    }

}
