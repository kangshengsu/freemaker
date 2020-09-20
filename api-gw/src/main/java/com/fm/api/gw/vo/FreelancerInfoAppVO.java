package com.fm.api.gw.vo;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FreelancerInfoAppVO extends VO implements Serializable {

    /**
     * 逻辑主键
     **/
    private Long id;


    /**
     * 自由职业者编码
     **/
    private String code;


    /**
     * 自由职业者姓名
     **/
    private String name;


    /**
     * 技能描述
     **/
    private String skillSummarize;


    /**
     * 语言
     **/
    private Integer language;


    /**
     * 所属领域
     **/
    private Long jobCateId;


    /**
     * 技能全路径
     **/
    private String cateTreeCode;


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
     * 关联账户(微信登录认证)
     **/
    private String accountCode;


    /**
     * 手机号
     **/
    private String phone;


    /**
     * 创建时间
     **/
    private Date createTime;


    /**
     * 修改时间
     **/
    private Date updateTime;


    /**
     * 创建人
     **/
    private Long createUser;


    /**
     * 修改人
     **/
    private Long updateUser;

}
