/**
 * @filename:FreelancerInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.gw.vo.freelancer;

import com.fm.api.gw.vo.user.UserApiVO;
import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import com.fm.framework.web.VO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
public class FreelancerInfoApiVO extends VO implements Serializable {

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


	private String headImg;


    /**
    * 技能描述
    **/
	@Size(max = 300,message = "技能描述不能太长",groups = {UserApiVO.UpdateAllInfo.class})
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
	 * 岗位全名称
	 **/
	private String cateTreeName;

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


}
