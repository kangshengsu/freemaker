/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.gw.controller;

import com.fm.api.gw.vo.JobCateVO;
import com.fm.api.gw.vo.JobSkillVO;
import com.fm.api.gw.vo.JobTagVO;
import com.fm.business.base.enums.TagStatus;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobSkill;
import com.fm.business.base.model.job.BdJobTag;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.IBdJobSkillService;
import com.fm.business.base.service.IBdJobTagService;
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
import java.util.Collections;
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
@RequestMapping("/v1/jobTag")
public class JobTagApi extends BaseController<BdJobTag, JobTagVO> {

    @Autowired
    private IBdJobTagService bdJobTagService;

    @RequestMapping(value = "getAllTag",method = RequestMethod.GET)
    public ApiResponse<List<JobTagVO>> getAllTag() {
        QueryItem item = new QueryItem();
        item.setQueryField("status");
        item.setValue(TagStatus.ENABLE.getCode());
        item.setType(QueryType.eq);
        ArrayList<QueryItem> queryList = new ArrayList();
        queryList.add(item);

        return ApiResponse.ofSuccess(this.convert(bdJobTagService.get(queryList)));
    }


    @RequestMapping(value = "getTagByJobCateId",method = RequestMethod.GET)
    public ApiResponse<List<JobTagVO>> getTagByJobCateId(@RequestParam("jobCateId") Long jobCateId) {
        if (jobCateId == null) {
            return ApiResponse.ofSuccess(Collections.emptyList());
        }
        return ApiResponse.ofSuccess(this.convert(bdJobTagService.getTagByJobCateId(jobCateId)));
    }


    @Override
    protected Service<BdJobTag> service() {
        return bdJobTagService;
    }
}
