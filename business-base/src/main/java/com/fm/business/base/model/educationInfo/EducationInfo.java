package com.fm.business.base.model.educationInfo;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EducationInfo extends BaseModel implements Serializable, IAudit {

    private static final long serialVersionUID = 1600497555102L;

    /**
     * 逻辑主键
     **/
    private Long id;

    /**
     * 自由职业者Id
     **/
    private Long freelancerId;

    /**
     * 入学时间
     **/
    private Date startTime;

    /**
     * 毕业时间
     **/
    private Date stopTime;

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 学历
     */
    private Integer education;

    /**
     * 学位
     */
    private Integer degree;

    /**
     * 专业
     */
    private String speciality;


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
