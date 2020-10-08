package com.fm.business.base.service.order;

import com.fm.business.base.model.order.OrderInfo;
import com.fm.framework.core.query.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class IOrderInfoServiceTest {

    @Autowired
    private IOrderInfoService orderInfoService;

    @Test
    public void queryOrderInfoByPage() {

        Page<OrderInfo> orderInfoPage =  orderInfoService.queryOrderInfoByPage(22L, 33L, 1, 50, 10, 80);
        log.info("{}", orderInfoPage.getData());
    }
}