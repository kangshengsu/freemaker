package com.fm.api.gw.vo.production;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.framework.core.utils.JsonUtil;
import com.fm.framework.web.VO;
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
public class ProductionApiVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555108L;

    public interface Release{ }

    public interface Modify{ }

    public interface DelStatusByCode{ }

    /**
     * 作品编码
     **/
    @NotEmpty(message = "作品编码不能为空",groups = {DelStatusByCode.class})
    @Size( max = 50 , message = "作品编码不能超过50",groups = {DelStatusByCode.class})
    private String code;


    /**
     * 发布用户编码
     **/
    private Long freelancerId;

    /**
     * 自由职业者
     */
    private FreelancerInfoApiVO freelancerInfo;

    /**
     * 作品标题
     **/
    @NotBlank(message = "作品标题不能为空",groups = {Release.class, Modify.class})
    @Size( max = 50 , message = "作品标题不能超过50字",groups = {Release.class, Modify.class})
    private String title;


    /**
     * 技能描述
     **/
    @NotBlank(message = "描述不能为空",groups = {Release.class, Modify.class})
    @Size( max = 300 , message = "技能描述不能超过300字",groups = {Release.class, Modify.class})
    private String summarize;


    /**
     * 时薪
     **/
    @NotNull(message = "时薪不能为空",groups = {Release.class, Modify.class})
    @Max(value = 99999,message = "超过时薪最大值",groups = {Release.class, Modify.class})
    private BigDecimal hourlyWage;


    /**
     * 状态（10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除）
     **/
    private Integer status;

    /**
     * 状态（10-未发布，20-审核中，30-审核未通过，40-已发布,50-已删除）
     **/
    private String statusName;

    /**
     * 所属岗位
     **/
    private Long jobCateId;

    /**
     * 所属岗位名称
     **/
    private String jobCateName;

    /**
     * 创建时间
     **/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 附件列表
     */
    @NotEmpty(message = "附件路径列表不能为空",groups = {Release.class, Modify.class})
    private List<AttachmentInfoApiVO> attachmentInfos;

    /**
     * 创建 修改 时的 领域-岗位-技能数据
     */
    @NotEmpty(message = "技能树列表不能为空",groups = {Release.class, Modify.class})
    private List<List<Long>> jobs;


    public static ProductionApiVO convert(ProductionInfo model) {
        ProductionApiVO form = new ProductionApiVO();
        BeanUtils.copyProperties(model,form);
        //转换枚举值
        form.setStatusName(ProductionStatus.get(model.getStatus()).getName());
        //岗位名称
        BdJobCate bdJobCate = model.getPostCate();
        if (bdJobCate != null) {
            form.setJobCateName(bdJobCate.getCateName());
        }
        //技能标签 树路径
        if(!CollectionUtils.isEmpty(model.getProductionSkillRelations())){
            form.setJobs(model.getProductionSkillRelations().stream().map(productionSkillRelation ->
                    JsonUtil.string2Obj(productionSkillRelation.getSkillTreePath(),new TypeReference<List<Long>>(){}))
                    .collect(Collectors.toList()));
        }
        //附件列表
        if(!CollectionUtils.isEmpty(model.getAttachmentInfos())){
            form.setAttachmentInfos(model.getAttachmentInfos().stream().map(attachmentInfo ->{
                AttachmentInfoApiVO attachmentInfoApiVO = new AttachmentInfoApiVO();
                BeanUtils.copyProperties(attachmentInfo,attachmentInfoApiVO);
                return attachmentInfoApiVO;
            }).collect(Collectors.toList()));
        }
        //作者 自由职业者
        if(model.getFreelancerInfo()!=null){
            FreelancerInfoApiVO freelancerInfoApiVO = new FreelancerInfoApiVO();
            BeanUtils.copyProperties(model.getFreelancerInfo(),freelancerInfoApiVO);
            form.setFreelancerInfo(freelancerInfoApiVO);
        }

        return form;
    }

}
