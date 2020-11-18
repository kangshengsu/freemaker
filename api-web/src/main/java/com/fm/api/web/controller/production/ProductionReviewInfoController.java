/**
* @filename:ProductionReviewInfoController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.production;

import com.fm.api.web.vo.production.ProductionReviewInfoVO;
import com.fm.business.base.enums.ProductionReviewStatus;
import com.fm.business.base.model.production.ProductionReviewInfo;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.service.production.IProductionReviewInfoService;
import com.fm.business.base.service.sm.IUserService;
import com.fm.business.base.service.sys.ISysUserService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
*
* <p>说明： 作品审核API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/production/productionReviewInfo")
public class ProductionReviewInfoController extends BaseController<ProductionReviewInfo, ProductionReviewInfoVO> {

    @Autowired
    private IProductionReviewInfoService productionReviewInfoService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IUserService iUserService;

    /**
     * 审核通过
     * @param form
     * @return
     */
    @RequestMapping(value = "/reviewPass",method = RequestMethod.POST)
    public ApiResponse<Boolean> reviewPass(@Valid @RequestBody ProductionReviewInfoVO form) {
        boolean result = productionReviewInfoService.review(convert(form), ProductionReviewStatus.REVIEW_PASS);
        if(!result){
            return failed("操作失败");
        }
        return success(Boolean.TRUE);

    }

    /**
     * 审核失败
     * @param form
     * @return
     */
    @RequestMapping(value = "/reviewNotPass",method = RequestMethod.POST)
    public ApiResponse<Boolean> reviewNotPass(@Valid @RequestBody ProductionReviewInfoVO form) {
        boolean result = productionReviewInfoService.review(convert(form), ProductionReviewStatus.REVIEW_NOT_PASS);
        if(!result){
            return failed("操作失败");
        }
        return success(Boolean.TRUE);

    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody ProductionReviewInfoVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody ProductionReviewInfoVO form) {

        return super.update(form);

    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ApiResponse<Page<ProductionReviewInfoVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }


    @Override
    protected Service<ProductionReviewInfo> service() {
        return productionReviewInfoService;
    }


    @Override
    protected ProductionReviewInfoVO convert(ProductionReviewInfo model) {

        ProductionReviewInfoVO form = super.convert(model);
        //获取审核人信息
        form.setStatusName(ProductionReviewStatus.get(model.getStatus()).getName());

        //获取作者数据
        User user = iUserService.get(model.getReviewerId());
        if( user != null ){
            form.setReviewerName(user.getName());
        }

        return form;
    }

}