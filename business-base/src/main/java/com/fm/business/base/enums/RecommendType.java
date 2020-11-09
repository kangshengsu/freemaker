package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RecommendType {

    /**
     * 10-我申请
     */
    MY_RECOMMEND(10,"我申请"),

    /**
     * 20-平台推荐
     */
    SYSTEM_RECOMMEND(20,"平台推荐"),

    /**
     * 我发起
     */
    MY_START(30,"我发起");

    /**
     * 编码
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static RecommendType get(Integer code) {
        if (code == null) {
            return null;
        }
        RecommendType[] _enums = values();
        for (RecommendType _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
