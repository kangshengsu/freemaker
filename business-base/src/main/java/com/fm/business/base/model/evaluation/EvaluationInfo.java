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
}
