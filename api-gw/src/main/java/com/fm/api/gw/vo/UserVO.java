package com.fm.api.gw.vo;

import com.fm.framework.web.VO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class  UserVO extends VO implements Serializable {

    @ApiModelProperty(value = "openId", notes = "小程序openId")
    private String openId;

    @ApiModelProperty(value = "sessionKey", notes = "用户sessionKey")
    private String sessionKey;

    @ApiModelProperty(value = "unionid", notes = "小程序unionid")
    private String unionid;
}
