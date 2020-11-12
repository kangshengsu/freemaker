package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TreeCodeType {

    /**
     * 专家类
     */
    CRIM(6000,"CRIM"),

    /**
     * 设计类
     */
    NCDI(6001,"NCDI"),

    /**
     * 运营类
     */
    ROBD(6002,"ROBD"),

    /**
     * 视频类
     */
    FWKJ(8000,"FWKJ"),

    /**
     * 研发类
     */
    YNEH(8001,"YNEH");


    private Integer jobCateId;

    private String cateTreeNode;

    public static TreeCodeType get(Integer jobCateId) {
        if (jobCateId == null) {
            return null;
        }
        TreeCodeType[] _enums = values();
        for (TreeCodeType _enum : _enums) {
            if (_enum.getJobCateId().equals(jobCateId)) {
                return _enum;
            }
        }
        return null;
    }
}
