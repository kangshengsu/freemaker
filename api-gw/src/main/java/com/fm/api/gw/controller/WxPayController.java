package com.fm.api.gw.controller;

import cn.hutool.core.date.DateUtil;
import com.fm.api.gw.vo.order.OrderOperateInfoVO;
import com.fm.business.base.model.order.OrderInfo;
import com.fm.business.base.model.order.OrderInfoDetail;
import com.fm.business.base.service.order.IOrderInfoDetailService;
import com.fm.business.base.service.order.IOrderInfoService;
import com.fm.framework.core.Context;
import com.fm.framework.core.utils.RandomStringUtil;
import com.fm.framework.web.response.ApiResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/v1/wxPay")
public class WxPayController {

    @Value("${wx.pay.notifyUrl}")
    private String notifyUrl;

    @Resource
    private WxPayService wxPayService;

    @Autowired
    private IOrderInfoDetailService orderInfoDetailService;

    @Autowired
    private IOrderInfoService orderInfoService;

    static String nonceStr = RandomStringUtil.getRandomStringByLength(32);
     Long orderId = null;

    /**
     * ??????????????????????????????????????????????????????????????????.
     *
     * @param     {@link com.github.binarywang.wxpay.bean.order}????????????
     * @return ?????? {@link com.github.binarywang.wxpay.bean.order}??????????????????
     */
    @ApiOperation(value = "??????????????????????????????????????????")
    @PostMapping("/createOrder")
    public ApiResponse createOrder(@RequestBody OrderOperateInfoVO OrderOperateInfoVO) throws WxPayException {
        this.orderId = OrderOperateInfoVO.getOrderId();
        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
        OrderInfoDetail orderInfoDetail = orderInfoDetailService.getOrderInfoDetailByOrderId(OrderOperateInfoVO.getOrderId());
        OrderInfo orderInfo = orderInfoService.get(OrderOperateInfoVO.getOrderId());
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        orderRequest.setSignType(WxPayConstants.SignType.MD5);
        orderRequest.setBody("HowWork-" + orderInfoDetail.getSummarize());
        orderRequest.setNonceStr(nonceStr);
        orderRequest.setOutTradeNo(DateUtil.format(new Date(), "yyyyMMddHHmmss") + orderId);
        orderRequest.setTradeType(WxPayConstants.TradeType.JSAPI);
        orderRequest.setTotalFee((int) (orderInfo.getActOrderMny() * 100));
        orderRequest.setOpenid(Context.getCurrUserCode());
        orderRequest.setSpbillCreateIp(ip);
        orderRequest.setNotifyUrl(notifyUrl);
        return ApiResponse.ofSuccess(this.wxPayService.createOrder(orderRequest));
    }

    /**
     * ????????????(??????https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1)
     * ??????????????????????????????????????????????????????????????????"???????????????????????????"
     * ???????????????https://api.mch.weixin.qq.com/pay/unifiedorder
     *
     * @param request ????????????????????????????????????appid???mchid?????????????????????????????????????????????????????????????????????????????????????????????????????????
     */
    @ApiOperation(value = "???????????????????????????")
    @PostMapping("/unifiedOrder")
    public WxPayUnifiedOrderResult unifiedOrder(@RequestBody WxPayUnifiedOrderRequest request) throws
            WxPayException {
        return this.wxPayService.unifiedOrder(request);
    }

    @ApiOperation(value = "????????????????????????")
    @PostMapping("/notify/order")
    public String parseOrderNotifyResult(HttpServletRequest request, HttpServletResponse response) throws WxPayException {
        try {
            log.info("??????????????????");
            String xmlData = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
            WxPayOrderNotifyResult result = this.wxPayService.parseOrderNotifyResult(xmlData);
            if ("SUCCESS".equals(result.getResultCode()) && "SUCCESS".equals(result.getReturnCode())) {
                log.info("????????????????????????");
                String serialNumber = result.getTransactionId();
                OrderInfo orderInfo = orderInfoService.get(this.orderId);
                orderInfo.setSerialNumber(serialNumber);
                orderInfoService.update(orderInfo);
            }
                return WxPayNotifyResponse.success("??????");
        } catch (Exception e) {
            log.error("???????????????????????????????????????:{}", e.getMessage());
            e.printStackTrace();
            return WxPayNotifyResponse.fail("???????????????????????????????????????:" + e.getMessage());
        }
    }
}
