package com.fm.business.base.service.wx.message.message;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangleqi
 * @date 2020/10/14
 */
@Data
public class WxMessage {
    private String touser;
    private String template_id;
    private String page;
    private Map<String,TemplateData> data;

    @lombok.Data
    @lombok.AllArgsConstructor
    public static class TemplateData {
        private String value;
    }
}
