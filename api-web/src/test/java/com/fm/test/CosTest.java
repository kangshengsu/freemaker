package com.fm.test;

import com.fm.api.web.ApiWebStarter;
import com.fm.framework.core.model.OssTmpSecret;
import com.fm.framework.core.service.FileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * @author zhangleqi
 * @date 2020/9/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiWebStarter.class)
public class CosTest {

    @Autowired
    private FileService fileService;

    @Test
    public void getUpload() throws IOException {
        File file = new File("/Users/zhangleqi/Pictures/me.jpg");
        InputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        new FileInputStream(file).read(data);

        fileService.upload("1.jpg", data);
    }

    @Test
    public void testGetTmpSecret() {
        OssTmpSecret tmpSecret = fileService.getTmpSecret();
        Assert.assertNotNull(tmpSecret);
    }

    @Test
    public void getBaseUrl() {
        String baseUrl = fileService.getBaseUrl();
        Assert.assertEquals("baseUrl不一致","https://howwork-1301749332.cos.ap-beijing.myqcloud.com/",baseUrl);
    }
}
