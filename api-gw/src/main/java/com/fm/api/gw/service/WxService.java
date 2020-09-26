package com.fm.api.gw.service;

import com.fm.api.gw.vo.WeChatDecryptVO;
import com.fm.api.gw.vo.WeChatLoginVO;

public interface WxService {

    WeChatDecryptVO getSessionInfo(WeChatLoginVO weChatLoginDTO);
}
