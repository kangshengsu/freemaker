package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/24 17:58
 */
@Getter
@AllArgsConstructor
public enum  SelectIsRecommend {
    RECOMMEND(10,"推荐"),
    NOT_RECOMMEND(20,"不推荐");

    private Integer code;
    private String name;

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static SelectIsRecommend get(Integer code) {
        if (code == null) {
            return null;
        }
        SelectIsRecommend[] _enums = values();
        for (SelectIsRecommend _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
