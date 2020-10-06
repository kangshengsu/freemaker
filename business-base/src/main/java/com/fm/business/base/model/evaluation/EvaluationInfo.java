package com.fm.business.base.model.evaluation;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
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
