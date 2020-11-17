package com.fm.api.web.vo.evaluation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EvaluationReviewVo extends VO implements Serializable {
    private static final long serialVersionUID = -6106702215235039800L;

    /**
     * 作品编码
     **/
    private Long evaluationId;


    /**
     * 审核人
     **/
    private Long reviewerId;

    /**
     * 审核人名称
     */
    private String reviewerName;

    /**
     * 审核意见
     **/
    private String reviewerOpinion;


    /**
     * 状态（10-未审核，20-审核未通过，30-审核通过）
     **/
    private Integer status;

    /**
     * 状态名称
     */
    private String statusName;

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
}
