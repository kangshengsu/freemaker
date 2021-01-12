package com.fm.api.web.controller.demand;

import cn.hutool.core.util.ObjectUtil;
import com.fm.api.web.vo.demand.DemandRemarkInfoVO;
import com.fm.business.base.model.demand.DemandRemarkInfo;
import com.fm.business.base.service.demand.IDemandRemarkInfoService;
import com.fm.business.base.service.sm.IUserService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/12 11:06
 */
@RequestMapping("demand/demandRemarkInfo")
@RestController
public class DemandRemarkInfoController extends BaseController<DemandRemarkInfo, DemandRemarkInfoVO> {
    @Autowired
    private IDemandRemarkInfoService demandRemarkInfoService;

    @Autowired
    private IUserService userService;

    @PostMapping("create")
    public ApiResponse<Boolean> create(@RequestBody DemandRemarkInfoVO demandRemarkInfoVO){
        return super.create(demandRemarkInfoVO);
    }

    @PostMapping("list")
    public ApiResponse<Page<DemandRemarkInfoVO>> list(@RequestBody QueryRequest queryRequest){
        if (ObjectUtil.isNull(queryRequest)) {
            return null;
        }
        ApiResponse<Page<DemandRemarkInfoVO>> list = super.list(queryRequest);
        list.getData().getData().forEach(demandRemarkInfoVO -> {
              demandRemarkInfoVO.setUserName(userService.get(demandRemarkInfoVO.getCreateUser()).getName());
        });
        return list;
    }

    @Override
    protected Service<DemandRemarkInfo> service() {
        return demandRemarkInfoService;
    }
}
