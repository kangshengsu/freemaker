/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.job;

import com.fm.api.web.vo.job.BdJobCateVO;
import com.fm.api.web.vo.job.BdJobSkillVO;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobSkill;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.IBdJobSkillService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
public class BdJobCateController extends BaseController<BdJobCate, BdJobCateVO> {

    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IBdJobSkillService bdJobSkillService;

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

    @RequestMapping(value = "treeData",method = RequestMethod.GET)
    public ApiResponse<Page<BdJobCateVO>> treeData() {
        List<BdJobCateVO> bdJobCateVOs = bdJobCateService.getAll().stream().map(this::convert).collect(Collectors.toList());
        List<BdJobSkillVO> bdJobSkillVOs = bdJobSkillService.getAll().stream().map(this::skillConvert).collect(Collectors.toList());

        return null;
    }

    @Override
    protected Service<BdJobCate> service() {
        return bdJobCateService;
    }

    protected BdJobSkillVO skillConvert(BdJobSkill form) {
        BdJobSkillVO model = new BdJobSkillVO();
        BeanUtils.copyProperties(form,model);
        return model;
    }

}