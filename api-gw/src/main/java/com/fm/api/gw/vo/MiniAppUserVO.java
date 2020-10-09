package com.fm.api.gw.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MiniAppUserVO  implements Serializable {

    private static final long serialVersionUID = 6903897025794655927L;

    private String sessionKey;

    private Long freeLancerId;

    private Long employerId;

    private Long userId;
}
