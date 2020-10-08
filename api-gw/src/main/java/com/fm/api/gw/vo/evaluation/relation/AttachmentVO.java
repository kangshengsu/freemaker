/**
 * @filename:AttachmentInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.gw.vo.evaluation.relation;

import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:(附件实体类)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Data
public class AttachmentVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;


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
	 * 存放路径
	 **/
	private String fullPath;


	/**
	 * 其他路径（图片时存放压缩图片）
	 **/
	private String fullOtherPath;
}
