package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 附件类型
 *  10-需求,20-作品,30-订单
 * @author zhangleqi
 * @date 2020-09-19 7:10 下午
 */
@Getter
@AllArgsConstructor
public enum AttachmentBusinessType {
    /**
     * 10-需求
     */
    DEMAND(10,"需求"),

    /**
     * 20-作品
     */
    PRODUCTION(20,"作品"),

    /**
     * 30-订单
     */
    ORDER(30,"订单");

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
     * @param code
     * @return
     */
    public static AttachmentBusinessType get(Integer code) {
        if(code == null){
            return null;
        }
        AttachmentBusinessType[] _enums = values();
        for (AttachmentBusinessType _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
