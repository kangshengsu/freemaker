package com.fm.api.web.controller;

import com.fm.api.web.vo.LoginVO;
import com.fm.api.web.vo.SysUserVO;
import com.fm.business.base.model.SysUser;
import com.fm.business.base.service.ISysUserService;
import com.fm.framework.core.Context;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.JsonUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

    /**
     * 默认存活时间
     */
    private static int DEFALUT_LOGIN_SURVIVE_TIME = 24;


    /**
     * 登录
     * @param form
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ApiResponse<LoginVO> login(@Valid @RequestBody LoginVO form){
        //获取用户
        SysUser sysUser = sysUserService.findByCode(form.getUsername());
        if(sysUser == null ){
            return failed("用户不存在！");
        }

        //匹配密码
        if(sysUser.getPassword().equals(form.getPassword())){
            //分配token
            String token = UUID.randomUUID().toString();
            form.setToken(token);
            //缓存token
            redissonClient.getBucket(token).set(sysUser,DEFALUT_LOGIN_SURVIVE_TIME, TimeUnit.HOURS);

        }else{
            return failed("密码不正确！");
        }

        return success(form);

    }


    /**
     * 登出
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.POST)
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
        LoginVO userInfo = new LoginVO();
        userInfo.setToken(token);
        String[] roles = {"admin"};
        userInfo.setRoles(roles);
        userInfo.setUsername(Context.getCurrUserName());
        userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfo.setIntroduction("introduction");
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
