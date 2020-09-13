package com.fm.api.gw.service;

import com.fm.api.gw.vo.UserInfoVO;
import com.fm.api.gw.vo.WeChatLoginVO;

public interface WxService {

    UserInfoVO getSessionInfo(WeChatLoginVO weChatLoginDTO);
}
