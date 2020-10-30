package com.fm.api.gw.vo.recommend;

import com.fm.api.gw.vo.evaluation.OverallEvaluationVO;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.api.gw.vo.production.relation.JobCateVO;
import com.fm.api.gw.vo.production.relation.SkillRelationVO;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhangleqi
 * @date 2020/10/10
 */
@Data
public class RecommendProductionVO extends VO implements Serializable {

    /**
     * 作品编码
     */
    private String code;

    /**
     * 标题
     */
    private String title;

    /**
     * 预算计算方式
     */
    private Integer budgetType;

    /**
     * 时薪
     **/
    private BigDecimal hourlyWage;

    /**
     * 领域
     */
    private JobCateVO domainCate;

    /**
     * 岗位
     */
    private JobCateVO postCate;

    /**
     * 作者信息
     */
    private FreelancerInfoApiVO freelancerInfo;

    /**
     * 技能
     */
    private List<SkillRelationVO> skills;

    /**
     * 展示图片信息
     */
    private List<AttachmentVO> images;

    /**
     * 综合评价
     */
    private OverallEvaluationVO overallEvaluation;
}
