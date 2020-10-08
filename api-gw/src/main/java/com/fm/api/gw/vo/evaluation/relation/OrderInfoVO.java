package com.fm.api.gw.vo.evaluation.relation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangleqi
 * @date 2020/10/8
 */
@Data
public class OrderInfoVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555102L;

    /**
     * 逻辑主键
     **/
    private Long id;


    /**
     * 订单编码
     **/
    private String code;


    /**
     * 需求类型
     **/
    private Long jobCateId;

}
