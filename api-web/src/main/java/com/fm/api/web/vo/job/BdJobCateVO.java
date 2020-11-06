/**
 * @filename:BdJobCate 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo.job;

import com.fm.business.base.model.AttachmentInfo;
import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

/**   
 * @Description:(岗位请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class BdJobCateVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;
	

	private String keyword;

    /**
    * 
    **/
	private String cateName;


    /**
    * 
    **/
	private String cateCode;

	private String englishName;

	private String icon;


    /**
    * 
    **/
	private Integer cateType;


    /**
    * 
    **/
	private String treeCode;


    /**
    * 
    **/
	private Long parentId;


    /**
    * 
    **/
	private String parentCode;

	/**
	 * 附件列表
	 */
	private List<AttachmentInfo> attachmentInfos;

	/**
	 * 附件路径
	 */
	private List<String> attachmentInfoPaths;


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
