/**
* @filename:BdJobSkillController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller;

import com.fm.business.base.model.BdJobSkill;
import com.fm.framework.core.query.Page;
import com.fm.business.base.service.IBdJobSkillService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.api.web.vo.BdJobSkillVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*
* <p>说明： 岗位技能API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/bdJobSkill")
public class BdJobSkillController extends BaseController<BdJobSkill, BdJobSkillVO> {

    @Autowired
    @Qualifier("bdJobSkillService")
    private IBdJobSkillService bdJobSkillService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody BdJobSkillVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody BdJobSkillVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<BdJobSkillVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<BdJobSkill> service() {
        return bdJobSkillService;
    }

    @Override
    protected BdJobSkill convert(BdJobSkillVO form) {
        BdJobSkill model = new BdJobSkill();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected BdJobSkillVO convert(BdJobSkill model) {
        BdJobSkillVO form = new BdJobSkillVO();
        BeanUtils.copyProperties(model,form);
        return form;
    }

}