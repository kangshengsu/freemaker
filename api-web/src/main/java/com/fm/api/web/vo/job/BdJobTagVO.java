package com.fm.api.web.vo.job;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BdJobTagVO extends VO implements Serializable {
    /**
     * 主键
     */
    private Long id;
    private String tagName;

    /**
     * 岗位分类id
     */
    private Long jobCateId;
    private String jobCateName;

    /**
     * 技能id
     */
    private Long skillId;
    private String skillName;

    /**
     * 启用状态
     */
    private Integer status;
    private String statusName;

    /**
     * 雇佣者id
     */
    private Long employerId;

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
