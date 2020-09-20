package com.fm.api.gw.vo;

import com.fm.framework.web.VO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class  UserVO extends VO implements Serializable {

    @ApiModelProperty(value = "用户编码", notes = "用户编码")
    private String userCode;

    @ApiModelProperty(value = "用户名称", notes = "用户名称")
    private Long userName;

    @ApiModelProperty(value = "用户类型", notes = "1-雇佣者，2-FreeLancer")
    private Integer userType;

    @ApiModelProperty(value = "用户手机号", notes = "加密手机号")
    private String userMobile;

    @ApiModelProperty(value = "openId", notes = "小程序openId")
    private String openId;

    @ApiModelProperty(value = "sessionId", notes = "用户sessionId")
    private String sessionId;

    @ApiModelProperty(value = "unionid", notes = "小程序unionid")
    private String unionid;
}
