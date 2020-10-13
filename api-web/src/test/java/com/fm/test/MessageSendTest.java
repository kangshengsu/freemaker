package com.fm.test;

import com.fm.api.web.ApiWebStarter;
import com.fm.business.base.service.wx.message.MessageSenderService;
import com.fm.framework.core.model.OssTmpSecret;
import com.fm.framework.core.service.FileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhangleqi
 * @date 2020/9/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiWebStarter.class)
public class MessageSendTest {

    @Autowired
    private MessageSenderService messageSenderService;

    @Test
    public void name() {
        messageSenderService.sendMessage();
    }
}
