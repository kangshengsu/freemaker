package com.fm.api.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author G
 * @date 2020/12/18 下午5:17
 */
@RestController
@RequestMapping("/wx/portal")
@Slf4j
public class WxPortalController {

    @GetMapping(produces = "text/plain;charset=utf-8")
    public String authGet(@RequestParam(name = "signature", required = false) String signature,
                          @RequestParam(name = "timestamp", required = false) String timestamp,
                          @RequestParam(name = "nonce", required = false) String nonce,
                          @RequestParam(name = "echostr", required = false) String echostr) {

        log.info("\n接收来自微信服务器的认证消息：[{}, {}, {}, {}]", signature, timestamp, nonce, echostr);

        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法");
        }
        if (this.checkSignature(timestamp, nonce, signature)){
            log.info("\n成功");
            return echostr;
        }
        return "非法请求";
    }

    private boolean checkSignature(String timestamp, String nonce, String signature){
        String token ="Cz5oH5KnsfJX8Bl536Yxd7CrwjMVazhqxY3mgcQXXRv";
        String[] arr = {token, timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String a : arr){
            sb.append(a);
        }
        return DigestUtils.sha1Hex(sb.toString()).equals(signature);
    }

}
