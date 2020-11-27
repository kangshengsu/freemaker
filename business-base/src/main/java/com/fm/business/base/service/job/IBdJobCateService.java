/**
 * @filename:BdJobCateService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.job;

import com.fm.business.base.model.job.BdJobCate;
import com.fm.framework.core.service.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Description:(岗位服务层)
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
public interface IBdJobCateService extends Service<BdJobCate> {

    /**
     * 获取全部领域
     * @param keyword 名称或编码
     * @return
     */
    List<BdJobCate> findJobCateDomain(String keyword);

    /**
     * 获取全部领域
     * @param keyword 名称或编码
     * @return
     */
    List<BdJobCate> findJobCatePost(String keyword);


    /**
     * 获取领域下岗位
     * @param DomainId 所属领域
     * @param keyword  名称或编码
     * @return
     */
    List<BdJobCate> findJobCatePost(Long DomainId,String keyword);

    /**
     * 根据领域、岗位编码获取实体对象集合
     * @param codes 编码集合
     * @return 实体对象集合
     */
    List<BdJobCate> get(Collection<String> codes);

    String getFullTreePathById(Long id);

    List<BdJobCate> getFullJobCateById(Long id);

    /**
     * 获取全部岗位
     * @return 岗位集合
     */
    List<BdJobCate> findAllJobCatePost();

    /**
     * 获取技能两级名称
     * @param id
     * @return
     */
    BdJobCate getJobCate(Long id);

    List<BdJobCate> getParentJobCateByParentId(List<Long> parentIds);

    List<BdJobCate> getFirstJobCate();

    BdJobCate getByParentId(Long id);


    List<Long> getSecondJobCate(Long cateJobId);
    /**
     * 查询一级类目下所有种类
     * @param id
     * @return
     */
    List<BdJobCate> findByParentId(Integer id);

}