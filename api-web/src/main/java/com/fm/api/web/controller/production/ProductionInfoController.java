/**
* @filename:ProductionInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.production;

import com.fm.business.base.enums.ProductionStatus;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.freelancer.IFreelancerInfoService;
import com.fm.framework.core.query.Page;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.api.web.vo.production.ProductionInfoVO;
import com.fm.framework.web.response.ApiStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/production/productionInfo")
public class ProductionInfoController extends BaseController<ProductionInfo, ProductionInfoVO> {

    @Autowired
    private IProductionInfoService productionInfoService;

    @Autowired
    private IFreelancerInfoService freelancerInfoService;

    @Autowired
    private IBdJobCateService bdJobCateService;


    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody ProductionInfoVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody ProductionInfoVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ApiResponse<Page<ProductionInfoVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<ProductionInfo> service() {
        return productionInfoService;
    }


    @Override
    protected ProductionInfoVO convert(ProductionInfo model) {
        ProductionInfoVO form = super.convert(model);
        //转换枚举值
        form.setStatusName(ProductionStatus.get(model.getStatus()).getName());
        //获取作者数据
        form.setFreelancerInfo(freelancerInfoService.get(model.getFreelancerId()));
        //获取岗位加领域
        BdJobCate jobCate = bdJobCateService.get(model.getJobCateId());
        form.setJobCateName(jobCate.getCateName());

        return form;
    }

}