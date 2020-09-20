package com.fm.business.base.model.conf;

import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.model.IAudit;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 前台(小程序)默认展现配置实体
 * @author clufeng
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class DisplayConfig extends BaseModel implements IAudit {

    /**
     * ID
     */
    private Long id;

    /**
     * 展现配置编码
     */
    private String displayCode;

    /**
     * 展现配置类型
     */
    private Integer displayType;

    /**
     * 过期时间
     */
    private Date expiredTime;

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


}
