/**
 * @filename:ProductionSkillRelationService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.production;

import com.fm.business.base.model.production.ProductionSkillRelation;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:(作品技能关系服务层)
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
public interface IProductionSkillRelationService extends Service<ProductionSkillRelation> {

    /**
     * 根据产品编码获取技能
     * @param ids
     * @return  map( k , v)  k-> productionId  v-> skills
     */
    Map<Long,List<ProductionSkillRelation>> getByProductionIds(Set<Long> ids);

    /**
     * 根据作品删除
     * @param productionId
     * @return
     */
    boolean deleteByProductionId(Long productionId);

    /**
     * 根据技能ID分页获取技能和作品关系
     * @param currentPage
     * @param pageSize
     * @param cateSkill 技能ID
     * @return
     */
    Page<ProductionSkillRelation> findByCateSkill(Integer currentPage, Integer pageSize, Long cateSkill);
}