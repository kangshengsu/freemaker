package com.fm.test;

import com.fm.api.web.ApiWebStarter;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.service.IAttachmentInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @program: freemaker-parent
 * @description: 测试
 * @author: liuduo8
 * @create: 2020-09-12 14:04
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiWebStarter.class)
public class MyBatisTest {

    @Autowired
    @Qualifier("attachmentInfoService")
    private IAttachmentInfoService attachmentInfoService;

    @Test
    public void testCreate(){
        AttachmentInfo attachmentInfo = new AttachmentInfo();
        attachmentInfo.setBusinessCode("22");
        attachmentInfo.setCreateUser("test");
        attachmentInfo.setUpdateUser("123");
        attachmentInfo.setCreateTime(new Date());
        attachmentInfo.setUpdateTime(new Date());
        attachmentInfoService.save(attachmentInfo);
    }
}
