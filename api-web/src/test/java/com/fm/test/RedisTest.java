package com.fm.test;

import com.fm.api.web.ApiWebStarter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RSetCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangleqi
 * @date 2020/9/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiWebStarter.class)
public class RedisTest {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void name() throws InterruptedException {
        RLock myLock = redissonClient.getLock("lock");
        Assert.assertTrue(myLock.tryLock(1, TimeUnit.SECONDS));
        myLock.lock(5, TimeUnit.SECONDS);
        myLock.unlock();
    }
}
