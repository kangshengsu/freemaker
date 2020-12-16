package com.fm.api.gw.controller.im;

import cn.hutool.core.util.ObjectUtil;
import com.fm.api.gw.vo.im.ImVO;
import com.fm.framework.web.response.ApiResponse;
import com.tencentyun.TLSSigAPIv2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/14 15:51
 */
@RestController
@RequestMapping(value = "/v1/ImUserSig")
@Api(description = "Im接口")
@Slf4j
public class ImUserSigApiController {
    private static final Long SDK_APP_ID = (long) 1400450633;
    private static final String SECRET_KEY = "45b745bdfc40cf28c92abac0ae6b8994e54ec5881b5d817e3f1e0adfc76f7baf";

    @RequestMapping(value = "/getImUserSig", method = RequestMethod.GET)
    @ApiOperation(value = "获取ImUserSig")
    public ApiResponse<ImVO> getUserSig(@RequestParam("identifier") String identifier) {
        log.info("进入生成Sig方法");
        ImVO imVO = new ImVO();
        TLSSigAPIv2 api = new TLSSigAPIv2(SDK_APP_ID, SECRET_KEY);
        if (ObjectUtil.isNotNull(api)) {
            if (StringUtil.isNotBlank(identifier)) {
                imVO.setUserSig(api.genSig(identifier, 365 * 86400 * 2));
            } else {
                imVO.setUserSig(api.genSig("HowWork", 365 * 86400 * 2));
            }
        }
        imVO.setSdkAppId(SDK_APP_ID);
        return ApiResponse.ofSuccess(imVO);
    }
}
