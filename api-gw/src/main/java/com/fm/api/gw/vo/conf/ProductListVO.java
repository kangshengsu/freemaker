package com.fm.api.gw.vo.conf;

import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.api.gw.vo.production.AttachmentInfoApiVO;
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
public class ProductListVO extends VO implements Serializable {

    /**
     *
     */
    private String name;

    /**
     * 时薪
     **/
    private BigDecimal hourlyWage;

    /**
     *
     */
    private JobCateDisplayVO domainCate;

    /**
     *
     */
    private JobCateDisplayVO postCate;

    /**
     *
     */
    private FreelancerInfoApiVO freelancerInfoApiVO;

    /**
     *
     */
    private List<AttachmentInfoApiVO> images;

}
