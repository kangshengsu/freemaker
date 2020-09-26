/**
 * @filename:ProductionSkillRelation 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.api.gw.vo.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fm.business.base.model.job.BdJobSkill;
import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import com.fm.framework.web.VO;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(作品技能关系VO)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class ProductionSkillRelationApiVO extends VO implements Serializable {

	private static final long serialVersionUID = 1600497555102L;

    /**
    * 技能编码
    **/
	private Long jobSkillId;

    /**
     * 技能树完整路径ID数组格式
     */
	private String skillTreePath;

    /**
     * 技能名称 别去技能对象了容易在关联岗位又多拉的好多数据
     */
    @TableField(exist = false)
    private String jobSkillName;


}
