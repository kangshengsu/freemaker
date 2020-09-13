package com.fm.api.gw.service;

import com.fm.api.gw.vo.UserVO;
import com.fm.api.gw.vo.WeChatLoginVO;

public interface WxService {

    UserVO getSessionInfo(WeChatLoginVO weChatLoginDTO);
}
