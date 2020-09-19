/**
 * @filename:BdJobCateService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service;

import com.fm.business.base.model.job.BdJobCate;
import com.fm.framework.core.service.Service;

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
     * 获取领域下岗位
     * @param DomainId 所属领域
     * @param keyword  名称或编码
     * @return
     */
    List<BdJobCate> findJobCatePost(Long DomainId,String keyword);
}