package com.fm.business.base.model.sm;

/**
 * @author hubo
 * @version 1.0.0
 **/
public enum MenuComponentType {
    /**
     * layout
     * */
    layout("layout"),
    /**
     * frame
     * */
    frame("frame"),

    /**
     * 内联
     * */
    nested("nested"),

    /**
     * 按钮
     * */
    button("button");

    private String type;

    MenuComponentType(String type) {
        this.type = type;
    }

    public String value (){
        return this.type;
    }
}
