package com.fm.api.web.vo.advert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author G
 * @date 2020/12/24 下午2:07
 */
@Data
public class AdvertInfoVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555102L;

    /**
     * 逻辑主键
     **/
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 应用场景
     */
    private String scene;

    /**
     * 可见角色
     */
    private String role;

    /**
     *状态（10-启用，20-停用）
     */
    private Integer status;

    /**
     * 上线时间
     */
    private Date upTime;

    /**
     * 下线时间
     */
    private Date downTime;

    /**
     * 存放路径
     **/
    private String path;

    /**
     * 其他路径（图片时存放压缩图片）
     **/
    private String otherPath;

    /**
     * url
     */
    private String url;

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
