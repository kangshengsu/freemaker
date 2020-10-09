package com.fm.api.gw.vo.employer;

import lombok.Data;

/**
 * @author zhangleqi
 * @date 2020/10/8
 */
@Data
public class EmployerInfoApiVO {
    /**
     * 逻辑主键
     **/
    private Long id;


    /**
     * 雇佣者编码
     **/
    private String code;


    /**
     * 雇佣者姓名
     **/
    private String name;


    /**
     * 关联账户(微信登录认证)
     **/
    private String accountCode;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 省份编码
     **/
    private String provinceCode;


    /**
     * 城市编码
     **/
    private String cityCode;


    /**
     * 区编码
     **/
    private String districtCode;


    /**
     * 县编码
     **/
    private String countyCode;


    /**
     * 手机号
     **/
    private String phone;

}
