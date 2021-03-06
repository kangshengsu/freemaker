/**
 * @filename:ProductionInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.model.production;

import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.partner.PartnerInfo;
import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description:(作品实体类)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Data
public class ProductionInfo extends BaseModel implements Serializable,IAudit {

	private static final long serialVersionUID = 1600497555102L;

    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 作品编码
    **/
	private String code;


    /**
    * 发布用户编码
    **/
	private Long freelancerId;


	private transient FreelancerInfo freelancerInfo;

    private transient PartnerInfo partnerInfo;

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
    * 所属领域
    **/
	private Long jobCateId;


    /**
    * 技能全路径
    **/
	private String cateTreeCode;

    /**
     * 领域-岗位
     */
    private transient BdJobCate domainCate;

    /**
     * 领域-岗位
     */
	private transient BdJobCate postCate;

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
     * 作品权重
     */
    private Integer productionWeight;

    /**
     * 交付方式名称
     */
    private transient String deliveryTypeName;

    /**
     * 预算方式名称
     */
    private transient String budgetTypeName;

    /**
     * 是否收藏
     */
    private transient Boolean isCollect;

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


    /**
     * 附件
     */
    private transient List<AttachmentInfo> attachmentInfos;

    /**
     * 技能关系
     */
    private transient List<ProductionSkillRelation> productionSkillRelations;

    /**
     * 获取主键方法，主键整体平台定义成Long数据类型，方便数据的整体插入性能
     *
     * @return 主键
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * 设置模型主键
     *
     * @param id 主键
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
