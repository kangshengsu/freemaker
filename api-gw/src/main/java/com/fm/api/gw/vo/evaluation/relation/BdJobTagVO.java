package com.fm.api.gw.vo.evaluation.relation;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangleqi
 * @date 2020/10/8
 */
@Data
public class BdJobTagVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555102L;

    /**
     * 标签名称
     */
    private String tagName;
}
