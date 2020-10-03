package com.fm.api.gw.vo;

import com.fm.business.base.model.sys.SysUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MiniAppUserVO extends SysUser {

    private String sessionKey;

    private Long freeLancerId;

    private Long employerId;
}
