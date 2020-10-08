/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller;

import com.fm.api.gw.vo.JobCateVO;
import com.fm.api.gw.vo.JobSkillVO;
import com.fm.business.base.enums.JobNodeType;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobSkill;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.IBdJobSkillService;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.TreeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
*
* <p>说明： 岗位API接口层</p>
* @version: V1.0
* @author: kangshengsu
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/v1/jobTree")
public class JobTreeApi extends BaseController<BdJobCate, JobCateVO> {

    @Autowired
    private IBdJobCateService bdJobCateService;
    @Autowired
    private IBdJobSkillService bdJobSkillService;

    @RequestMapping(value = "treeData",method = RequestMethod.GET)
    public ApiResponse<List<TreeNode<JobCateVO>>> treeData() {
        List<BdJobCate> bdJobCateVOs = bdJobCateService.getAll();
        if(CollectionUtils.isEmpty(bdJobCateVOs)){
            return ApiResponse.ofSuccess(new ArrayList<>(0));
        }
        TreeNode<JobCateVO> treeRoot = TreeUtil.buildTree(convert(bdJobCateVOs));
        TreeUtil.setParentNull(treeRoot);
        return ApiResponse.ofSuccess(treeRoot.getChilds());
    }

    @RequestMapping(value = "getSkillList",method = RequestMethod.GET)
    public ApiResponse<List<JobSkillVO>> getSkillList(@RequestParam(value="jobCateId") Long jobCateId) {
        QueryItem item = new QueryItem();
        item.setQueryField("jobCateId");
        item.setValue(jobCateId);
        item.setType(QueryType.eq);
        ArrayList<QueryItem> queryList = new ArrayList();
        queryList.add(item);
        List<BdJobSkill> bdJobSkills = bdJobSkillService.get(queryList);
        if(CollectionUtils.isEmpty(bdJobSkills)){
            return ApiResponse.ofSuccess(new ArrayList<>(0));
        }

        return ApiResponse.ofSuccess(
                bdJobSkills.stream()
                        .map(this::bdJobSill2JobSkillVO)
                        .collect(Collectors.toList())
        );
    }

    private JobSkillVO bdJobSill2JobSkillVO(BdJobSkill bdJobSkill){
        JobSkillVO jobSkillVO = new JobSkillVO();
        BeanUtils.copyProperties(bdJobSkill,jobSkillVO);
        return jobSkillVO;
    }

    @RequestMapping(value = "getJobList",method = RequestMethod.GET)
    public ApiResponse<List<JobCateVO>> getJobList(Integer jobType) {
        List<QueryItem> queryItems = new ArrayList<>();
        QueryItem item = new QueryItem();
        item.setQueryField("cateType");
        item.setType(QueryType.eq);
        item.setValue(jobType);
        queryItems.add(item);
        List<JobCateVO> jobCateVOS = this.convert(bdJobCateService.get(queryItems));
        return ApiResponse.ofSuccess(jobCateVOS);
    }



    @Override
    protected Service<BdJobCate> service() {
        return bdJobCateService;
    }


}
