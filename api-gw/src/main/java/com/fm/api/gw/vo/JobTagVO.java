package com.fm.api.gw.vo;

import com.fm.framework.core.model.ITreeNode;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class JobTagVO extends VO implements Serializable {
    /**
     * 逻辑主键
     **/
    private Long id;


    private String tagName;
}
