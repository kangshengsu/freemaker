/**
* @filename:SysBaseDictController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.sys;

import com.fm.business.base.constant.BaseDictGroupConstants;
import com.fm.business.base.model.sys.SysBaseDict;
import com.fm.framework.core.query.Page;
import com.fm.business.base.service.sys.ISysBaseDictService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.api.web.vo.sys.SysBaseDictVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
*
* <p>说明： 基础字典API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/sysBaseDict")
public class SysBaseDictController extends BaseController<SysBaseDict, SysBaseDictVO>{

    @Autowired
    private ISysBaseDictService sysBaseDictService;



    @RequestMapping(value = "/getByGroup",method = RequestMethod.POST)
    public ApiResponse<List<SysBaseDictVO>> create(@RequestBody Integer group) {
        if(BaseDictGroupConstants.get(group) == null){
            return failed("无效分组,请检查！");
        }
        List<SysBaseDictVO> sysBaseDictVOS = convert(sysBaseDictService.findByBelongGroup(BaseDictGroupConstants.get(group)));
        if(sysBaseDictVOS == null || sysBaseDictVOS.isEmpty()){
            return failed("未获取到字典数据");
        }
        //树形结果转换

        return success(sysBaseDictVOS);

    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody SysBaseDictVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody SysBaseDictVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ApiResponse<Page<SysBaseDictVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<SysBaseDict> service() {
        return sysBaseDictService;
    }
                

}