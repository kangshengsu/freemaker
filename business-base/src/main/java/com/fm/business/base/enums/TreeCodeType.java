package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TreeCodeType {
    LCJD(36001,"LCJD"),

    BBTE(36003,"BBTE"),

    RHXC(38002,"RHXC"),

    PJJI(38008,"PJJI"),

    NXTG(38011,"NXTG"),

    ULFU(38013,"ULFU");

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
