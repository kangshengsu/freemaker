package com.fm.api.gw.controller.common;

import com.fm.framework.core.model.OssTmpSecret;
import com.fm.framework.core.service.FileService;
import com.fm.framework.web.response.ApiResponse;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件操作
 *
 * @author zhangleqi
 * @date 2020-09-19 10:59 上午
 */
@RestController
@RequestMapping("/v1//file")
public class FileOperationController {

    @Autowired
    private FileService fileService;

    @Autowired
    private RedissonClient redissonClient;


    /**
     * 获取云存储密匙
     */
    @RequestMapping(value = "/getTmpSecret",method = RequestMethod.GET)
    public ApiResponse<OssTmpSecret> getTmpSecret(){

        return  ApiResponse.ofSuccess(fileService.getTmpSecret());
    }

    /**
     * 获取url前缀信息
     */
    @RequestMapping(value = "/getBaseUrl",method = RequestMethod.GET)
    public ApiResponse<String> getBaseUrl(){
        return ApiResponse.ofSuccess(fileService.getBaseUrl());
    }
}
