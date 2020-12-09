package com.fm.api.gw.vo.resume;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/9 10:09
 */
@Data
public class ResumeAttachmentVO extends VO implements Serializable {
    private static final long serialVersionUID = -451466587661483252L;

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
     * 简历名称
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
     * 路径
     */
    private String path;

    /**
     * 预览路径
     */
    private String otherPath;
}
