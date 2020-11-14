package com.fm.business.base.model.sm;

import com.fm.framework.core.exception.BusinessException;

import java.util.Arrays;

/**
 * 菜单类型
 * @author hubo
 * @version 1.0.0
 **/
public enum MenuType {
    /**
     * 按钮
     * */
    button(0),
    /**
     * 链接path
     * */
    menu(1),

    /**
     * 目录
     */
    catalog(2);

    private int type;

    MenuType(int type) {
        this.type = type;
    }

    public static MenuType getMenuType(int type) {
        return Arrays.stream(values()).filter(menuType -> menuType.value() == type)
                .findFirst().orElseThrow(()-> new BusinessException("未知菜单类型"));
    }

    public int value (){
        return this.type;
    }
}
