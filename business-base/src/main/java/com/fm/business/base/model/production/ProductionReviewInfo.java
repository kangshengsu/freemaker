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
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**   
 * @Description:(作品审核实体类)
 * 
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Data
public class ProductionReviewInfo extends BaseModel implements Serializable, IAudit {

	private static final long serialVersionUID = 1599831722595L;
	
    /**
    * 逻辑主键
    **/
	private Long id;


    /**
    * 作品编码
    **/
	private String productionCode;


    /**
    * 审核人
    **/
	private String reviewerCode;


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
	private String createUser;


    /**
    * 修改人
    **/
	private String updateUser;



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

    @Override
    public void setCreateTime(LocalDateTime createTime) {
        if(createTime == null){
            return;
        }
        this.createTime = Date.from(createTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public LocalDateTime getUpdateTime() {
        if(this.updateTime == null){
            return null;
        }
        return Instant.ofEpochMilli(this.updateTime.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public LocalDateTime getCreateTime(){
        if(this.createTime == null){
            return null;
        }
        return Instant.ofEpochMilli(this.createTime.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public void setUpdateTime(LocalDateTime updateTime) {
        if(updateTime == null){
            return;
        }
        this.updateTime = Date.from(updateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public String getCreateUserCode() {
        return this.createUser;
    }

    @Override
    public void setCreateUser(Long createUser) {
        this.createUser = String.valueOf(createUser);
    }

    @Override
    public Long getCreateUser() {
        if(this.createUser == null){
            return 0L;
        }
        return Long.valueOf(this.createUser);
    }

    @Override
    public void setCreateUserCode(String code) {

    }

    @Override
    public String getUpdateUserCode() {
        return createUser;
    }

    @Override
    public void setUpdateUser(Long updateUser) {
        this.updateUser = String.valueOf(updateUser);
    }

    @Override
    public Long getUpdateUser() {
        if(this.updateUser == null){
            return 0L;
        }
        return Long.valueOf(this.updateUser);
    }

    @Override
    public void setUpdateUserCode(String code) {

    }
}
