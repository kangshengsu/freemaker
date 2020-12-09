package com.fm.business.base.model.resume;

import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/2 15:05
 */
@Data
public class ResumeAttachmentInfo  extends BaseModel implements Serializable, IAudit {
    private static final long serialVersionUID = -8998875629259973L;
    /**
     * 逻辑主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 人才主键
     */
    private Long freelancerId;

    /**
     *简历名称
     */
    private String name;

    /**
     * 简历格式
     */
    private String resumeType;

    /**
     * 简历所属岗位
     */
    private Long jobCateId;

    /**
     * 简历路径
     */
    private String path;

    /**
     * 是否代发服务(10-代发 20-不代发)
     */
    private Long isReplace;

    /**
     * 是否发布过服务
     */
    private transient Integer isProduction;

    /**
     * 人才信息
     */
    private transient FreelancerInfo freelancerInfo;

    /**
     * 所属岗位
     */
    private transient String bdJobCateName;

    /**
     * 预览路径
     */
    private String otherPath;

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
