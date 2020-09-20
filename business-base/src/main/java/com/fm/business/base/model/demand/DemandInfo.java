/**
 * @filename:DemandInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.model.demand;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description:(需求实体类)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Data
public class DemandInfo extends BaseModel implements Serializable,IAudit {

	private static final long serialVersionUID = 1600497555102L;

    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 需求编码
    **/
	private String code;


    /**
    * 发布用户编码
    **/
	private Long employerId;


    /**
    * 需求状态（10-未发布，20-已发布，30-已取消，40-已下单）
    **/
	private Integer status;


    /**
    * 需求类型
    **/
	private Long jobCateId;


    /**
    * 需求类型
    **/
	private String cateTreeCode;


    /**
    * 期望交付时间
    **/
	private Date expectDeliveryTime;


    /**
    * 预算
    **/
	private Double budget;


    /**
    * 推荐人数
    **/
	private Integer recommendCount;


    /**
    * 需求省份编码
    **/
	private String provinceCode;


    /**
    * 需求城市编码
    **/
	private String cityCode;


    /**
    * 需求区编码
    **/
	private String districtCode;


    /**
    * 需求县编码
    **/
	private String countyCode;


    /**
    * 需求概括
    **/
	private String summarize;


    /**
    * 需求详细描述
    **/
	private String description;


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
