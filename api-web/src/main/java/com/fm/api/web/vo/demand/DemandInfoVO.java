/**
 * @filename:DemandInfo 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.web.vo.demand;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:(需求请求实体类)
 * @version: V1.0
 * @author: LiuDuo
 */
@Data
public class DemandInfoVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555102L;


    /**
     * 需求编码
     **/
    private String code;

    /**
     * 类型
     */
    private Integer demandType;

    /**
     * 发布用户编码
     **/
    private Long employerId;


    /**
     * 需求状态（10-未发布，20-已发布，30-已取消，40-已停用）
     **/
    private Integer status;

    /**
     * 需求状态（10-未发布，20-已发布，30-已取消，40-已停用））
     **/
    private String statusName;

    /**
     * 交付方式名称
     */
    private String deliveryTypeName;

    /**
     * 预算方式名称
     */
    private String budgetTypeName;
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date expectDeliveryTime;


    /**
     * 预算
     **/
    private Double budget;

    /**
     * 平台认证:0-未认证,1-认证
     */
    private Integer attestation;

    /**
     * 通过枚举后返回前端
     */
    private String attestationName;

    /**
     * 是否下单:10-已下单，20-未下单
     */
    private Integer isOrder;

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
     * 岗位要求（悬赏）
     */
    private String jobRequire;

    /**
     * 交付方式
     *
     * @see com.fm.business.base.enums.DeliveryType
     */
    private Integer deliveryType;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 预算计算方式
     *
     * @see com.fm.business.base.enums.BudgetType
     */
    private Integer budgetType;

    /**
     * 需求备注信息
     */
    private String remarkInfo;

    /**
     * 下次联系时间
     */
    private Date nextTime;

    /**
     *薪资范围
     */
    private String salaryRange;

    /**
     * 学历要求
     */
    private String educationRequire;

    /**
     * 工作经验
     */
    private String workExperience;

    /**
     * 年龄要求
     */
    private String ageRequire;

    /**
     * 推荐奖励
     */
    private Double recommendAward;

    /**
     * 招聘人数
     */
    private Integer recruitAmount;

    /**
     * 总金额
     */
    private Double sumMoney;


    /**
     * 创建时间
     **/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


    /**
     * 修改时间
     **/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
     * 发布者信息
     */
    private EmployerInfo employerInfo;

    /**
     * 需求名称
     */
    private BdJobCate bdJobCate;


}
