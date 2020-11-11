package com.fm.api.web.vo.sm;

import com.fm.framework.web.VO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserFormVO extends VO {

    /**
     * 员工编号
     */
    private String code;

    private String oldCode;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 头像链接
     */
    private String avatarHref;

    /**
     * 组织ID
     */
    private Long orgId;

    private String orgCode;

    private String orgName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String memo;

    List<Long> roles;

    /**
     * 时间戳
     */
    private LocalDateTime ts;

    AccountVO account;


}
