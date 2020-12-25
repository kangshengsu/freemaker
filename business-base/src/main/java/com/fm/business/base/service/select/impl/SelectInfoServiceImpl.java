package com.fm.business.base.service.select.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.select.SelectInfoMapper;
import com.fm.business.base.enums.SelectIsRecommend;
import com.fm.business.base.model.select.SelectInfo;
import com.fm.business.base.service.select.ISelectInfoService;
import com.fm.framework.core.service.AuditBaseService;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/24 13:59
 */
@Service
public class SelectInfoServiceImpl extends AuditBaseService<SelectInfoMapper, SelectInfo> implements ISelectInfoService {
    @Override
    public Map<String, List<String>> getKeyWordsByUserId(Long userId) {
        Map<String, List<String>> map = new HashMap<>();
        QueryWrapper<SelectInfo> wrapper = new QueryWrapper<>();
        map.put("keywords", getBaseMapper()
                        .selectList(Wrappers.lambdaQuery(SelectInfo.class)
                        .eq(SelectInfo::getUserId, userId)
                        .orderByDesc(SelectInfo::getUpdateTime)
                        .last("limit 6"))
                        .stream()
                        .map(SelectInfo::getKeyword)
                        .collect(Collectors.toList()));
        return map;
    }

    @Override
    public List<SelectInfo> getRecommendKeywordsByWeight() {
        return getBaseMapper().selectList(Wrappers.lambdaQuery(SelectInfo.class)
                .eq(SelectInfo::getIsRecommend, SelectIsRecommend.RECOMMEND.getCode())
                .orderByDesc(SelectInfo::getWeight));

    }

    @Override
    public Boolean deleteKeyword(Long userId) {
        if (getBaseMapper().delete(Wrappers.lambdaQuery(SelectInfo.class).eq(SelectInfo::getUserId, userId)) > 0) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public SelectInfo selectByUserIdAndKeyword(Long userId, String keyword) {
        return getBaseMapper().selectOne(Wrappers.lambdaQuery(SelectInfo.class).eq(SelectInfo::getUserId,userId).eq(SelectInfo::getKeyword,keyword));
    }
}
