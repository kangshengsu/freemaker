package com.fm.api.gw.vo;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
@Data
public class ContactInfoAppVO extends VO implements Serializable {
    private String phone;
    private String wxCode;
}
