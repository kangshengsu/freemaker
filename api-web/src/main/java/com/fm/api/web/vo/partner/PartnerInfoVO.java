package com.fm.api.web.vo.partner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PartnerInfoVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555102L;

    /**
     * 逻辑主键
     **/
    private String code;

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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


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
     * 自由职业者
     */
    private FreelancerInfo freelancerInfo;

    /**
     *服务作品状态
     */
    private Integer productionStatus;

}
