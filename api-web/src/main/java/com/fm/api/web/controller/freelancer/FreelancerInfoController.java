/**
 * @filename:FreelancerInfoController 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.api.web.controller.freelancer;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.framework.core.query.Page;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.api.web.vo.freelancer.FreelancerInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * <p>说明： 自由职业者信息API接口层</p>
 * @version: V1.0
 * @author: LiuDuo
 * @time 2020年09月11日
 *
 */

@RestController
@RequestMapping("/freelancer/freelancerInfo")
public class FreelancerInfoController extends BaseController<FreelancerInfo, FreelancerInfoVO> {

    @Autowired
    private IFreelancerInfoService freelancerInfoService;


    /**
     * 根据名字和电话模糊查找数据最多返回10条
     * @param form
     * @return
     */
    @RequestMapping(value = "/findLikeNameOrPhone", method = RequestMethod.POST)
    public ApiResponse<List<FreelancerInfoVO>> findLikeNameOrPhone(@RequestBody FreelancerInfoVO form) {

        List<FreelancerInfo> freelancerInfos = freelancerInfoService.findLikeNameOrPhone(form.getKeyword());

        return success(convert(freelancerInfos));

    }

    /**
     * 根据推荐人Id或姓名查找数据
     * @param form
     * @return
     */
    @RequestMapping(value = "/findLikeNameOrUserId",method = RequestMethod.POST)
    public ApiResponse<List<FreelancerInfoVO>> findLikeNameOrUserId(@RequestBody FreelancerInfoVO form){
       List<FreelancerInfo> freelancerInfos = freelancerInfoService.findLikeNameOrUserId(form.getKeyword());
       return success(convert(freelancerInfos));

    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody FreelancerInfoVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody FreelancerInfoVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ApiResponse<Page<FreelancerInfoVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }

    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public ApiResponse<FreelancerInfoVO> list(@RequestBody FreelancerInfoVO form) {
        return success(convert(freelancerInfoService.get(form.getId())));
    }

    @RequestMapping(value = "/deleteByIds", method = RequestMethod.POST)
    public ApiResponse<Boolean> deleteByIds(@RequestBody FreelancerInfoVO form) {
        //转换批量ID
        if (CollectionUtils.isEmpty(form.getIds())) {
            return failed("无删除数据");
        }

        return success(service().delete(form.getIds().stream().map(id -> {
            FreelancerInfo freelancerInfo = new FreelancerInfo();
            freelancerInfo.setId(id);
            return freelancerInfo;
        }).collect(Collectors.toList())));

    }

    @RequestMapping(value = "getFreelancerName",method = RequestMethod.POST)
    public ApiResponse<List<FreelancerInfoVO>> getFreelancerName(@RequestBody FreelancerInfoVO form){
        List<FreelancerInfo> freelancerInfos =  freelancerInfoService.getFreelancerName(form.getReferrers());
        return success(convert(freelancerInfos));
    }


    @Override
    protected Service<FreelancerInfo> service() {
        return freelancerInfoService;
    }

}