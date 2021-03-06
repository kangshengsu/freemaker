package com.fm.api.web.vo.evaluation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.api.web.vo.freelancer.FreelancerInfoVO;
import com.fm.api.web.vo.order.OrderInfoDetailVO;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobTag;
import com.fm.framework.web.VO;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
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
     * 作品主键
     */
    private Long productionId;

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
    @DecimalMin(value = "0.00",message = "总分不能小于0分")
    @DecimalMax(value = "5.00",message = "总分不能大于5分")
    @Digits(integer = 1, fraction = 2,message = "总分不合法,只能有两位小数")
    @Digits(integer = 1, fraction = 2)
    public String totalScore;
    /**
     * 响应速度
     */
    @DecimalMin(value = "0.00",message = "结果分不能小于0分")
    @DecimalMax(value = "5.00",message = "结果分不能大于5分")
    @Digits(integer = 1, fraction = 2,message = "响应速度分数不合法,只能有两位小数")
    @Digits(integer = 1, fraction = 2)
    public String responseSpeed;
    /**
     * 沟通能力
     */
    @DecimalMin(value = "0.00",message = "过程分不能小于0分")
    @DecimalMax(value = "5.00",message = "过程分不能大于5分")
    @Digits(integer = 1, fraction = 2,message = "沟通能力分数不合法,只能有两位小数")
    public String communicateCapacity;
    /**
     * 完成时间
     */
    @DecimalMin(value = "0.00",message = "过程分不能小于0分")
    @DecimalMax(value = "5.00",message = "过程分不能大于5分")
    @Digits(integer = 1, fraction = 2,message = "完成时间分数不合法,只能有两位小数")
    public String completionTime;
    /**
     * 完成质量
     */
    @DecimalMin(value = "0.00",message = "过程分不能小于0分")
    @DecimalMax(value = "5.00",message = "过程分不能大于5分")
    @Digits(integer = 1, fraction = 2,message = "完成质量分数不合法,只能有两位小数")
    public String accomplishQuality;
    /**
     * 推荐意向
     */
    @DecimalMin(value = "0.00",message = "推荐分不能小于0分")
    @DecimalMax(value = "5.00",message = "推荐分不能大于5分")
    @Digits(integer = 1, fraction = 2,message = "推荐意愿分数不合法,只能有两位小数")
    public String recommendScore;
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
     * 被评价人信息
     */
    private FreelancerInfoVO freelancerInfo;
    /**
     * 评价人信息
     */
    private EmployerInfo employerInfo;
    /**
     * 订单详情信息
     */
    private OrderInfoDetailVO orderInfoDetail;
    /**
     * 岗位信息
     */
    private BdJobCate bdJobCate;
    /**
     * 评价标签信息
     */
    private List<BdJobTag> bdJobTags;
    /**
     * 附件信息
     */
    private List<AttachmentInfo> images;

    /**
     * 评价审核状态（10-审核中  20-审核未通过，30审核通过）
     */
    private String evaluationStatusName;

    /**
     * 订单概括
     **/
    private String summarize;

    /**
     * 评价审核状态
     */
    private Integer status;
}

