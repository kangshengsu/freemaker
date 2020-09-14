package com.fm.api.web.vo.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：liuduo
 * @description：TODO
 * @date ：2020/9/14 22:03
 */
@Data
public class EnumVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;

}
