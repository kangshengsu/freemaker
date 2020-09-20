package com.fm.business.base.constant;

import com.fm.business.base.enums.ProductionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 基础字典group常量池
 * liuduo
 * 2020年9月14日 22:39:17
 */
@AllArgsConstructor
@Getter
public enum BaseDictGroupConstants {

    /**
     * 测试字典
     */
    TEST(1);

    private Integer group;

    /**
     * 根据group获取枚举
     * @param group
     * @return
     */
    public static BaseDictGroupConstants get(Integer group) {
        if(group == null){
            return null;
        }
        BaseDictGroupConstants[] _enums = values();
        for (BaseDictGroupConstants _enum : _enums) {
            if (_enum.getGroup().equals(group)) {
                return _enum;
            }
        }
        return null;
    }
}
