/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller;

import com.fm.api.gw.vo.ContactInfoAppVO;
import com.fm.api.gw.vo.FreelancerOrderSummaryVO;
import com.fm.api.gw.vo.freelancer.FreelancerInfoApiVO;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("v1/freelancer")
@Api("自由职业者相关操作")
public class FreelancerApi extends BaseController<FreelancerInfo, FreelancerInfoApiVO> {

    @Autowired
    private IFreelancerInfoService iFreelancerInfoService;

    @Autowired
    private IOrderInfoService iOrderInfoService;

    @Autowired
    private IProductionInfoService iProductionInfoService;

    @RequestMapping(value = "contactInfo",method = RequestMethod.GET)
    @ApiOperation("获取联系方式")
    public ApiResponse<ContactInfoAppVO> contactInfo() {
        ContactInfoAppVO contactInfoAppVO = getContactInfoAppVO(Context.getCurrUserId());
        return ApiResponse.ofSuccess(contactInfoAppVO);
    }

    private ContactInfoAppVO getContactInfoAppVO(Long id) {
        FreelancerInfo freelancerInfo = iFreelancerInfoService.getByUserId(id);
        if(freelancerInfo == null){
            throw new BusinessException("自由职业者信息有误");
        }
        ContactInfoAppVO contactInfoAppVO = new ContactInfoAppVO();
        contactInfoAppVO.setPhone(freelancerInfo.getPhone());
        contactInfoAppVO.setWxCode(StringUtils.isEmpty(freelancerInfo.getAccountCode())?"":freelancerInfo.getAccountCode());
        return contactInfoAppVO;
    }


    @RequestMapping(value = "order/contactInfo",method = RequestMethod.GET)
    @ApiOperation("获取联系方式")
    public ApiResponse<ContactInfoAppVO> contactInfoByOrderId(Long orderId) {
        OrderInfo orderInfo = iOrderInfoService.get(orderId);
        ContactInfoAppVO contactInfoAppVO = getContactInfoAppVO(orderInfo.getFreelancerId());
        return ApiResponse.ofSuccess(contactInfoAppVO);
    }

    @RequestMapping(value = "production/contactInfo",method = RequestMethod.GET)
    @ApiOperation("获取联系方式")
    public ApiResponse<ContactInfoAppVO> contactInfoByProductionId(Long productionId) {
        ProductionInfo productionInfo = iProductionInfoService.get(productionId);
        ContactInfoAppVO contactInfoAppVO = getContactInfoAppVO(productionInfo.getFreelancerId());
        return ApiResponse.ofSuccess(contactInfoAppVO);
    }

    @RequestMapping(value = "income",method = RequestMethod.GET)
    @ApiOperation("获取总收入")
    public ApiResponse<FreelancerOrderSummaryVO> income() {
        FreelancerInfo freelancerInfo = iFreelancerInfoService.getByUserId(Context.getCurrUserId());
        if(freelancerInfo == null){
            throw new BusinessException("自由职业者信息有误");
        }

        List<OrderInfo> orderInfos = iOrderInfoService.queryFinishedOrderByFreelancer(freelancerInfo.getId());
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
