package com.fm.api.web.controller.common;

import com.fm.framework.core.model.OssTmpSecret;
import com.fm.framework.core.service.FileService;
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
@RequestMapping("/file")
public class FileOperationController {

    @Autowired
    private FileService fileService;


    /**
     * 获取云存储密匙
     */
    @RequestMapping(value = "/getTmpSecret",method = RequestMethod.GET)
    public OssTmpSecret getTmpSecret(){

        return fileService.getTmpSecret();
    }

    /**
     * 获取url前缀信息
     */
    @RequestMapping(value = "/getBaseUrl",method = RequestMethod.GET)
    public String getBaseUrl(){
        return fileService.getBaseUrl();
    }
}
