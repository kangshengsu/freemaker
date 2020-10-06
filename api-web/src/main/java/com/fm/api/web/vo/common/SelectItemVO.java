package com.fm.api.web.vo.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：liuduo
 * @description：TODO
 * @date ：2020/9/14 22:03
 */
@Data
@AllArgsConstructor
public class SelectItemVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编码
     */
    private Long value;

    /**
     * 名称
     */
    private String text;

}
