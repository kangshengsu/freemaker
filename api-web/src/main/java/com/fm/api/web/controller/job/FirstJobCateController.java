package com.fm.api.web.controller.job;

import com.fm.api.web.vo.job.BdJobCateVO;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.CodeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.print.SunPrinterJobService;

import javax.swing.*;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/20 17:19
 */
@RestController
@RequestMapping(value = "/job/firstJobCate")
public class FirstJobCateController extends BaseController<BdJobCate, BdJobCateVO> {
    @Autowired
    private IBdJobCateService bdJobCateService;

    @Override
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<BdJobCateVO>> list(@RequestBody QueryRequest queryRequest){
        ApiResponse<Page<BdJobCateVO>> list = super.list(queryRequest);
        return list;
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody BdJobCateVO bdJobCateVO){
        if (StringUtils.isBlank(bdJobCateVO.getCateCode())){
            bdJobCateVO.setCateCode(CodeUtil.generateNewCode2yyMMddHH());
        }
        return super.create(bdJobCateVO);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ApiResponse<Boolean> update (@RequestBody BdJobCateVO BdJobCateVO){
           return super.update(BdJobCateVO);
    }

    @RequestMapping(value = "deleteById",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody BdJobCateVO form){

            if (Optional.ofNullable(bdJobCateService.getByParentId(form.getParentId()))
                    .map(Objects::nonNull)
                    .orElse(false)){
                return ApiResponse.of(ApiStatus.FAILED,"不能删除有二级类目的一级类目");
            }

        return super.delete(form.getParentId());
    }

    @Override
    protected Service<BdJobCate> service() {
        return bdJobCateService;
    }
}
