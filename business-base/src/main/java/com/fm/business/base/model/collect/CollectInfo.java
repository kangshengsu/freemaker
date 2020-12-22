package com.fm.business.base.model.collect;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.util.Date;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/21 18:37
 */
@Data
public class CollectInfo extends BaseModel implements IAudit {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 收藏信息
     */
    private Long collect;

    /**
     * 收藏类型
     */
    private Long collectType;

    /**
     * 收藏状态
     */
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
