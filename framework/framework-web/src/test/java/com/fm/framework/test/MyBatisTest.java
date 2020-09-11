package com.fm.framework.test;

import com.fm.framework.core.model.DemandInfo;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.IDemandInfoService;
import com.fm.framework.web.FrameworkApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: freemaker-parent
 * @description: ce
 * @author: liuduo8
 * @create: 2020-09-11 11:21
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FrameworkApplication.class)
public class MyBatisTest {

    @Autowired
    private IDemandInfoService demandInfoService;

    @Test
    public void testDemo(){
        DemandInfo demandInfo = demandInfoService.get(1L);
        System.out.println(" ---------------get  "+demandInfo.getCode());

        //System.out.println(" ---------------test   "+demandInfoService.test(1L).get(0).getCode());

        /*DemandInfo entity = new DemandInfo();
        entity.setCode("test1");
        demandInfoService.save(entity);*/
        Page list = demandInfoService.list(0,3);
        System.out.println(" ---------------list page  "+list.getTotal());
    }
}
