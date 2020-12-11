package com.fm.business.base.model.educationInfo;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProfessionNameInfo extends BaseModel implements Serializable, IAudit {

    private static final long serialVersionUID = 1600497555102L;

    private Long id;

    private String professional;

    private String name;

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

    @Override
    public Date getCreateTime() {
        return null;
    }

    @Override
    public void setCreateTime(Date createTime) {

    }

    @Override
    public Date getUpdateTime() {
        return null;
    }

    @Override
    public void setUpdateTime(Date updateTime) {

    }

    @Override
    public Long getCreateUser() {
        return null;
    }

    @Override
    public void setCreateUser(Long createUser) {

    }

    @Override
    public Long getUpdateUser() {
        return null;
    }

    @Override
    public void setUpdateUser(Long updateUser) {

    }
}
