package com.fm.business.base.model.select;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/23 18:12
 */
@Data
public class SelectInfo extends BaseModel implements Serializable, IAudit {
    private static final long serialVersionUID = 5507272971105519273L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 是否推荐
     */
    private Integer isRecommend;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 是否火热
     */
    private Integer isHot;

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
