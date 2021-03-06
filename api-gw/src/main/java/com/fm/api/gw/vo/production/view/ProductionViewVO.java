package com.fm.api.gw.vo.production.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.production.list.ProductionListVO;
import com.fm.api.gw.vo.production.relation.SkillRelationVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.framework.core.utils.JsonUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：liuduo
 * @description：TODO
 * @date ：2020/9/22 22:57
 */
@Data
public class ProductionViewVO extends ProductionListVO implements Serializable {

    private static final long serialVersionUID = 1600497555101L;

    /**
     * 作品编码
     **/
    private String code;

    /**
     * 描述
     **/
    private String summarize;

    /**
     * 状态（10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除）
     **/
    private Integer status;

    private String statusName;

    /**
     * 交付方式
     * @see com.fm.business.base.enums.DeliveryType
     */
    private Integer deliveryType;

    /**
     * 薪资计算方式
     * @see com.fm.business.base.enums.BudgetType
     */
    private Integer budgetType;

    /**
     * 交付方式名称
     */
    private  String deliveryTypeName;

    /**
     * 预算方式名称
     */
    private  String budgetTypeName;
    /**
     * 是否收藏
     */
    private transient Boolean isCollect;

    /**
     * 创建时间
     **/
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    private Long jobCateId;

    /**
     * 技能
     */
    private List<SkillRelationVO> skills;

    /**
     * 发布用户编码
     **/
    private Long freelancerId;

}
