/**
 * @filename:ProductionSkillRelationServiceImpl 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2018 LiuDuo Co. Ltd. 
 * All right reserved. 
 */
package com.fm.business.base.service.production.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fm.business.base.dao.production.IProductionSkillRelationMapper;
import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.job.BdJobSkill;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.model.production.ProductionSkillRelation;
import com.fm.business.base.service.IBdJobSkillService;
import com.fm.business.base.service.production.IProductionSkillRelationService;
import com.fm.framework.core.service.AuditBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fm.framework.core.service.BaseService;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**   
 * @Description:(作品技能关系服务实现)
 *
 * @version: V1.0
 * @author: LiuDuo
 * 
 */
@Slf4j
@Service("productionSkillRelationService")
public class ProductionSkillRelationServiceImpl extends AuditBaseService<IProductionSkillRelationMapper, ProductionSkillRelation> implements IProductionSkillRelationService {

    @Autowired
    private IBdJobSkillService bdJobSkillService;

    /**
     * 根据产品编码获取技能
     *
     * @param ids
     * @return map(k, v)  k-> productionId  v-> skills
     */
    @Override
    public Map<Long, List<ProductionSkillRelation>> getByProductionIds(Set<Long> ids) {
        if(ids.isEmpty()){
            return new HashMap<>();
        }

        List<ProductionSkillRelation> skillRelations = list(Wrappers.lambdaQuery(ProductionSkillRelation.class)
                .in(ProductionSkillRelation::getProductionId,ids));

        fillRelation(skillRelations);

        return skillRelations.stream().collect(Collectors.toMap(ProductionSkillRelation::getProductionId, v -> {
                    List<ProductionSkillRelation> list = new ArrayList<>();
                    list.add(v);
                    return list;
                }, (v1, v2) -> {
                    v1.addAll(v2);
                    return v1;
                }));
    }




    /**
     * 补全数据
     * @param productionSkillRelations
     */
    private void fillRelation(Collection<ProductionSkillRelation> productionSkillRelations) {
        if(CollectionUtils.isEmpty(productionSkillRelations)){
            return;
        }

        Set<Long> skillIds = new HashSet<>();

        productionSkillRelations.forEach(productionSkillRelation -> {
            skillIds.add(productionSkillRelation.getJobSkillId());
        });

        Map<Long,BdJobSkill> bdJobSkillMap = bdJobSkillService.getByIds(skillIds).stream()
                .collect(Collectors.toMap(BdJobSkill::getId, Function.identity(), (v1, v2) -> v2));

        productionSkillRelations.forEach(productionSkillRelation -> {
            if(bdJobSkillMap.containsKey(productionSkillRelation.getJobSkillId())){
                productionSkillRelation.setJobSkillName(bdJobSkillMap.get(productionSkillRelation.getJobSkillId()).getSkillName());
            }
        });


    }


}