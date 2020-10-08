package com.fm.api.gw.vo.evaluation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.api.gw.vo.OrderInfoVO;
import com.fm.api.gw.vo.employer.EmployerInfoApiVO;
import com.fm.api.gw.vo.evaluation.relation.BdJobTagVO;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.production.relation.AttachmentVO;
import com.fm.api.gw.vo.production.relation.JobCateVO;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.evaluation.EvaluationInfoTag;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class EvaluationInfoVO extends VO implements Serializable {
    /**
     * 主键
     */
    public Long id;

    /**
     * 订单主键
     */
    public Long orderId;
    /**
     * 所属领域
     **/
    private Long jobCateId;
    /**
     * 技能全路径
     **/
    private String cateTreeCode;
    /**
     * 评价者主键
     */
    private Long employerId;
    /**
     * 被评价主键
     **/
    private Long freelancerId;
    /**
     * 总体评价
     */
    public Double totalScore;
    /**
     * 结果打分
     */
    public Double resultScore;
    /**
     * 过程打分
     */
    public Double processScore;
    /**
     * 推荐意向
     */
    public Double recommendScore;
    /**
     * 评价描述
     */
    public String description;
    /**
     * 创建时间
     **/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


    /**
     * 修改时间
     **/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
     * 评价人信息
     */
    private FreelancerInfoApiVO freelancerInfo;
    /**
     * 被评价人信息
     */
    private EmployerInfoApiVO employerInfo;
    /**
     * 订单信息
     */
    private OrderInfoVO orderInfo;
    /**
     * 岗位信息
     */
    private JobCateVO jobCate;
    /**
     * 评价标签信息
     */
    private List<BdJobTagVO> bdJobTags;
    /**
     * 附件信息
     */
    private List<AttachmentVO> images;
}
