package com.fm.business.base.enums;

public enum OrderOperateType {
    SUBMIT_PAYMENT_VOUCHER(9,"提交支付凭证"),
    SUBMIT(10,"提交验收"),
    SUBMIT_AGAIN(11,"重新提交验收"),
    ACCEPT(20,"验收通过"),
    UNACCEPT(30,"验收不通过"),
    RECEIVE(31,"接单"),
    FINISH(32,"完成服务");

    private Integer code;
    private String name;

    OrderOperateType(int type, String name) {
        this.code = type;
        this.name = name;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() { return this.name; }

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static OrderOperateType get(Integer code) {
        if (code == null) {
            return null;
        }
        OrderOperateType[] _enums = values();
        for (OrderOperateType _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
