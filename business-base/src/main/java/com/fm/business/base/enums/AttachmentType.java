package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 附件类型
 *  1-图片,2-视频
 * @author zhangleqi
 * @date 2020-09-19 7:10 下午
 */
@Getter
@AllArgsConstructor
public enum AttachmentType {
    /**
     * 10-需求
     */
    PICTURE(1,"图片"),

    /**
     * 20-作品
     */
    VIDEO(2,"视频");

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
    public static AttachmentType get(Integer code) {
        if(code == null){
            return null;
        }
        AttachmentType[] _enums = values();
        for (AttachmentType _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }
}
