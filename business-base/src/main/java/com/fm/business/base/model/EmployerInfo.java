/**
 * @filename:EmployerInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(雇佣者信息实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class EmployerInfo extends BaseModel implements Serializable,IAudit {

	private static final long serialVersionUID = 1600497555102L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 雇佣者编码
    **/
	private String code;


    /**
    * 雇佣者姓名
    **/
	private String name;


    /**
    * 关联账户(微信登录认证)
    **/
	private String accountCode;


    /**
    * 省份编码
    **/
	private String provinceCode;


    /**
    * 城市编码
    **/
	private String cityCode;


    /**
    * 区编码
    **/
	private String districtCode;


    /**
    * 县编码
    **/
	private String countyCode;


    /**
    * 手机号
    **/
	private String phone;


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


    /**
     * 关联SysUser的ID
     **/
    private Long userId;




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
