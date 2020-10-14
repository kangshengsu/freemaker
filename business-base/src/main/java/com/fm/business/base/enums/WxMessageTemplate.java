package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 支付模板
 * @author zhangleqi
 * @date 2020/10/14
 */
@Getter
@AllArgsConstructor
public enum WxMessageTemplate {

    RECOMMEND_MESSAGE("cv5hTnU_ABBjp8spFDvQacYttU2ZC3guvvJAoGKC8bA", "岗位匹配提醒"),
    PAY_SUCCEE_MESSAGE("CAwk0-nW2lZqcrC67SzF1YQiKqLaOANGkno6gxRjdKA", "订单支付成功通知"),
    ORDER_STATUS_CHANGE_MESSAGE("0mfM9FVKOJzkD-tbXC9M1d5d5pfouIhjxDMBUzYogFI", "订单状态通知"),
    NEW_ORDER_MESSAGE("xwR8tbRVyVuZ6AlMF6Q7wtxzQNYV_SbiVkq2eMMpwBk", "新订单通知");

    private String code;

    private String desc;


}
