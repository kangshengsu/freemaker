package com.fm.api.gw.vo.im;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/14 17:14
 */
@Data
public class ImVO implements Serializable {
    private static final long serialVersionUID = -8919460012280660267L;

    private  Long sdkAppId;

    private String userSig;
}
