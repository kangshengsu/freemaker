package com.fm.api.web.vo.sm;

import com.fm.business.base.model.sm.Role;
import com.fm.framework.web.VO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * <p>类描述</p>
 *
 * @author hubo
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserTableVO extends VO {

    public static final String DEFAULT_AVATAR_HREF = "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png";

    /**
     * 员工编号
     */
    private String code;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 别名
     */
    private String aliasName;

    /**
     * 头像链接
     */
    private String avatarHref = DEFAULT_AVATAR_HREF;

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

    List<Role> roles;

    List<AccountVO> accounts;

    private Long tenantId;

    private String tenantCode;

    private String tenantName;


}
