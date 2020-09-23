package com.fm.api.gw.controller;

import com.fm.api.gw.service.WxService;
import com.fm.api.gw.vo.UserVO;
import com.fm.api.gw.vo.WeChatLoginVO;
import com.fm.business.base.model.sys.SysUser;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/miniApp")
public class MiniAppController {

    @Resource
    private WxService wxService;

    @Autowired
    private RedissonClient redissonClient;


    /**
     * 默认存活时间
     */
    private static int DEFALUT_LOGIN_SURVIVE_TIME = 24;

    /**
     * 小程序登录
     *
     * @param weChatLoginVO
     * @return
     */
    @RequestMapping(value = "/syncUserInfo", method = {RequestMethod.POST})
    public ApiResponse getSessionKey(@RequestBody WeChatLoginVO weChatLoginVO) {
        UserVO userInfo = wxService.getSessionInfo(weChatLoginVO);

        SysUser sysUser = convertSysUser(weChatLoginVO, userInfo);
        //缓存用户信息，供拦截器使用
        redissonClient.getBucket(userInfo.getOpenId()).set(sysUser,DEFALUT_LOGIN_SURVIVE_TIME, TimeUnit.HOURS);

        //todo 写用户表

        return ApiResponse.of(ApiStatus.SUCCESS, userInfo.getOpenId());
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
        //更新用户表电话
        return ApiResponse.of(ApiStatus.SUCCESS, userInfo);
    }


    private SysUser convertSysUser(@RequestBody WeChatLoginVO weChatLoginVO, UserVO userInfo) {
        SysUser sysUser = new SysUser();
        sysUser.setOpenId(userInfo.getOpenId());
        sysUser.setCredentials(weChatLoginVO.getCode());
        sysUser.setSessionKey(userInfo.getSessionKey());
        sysUser.setProvince(weChatLoginVO.getProvince());
        sysUser.setCity(weChatLoginVO.getCity());
        sysUser.setDistrict(weChatLoginVO.getDistrict());
        sysUser.setCounty(weChatLoginVO.getCounty());
        return sysUser;
    }
}
