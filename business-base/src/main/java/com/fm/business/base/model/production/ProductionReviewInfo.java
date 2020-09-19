/**
 * @filename:ProductionReviewInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model.production;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:(作品审核实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class ProductionReviewInfo extends BaseModel implements Serializable,IAudit {

	private static final long serialVersionUID = 1600497555102L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 作品编码
    **/
	private Long productionId;


    /**
    * 审核人
    **/
	private Long reviewerId;


    /**
    * 审核意见
    **/
	private String reviewerOpinion;


    /**
    * 状态（10-未审核，20-审核未通过，30-审核通过）
    **/
	private Integer status;


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
