/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.job;

import com.fm.api.web.vo.job.BdJobCateVO;
import com.fm.api.web.vo.job.BdJobSkillVO;
import com.fm.api.web.vo.job.JobNodeVO;
import com.fm.business.base.enums.JobNodeType;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobSkill;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.job.IBdJobSkillService;
import com.fm.business.base.service.conf.impl.DisplayConfigServiceImpl;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.CodeUtil;
import com.fm.framework.core.utils.TreeIncodeUtil;
import com.fm.framework.core.utils.TreeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
*
* <p>说明： 岗位API接口层</p>
* @version: V1.0
* @author: LiuDuo
* @time    2020年09月11日
*
*/

@RestController
@RequestMapping("/job/bdJobCate")
public class BdJobCateController extends BaseController<BdJobCate, BdJobCateVO> {

    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private IBdJobSkillService bdJobSkillService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DisplayConfigServiceImpl displayConfigService;




    /**
     * 获取领域数据
     * @param form
     * @return
     */
    @RequestMapping(value = "/findJobCateDomain",method = RequestMethod.POST)
    public ApiResponse<List<BdJobCateVO>> findJobCateDomain(@RequestBody BdJobCateVO form) {
        return success(convert(bdJobCateService.findJobCateDomain(form.getKeyword())));
    }

    /**
     * 获取领域下的岗位数据
     * @param form
     * @return
     */
    @RequestMapping(value = "/findJobCatePost",method = RequestMethod.POST)
    public ApiResponse<List<BdJobCateVO>> findJobCatePost(@RequestBody BdJobCateVO form) {
        List<BdJobCateVO> a = convert(bdJobCateService.findJobCatePost(form.getParentId(),form.getKeyword()));
        return success(convert(bdJobCateService.findJobCatePost(form.getParentId(),form.getKeyword())));
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody BdJobCateVO form) {

        return super.create(form);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody BdJobCateVO newNode) {
        return saveJob(newNode, false);
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<BdJobCateVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }

    /**
     * 获取技能两级名称
     * @param form
     * @return
     */
    @RequestMapping(value = "findJobCate", method = RequestMethod.POST)
    public ApiResponse<String> findJobCate(@RequestBody BdJobSkillVO form){
        BdJobCate jobCate1 = bdJobCateService.getJobCate(form.getJobCateId());
        BdJobCate jobCate2 = bdJobCateService.getJobCate(jobCate1.getParentId());
        return ApiResponse.ofSuccess(jobCate2.getCateName()+"-"+jobCate1.getCateName());
    }

    @RequestMapping(value = "treeData",method = RequestMethod.GET)
    public ApiResponse<List<JobNodeVO>> treeData() {
        List<BdJobCateVO> bdJobCateVOs = bdJobCateService.getAll().stream().map(this::convert).collect(Collectors.toList());
        List<BdJobSkillVO> bdJobSkillVOs = bdJobSkillService.getAll().stream().map(this::skillConvert).collect(Collectors.toList());

        List<JobNodeVO> treeNodeList = makeTreeCateList(bdJobCateVOs);
        JobNodeVO treeNode;
        for (BdJobSkillVO bdJobSkillVO : bdJobSkillVOs) {
            treeNode = new JobNodeVO();
            treeNode.setJobId(bdJobSkillVO.getId());
            treeNode.setCode(bdJobSkillVO.getSkillCode());
            treeNode.setEnglishName(bdJobSkillVO.getEnglishName());
            treeNode.setIcon(bdJobSkillVO.getIcon());
            treeNode.setLabel(bdJobSkillVO.getSkillName());
            treeNode.setTreeCode(bdJobSkillVO.getTreeCode());
            treeNode.setCateType(JobNodeType.SKILL.getType());
            treeNode.setParentId(bdJobSkillVO.getJobCateId());
            treeNode.setParentCode(bdJobSkillVO.getCateTreeCode());

            treeNodeList.add(treeNode);
        }

        return ApiResponse.ofSuccess(Arrays.asList(transferTree(treeNodeList)));
    }


    /**
     * 获取只有领域岗位技能树
     * @return
     */
    @RequestMapping(value = "treeDataWithoutSkill",method = RequestMethod.GET)
    public ApiResponse<List<JobNodeVO>> treeDataWithoutSkill() {
        List<BdJobCateVO> bdJobCateVOs = bdJobCateService.getAll().stream().map(this::convert).collect(Collectors.toList());
        return ApiResponse.ofSuccess(Arrays.asList(transferTree(makeTreeCateList(bdJobCateVOs))));
    }

    @RequestMapping(value = "addJob",method = RequestMethod.POST)
    public ApiResponse<Boolean> addJob(@RequestBody BdJobCateVO newNode) {
        return saveJob(newNode, true);
    }

    private ApiResponse<Boolean> saveJob(BdJobCateVO newNode, boolean isAdd) {
        if (StringUtils.isBlank(newNode.getCateCode())) {
            newNode.setCateCode(CodeUtil.generateNewCode2yyMMddHH());
        }

        newNode.setTreeCode(TreeIncodeUtil.create(newNode.getParentCode()));
        newNode.setParentId(newNode.getParentId());

        ApiResponse<Boolean> result;
        if (!JobNodeType.SKILL.getType().equals(newNode.getCateType())) {
            if (isAdd) {
                result = super.create(newNode);
                String displayKey = "displayConfigs";
                if (!redisTemplate.opsForHash().values(displayKey).isEmpty()){
                    redisTemplate.boundHashOps(displayKey).put(newNode.getId().toString(),newNode);
                }

            } else {
                newNode.setTreeCode(null);
                newNode.setParentId(null);
                result = super.update(newNode);
                String displayKey = "displayConfigs";
                if (!redisTemplate.opsForHash().values(displayKey).isEmpty()){
                    redisTemplate.delete(displayKey);
                }
            }
        } else {
            BdJobSkill jobSkill = new BdJobSkill();
            jobSkill.setId(newNode.getId());
            jobSkill.setSkillCode(newNode.getCateCode());
            jobSkill.setSkillName(newNode.getCateName());
            jobSkill.setEnglishName(newNode.getEnglishName());
            jobSkill.setIcon(newNode.getIcon());
            if (isAdd) {
                jobSkill.setJobCateId(newNode.getParentId());
                jobSkill.setTreeCode(newNode.getTreeCode());
                jobSkill.setCateTreeCode(newNode.getParentCode());
                result = super.success(bdJobSkillService.save(jobSkill));
            } else {
                result = super.success(bdJobSkillService.update(jobSkill));
            }
        }

        return result;
    }

    @RequestMapping(value = "delJob",method = RequestMethod.POST)
    public ApiResponse<Boolean> delJob(@RequestBody JobNodeVO jobNodeVO) {
        ApiResponse<Boolean> result;
        if (!JobNodeType.SKILL.getType().equals(jobNodeVO.getCateType()) && hasChildNode(jobNodeVO.getJobId())) {
            return ApiResponse.ofFailed("非末级节点，不能删除！");
        }

        if (JobNodeType.SKILL.getType().equals(jobNodeVO.getCateType())) {
            result = super.success(this.bdJobSkillService.delete(jobNodeVO.getJobId()));
        } else {
            result = super.delete(jobNodeVO.getJobId());
            String displayKey = "displayConfigs";
            if(!redisTemplate.opsForHash().values(displayKey).isEmpty()){
                redisTemplate.delete(displayKey);
            }
        }

        return result;
    }

    private boolean hasChildNode(Long jobId) {
        QueryItem item = new QueryItem();
        item.setQueryField("parentId");
        item.setValue(jobId);
        item.setType(QueryType.eq);
        ArrayList<QueryItem> queryList = new ArrayList();
        queryList.add(item);
        List<BdJobCate> bdJobCates = bdJobCateService.get(queryList);

        item = new QueryItem();
        item.setQueryField("jobCateId");
        item.setValue(jobId);
        item.setType(QueryType.eq);
        ArrayList<QueryItem> queryList1 = new ArrayList();
        queryList1.add(item);
        List<BdJobSkill> bdJobSkills = bdJobSkillService.get(queryList1);

        return (bdJobCates != null && bdJobCates.size() > 0) || (bdJobSkills != null && bdJobSkills.size() > 0);
    }

    private JobNodeVO transferTree( List<JobNodeVO> treeNodeList) {
        TreeNode<JobNodeVO> treeNodes = TreeUtil.buildCodeTree(treeNodeList);
        JobNodeVO root = new JobNodeVO();
        root.setLabel("ROOT");
        root.setLabel("岗位技能树");
        root.setChildren(new ArrayList<>());
        treeNodes.setValue(root);
        getChildren(root, treeNodes.getChilds());

        return root;
    }

    private void getChildren(JobNodeVO parent, List<TreeNode<JobNodeVO>> children) {
        if (children == null || children.size() == 0) {
            return;
        }
        parent.setChildren(new ArrayList<>());
        JobNodeVO thisNode;
        for (TreeNode<JobNodeVO> child : children) {
            thisNode = child.getValue();
            getChildren(thisNode, child.getChilds());
            parent.getChildren().add(thisNode);
        }
    }

    @Override
    protected Service<BdJobCate> service() {
        return bdJobCateService;
    }

    protected BdJobSkillVO skillConvert(BdJobSkill form) {
        BdJobSkillVO model = new BdJobSkillVO();
        BeanUtils.copyProperties(form,model);
        return model;
    }

    @Override
    protected BdJobCateVO convert(BdJobCate model) {
        BdJobCateVO bdJobCateVO = new BdJobCateVO();
        BeanUtils.copyProperties(model,bdJobCateVO);
        return bdJobCateVO;
    }

    /**
     * 组装 List<BdJobCateVO> 2 List<JobNodeVO>
     * @param bdJobCateVOs
     * @return
     */
    private List<JobNodeVO> makeTreeCateList(List<BdJobCateVO> bdJobCateVOs){
        List<JobNodeVO> treeNodeList = new ArrayList<>();
        JobNodeVO treeNode;
        for (BdJobCateVO bdJobCateVO : bdJobCateVOs) {
            treeNode = new JobNodeVO();
            treeNode.setJobId(bdJobCateVO.getId());
            treeNode.setCode(bdJobCateVO.getCateCode());
            treeNode.setLabel(bdJobCateVO.getCateName());
            treeNode.setTreeCode(bdJobCateVO.getTreeCode());
            treeNode.setCateType(bdJobCateVO.getCateType());
            treeNode.setEnglishName(bdJobCateVO.getEnglishName());
            treeNode.setIcon(bdJobCateVO.getIcon());
            treeNode.setParentId(bdJobCateVO.getParentId());
            treeNode.setParentCode(bdJobCateVO.getParentCode());

            treeNodeList.add(treeNode);
        }
        return treeNodeList;
    }

}
