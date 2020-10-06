package com.fm.api.gw.controller;

import com.fm.api.gw.rpc.WxRpcService;
import com.fm.api.gw.vo.MiniAppUserVO;
import com.fm.api.gw.vo.WeChatDecryptVO;
import com.fm.api.gw.vo.WeChatLoginVO;
import com.fm.business.base.enums.LanguageEnum;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.IAccountInfoService;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.Context;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.utils.JwtUtil;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import io.swagger.annotations.ApiOperation;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/v1/miniApp")
public class MiniAppController {

    @Resource
    private WxRpcService wxRpcService;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private IAccountInfoService iAccountInfoService;

    @Autowired
    private IFreelancerInfoService iFreelancerInfoService;

    @Autowired
    private IEmployerInfoService iEmployerInfoService;

    /**
     * 默认存活时间
     */
    private static int DEFALUT_LOGIN_SURVIVE_TIME = 24;

    /**
     * 小程序登录
     * todo zyc 此处肥长 看着不爽 待改 用BaseService的afterSave方法做
     *
     * @param weChatLoginVO
     * @return
     */
    @RequestMapping(value = "/syncUserInfo", method = {RequestMethod.POST})
    public ApiResponse getSessionKey(@RequestBody WeChatLoginVO weChatLoginVO) {

        //获取sessionkey openId unionId
        WeChatDecryptVO weChatDecryptVO = wxRpcService.getSessionInfo(weChatLoginVO);

        String openId = weChatDecryptVO.getOpenId();
        SysUser sysUser = iSysUserService.findByCode(openId);
        String phoneNumber = "";

        //缓存用户信息，供拦截器使用
        String userToken = JwtUtil.generateToken(openId);
        RBucket<SysUser> currUser = redissonClient.getBucket(userToken);

        if (sysUser == null) {
            sysUser = new SysUser();
            //构建各类用户信息 todo 1，code和name一样 2. 四级地址只有二级，和我们的四级地址库是否匹配 3.语言编码目前只存了一种，

            convertSysUser(sysUser, weChatLoginVO, openId, phoneNumber);
            //同步howwork账号、自由职业者、雇主信息
            iSysUserService.save(sysUser);
            //获取新增的用户ID
            SysUser queryResult = iSysUserService.findByCode(openId);
            Long userId = queryResult.getId();

            FreelancerInfo freelancerInfo = new FreelancerInfo();
            convertFreelancerInfo(freelancerInfo, weChatLoginVO, userId, phoneNumber);

            EmployerInfo employerInfo = new EmployerInfo();
            convertEmployerInfo(employerInfo, weChatLoginVO, userId, phoneNumber);

            iAccountInfoService.createAccount(freelancerInfo, employerInfo);
            List<QueryItem> queryItems = getQueryItemsForUserId(userId);

            EmployerInfo employerInfoResult = iEmployerInfoService.getOne(queryItems);
            FreelancerInfo freelancerInfoResult = iFreelancerInfoService.getOne(queryItems);

            //塞入缓存
            MiniAppUserVO miniAppUserVO = new MiniAppUserVO();
            BeanUtils.copyProperties(queryResult, miniAppUserVO);
            miniAppUserVO.setEmployerId(employerInfoResult.getId());
            miniAppUserVO.setFreeLancerId(freelancerInfoResult.getId());
            miniAppUserVO.setId(userId);
            miniAppUserVO.setSessionKey(weChatDecryptVO.getSessionKey());

            currUser.set(miniAppUserVO, DEFALUT_LOGIN_SURVIVE_TIME, TimeUnit.HOURS);

        } else {
            //构建各类用户信息 todo 1，code和name一样 2. 四级地址只有二级，和我们的四级地址库是否匹配 3.语言编码目前只存了一种，
            convertSysUser(sysUser, weChatLoginVO, openId, phoneNumber);
            //同步howwork账号、自由职业者、雇主信息
            iSysUserService.update(sysUser);
            Long userId = sysUser.getId();


            List<QueryItem> queryItems = getQueryItemsForUserId(userId);

            FreelancerInfo freelancerInfo = iFreelancerInfoService.getOne(queryItems);
            convertFreelancerInfo(freelancerInfo, weChatLoginVO, userId, phoneNumber);

            EmployerInfo employerInfo = iEmployerInfoService.getOne(queryItems);
            convertEmployerInfo(employerInfo, weChatLoginVO, userId, phoneNumber);

            iAccountInfoService.updateAccount(freelancerInfo, employerInfo);

            //塞入缓存
            MiniAppUserVO miniAppUserVO = new MiniAppUserVO();

            EmployerInfo employerInfoResult = iEmployerInfoService.getOne(queryItems);
            FreelancerInfo freelancerInfoResult = iFreelancerInfoService.getOne(queryItems);

            miniAppUserVO.setEmployerId(employerInfoResult.getId());
            miniAppUserVO.setFreeLancerId(freelancerInfoResult.getId());
            miniAppUserVO.setId(userId);
            miniAppUserVO.setSessionKey(weChatDecryptVO.getSessionKey());

            currUser.set(miniAppUserVO, DEFALUT_LOGIN_SURVIVE_TIME, TimeUnit.HOURS);
        }

        return ApiResponse.of(ApiStatus.SUCCESS.getCode(), ApiStatus.SUCCESS.getMessage(), userToken);
    }

    private List<QueryItem> getQueryItemsForUserId(Long userId) {
        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField("userId");
        queryItem.setType(QueryType.eq);
        queryItem.setValue(userId);
        queryItems.add(queryItem);
        return queryItems;
    }

    @ApiOperation("小程序获取手机号")
    @RequestMapping(value = "/updatePhone", method = {RequestMethod.POST})
    public ApiResponse updatePhone(@RequestBody WeChatLoginVO weChatLoginVO) {
        WeChatDecryptVO userInfo = null;

        try {
            String phoneNumber = null;
            if (StringUtil.isNotBlank(Context.getMiniAppSecretKey())) {
                phoneNumber = wxRpcService.getPhoneNumber(Context.getMiniAppSecretKey(), weChatLoginVO.getEncryptedData(), weChatLoginVO.getIv());
            }

            if (StringUtil.isNotBlank(phoneNumber)) {
                EmployerInfo employerInfo = new EmployerInfo();
                employerInfo.setId(Context.getCurrEmployerId());
                employerInfo.setPhone(phoneNumber);

                FreelancerInfo freelancerInfo = new FreelancerInfo();
                freelancerInfo.setId(Context.getCurrFreelancerId());
                freelancerInfo.setPhone(phoneNumber);

                SysUser sysUser = new SysUser();
                sysUser.setId(Context.getCurrUserId());
                sysUser.setPhone(phoneNumber);

                iFreelancerInfoService.update(freelancerInfo);
                iEmployerInfoService.update(employerInfo);
                iSysUserService.update(sysUser);
            }
        } catch (Exception e) {
            log.info("获取用户手机号异常", e);
            return ApiResponse.ofFailed(e.getMessage());
        }
        //更新用户表电话
        return ApiResponse.of(ApiStatus.SUCCESS, userInfo);
    }

    private void convertSysUser(SysUser sysUser, WeChatLoginVO weChatLoginVO, String openId, String phoneNumber) {
        sysUser.setName(weChatLoginVO.getNickName());
        sysUser.setPhone(phoneNumber);
        sysUser.setCode(openId);
    }

    private void convertEmployerInfo(EmployerInfo employerInfo, WeChatLoginVO weChatLoginVO, Long userId, String phoneNumber) {
        employerInfo.setName(weChatLoginVO.getNickName());
        employerInfo.setCode(weChatLoginVO.getNickName());
        employerInfo.setPhone(phoneNumber);
        employerInfo.setProvinceCode(weChatLoginVO.getProvince());
        employerInfo.setCityCode(weChatLoginVO.getCity());
        //todo zyc 下三个为空
        employerInfo.setDistrictCode(Optional.ofNullable(weChatLoginVO.getDistrict()).orElse(""));
        employerInfo.setCountyCode(Optional.ofNullable(weChatLoginVO.getCounty()).orElse(""));
        employerInfo.setAccountCode("");
        employerInfo.setUserId(userId);
        employerInfo.setHeadImg(weChatLoginVO.getAvatarUrl());
    }

    private void convertFreelancerInfo(FreelancerInfo freelancerInfo, WeChatLoginVO weChatLoginVO, Long userId, String phoneNumber) {
        freelancerInfo.setName(weChatLoginVO.getNickName());
        freelancerInfo.setCode(weChatLoginVO.getNickName());
        freelancerInfo.setPhone(phoneNumber);
        //todo zyc 下面四个没值
        freelancerInfo.setCateTreeCode("");
        freelancerInfo.setJobCateId(0L);
        freelancerInfo.setSkillSummarize("");
        freelancerInfo.setAccountCode("");

        freelancerInfo.setLanguage(LanguageEnum.getIndexByCode(weChatLoginVO.getLanguage()));
        freelancerInfo.setProvinceCode(weChatLoginVO.getProvince());
        freelancerInfo.setCityCode(weChatLoginVO.getCity());
        freelancerInfo.setDistrictCode(Optional.ofNullable(weChatLoginVO.getDistrict()).orElse(""));
        freelancerInfo.setCountyCode(Optional.ofNullable(weChatLoginVO.getCounty()).orElse(""));
        freelancerInfo.setUserId(userId);
        freelancerInfo.setHeadImg(weChatLoginVO.getAvatarUrl());

    }
}
