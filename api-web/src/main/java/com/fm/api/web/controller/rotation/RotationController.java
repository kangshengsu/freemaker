package com.fm.api.web.controller.rotation;

import com.fm.api.web.vo.rotation.RotationInfoVO;
import com.fm.business.base.model.rotation.RotationInfo;
import com.fm.business.base.service.rotation.RotationService;
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
 * @date 2020/12/25 下午2:18
 */
@RestController
@RequestMapping("/rotation/rotationInfo")
public class RotationController extends BaseController<RotationInfo, RotationInfoVO>  {

    @Autowired
    private RotationService rotationService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ApiResponse<Page<RotationInfoVO>> list(@RequestBody QueryRequest queryRequest){
        return super.list(queryRequest);
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ApiResponse<Boolean> save(@RequestBody RotationInfoVO rotationInfoVO) {
        return super.create(rotationInfoVO);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody RotationInfoVO rotationInfoVO) {
        return super.update(rotationInfoVO);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody RotationInfoVO rotationInfoVO) {

        return super.delete(rotationInfoVO.getId());
    }

    @Override
    protected RotationInfoVO convert(RotationInfo form) {
        RotationInfoVO model = new RotationInfoVO();
        BeanUtils.copyProperties(form,model);
        model.setUpdateUserName(userService.get(model.getUpdateUser()).getName());
        return model;
    }

    @Override
    protected Service<RotationInfo> service() {
        return rotationService;
    }
}
