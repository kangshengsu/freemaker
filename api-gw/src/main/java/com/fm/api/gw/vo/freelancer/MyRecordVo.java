package com.fm.api.gw.vo.freelancer;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

@Data
public class MyRecordVo extends VO implements Serializable {

    private static final long serialVersionUID = 5919048682566145671L;

    /**
     * 推荐人数
     */
    private Long recommended;

    /**
     * 推荐后发布作品人数
     */
    private Long publishProduction;

    /**
     * 推荐后发布作品通过的人数
     */
    private Long productionPass;
}
