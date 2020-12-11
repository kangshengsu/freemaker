package com.fm.api.web.vo.educationInfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.core.model.IAudit;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EducationInfoVO extends VO implements Serializable, IAudit {

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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


    /**
     * 修改时间
     **/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
