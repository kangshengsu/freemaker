package com.fm.test;

import com.fm.api.web.ApiWebStarter;
import com.fm.business.base.constant.CacheKeyConstants;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.sys.ISysUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
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
    @Autowired
    private ISysUserService sysUserService;

    @Test
    public void name() throws InterruptedException {

        RLock myLock = redissonClient.getLock("lock");
        Assert.assertTrue(myLock.tryLock(1, TimeUnit.SECONDS));
        myLock.lock(5, TimeUnit.SECONDS);
        myLock.unlock();
        RBucket<String> keyObject = redissonClient.getBucket("key");
        RBucket<Object> bucket = redissonClient.getBucket("haha");
        bucket.set("123");
        RBucket<Object> haha = redissonClient.getBucket("haha");
        Assert.assertEquals("123",haha.get());
    }
    @Test
    public void testObject(){
        SysUser sysUser = new SysUser();
        sysUser.setCode("123456");
        redissonClient.getBucket("liuduo").set(sysUser,100,TimeUnit.SECONDS);
        String cacheCode = ((SysUser)redissonClient.getBucket("liuduo").get()).getCode();
        Assert.assertEquals("123456",cacheCode);
    }

    @Test
    public void Cookie(){
        //获取用户
        SysUser sysUser = sysUserService.findByCode("admin");

        //分配token
        String token = "0112ca2c-d711-4623-8085-09682f7191df";
        String cacheKye = String.format(CacheKeyConstants.LOGIN_TOKEN.getKey(),token);

        //缓存token
        redissonClient.getBucket(cacheKye).set(sysUser);
    }
}
