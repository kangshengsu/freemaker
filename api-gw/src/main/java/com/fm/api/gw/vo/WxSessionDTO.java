package com.fm.api.gw.vo;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 * code换取session_key接口的响应
 * 文档地址：https://mp.weixin.qq.com/debug/wxadoc/dev/api/api-login.html#wxloginobject
 * 微信返回报文：{"session_key":"nzoqhc3OnwHzeTxJs+inbQ==","openid":"oVBkZ0aYgDMDIywRdgPW8-joxXc4"}
 * </pre>
 * @author hekuan
 */
@Data
public class WxSessionDTO  extends VO implements Serializable {
  private static final long serialVersionUID = -1060216618475607933L;
//
//  @SerializedName("session_key")
//  private String sessionKey;
//
//  @SerializedName("openid")
//  private String openid;
//
//  @SerializedName("unionid")
//  private String unionid;
//
//  public static WxSessionDTO fromJson(String json) {
//    return WxMaGsonBuilder.create().fromJson(json, WxSessionDTO.class);
//  }

}