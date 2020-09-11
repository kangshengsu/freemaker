/**
* @filename:DemandProductionRelationController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.framework.web.controller;

import com.fm.framework.core.model.DemandProductionRelation;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.IDemandProductionRelationService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.vo.DemandProductionRelationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*
* <p>说明： 需求作品关系API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/demandProductionRelation")
public class DemandProductionRelationController extends BaseController<DemandProductionRelation, DemandProductionRelationVO>{

    @Autowired
    @Qualifier("demandProductionRelationService")
    private IDemandProductionRelationService demandProductionRelationService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody DemandProductionRelationVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody DemandProductionRelationVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<DemandProductionRelationVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<DemandProductionRelation> service() {
        return demandProductionRelationService;
    }

    @Override
    protected DemandProductionRelation convert(DemandProductionRelationVO form) {
        DemandProductionRelation model = new DemandProductionRelation();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected DemandProductionRelationVO convert(DemandProductionRelation model) {
        DemandProductionRelationVO form = new DemandProductionRelationVO();
        BeanUtils.copyProperties(model,form);
        return form;
    }

}