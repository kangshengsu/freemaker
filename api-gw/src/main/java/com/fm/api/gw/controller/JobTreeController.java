/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller;

import com.fm.api.gw.vo.JobCateVO;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.TreeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
*
* <p>说明： 岗位API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/jobTree")
public class JobTreeController extends BaseController<BdJobCate, JobCateVO> {

    @Autowired
    private IBdJobCateService bdJobCateService;

    @RequestMapping(value = "treeData",method = RequestMethod.GET)
    public ApiResponse<List<TreeNode<JobCateVO>>> treeData() {
        List<BdJobCate> bdJobCateVOs = bdJobCateService.getAll();
        if(CollectionUtils.isEmpty(bdJobCateVOs)){
            return ApiResponse.ofSuccess(new ArrayList(0));
        }
        TreeNode<JobCateVO> treeRoot = TreeUtil.buildTree(convert(bdJobCateVOs));
        TreeUtil.setParentNull(treeRoot);
        return ApiResponse.ofSuccess(treeRoot.getChilds());
    }

    @Override
    protected Service<BdJobCate> service() {
        return bdJobCateService;
    }


}
