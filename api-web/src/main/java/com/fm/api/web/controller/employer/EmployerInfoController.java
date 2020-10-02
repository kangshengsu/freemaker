/**
* @filename:EmployerInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.employer;

import com.fm.api.web.vo.freelancer.FreelancerInfoVO;
import com.fm.business.base.model.EmployerInfo;
import com.fm.business.base.model.freelancer.FreelancerInfo;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    /**
     * 根据名字和电话模糊查找数据最多返回10条
     * @param
     * @return
     */
    @RequestMapping(value = "/findLikeNameOrPhone",method = RequestMethod.GET)
    public ApiResponse<List<EmployerInfoVO>> findLikeNameOrPhone(@RequestParam("keyWord") String keyWord) {

        List<EmployerInfo> employerInfos = employerInfoService.findLikeNameOrPhone(keyWord);

        return success(convert(employerInfos));

    }

    /**
     * 根据id获取信息
     */
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public ApiResponse<EmployerInfoVO> list(@RequestParam("id") Long id) {
        return success(convert(employerInfoService.get(id)));
    }

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
