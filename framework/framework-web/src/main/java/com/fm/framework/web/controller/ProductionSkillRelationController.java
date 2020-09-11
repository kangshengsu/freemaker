/**
* @filename:ProductionSkillRelationController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.framework.web.controller;

import com.fm.framework.core.model.ProductionSkillRelation;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.IProductionSkillRelationService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.vo.ProductionSkillRelationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*
* <p>说明： 作品技能关系API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/productionSkillRelation")
public class ProductionSkillRelationController extends BaseController<ProductionSkillRelation, ProductionSkillRelationVO>{

    @Autowired
    @Qualifier("productionSkillRelationService")
    private IProductionSkillRelationService productionSkillRelationService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody ProductionSkillRelationVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody ProductionSkillRelationVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<ProductionSkillRelationVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<ProductionSkillRelation> service() {
        return productionSkillRelationService;
    }

    @Override
    protected ProductionSkillRelation convert(ProductionSkillRelationVO form) {
        ProductionSkillRelation model = new ProductionSkillRelation();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected ProductionSkillRelationVO convert(ProductionSkillRelation model) {
        ProductionSkillRelationVO form = new ProductionSkillRelationVO();
        BeanUtils.copyProperties(model,form);
        return form;
    }

}