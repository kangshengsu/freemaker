package com.fm.api.gw.vo.production;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.framework.web.VO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    private String title;


    /**
     * 技能描述
     **/
    @NotBlank(message = "描述不能为空",groups = {Release.class, Modify.class})
    private String summarize;


    /**
     * 时薪
     **/
    @NotNull(message = "时薪不能为空",groups = {Release.class, Modify.class})
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
    private List<AttachmentInfoApiVO> attachmentInfos;

    /**
     * 附件路径
     * 返回时不序列化
     */
    @NotEmpty(message = "附件路径列表不能为空",groups = {Release.class, Modify.class})
    private List<String> attachmentInfoPaths;

    /**
     * 创建 修改 时的 领域-岗位-技能数据
     */
    @NotEmpty(message = "技能树列表不能为空",groups = {Release.class, Modify.class})
    private List<List<Long>> jobs;

}
