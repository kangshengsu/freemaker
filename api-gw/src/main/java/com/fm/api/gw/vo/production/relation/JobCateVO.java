package com.fm.api.gw.vo.production.relation;

import com.fm.framework.web.VO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 领域岗位展示配置VO
 * @author clufeng
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class JobCateVO extends VO implements Serializable {

    private String cateName;

    private String englishName;

    private String icon;

    private Integer cateType;

}
