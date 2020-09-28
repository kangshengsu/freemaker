/**
 * @filename:FreelancerInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model.freelancer;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fm.business.base.model.sys.SysUser;
import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(自由职业者信息实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class FreelancerInfo extends BaseModel implements Serializable,IAudit {

	private static final long serialVersionUID = 1600497555102L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 自由职业者编码
    **/
	private String code;


    /**
    * 自由职业者姓名
    **/
	private String name;

    /**
     * 头像
     */
    private String headImg;

    /**
    * 技能描述
    **/
	private String skillSummarize;


    /**
    * 语言
    **/
	private Integer language;


    /**
    * 所属领域
    **/
	private Long jobCateId;


    /**
    * 技能全路径
    **/
	private String cateTreeCode;


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
    * 关联账户(微信登录认证)
    **/
	private String accountCode;


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
     * 关联SysUser
     */
    private transient SysUser user;


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
