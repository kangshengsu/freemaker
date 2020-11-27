package com.fm.business.base.model.job;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/20 17:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BdJobCateDetail extends BaseModel implements Serializable, IAudit {

    private static final long serialVersionUID = -957796598006469706L;

    private Long id;
    /**
     * 对应类目主键
     */
    private Long jobCateId;

    /**
     * 类目简称
     */
    private String cateNameAbb;

    /**
     * 类目名称
     */
    private String cateName;

    /**
     * 类目英文名
     */
    private String englishName;

    /**
     * 类目icon
     */
    private String icon;

    /**
     * 类目描述
     */
    private String description;

    /**
     * 类目类型
     */
    private Long cateType;

    /**
     * 是否首页展示(目前仅一级使用)
     */
    private Long isHomeShow;

    /**
     * 首页展示顺序(目前仅一级使用)
     */
    private Long homeShowOrder;

    /**
     * 是否类目页展示
     */
    private Long categoryShow;

    /**
     * 类目页展示顺序
     */
    private Long categoryShowOrder;

    /**
     * 服务均价
     */
    private BigDecimal servePrice;

    /**
     * 服务企业数
     */
    private Long serveCompany;

    /**
     * 服务人才数
     */
    private Long serveFreelancer;

    /**
     * 是否上新
     */
    private Long isNew;

    /**
     * 是否火热
     */

    private Long isHot;


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
