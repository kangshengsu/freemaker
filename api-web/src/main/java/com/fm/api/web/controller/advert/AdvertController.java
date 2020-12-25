package com.fm.api.web.controller.advert;

import com.fm.api.web.vo.advert.AdvertInfoVO;
import com.fm.business.base.enums.TagStatus;
import com.fm.business.base.model.advert.AdvertInfo;
import com.fm.business.base.service.advert.AdvertInfoService;
import com.fm.business.base.service.sm.IUserService;
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

/**
 * @author G
 * @date 2020/12/24 下午2:11
 */
@RestController
@RequestMapping("/advert/advertInfo")
public class AdvertController extends BaseController<AdvertInfo, AdvertInfoVO> {

    @Autowired
    private AdvertInfoService advertInfoService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<AdvertInfoVO>> list(@RequestBody QueryRequest queryRequest) {
//        OrderItem orderItem = new OrderItem(OrderType.desc, "createTime");
//        queryRequest.setOrderItem(orderItem);
        return super.list(queryRequest);
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ApiResponse<Boolean> save(@RequestBody AdvertInfoVO advertInfoVO) {
        if(advertInfoVO.getStatus().equals(TagStatus.ENABLE.getCode())){
            Integer validCount = advertInfoService.findValidCount();
            if(validCount >= 3){
                return ApiResponse.ofFailed("添加失败，启用数量已达三个！");
            }
        }
        return super.create(advertInfoVO);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody AdvertInfoVO advertInfoVO) {
        if(advertInfoVO.getStatus().equals(TagStatus.ENABLE.getCode())){
            Integer validCount = advertInfoService.findValidCount();
            if(validCount >= 3){
                return ApiResponse.ofFailed("修改失败，启用数量已达三个！");
            }
        }
        return super.update(advertInfoVO);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody AdvertInfoVO advertInfoVO) {

        return super.delete(advertInfoVO.getId());
    }

    @Override
    protected AdvertInfoVO convert(AdvertInfo form) {
        AdvertInfoVO model = new AdvertInfoVO();
        BeanUtils.copyProperties(form,model);
        model.setUpdateUserName(userService.get(model.getUpdateUser()).getName());
        return model;
    }

    @Override
    protected Service<AdvertInfo> service() {
        return advertInfoService;
    }
}
