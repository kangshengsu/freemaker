package com.fm.api.web.controller.serviceCharge;

import cn.hutool.core.util.ObjectUtil;
import com.fm.api.web.vo.serviceCharge.ServiceChargeVO;
import com.fm.business.base.model.serviceCharge.ServiceCharge;
import com.fm.business.base.service.serviceCharge.IServiceChargeService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/7 11:29
 */
@RequestMapping("serviceCharge")
@RestController
public class ServiceChargeController extends BaseController<ServiceCharge, ServiceChargeVO> {

    @Autowired
    private IServiceChargeService serviceChargeService;

    @GetMapping("getServiceCharge")
    public ApiResponse<ServiceChargeVO> getServiceCharge() {
        return success(convert(serviceChargeService.getAll().get(0)));
    }

    @PostMapping("updateServiceCharge")
    public ApiResponse<Boolean> updateServiceCharge(@RequestBody ServiceChargeVO serviceChargeVO) {
        if (ObjectUtil.isNotNull(serviceChargeVO)) {
            return success(serviceChargeService.update(convert(serviceChargeVO)));
        }
        return failed("修改服务费失败");
    }

    @Override
    protected Service<ServiceCharge> service() {
        return serviceChargeService;
    }
}
