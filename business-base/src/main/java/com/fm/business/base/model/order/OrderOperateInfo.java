/**
 * @filename:OrderInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.model.order;

import com.fm.business.base.model.AttachmentInfo;
import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**   
 * @Description:(订单操作信息实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class OrderOperateInfo extends BaseModel implements Serializable,IAudit {

	private static final long serialVersionUID = 1600497555102L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
     * 订单编码
     **/
    private Long orderId;

    /**
     * 操作类型
     **/
    private Integer operateType;

    /**
     * 操作人
     **/
    private Long operateUser;
    private transient String operateUserName;


    /**
     * 接收人
     **/
    private Long receiveUser;

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
     * 操作描述
     */
	private String description;

    /**
     * 附件
     */
	private transient List<AttachmentInfo> attachmentInfos;

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
