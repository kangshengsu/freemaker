/**
 * @filename:SysUser 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model.sys;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fm.framework.core.model.BaseModel;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(用户实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class SysUser extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1600497555102L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 编码 openID
    **/
	private String code;


    /**
    * 名字
    **/
	private String name;


    /**
    * 
    **/
	private String password;


    /**
    * 
    **/
	private String phone;


    /**
    * 最近登录时间
    **/
	private Date lastLoginTime;


    /**
    * 创建时间
    **/
	private Date createTime;


    private Date updateTime;

    private String createUser;


    private String updateUser;

    /**
     * 用户的小程序openId
     */
//    private String openId;

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
