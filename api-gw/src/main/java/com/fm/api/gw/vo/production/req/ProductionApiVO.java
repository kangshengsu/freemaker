package com.fm.api.gw.vo.production.req;

import com.fm.api.gw.vo.production.relation.AttachmentVO;
import com.fm.framework.web.VO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author ：liuduo
 * @description：TODO
 * @date ：2020/9/22 22:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductionApiVO extends VO implements Serializable {

    private static final long serialVersionUID = 1600497555108L;

    public interface Release{ }

    public interface Modify{ }

    public interface DelStatusByCode{ }

    /**
     * 作品编码
     **/
    @NotNull(message = "作品ID不能为空",groups = {Modify.class})
    private Long id;


    /**
     * 作品编码
     **/
    @NotEmpty(message = "作品编码不能为空",groups = {DelStatusByCode.class})
    @Size( max = 50 , message = "作品编码不能超过50",groups = {DelStatusByCode.class})
    private String code;


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
     * 附件列表
     */
    @NotEmpty(message = "附件路径列表不能为空",groups = {Release.class, Modify.class})
    private List<AttachmentVO> attachmentInfos;


    /**
     * 创建 修改 时的 领域-岗位-技能数据
     */
    //作品可以没有技能类型，只有领域和岗位也ok
    @NotEmpty(message = "技能树列表不能为空",groups = {Release.class, Modify.class})
    private List<List<Long>> jobs;



}
