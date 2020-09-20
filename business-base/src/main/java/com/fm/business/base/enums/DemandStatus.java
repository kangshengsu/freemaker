package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 需求状态
 *
 * @author zhangleqi
 * @date 2020-09-19 4:28 下午
 */
@Getter
@AllArgsConstructor
public enum DemandStatus {
    /**
     * 10-未发布
     */
    NOT_RELEASE(10, "未发布"),
    /**
     * 20-已发布
     */
    RELEASE(20, "已发布"),
    /**
     * 30-已取消
     */
    CANCEL(30, "已取消"),
    /**
     * 40-已下单
     */
    ORDERED(40, "已下单");
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
    public static DemandStatus get(Integer code) {
        if (code == null) {
            return null;
        }
        DemandStatus[] _enums = values();
        for (DemandStatus _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

}
