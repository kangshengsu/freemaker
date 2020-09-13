package com.fm.api.gw.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.binarywang.spring.starter.wxjava.miniapp.properties.WxMaProperties;
import com.fm.api.gw.service.WxService;
import com.fm.api.gw.vo.UserVO;
import com.fm.api.gw.vo.WeChatLoginVO;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.web.response.ApiStatus;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class WxServiceImpl implements WxService {

    @Resource
    private WxMaProperties wxProperties;

    @Resource
    private WxMaService wxMaService;


    public UserVO getSessionInfo(WeChatLoginVO weChatLoginDTO) {
        UserVO userVO = new UserVO();
        WxMaJscode2SessionResult sessionInfo = null;
        try {
            sessionInfo = wxMaService.getUserService().getSessionInfo(weChatLoginDTO.getCode());
        } catch (WxErrorException e) {
            log.error("小程序授权解析异常", e);
            throw new BusinessException(ApiStatus.MINI_LOGIN_EXCEPTIONA.getCode(), ApiStatus.MINI_LOGIN_EXCEPTIONA.getMessage());
        }
        userVO.setSessionId(sessionInfo.getSessionKey());
        userVO.setOpenId(sessionInfo.getOpenid());
        userVO.setUnionid(sessionInfo.getUnionid());

        return userVO;

    }
}
