package com.fm.business.base.model.rotation;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author G
 * @date 2020/12/25 下午2:06
 */
@Data
public class RotationInfo extends BaseModel implements Serializable, IAudit {

    private static final long serialVersionUID = 1600497555102L;

    /**
     * 逻辑主键
     **/
    private Long id;

    /**
     * 模版名称
     */
    private String name;

    /**
     * 角色
     */
    private String role;

    /**
     * 内容
     */
    private String content;

    /**
     * 金额
     */
    private String money;

    /**
     * 类型类型（10-需求/服务，20-支付，30-评价）
     */
    private Integer type;

    /**
     * 状态（10-启用，20-停用）
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
