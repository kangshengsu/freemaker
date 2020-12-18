package com.fm.api.web.controller.wxServer;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author G
 * @date 2020/12/18 下午5:17
 */
@Controller
@RequestMapping("/wxPublic/serverApi")
@Slf4j
public class WxServerApi {

    //在 微信公众号-服务器配置 中配置, 对应“令牌(Token)”
    @Value("${wx.public.wxServerAuthenToken}")
    String wxServerAuthenToken;

    /**
     * 开发者认证接口
     * 微信api用于认证 服务器 是否为可用服务器
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping("/wxAuthenConfig")
    @ResponseBody
    public String wxAuthenConfig(String signature, String timestamp, String nonce, String echostr) {

        log.info("开发者认证接口 - 开始签名验证：" + " PARAM VAL: >>>" + signature + "\t" + timestamp + "\t" + nonce + "\t" + echostr);

        if (StringUtils.isNotEmpty(signature) && StringUtils.isNotEmpty(timestamp) && StringUtils.isNotEmpty(nonce)
                && StringUtils.isNotEmpty(echostr)) {
            String sTempStr = "";
            try {
                sTempStr = SHA1.getSHA1(timestamp, nonce, wxServerAuthenToken, "");
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (StringUtils.isNotEmpty(sTempStr) && StringUtils.equals(signature, sTempStr)) {
                log.info("开发者认证接口 - 开始签名验证 - 验证成功：-----------：" + sTempStr);
                return echostr;
            } else {
                log.info("开发者认证接口 - 开始签名验证 - 验证失败：-----------：00000");
                return "-1";
            }
        } else {
            log.info("开发者认证接口 - 开始签名验证 - 验证失败：-----------：11111");
            return "-1";
        }
    }

}
