/**
 * @filename:FreelancerInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo.freelancer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**   
 * @Description:(自由职业者信息请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class FreelancerInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;

	private List<Long> ids;

	private List<Long> referrers;

	private String keyword;

    /**
    * 自由职业者编码
    **/
	private String code;

	/**
	 * 用户id
	 */
	private Long userId;

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
	 * 推荐码
	 */
	private String referralCode;

	/**
	 * 推荐人
	 */
	private Long referrer;

	/**
	 * 推荐人昵称
	 */
	private transient String referrerName;


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








}
