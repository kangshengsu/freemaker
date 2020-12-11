package com.fm.api.web.vo.educationInfo;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProfessionNameInfoVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555102L;

    private Long id;

    private String professional;

    private String name;

    private String keyword;
}
