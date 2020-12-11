package com.fm.api.web.vo.workInfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.core.model.IAudit;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WorkInfoVO extends VO implements Serializable, IAudit {

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
     * 入职时间
     **/
    private Date startTime;

    /**
     * 离职时间
     **/
    private Date stopTime;

    /**
     * 公司名称
     **/
    private String companyName;

    /**
     * 部门
     */
    private String department;

    /**
     * 职位
     */
    private String position;

    /**
     * 工作内容
     */
    private String jobContent;

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
