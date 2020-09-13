package com.fm.api.gw.vo;

import com.fm.framework.web.VO;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserInfoVO  extends VO implements Serializable {

    @ApiModelProperty(value = "用户编码", notes = "用户编码")
    private String userCode;

    @ApiModelProperty(value = "用户名称", notes = "用户名称")
    private Long userName;

    @ApiModelProperty(value = "用户类型", notes = "1-雇佣者，2-FreeLancer")
    private Integer userType;

    @ApiModelProperty(value = "用户手机号", notes = "加密手机号")
    private String userMobile;

    @ApiModelProperty(value = "openId", notes = "openID")
    private String openId;

}
