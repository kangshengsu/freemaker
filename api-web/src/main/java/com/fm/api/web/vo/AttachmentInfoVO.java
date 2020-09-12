/**
 * @filename:AttachmentInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo;

import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(附件请求实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class AttachmentInfoVO extends VO implements Serializable {

	private static final long serialVersionUID = 1599835185585L;
	


    /**
    * 附件所属业务类型（10-需求,20-作品,30-订单）
    **/
	private Integer businessType;


    /**
    * 附件所属业务编码
    **/
	private String businessCode;


    /**
    * 附件类型（1-图片,2-视频）
    **/
	private Integer type;


    /**
    * 附件名称
    **/
	private String name;


    /**
    * 存放路径
    **/
	private String path;


    /**
    * 其他路径（图片时存放压缩图片）
    **/
	private String otherPath;


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
	private String createUser;


    /**
    * 修改人
    **/
	private String updateUser;








}
