package com.fm.api.gw.vo.user;

import com.fm.api.gw.vo.employer.EmployerInfoApiVO;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.framework.web.VO;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @program: freemaker-parent
 * @description: 用户个人信息实体
 * @author: liuduo8
 * @create: 2020-10-17 10:30
 **/
@Data
public class UserApiVO extends VO implements Serializable {

    public interface UpdateAllInfo{}

    /**
     * 名字
     **/
    @Size(max = 32 ,message = "名字不能太长",groups = {UpdateAllInfo.class})
    private String name;

    /**
     * 头像
     **/
    @Size(max = 250 ,message = "头像路径不能太长",groups = {UpdateAllInfo.class})
    private String headImg;


    /**
     * 省份编码
     **/
    @NotEmpty(message = "省份编码不能为空",groups = {UpdateAllInfo.class})
    @Size(max = 10 ,message = "省份编码不能太长",groups = {UpdateAllInfo.class})
    private String provinceCode;


    /**
     * 城市编码
     **/
    @NotEmpty(message = "城市编码不能为空",groups = {UpdateAllInfo.class})
    @Size(max = 10 ,message = "城市编码不能太长",groups = {UpdateAllInfo.class})
    private String cityCode;


    /**
     * 区编码
     **/
    @NotEmpty(message = "区编码不能为空",groups = {UpdateAllInfo.class})
    @Size(max = 10 ,message = "区编码不能太长",groups = {UpdateAllInfo.class})
    private String districtCode;


    /**
     * 县编码
     **/
    private String countyCode;


    /**
     * 自由职业者相关信息
     */
    @Valid
    private FreelancerInfoApiVO freelancerInfo;


    /**
     * 雇佣者相关信息
     */
    private EmployerInfoApiVO employerInfoApiVO;
}
