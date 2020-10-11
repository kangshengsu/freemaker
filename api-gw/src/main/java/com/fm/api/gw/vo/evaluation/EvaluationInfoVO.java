package com.fm.api.gw.vo.evaluation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.api.gw.vo.employer.EmployerInfoApiVO;
import com.fm.api.gw.vo.evaluation.relation.BdJobTagVO;
import com.fm.api.gw.vo.evaluation.relation.OrderInfoDetailVO;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.attachment.AttachmentVO;
import com.fm.api.gw.vo.production.relation.JobCateVO;
import com.fm.framework.web.VO;
import lombok.Data;

import javax.validation.constraints.*;
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
    @NotNull(message = "订单不能为空")
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
    @DecimalMin(value = "0.0",message = "总分不能小于0分")
    @DecimalMax(value = "5.0",message = "总分不能大于5分")
    @Digits(integer = 1, fraction = 1,message = "总分不合法,只能有一位小数")
    @Digits(integer = 1, fraction = 1)
    public Double totalScore;
    /**
     * 结果打分
     */
    @DecimalMin(value = "0.0",message = "结果分不能小于0分")
    @DecimalMax(value = "5.0",message = "结果分不能大于5分")
    @Digits(integer = 1, fraction = 1,message = "结果分数不合法,只能有一位小数")
    @Digits(integer = 1, fraction = 1)
    public Double resultScore;
    /**
     * 过程打分
     */
    @DecimalMin(value = "0.0",message = "过程分不能小于0分")
    @DecimalMax(value = "5.0",message = "过程分不能大于5分")
    @Digits(integer = 1, fraction = 1,message = "过程分数不合法,只能有一位小数")
    public Double processScore;
    /**
     * 推荐意向
     */
    @DecimalMin(value = "0.0",message = "推荐分不能小于0分")
    @DecimalMax(value = "5.0",message = "推荐分不能大于5分")
    @Digits(integer = 1, fraction = 1,message = "推荐分数不合法,只能有一位小数")
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
     * 订单详情信息
     */
    private OrderInfoDetailVO orderInfoDetail;
    /**
     * 岗位信息
     */
    private JobCateVO bdJobCate;
    /**
     * 评价标签信息
     */
    private List<BdJobTagVO> bdJobTags;
    /**
     * 附件信息
     */
    private List<AttachmentVO> images;
}
