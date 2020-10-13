package com.fm.business.base.service.wx.message.message;

import lombok.Data;

/**
 * @author zhangleqi
 * @date 2020/10/14
 */
@Data
public class WxMessage {
    private String touser;
    private String template_id;
    private String page;
    private Data data;

    @lombok.Data
    public static class Data {
        private String number1;
        private String thing2;
    }

}
