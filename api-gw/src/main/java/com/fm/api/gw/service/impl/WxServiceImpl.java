package com.fm.api.gw.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.binarywang.spring.starter.wxjava.miniapp.properties.WxMaProperties;
import com.fm.api.gw.service.WxService;
import com.fm.api.gw.vo.UserInfoVO;
import com.fm.api.gw.vo.WeChatLoginVO;
import com.fm.framework.core.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class WxServiceImpl implements WxService {
    private static final String WX_MA_TEMPLATE_MESSAGE_URL ="https://api.weixin.qq.com/cgi-bin/message/template/send";

    @Resource
    private WxMaProperties wxProperties;

    @Resource
    private WxMaService wxMaService;



    public UserInfoVO getSessionInfo(WeChatLoginVO weChatLoginDTO) {
        UserInfoVO userInfoDTO = new UserInfoVO();
        WxMaJscode2SessionResult sessionInfo = null;
        try {
            sessionInfo = wxMaService.getUserService().getSessionInfo(weChatLoginDTO.getCode());
        } catch (WxErrorException e) {
            log.error("小程序授权解析异常", e);
            throw new BusinessException("1000","小程序授权解析异常");
        }
        return userInfoDTO;

    }
}
