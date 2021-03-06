package com.fm.api.gw.controller;

import com.fm.api.gw.rpc.WxRpcService;
import com.fm.api.gw.vo.LoginReturnVO;
import com.fm.api.gw.vo.MiniAppUserVO;
import com.fm.api.gw.vo.WeChatDecryptVO;
import com.fm.api.gw.vo.WeChatLoginVO;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.partner.PartnerInfo;
import com.fm.business.base.model.sys.SysUser;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.partner.PartnerInfoService;
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
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private PartnerInfoService partnerInfoService;

    @Autowired
    private IFreelancerInfoService iFreelancerInfoService;

    @Autowired
    private IEmployerInfoService iEmployerInfoService;

    /**
     * ??????????????????
     */
    private static int DEFALUT_LOGIN_SURVIVE_TIME = 365;

    /**
     * ???????????????
     * todo zyc ???????????? ???????????? ?????? ???BaseService???afterSave?????????
     *
     * @param weChatLoginVO
     * @return
     */
    @RequestMapping(value = "/syncUserInfo", method = {RequestMethod.POST})
    @Transactional(rollbackFor = RuntimeException.class)
    public ApiResponse<LoginReturnVO> syncUserInfo(HttpServletRequest request, @RequestBody WeChatLoginVO weChatLoginVO) {
        LoginReturnVO loginReturnVO = new LoginReturnVO();
        //??????sessionkey openId unionId
        WeChatDecryptVO weChatDecryptVO = wxRpcService.getSessionInfo(weChatLoginVO);
        String openId = weChatDecryptVO.getOpenId();
        log.info("openId: {}", openId);
        SysUser sysUser = iSysUserService.findByCode(openId);
        //token??????
        RBucket<String> cacheToken = redissonClient.getBucket(openId);
        //????????????token???????????????????????????
        if (!cacheToken.isExists()) {
            cacheToken.set(JwtUtil.generateToken(openId));
        }

        Long userId = null;
        if (sysUser == null) {
            sysUser = new SysUser();
            convertSysUser(sysUser, weChatLoginVO, openId);
            //??????howwork???????????????????????????????????????
            iSysUserService.save(sysUser);
            //?????????????????????ID todo ???????????????????????????sysUser???????????????userId??????????????????????????????BaseService#initDefaultField
            //sysUser = iSysUserService.findByCode(openId);

            //???????????????????????????????????????????????????????????????????????????
            userId = sysUser.getId();
            List<QueryItem> queryItems = getQueryItemsForUserId(userId);
            FreelancerInfo freelancerInfoResult = iFreelancerInfoService.getOne(queryItems);
            PartnerInfo partnerInfo = new PartnerInfo();
            if (weChatLoginVO.getScene() != null) {
                partnerInfo.setReferrerId(weChatLoginVO.getScene());
                partnerInfo.setBelongId(weChatLoginVO.getScene());
            }
            partnerInfo.setFreelancerId(freelancerInfoResult.getId());
            partnerInfoService.save(partnerInfo);
        }

        userId = sysUser.getId();
        RBucket<MiniAppUserVO> currUser = redissonClient.getBucket(cacheToken.get());

        List<QueryItem> queryItems = getQueryItemsForUserId(userId);
        EmployerInfo employerInfoResult = iEmployerInfoService.getOne(queryItems);
        FreelancerInfo freelancerInfoResult = iFreelancerInfoService.getOne(queryItems);

        MiniAppUserVO miniAppUserVO = new MiniAppUserVO();
        miniAppUserVO.setEmployerId(employerInfoResult.getId());
        miniAppUserVO.setFreeLancerId(freelancerInfoResult.getId());
        miniAppUserVO.setUserId(userId);
        miniAppUserVO.setSessionKey(weChatDecryptVO.getSessionKey());
        miniAppUserVO.setOpenId(openId);
        if (!currUser.isExists()) {
            currUser.set(miniAppUserVO);
        }

        boolean isExistPhone = Optional.ofNullable(sysUser)
                .map(u -> StringUtils.isNotBlank(u.getPhone()))
                .orElse(false);

        loginReturnVO.setHasPhone(isExistPhone);
        loginReturnVO.setUserToken(cacheToken.get());
        loginReturnVO.setUserId(sysUser.getId());

        return ApiResponse.of(ApiStatus.SUCCESS.getCode(), ApiStatus.SUCCESS.getMessage(), loginReturnVO);
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

    @ApiOperation("????????????????????????")
    @RequestMapping(value = "/updatePhone", method = {RequestMethod.POST})
    public ApiResponse updatePhone(@RequestBody WeChatLoginVO weChatLoginVO) {
        WeChatDecryptVO userInfo = null;

        try {
            String phoneNumber = null;
            if (StringUtil.isNotBlank(Context.getMiniAppSecretKey())) {
                phoneNumber = wxRpcService.getPhoneNumber(Context.getMiniAppSecretKey(), weChatLoginVO.getEncryptedData(), weChatLoginVO.getIv());
                log.info("????????????????????????{}mix", phoneNumber);
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
            log.info("???????????????????????????", e);
            return ApiResponse.of(ApiStatus.SUCCESS, e.getMessage());
        }
        //?????????????????????
        return ApiResponse.of(ApiStatus.SUCCESS, userInfo);
    }

    private void convertSysUser(SysUser sysUser, WeChatLoginVO weChatLoginVO, String openId) {
        sysUser.setName(weChatLoginVO.getNickName());
        sysUser.setAvatarUrl(weChatLoginVO.getAvatarUrl());
//        sysUser.setPhone(phoneNumber);
        sysUser.setCode(openId);
        sysUser.setScene(weChatLoginVO.getScene());
    }
}
