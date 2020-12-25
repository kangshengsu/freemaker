package com.fm.api.web.vo.rotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author G
 * @date 2020/12/25 下午2:06
 */
@Data
public class RotationInfoVO extends VO implements Serializable {

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

    /**
     * 修改人名字
     **/
    private String updateUserName;
}
