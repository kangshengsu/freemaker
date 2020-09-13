package com.fm.api.gw.controller;

import com.fm.api.gw.service.WxService;
import com.fm.api.gw.vo.UserVO;
import com.fm.api.gw.vo.WeChatLoginVO;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/miniApp")
public class MiniAppController {

    @Resource
    private WxService wxService;

    /**
     * 小程序登录
     *
     * @param weChatLoginVO
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ApiResponse getSessionKey(@RequestBody WeChatLoginVO weChatLoginVO) {
        UserVO userInfo = wxService.getSessionInfo(weChatLoginVO);
        return ApiResponse.of(ApiStatus.SUCCESS, userInfo);
    }


    @ApiOperation("小程序获取手机号")
    @PostMapping(value = "/phoneLogin", consumes = "application/json;charset=UTF-8")
    public ApiResponse phoneLogin(@RequestBody WeChatLoginVO weChatLoginDTO) {
        UserVO userInfo = null;
//        try {
//            userInfoDTO = minProgramService.phoneLogin(weChatLoginDTO);
//        } catch (Exception e) {
//            log.info("获取用户手机号异常",e);
//            return ApiResponse.ofFailed(e.getMessage());
//        }
        return ApiResponse.of(ApiStatus.SUCCESS, userInfo);
    }
}
