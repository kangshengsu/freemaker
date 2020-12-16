package com.fm.business.base.service.wx.message.impl;

import com.fm.business.base.service.wx.message.MessageSenderService;
import com.fm.business.base.service.wx.message.message.WxMessage;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangleqi
 * @date 2020/10/14
 */
@Service
@Slf4j
public class WxMessageSenderService implements MessageSenderService {
    @Autowired
    private RedissonClient redissonClient;
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
        log.info("开始推送小程序消息:[{}]", message);
        try {
            String accessToken = getAccessToken();

            String sendUrl = String.format(messageUrl, accessToken);

            ResponseEntity<String> response = restTemplate.postForEntity(sendUrl, message, String.class);
            log.info("推送小程序消息:[{}]", response);
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
        RBucket<String> rBucket = redissonClient.getBucket("appAccessToken");
        //缓存用户token信息，供拦截器使用
        if (rBucket.isExists()) {
            return rBucket.get();
        }
        String url = String.format(accessUrl, appid, secret);
        String json = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(json);
        String access_token = jsonObject.get("access_token").toString();
        redissonClient.getBucket("appAccessToken").set(access_token,1, TimeUnit.HOURS);
        return access_token;
    }

}
