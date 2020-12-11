package com.fm.business.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 后台人才分配页面服务作品状态
 * @version 1.0.0
 *
 *   10-未发布，20-审核中，30-未通过，40-已发布
 **/
@Getter
@AllArgsConstructor
public enum ServiceProductionStatus {
    /**
     * 10-未发布
     */
    NOT_RELEASE(10,"未发布"),
    /**
     * 20-审核中
     */
    REVIEW(20,"审核中"),
    /**
     * 30-未通过
     */
    REVIEW_NOT_PASS(30,"未通过"),
    /**
     * 40-已发布
     */
    RELEASE(40,"已发布");
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
    public static ServiceProductionStatus get(Integer code) {
        if(code == null){
            return null;
        }
        ServiceProductionStatus[] _enums = values();
        for (ServiceProductionStatus _enum : _enums) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 根据code获取name
     * @param code
     * @return
     */
    public static String getNameByCode(Integer code) {
        ServiceProductionStatus serviceProductionStatus = get(code);
        if (serviceProductionStatus==null) {
            return "";
        }
        return serviceProductionStatus.getName();
    }


}
