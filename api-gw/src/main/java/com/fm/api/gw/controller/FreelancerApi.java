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
import com.fm.api.gw.vo.freelancer.MyRecordVo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.wx.message.impl.WxMessageSenderService;
import com.fm.framework.core.Context;
import com.fm.framework.core.cos.CosProperties;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.core.service.FileService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import com.qcloud.cos.COSClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>说明： 用户信息接口层</p>
 *
 * @version: V1.0
 * @author: kangshengsu
 * @time 2020年09月20日
 */

@RestController
@RequestMapping("v1/freelancer")
@Api("自由职业者相关操作")
@Slf4j
public class FreelancerApi extends BaseController<FreelancerInfo, FreelancerInfoApiVO> {

    @Autowired
    private IFreelancerInfoService iFreelancerInfoService;

    @Autowired
    private IOrderInfoService iOrderInfoService;

    @Autowired
    private IProductionInfoService iProductionInfoService;

    @Autowired
    private IFreelancerInfoService freelancerInfoService;

    @RequestMapping(value = "contactInfo", method = RequestMethod.GET)
    @ApiOperation("获取联系方式")
    public ApiResponse<ContactInfoAppVO> contactInfo() {
        ContactInfoAppVO contactInfoAppVO = getContactInfoAppVO(Context.getCurrUserId());
        return ApiResponse.ofSuccess(contactInfoAppVO);
    }

    private ContactInfoAppVO getContactInfoAppVO(Long id) {
        FreelancerInfo freelancerInfo = iFreelancerInfoService.getByUserId(id);
        if (freelancerInfo == null) {
            throw new BusinessException("自由职业者信息有误");
        }
        ContactInfoAppVO contactInfoAppVO = new ContactInfoAppVO();
        contactInfoAppVO.setPhone(freelancerInfo.getPhone());
        contactInfoAppVO.setWxCode(StringUtils.isEmpty(freelancerInfo.getAccountCode()) ? "" : freelancerInfo.getAccountCode());
        return contactInfoAppVO;
    }


    @RequestMapping(value = "order/contactInfo", method = RequestMethod.GET)
    @ApiOperation("获取联系方式")
    public ApiResponse<ContactInfoAppVO> contactInfoByOrderId(Long orderId) {
        OrderInfo orderInfo = iOrderInfoService.get(orderId);
        ContactInfoAppVO contactInfoAppVO = getContactInfoAppVO(orderInfo.getFreelancerId());
        return ApiResponse.ofSuccess(contactInfoAppVO);
    }

    @RequestMapping(value = "production/contactInfo", method = RequestMethod.GET)
    @ApiOperation("获取联系方式")
    public ApiResponse<ContactInfoAppVO> contactInfoByProductionId(Long productionId) {
        ProductionInfo productionInfo = iProductionInfoService.get(productionId);
        ContactInfoAppVO contactInfoAppVO = getContactInfoAppVO(productionInfo.getFreelancerId());
        return ApiResponse.ofSuccess(contactInfoAppVO);
    }

    @RequestMapping(value = "income", method = RequestMethod.GET)
    @ApiOperation("获取总收入")
    public ApiResponse<FreelancerOrderSummaryVO> income() {
        FreelancerInfo freelancerInfo = iFreelancerInfoService.getByUserId(Context.getCurrUserId());
        if (freelancerInfo == null) {
            throw new BusinessException("自由职业者信息有误");
        }

        List<OrderInfo> orderInfos = iOrderInfoService.queryFinishedOrderByFreelancer(freelancerInfo.getId());
        FreelancerOrderSummaryVO summaryVO = new FreelancerOrderSummaryVO();
        if (CollectionUtils.isEmpty(orderInfos)) {
            summaryVO.setTotalIncome(0.0d);
        }
        summaryVO.setTotalIncome(orderInfos.stream().mapToDouble(OrderInfo::getOrderMny).sum());
        return ApiResponse.ofSuccess(summaryVO);
    }

    /**
     * 生成个人小程序码，作为推荐码返回
     *
     * @return
     */
    @RequestMapping(value = "referralCode", method = RequestMethod.GET)
    @ApiOperation("生成小程序码")
    public ApiResponse<String> referralCode() {
        return ApiResponse.ofSuccess(freelancerInfoService.createReferralCode());
    }

    @RequestMapping(value = "myRecord",method = RequestMethod.GET)
    @ApiOperation("海报我的战绩")
    public ApiResponse<MyRecordVo> myRecord(){
        Long currUserId = Context.getCurrUserId();
        /*获得推荐的人数*/
       Long recommended =  freelancerInfoService.getRecommended(currUserId);
       /*获得推荐后入驻人数*/
       Long publishProduction =  freelancerInfoService.getPublishProduction(currUserId);
       /*获得推荐后入驻通过的人数*/
      Long productionPass =  freelancerInfoService.getProductionPass(currUserId);
        MyRecordVo myRecordVo = new MyRecordVo();
        myRecordVo.setRecommended(recommended);
        myRecordVo.setPublishProduction(publishProduction);
        myRecordVo.setProductionPass(productionPass);
        return ApiResponse.ofSuccess(myRecordVo);
    }


    @Override
    protected Service<FreelancerInfo> service() {
        return iFreelancerInfoService;
    }


}
