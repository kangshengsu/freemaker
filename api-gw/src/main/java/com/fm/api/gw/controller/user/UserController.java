package com.fm.api.gw.controller.user;

import com.fm.api.gw.vo.user.UserApiVO;
import com.fm.api.gw.vo.user.mapper.UserMapper;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.Context;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @program: freemaker-parent
 * @description: 用户相关
 * @author: liuduo8
 * @create: 2020-10-17 10:19
 **/
@Api(value = "/v1/userApi",description ="用户操作相关接口")
@RestController
@RequestMapping("/v1/userApi")
@Slf4j
public class UserController extends BaseController<SysUser,UserApiVO> {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 更新个人信息 同步更新自由职业者和雇佣者
     *
     * 统一字段以个人信息主属性为主，自由职业者和雇佣者特殊字段以对应子属性为主
     *
     * 如果后续有缓存 请刷新缓存
     *
     *
     * 请求报文样例：
       {
         "provinceCode": "一级地址编码",
         "cityCode": "二级地址编码",
         "districtCode": "三级级地址编码",
         "countyCode": "四级级地址编码",
         "freelancerInfo": {
         "language": 20,
         "skillSummarize": "技能描述"
         },
         "headImg": "头像路径（不要全路径）",
         "name": "名字"
       }
     *
     * @param form
     * @return
     */
    @PostMapping("/updateAll")
    @ApiOperation(value="更新个人信息（同步更新自由职业者和雇佣者）")
    @ApiImplicitParam(name = "form", value = "作品相关属性", dataType = "UserApiVO",paramType = "body")
    public ApiResponse<Boolean> updateAll(@RequestBody @Validated(value = UserApiVO.UpdateAllInfo.class) UserApiVO form) {
        SysUser sysUser = userMapper.toSysUser(form);
        log.info("当前登录人：{}",Context.getCurrUserId());
        sysUser.setId(Context.getCurrUserId());
        sysUser.getFreelancerInfo().setId(Context.getCurrFreelancerId());
        sysUser.getEmployerInfo().setId(Context.getCurrEmployerId());

        if(!sysUserService.updateUserAllInfo(sysUser)){
            return ApiResponse.ofFailed("更新个人信息失败");
        }
        //fixme 如果后续有缓存 请刷新缓存
        return ApiResponse.ofSuccess(Boolean.TRUE);
    }

    @GetMapping("/getCurrentInfo")
    @ApiOperation(value="查看个人信息")
    public ApiResponse<UserApiVO> getCurrent() {
        Long currUserId = Context.getCurrUserId();
        SysUser sysUser = sysUserService.findById(currUserId);
        UserApiVO userApiVO = userMapper.toUserApiVO(sysUser);
        return ApiResponse.ofSuccess(userApiVO);
    }



    @Override
    protected Service<SysUser> service() {
        return sysUserService;
    }
}
