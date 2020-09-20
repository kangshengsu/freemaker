/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller;

import com.fm.api.gw.vo.ContactInfoAppVO;
import com.fm.api.gw.vo.FreelancerInfoAppVO;
import com.fm.api.gw.vo.FreelancerOrderSummaryVO;
import com.fm.api.gw.vo.JobCateVO;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.TreeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
*
* <p>说明： 用户信息接口层</p>
* @version: V1.0
* @author: kangshengsu
* @time    2020年09月20日
*
*/

@RestController
@RequestMapping("api/v1/freelancer")
@Api("自由职业者相关操作")
public class FreelancerController extends BaseController<FreelancerInfo, FreelancerInfoAppVO> {

    @Autowired
    private IFreelancerInfoService iFreelancerInfoService;

    @Autowired
    private IOrderInfoService iOrderInfoService;

    @RequestMapping(value = "contactInfo",method = RequestMethod.GET)
    @ApiOperation("获取联系方式")
    public ApiResponse<ContactInfoAppVO> contactInfo(@RequestParam(value="id") Long freelancerId) {
        if(freelancerId == null){
            throw new BusinessException("自由职业者信息有误");
        }
        FreelancerInfo freelancerInfo = iFreelancerInfoService.get(freelancerId);
        if(freelancerInfo == null){
            throw new BusinessException("自由职业者信息有误");
        }
        ContactInfoAppVO contactInfoAppVO = new ContactInfoAppVO();
        contactInfoAppVO.setPhone(freelancerInfo.getPhone());
        return ApiResponse.ofSuccess(contactInfoAppVO);
    }

    @RequestMapping(value = "income",method = RequestMethod.GET)
    @ApiOperation("获取总收入")
    public ApiResponse<FreelancerOrderSummaryVO> income(@RequestParam(value="id") Long freelancerId) {
        List<OrderInfo> orderInfos = iOrderInfoService.queryFinishedOrderByFreelancer(freelancerId);
        FreelancerOrderSummaryVO summaryVO = new FreelancerOrderSummaryVO();
        if(CollectionUtils.isEmpty(orderInfos)){
            summaryVO.setTotalIncome(0.0d);
        }
        summaryVO.setTotalIncome(orderInfos.stream().mapToDouble(OrderInfo::getOrderMny).sum());
        return ApiResponse.ofSuccess(summaryVO);
    }

    @Override
    protected Service<FreelancerInfo> service() {
        return iFreelancerInfoService;
    }


}
