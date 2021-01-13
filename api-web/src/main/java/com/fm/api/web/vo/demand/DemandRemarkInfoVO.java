package com.fm.api.web.vo.demand;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/12 11:04
 */
@Data
public class DemandRemarkInfoVO extends VO implements Serializable {
    private static final long serialVersionUID = -7227081610321915603L;

    /**
     * 需求主键
     */
    private Long demandId;

    /**
     * 备注信息
     */
    private String remarkInfo;

    /**
     * 是否下单
     */
    private transient Integer isOrder;

    /**
     * 下次联系时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date nextTime;

    /**
     * 跟进人
     */
    private String userName;

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
