package com.fm.business.base.model.conf;

/**
 * 展现类型
 * @author hubo
 * @version 1.0.0
 **/
public enum DisplayType {

    /**
     * 领域
     */
    job_cate_1(1),
    /**
     * 领域
     */
    job_cate_2(2),
    /**
     * 推荐作品
     */
    r_product_info(7);

    private int code;

    DisplayType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }



}
