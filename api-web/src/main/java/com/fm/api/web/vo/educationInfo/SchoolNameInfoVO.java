package com.fm.api.web.vo.educationInfo;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

@Data
public class SchoolNameInfoVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555102L;

    private Long id;

    private String name;

    private String place;

    private String type;

    private String properties;

    private String keyword;
}
