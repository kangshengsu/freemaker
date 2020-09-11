/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.framework.web.controller;

import com.fm.framework.core.model.BdJobCate;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.IBdJobCateService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.vo.BdJobCateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*
* <p>说明： 岗位API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/bdJobCate")
public class BdJobCateController extends BaseController<BdJobCate, BdJobCateVO>{

    @Autowired
    @Qualifier("bdJobCateService")
    private IBdJobCateService bdJobCateService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody BdJobCateVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody BdJobCateVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<BdJobCateVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<BdJobCate> service() {
        return bdJobCateService;
    }

    @Override
    protected BdJobCate convert(BdJobCateVO form) {
        BdJobCate model = new BdJobCate();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected BdJobCateVO convert(BdJobCate model) {
        BdJobCateVO form = new BdJobCateVO();
        BeanUtils.copyProperties(model,form);
        return form;
    }

}