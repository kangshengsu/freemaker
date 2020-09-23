package com.fm.api.gw.vo.production;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.production.ProductionSkillRelation;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ：liuduo
 * @description：TODO
 * @date ：2020/9/22 22:57
 */
@Data
public class ProductionApiVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555108L;

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
     * 创建 修改 时的 领域-岗位-技能数据
     */
    private List<List<Long>> jobs;

    /**
     * 是否需求审核
     */
    private Boolean needReview;

}
