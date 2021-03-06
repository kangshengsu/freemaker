package com.fm.business.base.model.evaluation;

import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobTag;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description:(评价信息实体)
 * @version: V1.0
 * @author: kangshengsu
 */
@Data
public class EvaluationInfo extends BaseModel implements Serializable, IAudit {
    /**
     * 主键
     */
    public Long id;

    /**
     * 订单主键
     */
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
    public String totalScore;
    /**
     * 响应速度
     */
    public String responseSpeed;
    /**
     * 沟通能力
     */
    public String communicateCapacity;
    /**
     * 完成时间
     */
    public String completionTime;
    /**
     * 完成质量
     */
    public String accomplishQuality;
    /**
     * 推荐意向
     */
    public String recommendScore;
    /**
     * 评价描述
     */
    public String description;
    /**
     * 评价审核状态
     */
    public Integer status;
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


    private transient FreelancerInfo freelancerInfo;

    private transient EmployerInfo employerInfo;

    private transient OrderInfoDetail orderInfoDetail;

    private transient BdJobCate bdJobCate;

    private transient List<BdJobTag> bdJobTags;


    private transient List<AttachmentInfo> attachmentInfos;

}
