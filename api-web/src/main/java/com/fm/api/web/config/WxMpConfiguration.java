package com.fm.api.web.config;

import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * wechat mp configuration
 *
 * @author Binary Wang(https://github.com/binarywang)
 */
@AllArgsConstructor
@Configuration
public class WxMpConfiguration {

    @Bean
    public WxMpService wxMpService() {

        return new WxMpServiceImpl();
    }


}
