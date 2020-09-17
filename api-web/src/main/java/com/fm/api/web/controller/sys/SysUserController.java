/**
* @filename:SysUserController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.sys;

import com.fm.business.base.model.sys.SysUser;
import com.fm.framework.core.query.Page;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.api.web.vo.sys.SysUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
*
* <p>说明： 用户API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController<SysUser, SysUserVO>{

    @Autowired
    private ISysUserService sysUserService;


    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody SysUserVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody SysUserVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<SysUserVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<SysUser> service() {
        return sysUserService;
    }

    @Override
    protected SysUser convert(SysUserVO form) {
        SysUser model = new SysUser();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected SysUserVO convert(SysUser model) {
        SysUserVO form = new SysUserVO();
        BeanUtils.copyProperties(model,form);
        return form;
    }

}