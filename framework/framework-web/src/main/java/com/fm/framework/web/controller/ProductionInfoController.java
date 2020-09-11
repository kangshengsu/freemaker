/**
* @filename:ProductionInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.framework.web.controller;

import com.fm.framework.core.model.ProductionInfo;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.IProductionInfoService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.vo.ProductionInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*
* <p>说明： 作品API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/productionInfo")
public class ProductionInfoController extends BaseController<ProductionInfo, ProductionInfoVO>{

    @Autowired
    @Qualifier("productionInfoService")
    private IProductionInfoService productionInfoService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody ProductionInfoVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody ProductionInfoVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<ProductionInfoVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<ProductionInfo> service() {
        return productionInfoService;
    }

    @Override
    protected ProductionInfo convert(ProductionInfoVO form) {
        ProductionInfo model = new ProductionInfo();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected ProductionInfoVO convert(ProductionInfo model) {
        ProductionInfoVO form = new ProductionInfoVO();
        BeanUtils.copyProperties(model,form);
        return form;
    }

}