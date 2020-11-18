/**
 * @filename:FreelancerInfoServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service.freelancer.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.freelancer.IFreelancerInfoMapper;
import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.freelancer.FreelancerInfo;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.business.base.service.wx.message.impl.WxMessageSenderService;
import com.fm.framework.core.Context;
import com.fm.framework.core.cos.CosProperties;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.AuditBaseService;
import com.fm.framework.core.service.FileService;
import com.qcloud.cos.COSClient;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:(自由职业者信息服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 *
 */
@Slf4j
@Service("freelancerInfoService")
public class FreelancerInfoServiceImpl extends AuditBaseService<IFreelancerInfoMapper, FreelancerInfo> implements IFreelancerInfoService {
    @Autowired
    private WxMessageSenderService wxMessageSenderService;

    @Autowired
    private FileService fileService;

    @Autowired
    private COSClient cosClient;

    @Autowired
    private CosProperties cosProperties;

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private RestTemplate rest;



    @Value("${wx.miniapp.appid}")
    private String appid;

    @Value("${wx.miniapp.secret}")
    private String secret;

    @Value("${wx.miniapp.accessUrl}")
    private String accessUrl;


    /**
     * 通过名字或电话查找数据 最多返回10条
     * @param str
     * @return
     */
    @Override
    public List<FreelancerInfo> findLikeNameOrPhone(String str) {

        if (StringUtils.isEmpty(str)) {
            return Collections.emptyList();
        }

        List<FreelancerInfo> freelancerInfos = getBaseMapper().selectList(Wrappers.lambdaQuery(FreelancerInfo.class)
                .like(FreelancerInfo::getName, str)
                .or()
                .like(FreelancerInfo::getPhone, str)
                .or()
                .orderByAsc(FreelancerInfo::getName, FreelancerInfo::getPhone)
                .last("limit 10"));
        return freelancerInfos;
    }

    /**
     * 通过名字或UserId查找数据 最多返回10条
     * @param
     * @return
     */
    @Override
    public List<FreelancerInfo> findLikeNameOrUserId(String keyword) {
        if (StringUtils.isEmpty(keyword)){
            return Collections.emptyList();
        }

        return getBaseMapper().selectList(Wrappers.lambdaQuery(FreelancerInfo.class)
                .like(FreelancerInfo::getName,keyword)
                .or()
                .eq(FreelancerInfo::getUserId,keyword)
                .or()
                .like(FreelancerInfo::getPhone,keyword)
                .orderByAsc(FreelancerInfo::getName,FreelancerInfo::getUserId,FreelancerInfo::getPhone));
    }



    @Override
    public FreelancerInfo getByUserId(Long userId) {
        if (null == userId) {
            return null;
        }

        List<FreelancerInfo> freelancerInfos = getBaseMapper().selectList(Wrappers.<FreelancerInfo>lambdaQuery().eq(FreelancerInfo::getUserId, userId));
        if (CollectionUtils.isEmpty(freelancerInfos)) {
            return null;
        }

        return freelancerInfos.get(0);
    }

    @Override
    public String createReferralCode() {
        ByteArrayInputStream inputStream = null;
        try {
            Long currUserId = Context.getCurrUserId();
            FreelancerInfo freelancerInfo1 = getBaseMapper().selectOne(Wrappers.lambdaQuery(FreelancerInfo.class)
                    .eq(FreelancerInfo::getUserId, currUserId));
            if(!StringUtils.isEmpty(freelancerInfo1.getReferralCode())){
                return freelancerInfo1.getReferralCode();
            }

            String accessToken = getAccessToken();
            String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + accessToken;
            Map<String, Object> param = new HashMap<>();
            param.put("scene", currUserId);
            LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(param, headers);
            ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class);
            byte[] result = entity.getBody();
            byte[] bytes = new byte[result.length];
            inputStream = new ByteArrayInputStream(result);
            inputStream.read(bytes);
            long time = new Date().getTime();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formatDate = sdf.format(date);
            fileService.upload("referralCode/" + formatDate + "/"+ currUserId + time + "referralCode.png", bytes);
            String bucketName = cosProperties.getBucketName();
            String key = "referralCode/" + formatDate + "/"+ currUserId + time + "referralCode.png";
            Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
            URL oldUrl = cosClient.generatePresignedUrl(bucketName, key, expiration);
            String newUrl = oldUrl.toString();
            newUrl = newUrl.substring(0, newUrl.indexOf("?"));
            FreelancerInfo freelancerInfo = new FreelancerInfo();
            freelancerInfo.setId(Context.getCurrFreelancerId());
            freelancerInfo.setReferralCode(newUrl);
            getBaseMapper().updateById(freelancerInfo);
            return newUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
                if (inputStream != null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
        return null;
    }

    @Override
    public Long getRecommended(Long currUserId) {
        List<FreelancerInfo> freelancerInfos = getBaseMapper().selectList(Wrappers.lambdaQuery(FreelancerInfo.class)
                .eq(FreelancerInfo::getReferrer, currUserId));
        return (long) freelancerInfos.size();
    }

    @Override
    public Long getPublishProduction(Long currUserId) {
        List<FreelancerInfo> freelancerInfos = getBaseMapper().selectList(Wrappers.lambdaQuery(FreelancerInfo.class)
                .eq(FreelancerInfo::getReferrer, currUserId));
        List<Long> freelancerIds = freelancerInfos.stream().map(freelancerInfo -> freelancerInfo.getId()).collect(Collectors.toList());
        HashMap<Long, Object> map = new HashMap<>();
        freelancerIds.forEach(freelancerId -> {
            List<ProductionInfo> production = productionInfoService.findByFreeLancer(freelancerId);
            if (!CollectionUtils.isEmpty(production)) {
                map.put(freelancerId, production);
            }
        });
        return (long) map.size();
    }

    @Override
    public Long getProductionPass(Long currUserId) {
        List<FreelancerInfo> freelancerInfos = getBaseMapper().selectList(Wrappers.lambdaQuery(FreelancerInfo.class)
                .eq(FreelancerInfo::getReferrer, currUserId));
        List<Long> freelancerIds = freelancerInfos.stream().map(freelancerInfo -> freelancerInfo.getId()).collect(Collectors.toList());
        Map<Long, Object> map = new HashMap<>();
        freelancerIds.forEach(freelancerId -> {
            Page<ProductionInfo> production = productionInfoService.findByFreelancer(1, 20, freelancerId, ProductionStatus.RELEASE.getCode());
            if (production.getTotal() != 0) {
                map.put(freelancerId, production);
            }
        });
        return (long) map.size();
    }

    private String getAccessToken(){
        String url = String.format(accessUrl, appid, secret);
        String json = rest.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(json);
        String access_token = jsonObject.get("access_token").toString();
        return access_token;
    }


    @Override
    public List<FreelancerInfo> getFreelancerName(List<Long> referrers) {
        if (CollectionUtils.isEmpty(referrers)){
            return Collections.emptyList();
        }
        List<FreelancerInfo> list = new ArrayList<>();
        referrers.forEach(referrer -> {
            if (referrer == null){
                return ;
            }
            FreelancerInfo freelancerInfo = getBaseMapper().selectOne(Wrappers.lambdaQuery(FreelancerInfo.class)
                    .eq(FreelancerInfo::getUserId, referrer));
            list.add(freelancerInfo);
        });
        return list;
    }

    @Override
    public List<FreelancerInfo> findUserByReferrer(Long referrer) {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(FreelancerInfo.class)
                .eq(FreelancerInfo::getReferrer, referrer));
    }
}