package com.fm.business.base.enums;

public enum FollowType {
    INIT_10(10, "下单"),

    WAITING_20(20, "接单"),//已下单

    REJECT_30(30, "取消"),//已拒单

    TAKING_40(40, "支付"),//待支付

    CANCELD_100(100, "取消"),

    PAID_50(50, "作中"), // = 已支付

    CANCEL_51(51,"取消订单待审核"),// 制作时雇主取消后待审核

    CANCEL_52(52,"已取消"),// 审核通过，取消订单

    CANCEL_53(53,"取消不通过"),// 审核未通过，回到服务中

    CHECKING_60(60, "验收"),

    CHECK_FAIL_61(61, "验收不通过"),//二次待验收

    CHECK_FAIL_70(70, "验收不通过"),//第一次不通过

    FINISHED_80(80, "完成"),

    FINISHED_81(81, "二次验收不通过"),//二次验收不通过，终止交易

    EVALUATED_90(90, "评价"),

    MODIFY_MNY_110(110, "修改订单金额");



    private Integer code;
    private String name;
    FollowType(int type, String name) {
        this.code = type;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static FollowType get(Integer code) {
        if (code == null) {
            return null;
        }
        FollowType[] _enums = values();
        for (FollowType _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
