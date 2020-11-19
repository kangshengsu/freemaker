/**
 * @filename:SysUser 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model.sys;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
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
     * 头像
     **/
    private String avatarUrl;

    /**
     * 用户的小程序openId
     */
//    private String openId;

    /**
     * 自由职业者
     */
    private transient FreelancerInfo freelancerInfo;

    /**
     * 雇佣者
     */
    private transient EmployerInfo employerInfo;

    /**
     * 推荐人
     * todo 由于目前设定的CRUD模板，只能传数据库实体，因此在SysUser上扩展参数，并标注非数据库字段
     * todo 仅从controller层到service传参使用，为构造Freelancer数据，可根据现有权限模型调整
     */
    @TableField(exist = false)
    private Long scene;

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
