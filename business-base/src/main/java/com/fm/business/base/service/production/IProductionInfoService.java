/**
 * @filename:ProductionInfoService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.production;

import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Description:(作品服务层)
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
public interface IProductionInfoService extends Service<ProductionInfo> {

    /**
     * 根据作品编码获取作品信息
     * @param codes 作品编码集合
     * @return 作品信息
     */
    List<ProductionInfo> get(Collection<String> codes);

    /**
     * 变更审核状态
     * @param productionInfo
     * @return
     */
    boolean updateStatus(ProductionInfo productionInfo);

    /**
     * 分页获取领域下的所有作品
     * @param currentPage
     * @param pageSize
     * @param cateDomain 领域ID
     * @return
     */
    Page<ProductionInfo> findByCateDomain(Integer currentPage,Integer pageSize,Long cateDomain);


    /**
     * 分页获取岗位下的所有作品
     * @param currentPage
     * @param pageSize
     * @param catePost 岗位ID
     * @return
     */
    Page<ProductionInfo> findByCatePost(Integer currentPage,Integer pageSize,Long catePost);


    /**
     * 分页获取技能下的所有作品
     * @param currentPage
     * @param pageSize
     * @param cateSkill 技能ID
     * @return
     */
    @Deprecated
    Page<ProductionInfo> findByCateSkill(Integer currentPage,Integer pageSize,Long cateSkill);

    /**
     * 分页获取作者下的所有作品
     * @param currentPage
     * @param pageSize
     * @param freelancerId 自由职业者ID
     * @return
     */
    Page<ProductionInfo> findByFreelancer(Integer currentPage, Integer pageSize, Long freelancerId, Collection<Integer> statuses);


}