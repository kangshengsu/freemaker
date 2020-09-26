package com.fm.api.gw.rpc;

import com.fm.api.gw.vo.WeChatDecryptVO;
import com.fm.api.gw.vo.WeChatLoginVO;

public interface WxRpcService {

    WeChatDecryptVO getSessionInfo(WeChatLoginVO weChatLoginDTO);

    String getPhoneNumber(String sessionKey, String encryptedData, String iv);

}
