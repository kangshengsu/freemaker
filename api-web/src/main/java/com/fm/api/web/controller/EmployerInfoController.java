/**
* @filename:EmployerInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller;

import com.fm.business.base.model.EmployerInfo;
import com.fm.framework.core.query.Page;
import com.fm.business.base.service.IEmployerInfoService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.api.web.vo.EmployerInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*
* <p>说明： 雇佣者信息API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/employerInfo")
public class EmployerInfoController extends BaseController<EmployerInfo, EmployerInfoVO> {

    @Autowired
    private IEmployerInfoService employerInfoService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody EmployerInfoVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody EmployerInfoVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<EmployerInfoVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<EmployerInfo> service() {
        return employerInfoService;
    }

    @Override
    protected EmployerInfo convert(EmployerInfoVO form) {
        EmployerInfo model = new EmployerInfo();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected EmployerInfoVO convert(EmployerInfo model) {
        EmployerInfoVO form = new EmployerInfoVO();
        BeanUtils.copyProperties(model,form);
        return form;
    }

}