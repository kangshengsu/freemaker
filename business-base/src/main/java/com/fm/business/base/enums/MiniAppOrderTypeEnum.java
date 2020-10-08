package com.fm.business.base.enums;

import com.fm.framework.core.exception.BusinessException;
import lombok.Getter;

import java.util.Arrays;

/**
 * 小程序订单视图层的订单分类（非真实订单分类）
 */
@Getter
public enum MiniAppOrderTypeEnum {

    /**
     * 10 全部
     */
    ALL(10, "全部订单"),
    /**
     * 20-我发起的
     */
    INITIATE(20, "我发起的"),
    /**
     * 30-我收到的
     */
    RECEIVED(30, "我收到的");

    /**
     * 类型编码
     */
    private Integer index;

    /**
     * 名称
     */
    private String desc;

    MiniAppOrderTypeEnum(Integer index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public static MiniAppOrderTypeEnum resolve(Integer index) {
        return Arrays.stream(values()).filter(v -> v.getIndex().equals(index)).findFirst().orElseThrow(()-> new BusinessException("MiniAppOrderTypeEnum type error"));

    }

}
