/**
 * @filename:OrderInfoDetail 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.gw.vo.evaluation.relation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:(订单详情请求实体类)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Data
public class OrderInfoDetailVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555102L;

    /**
    * 订单码
    **/
	private Long orderId;


    /**
    * 订单概括
    **/
	private String summarize;


    /**
    * 订单详细描述
    **/
	private String description;

}
