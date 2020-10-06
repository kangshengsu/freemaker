package com.fm.business.base.model.evaluation;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:(评价印象标签实体)
 * @version: V1.0
 * @author: kangshengsu
 */
@Data
public class EvaluationInfoTag extends BaseModel implements Serializable, IAudit {
    /**
     * 主键
     */
    public Long id;

    /**
     * 评价信息主键
     */
    public Long evaluationInfoId;

    /**
     * 标签主键
     */
    public Long tagId;

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
