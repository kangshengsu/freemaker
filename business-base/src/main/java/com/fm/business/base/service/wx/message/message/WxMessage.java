package com.fm.business.base.service.wx.message.message;

import com.fm.business.base.enums.WxMessageTemplate;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

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
    private Map<String, TemplateData> data = new HashMap<>();

    public static WxMessage.Builder builder() {
        return new WxMessage.Builder();
    }


    @lombok.Data
    @lombok.AllArgsConstructor
    public static class TemplateData {
        private String value;
    }

    public static class Builder {
        private String touser;
        private String template_id;
        private String page;
        private String miniprogram_state;
        private Map<String, TemplateData> data = new HashMap<>();

        Builder() {
        }

        public WxMessage.Builder addToUser(String touser) {
            this.touser = touser;
            return this;
        }

        public WxMessage.Builder addTemplate(WxMessageTemplate wxMessageTemplate) {
            this.template_id = wxMessageTemplate.getCode();
            return this;
        }

        public WxMessage.Builder addPage(String page) {
            this.page = page;
            return this;
        }

        public WxMessage.Builder addData(String name, String vaule) {
            this.data.put(name, new TemplateData(vaule));
            return this;
        }

        public WxMessage.Builder addMiniprogramState(String state) {
            this.miniprogram_state = state;
            return this;
        }

        public WxMessage build() {
            WxMessage wxMessage = new WxMessage();
            wxMessage.setTouser(this.touser);
            wxMessage.setTemplate_id(this.template_id);
            wxMessage.setPage(this.page);
            wxMessage.setData(this.data);
            return wxMessage;
        }
    }
}
