/**
* @filename:BdJobSkillController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.tag;

import com.fm.api.web.vo.job.BdJobTagVO;
import com.fm.business.base.enums.TagStatus;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobSkill;
import com.fm.business.base.model.job.BdJobTag;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.IBdJobSkillService;
import com.fm.business.base.service.IBdJobTagService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*
* <p>说明： 岗位标签API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/tag/bdJobTag")
public class BdJobTagController extends BaseController<BdJobTag, BdJobTagVO> {

    @Autowired
    private IBdJobTagService bdJobTagService;

    @Autowired
    private IBdJobCateService jobCateService;

    @Autowired
    private IBdJobSkillService jobSkillService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody BdJobTagVO form) {

        return super.create(form);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody BdJobTagVO form) {
        return super.update(form);
    }

    @RequestMapping(value = "getJobTagById",method = RequestMethod.GET)
    public ApiResponse<BdJobTagVO> getJobTagById(Long id) {
        return this.success(this.convert(bdJobTagService.get(id)));
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<BdJobTagVO>> list(@RequestBody QueryRequest queryRequest) {
        ApiResponse<Page<BdJobTagVO>> result = super.list(queryRequest);
        List<Long> cateIds = new ArrayList<>();
        List<Long> skillIds = new ArrayList<>();
        for (BdJobTagVO jobTagVO : result.getData().getData()) {
            jobTagVO.setStatusName(TagStatus.get(jobTagVO.getStatus()).getName());

            cateIds.add(jobTagVO.getJobCateId());
            skillIds.add(jobTagVO.getSkillId());
        }

        List<BdJobCate> jobCates = jobCateService.getByIds(cateIds);
        List<BdJobSkill> jobSkills = jobSkillService.getByIds(skillIds);
        Map<Long, BdJobCate> cateMap = new HashMap();
        Map<Long, BdJobSkill> skillMap = new HashMap();
        for (BdJobCate jobCate : jobCates) {
           cateMap.put(jobCate.getId(), jobCate);
        }

        for (BdJobSkill jobSkill : jobSkills) {
            skillMap.put(jobSkill.getId(), jobSkill);
        }

        for (BdJobTagVO jobTagVO : result.getData().getData()) {
            if (cateMap.containsKey(jobTagVO.getJobCateId())) {
                jobTagVO.setJobCateName(cateMap.get(jobTagVO.getJobCateId()).getCateName());
            }

            if (skillMap.containsKey(jobTagVO.getSkillId())) {
                jobTagVO.setSkillName(skillMap.get(jobTagVO.getSkillId()).getSkillName());
            }
        }

        return result;
    }

    @Override
    protected Service<BdJobTag> service() {
        return bdJobTagService;
    }

}
