package com.fm.api.gw.vo.production.list;

import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.production.relation.AttachmentVO;
import com.fm.api.gw.vo.production.relation.JobCateVO;
import com.fm.framework.web.VO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 作品展现配置
 * @author clufeng
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductionListVO extends VO implements Serializable {

    /**
     * 标题
     */
    private String title;

    /**
     * 时薪
     **/
    private BigDecimal hourlyWage;

    /**
     * 领域
     */
    private JobCateVO domainCate;

    /**
     * 岗位
     */
    private JobCateVO postCate;

    /**
     * 作者信息
     */
    private FreelancerInfoApiVO freelancerInfo;

    /**
     * 展示图片信息
     */
    private List<AttachmentVO> images;

}
