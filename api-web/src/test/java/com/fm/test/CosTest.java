package com.fm.test;

import com.fm.api.web.ApiWebStarter;
import com.fm.framework.core.service.StorageService;
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
    private StorageService storageService;

    @Test
    public void upload() throws IOException {
        File file = new File("/Users/zhangleqi/Pictures/me.jpg");
        InputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        new FileInputStream(file).read(data);

        storageService.upload("pictures/me.jpg", data);
    }
}
