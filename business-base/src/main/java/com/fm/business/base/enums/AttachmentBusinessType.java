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
    ORDER(30,"订单"),
    ORDER_OPERATE(31,"订单操作"),
    ORDER_EVALUATION(32,"订单评价"),
    ORDER_CANCEL(33,"取消订单"),
    /**
     * 41-技能树头像
     */
    JOB_PROFILE_PHOTO(40,"技能树"),
    /**
     * 41-自由职业者头像
     */
    FREELANCER_PROFILE_PHOTO(41,"自由职业者"),
    /**
     * 42-雇佣者
     */
    EMPLOYER_PROFILE_PHOTO(42,"雇佣者"),

    /**
     * 50-岗位默认图片
     */
    JOB_DEFAULT_IMAGE(50,"岗位默认图片");

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
