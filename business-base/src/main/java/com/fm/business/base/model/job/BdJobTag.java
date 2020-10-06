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
    private Long id;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 岗位分类id
     */
    private Long jobCateId;

    /**
     * 技能id
     */
    private Long skillId;

    /**
     * 启用状态
     */
    private Integer status;

    /**
     * 雇佣者id
     */
    private Long employerId;

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
