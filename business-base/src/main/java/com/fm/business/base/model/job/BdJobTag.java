package com.fm.business.base.model.job;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:(岗位技能标签实体)
 * @version: V1.0
 * @author: kangshengsu
 */
@Data
public class BdJobTag extends BaseModel implements Serializable, IAudit {
    /**
     * 主键
     */
    public Long id;

    /**
     * 岗位分类id
     */
    public Long jobCateId;

    /**
     * 技能id
     */
    public Long skillId;

    /**
     * 标签主键
     */
    public String tagName;

    /**
     * 雇佣者id
     */
    public Long employerId;

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
