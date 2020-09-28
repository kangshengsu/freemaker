/**
 * @filename:BdJobCate 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.web.vo.job;

import com.fm.framework.core.model.ITreeNode;
import com.fm.framework.web.VO;
import lombok.Data;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**   
 * @岗位技能树节点VO
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class JobNodeVO implements ITreeNode, Serializable {
	private static final long serialVersionUID = 1599835185585L;

	private String label;

	private String code;

	private String treeCode;

	private String englishName;

	private String icon;

	private Integer cateType;

	private Long jobId;

	private Long parentId;

	private String parentCode;

	List<JobNodeVO> children;

	@Override
	public Long getNodeId() {
		return jobId;
	}

	@Override
	public String getParentCode() {
		return parentCode;
	}

	@Override
	public Long getParentId() {
		return parentId;
	}

	@Override
	public String getIncode() {
		return null;
	}

	@Override
	public void setIncode(String incode) {

	}
}
