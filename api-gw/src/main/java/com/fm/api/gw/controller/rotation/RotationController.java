package com.fm.api.gw.controller.rotation;

import com.fm.api.gw.vo.rotation.RotationInfoVO;
import com.fm.api.gw.vo.rotation.mapper.RotationMapper;
import com.fm.business.base.model.rotation.RotationInfo;
import com.fm.business.base.service.rotation.RotationService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author G
 * @date 2020/12/25 下午4:08
 */
@RestController
@RequestMapping("/v1/rotationApi")
@Api(description = "轮播接口")
public class RotationController extends BaseController<RotationInfo, RotationInfoVO>  {

    @Autowired
    private RotationService rotationService;

    @Autowired
    private RotationMapper rotationMapper;

    @ApiOperation(value = "轮播查询")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ApiResponse<List<RotationInfoVO>> list() {

        List<RotationInfo> all = rotationService.findAll();

        return success(all.stream().map(RotationInfo ->
                rotationMapper.toRotationVO(RotationInfo)).collect(Collectors.toList()));
    }

    @Override
    protected Service<RotationInfo> service() {
        return rotationService;
    }
}
