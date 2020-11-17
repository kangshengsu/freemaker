package com.fm.business.base.model.evaluation;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EvaluationReviewInfo extends BaseModel implements Serializable, IAudit {
    private static final long serialVersionUID = -3387788732651604791L;

    /**
     * 逻辑主键
     **/
    private Long id;


    /**
     * 评价id
     **/
    private Long evaluationId;


    /**
     * 审核人
     **/
    private Long reviewerId;


    /**
     * 审核意见
     **/
    private String reviewerOpinion;


    /**
     * 状态（10-未审核，20-审核未通过，30-审核通过）
     **/
    private Integer status;


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

}
