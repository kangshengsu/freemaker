package com.fm.api.web.util;

import com.fm.framework.core.query.PageInfo;
import lombok.Data;

/**
 * .
 */
@Data
public class RestRequest <T> {

    private T data;

    private PageInfo<T> page ;

    /**
     * 基本校验 ，rest请求参数体不能为空
     * */
    public boolean baseCheck(){
        return data != null;
    }
}
