package com.fm.api.web.controller.common;

import com.fm.api.web.vo.common.LoginVO;
import com.fm.business.base.constant.CacheKeyConstants;
import com.fm.business.base.model.sm.Account;
import com.fm.business.base.model.sm.Role;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.sm.IAccountService;
import com.fm.business.base.service.sm.IUserService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.Context;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @program: freemaker-parent
 * @description: 系统公共接口
 * @author: liuduo8
 * @create: 2020-09-13 10:43
 **/
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController<SysUser, LoginVO> {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IUserService userService;

    /**
     * 默认存活时间
     */
    private static int DEFALUT_LOGIN_SURVIVE_TIME = 24;


    /**
     * 登录
     * @param form
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ApiResponse<LoginVO> login(@Valid @RequestBody LoginVO form){
        //获取用户
//        SysUser sysUser = sysUserService.findByCode(form.getUsername());

        Account account = accountService.getAccount(form.getUsername());

        if(account == null ){
            return failed("用户不存在！");
        }

        //匹配密码
        if(account.getPassword().equals(form.getPassword())){
            //分配token
            String token = UUID.randomUUID().toString();
            String cacheKye = String.format(CacheKeyConstants.LOGIN_TOKEN.getKey(),token);
            form.setToken(token);

            User user = userService.get(account.getUserId());
            //缓存token
            redissonClient.getBucket(cacheKye).set(user,DEFALUT_LOGIN_SURVIVE_TIME, TimeUnit.HOURS);

        }else{
            return failed("密码不正确！");
        }

        return success(form);

    }


    /**
     * 登出
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public ApiResponse<Boolean> logout(){

        redissonClient.getBucket(Context.getCurrUserToken()).delete();

        return success(Boolean.TRUE);

    }

    /**
     * 用户信息
     * roles, name, avatar, introduction
     *
     * @return
     */
    @RequestMapping(value = "/user/info",method = RequestMethod.GET)
    public ApiResponse<LoginVO> userInfo(String token){

        String cacheKye = String.format(CacheKeyConstants.LOGIN_TOKEN.getKey(),token);
        RBucket<User> currUser = redissonClient.getBucket(cacheKye);
        User user = currUser.get();
        LoginVO userInfo = new LoginVO();
        userInfo.setToken(token);
        userInfo.setRoles(new String[]{"admin"});
        userInfo.setName(Context.getCurrUserName());
        userInfo.setAvatar(user.getAvatarHref());
        userInfo.setIntroduction("introduction");
        userInfo.setId(user.getId());
        return success(userInfo);

    }



    @Override
    protected Service<SysUser> service() {
        return sysUserService;
    }

    @Override
    protected SysUser convert(LoginVO form) {
        SysUser model = new SysUser();
        model.setCode(form.getUsername());
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected LoginVO convert(SysUser model) {
        LoginVO form = new LoginVO();
        form.setUsername(model.getCode());
        BeanUtils.copyProperties(model,form);
        return form;
    }
}
