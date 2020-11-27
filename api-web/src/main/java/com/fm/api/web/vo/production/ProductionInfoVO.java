/**
 * @filename:ProductionInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.web.vo.production;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.partner.PartnerInfo;
import com.fm.business.base.model.production.ProductionSkillRelation;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description:(作品请求实体类)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Data
public class ProductionInfoVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555102L;

    private List<Long> ids;

    /**
     * 作品编码
     **/
    private String code;


    /**
     * 发布用户编码
     **/
    private Long freelancerId;

    /**
     * 自由职业者
     */
    private FreelancerInfo freelancerInfo;

    /**
     * 合伙人信息
     */
    private PartnerInfo partnerInfo;

    /**
     * 作品标题
     **/
    private String title;


    /**
     * 技能描述
     **/
    private String summarize;


    /**
     * 时薪
     **/
    private BigDecimal hourlyWage;


    /**
     * 状态（10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除）
     **/
    private Integer status;

    /**
     * 状态（10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除）
     **/
    private String statusName;

    /**
     * 所属岗位
     **/
    private Long jobCateId;

    /**
     * 所属岗位名称
     **/
    private String jobCateName;

    /**
     * 技能全路径
     **/
    private String cateTreeCode;

    /**
     * 交付方式
     * @see com.fm.business.base.enums.DeliveryType
     */
    private Integer deliveryType;

    /**
     * 薪资计算方式
     * @see com.fm.business.base.enums.BudgetType
     */
    private Integer budgetType;

    /**
     * 交付方式名称
     */
    private  String deliveryTypeName;

    /**
     * 预算方式名称
     */
    private  String budgetTypeName;

    /**
     * 创建时间
     **/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 附件列表
     */
    private List<AttachmentInfo> attachmentInfos;

    /**
     * 附件路径
     */
    private List<String> attachmentInfoPaths;

    /**
     * 技能列表
     */
    private List<ProductionSkillRelation> productionSkillRelations;

    /**
     * 修改时间
     **/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;


    /**
     * 创建人
     **/
    private Long createUser;


    /**
     * 修改人
     **/
    private Long updateUser;


    /**
     * 是否需求审核
     */
    private Boolean needReview;

}
