package com.fm.api.gw.controller.advert;

import com.fm.api.gw.vo.advert.AdvertInfoVO;
import com.fm.api.gw.vo.advert.mapper.AdvertInfoMapper;
import com.fm.business.base.model.advert.AdvertInfo;
import com.fm.business.base.service.advert.AdvertInfoService;
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
 * @date 2020/12/24 下午7:20
 */
@RestController
@RequestMapping("/v1/advertApi")
@Api(value = "广告位接口")
public class AdvertInfoController extends BaseController<AdvertInfo, AdvertInfoVO> {

    @Autowired
    private AdvertInfoService advertInfoService;

    @Autowired
    private AdvertInfoMapper advertInfoMapper;

    @ApiOperation(value = "广告位查询")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ApiResponse<List<AdvertInfoVO>> getDemandCenterPage() {

        List<AdvertInfo> all = advertInfoService.findAll();

        return success(all.stream().map(advertInfo ->
                advertInfoMapper.toAdvertVO(advertInfo)).collect(Collectors.toList()));
    }

    @Override
    protected Service<AdvertInfo> service() {
        return advertInfoService;
    }
}
