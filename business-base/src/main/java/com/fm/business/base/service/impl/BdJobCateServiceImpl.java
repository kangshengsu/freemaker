/**
 * @filename:BdJobCateServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.job.IBdJobCateMapper;
import com.fm.business.base.enums.JobNodeType;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**   
 * @Description:(岗位服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("bdJobCateService")
public class BdJobCateServiceImpl extends AuditBaseService<IBdJobCateMapper, BdJobCate> implements IBdJobCateService {


    /**
     * 获取全部领域 暂时不限制条数
     * @param keyword 名称或编码
     * @return
     */
    @Override
    public List<BdJobCate> findJobCateDomain(String keyword) {
        LambdaQueryWrapper<BdJobCate> wrapper = Wrappers.lambdaQuery(BdJobCate.class)
                .eq(BdJobCate::getCateType, JobNodeType.JOB.getType());

        if(!StringUtils.isEmpty(keyword)){
            wrapper.like(BdJobCate::getCateName, keyword)
                    .or()
                    .like(BdJobCate::getCateCode, keyword);
        }
        return getBaseMapper().selectList(wrapper);
    }

    @Override
    public List<BdJobCate> findJobCatePost(String keyword) {
        LambdaQueryWrapper<BdJobCate> wrapper = Wrappers.lambdaQuery(BdJobCate.class)
                .eq(BdJobCate::getCateType, JobNodeType.POST.getType());

        if(!StringUtils.isEmpty(keyword)){
            wrapper.like(BdJobCate::getCateName, keyword)
                    .or()
                    .like(BdJobCate::getCateCode, keyword);
        }
        return getBaseMapper().selectList(wrapper);
    }

    /**
     * 获取领域下岗位
     * @param DomainId 所属领域
     * @param keyword  名称或编码
     * @return
     */
    @Override
    public List<BdJobCate> findJobCatePost(Long DomainId, String keyword) {
        LambdaQueryWrapper<BdJobCate> wrapper = Wrappers.lambdaQuery(BdJobCate.class)
                .eq(BdJobCate::getParentId, DomainId)
                .eq(BdJobCate::getCateType, JobNodeType.POST.getType());

        if(!StringUtils.isEmpty(keyword)){
            wrapper.like(BdJobCate::getCateName, keyword)
                    .or()
                    .like(BdJobCate::getCateCode, keyword);
        }
        return getBaseMapper().selectList(wrapper);
    }




    @Override
    public List<BdJobCate> get(Collection<String> codes) {

        if(CollectionUtils.isEmpty(codes)) {
            return Collections.emptyList();
        }

        return list(Wrappers.lambdaQuery(BdJobCate.class).in(BdJobCate::getCateCode, codes));

    }

    @Override
    public String getFullTreePathById(Long id) {
        BdJobCate jobCate = this.get(id);
        String treeCode = jobCate.getTreeCode();
        List<String> treeCodes = splitTreeCode(treeCode);

        List<BdJobCate> bdJobCates = getJobNodes(treeCodes);
        Map<String, String> jobCateMap = new HashMap<>();
        for (BdJobCate bdJobCate : bdJobCates) {
            jobCateMap.put(bdJobCate.getTreeCode(), bdJobCate.getCateName());
        }

        StringBuffer treePath = new StringBuffer();
        for (String code : treeCodes) {
            treePath.append("-").append(jobCateMap.get(code));
        }

        return treePath.length() > 0 ? treePath.substring(1) : "";

    }

    @Override
    public List<BdJobCate> getFullJobCateById(Long id) {
        BdJobCate jobCate = this.get(id);
        String treeCode = jobCate.getTreeCode();
        List<String> treeCodes = splitTreeCode(treeCode);

        List<BdJobCate> bdJobCates = getJobNodes(treeCodes);
        Map<String, BdJobCate> jobCateMap = new HashMap<>();
        for (BdJobCate bdJobCate : bdJobCates) {
            jobCateMap.put(bdJobCate.getTreeCode(), bdJobCate);
        }

        List<BdJobCate> jobCates = new ArrayList<>();
        for (String code : treeCodes) {
            jobCates.add(jobCateMap.get(code));
        }

        return jobCates;
    }

    @Override
    public List<BdJobCate> findAllJobCatePost() {
        LambdaQueryWrapper<BdJobCate> wrapper = Wrappers.lambdaQuery(BdJobCate.class)
                .eq(BdJobCate::getCateType, JobNodeType.POST.getType());

        return getBaseMapper().selectList(wrapper);
    }

    private List<BdJobCate> getJobNodes(List<String> treeCodes) {
        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField("treeCode");
        queryItem.setType(QueryType.in);
        queryItem.setValue(treeCodes);
        queryItems.add(queryItem);
        List<BdJobCate> jobCates = this.get(queryItems);

        return jobCates;
    }

    private List<String> splitTreeCode(String treeCode) {
        List<String> treeCodeList = new ArrayList<>();
        String thisLvlPath = "";
        for (int i = 0; i < treeCode.length(); i=i+4) {
            thisLvlPath += treeCode.substring(i, i+4);
            treeCodeList.add(thisLvlPath);
        }

        return treeCodeList;
    }
}