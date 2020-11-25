package com.fm.business.base.model.partner;

import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PartnerInfo extends BaseModel implements Serializable, IAudit {

    private static final long serialVersionUID = 1600497555102L;

    /**
     * 逻辑主键
     **/
    private Long id;

    /**
     * 自由职业者编码
     */
    private Long freelancerId;

    /**
     * 推荐人编码
     */
    private Long referrerId;

    /**
     * 所属合伙人编码
     */
    private Long belongId;

    /**
     * 分配人编码
     */
    private Long distributionId;

    /**
     * 结算人编码
     */
    private Long settlementId;

    /**
     * 结算状态（0-未结算，1-已结算）
     */
    private Integer settlementStatus;

    /**
     * 是否分配合伙人（0-否，1-是）
     */
    private Integer distributionStatus;

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

    private transient FreelancerInfo freelancerInfo;

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
