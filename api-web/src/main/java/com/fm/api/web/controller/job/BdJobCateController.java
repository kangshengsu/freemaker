/**
* @filename:BdJobCateController 2020年09月11日
* @project HowWork  V1.0
* Copyright(c) 2020 LiuDuo Co. Ltd.
* All right reserved.
*/
package com.fm.api.web.controller.job;

import com.fm.api.web.enums.JobNodeType;
import com.fm.api.web.vo.job.BdJobCateVO;
import com.fm.api.web.vo.job.BdJobSkillVO;
import com.fm.api.web.vo.job.JobNodeVO;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobSkill;
import com.fm.business.base.service.IBdJobCateService;
import com.fm.business.base.service.IBdJobSkillService;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.TreeIncodeUtil;
import com.fm.framework.core.utils.TreeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody BdJobCateVO form) {

        return super.create(form);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody Long id) {

        return super.delete(id);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ApiResponse<Boolean> update(@RequestBody BdJobCateVO form) {

        return super.update(form);
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ApiResponse<Page<BdJobCateVO>> list(@RequestBody QueryRequest queryRequest) {

        return super.list(queryRequest);
    }

    @RequestMapping(value = "treeData",method = RequestMethod.GET)
    public ApiResponse<List<JobNodeVO>> treeData() {
        List<BdJobCateVO> bdJobCateVOs = bdJobCateService.getAll().stream().map(this::convert).collect(Collectors.toList());
        List<BdJobSkillVO> bdJobSkillVOs = bdJobSkillService.getAll().stream().map(this::skillConvert).collect(Collectors.toList());

        List<JobNodeVO> treeNodeList = new ArrayList<>();
        JobNodeVO treeNode;
        for (BdJobCateVO bdJobCateVO : bdJobCateVOs) {
            treeNode = new JobNodeVO();
            treeNode.setLabel(bdJobCateVO.getCateCode());
            treeNode.setLabel(bdJobCateVO.getCateName());
            treeNode.setTreeCode(bdJobCateVO.getTreeCode());
            treeNode.setCateType(bdJobCateVO.getCateType());

            treeNodeList.add(treeNode);
        }

        for (BdJobSkillVO bdJobSkillVO : bdJobSkillVOs) {
            treeNode = new JobNodeVO();
            treeNode.setLabel(bdJobSkillVO.getSkillCode());
            treeNode.setLabel(bdJobSkillVO.getSkillName());
            treeNode.setTreeCode(bdJobSkillVO.getCateTreeCode());
            treeNode.setCateType(JobNodeType.SKILL.getType());

            treeNodeList.add(treeNode);
        }

        return ApiResponse.ofSuccess(Arrays.asList(transferTree(treeNodeList)));
    }

    @RequestMapping(value = "addJob",method = RequestMethod.POST)
    public ApiResponse<Boolean> addJob(@RequestBody BdJobCateVO newNode) {
        newNode.setTreeCode(TreeIncodeUtil.create(newNode.getParentCode()));

        return super.create(newNode);
    }

    @RequestMapping(value = "delNode",method = RequestMethod.POST)
    public ApiResponse<Boolean> delJob(@RequestBody BdJobCateVO selNode) {
        return super.delete(selNode.getId());
    }

    private JobNodeVO transferTree( List<JobNodeVO> treeNodeList) {
        TreeNode<JobNodeVO> treeRoot = TreeUtil.buildTree(treeNodeList);
        JobNodeVO root = new JobNodeVO();
        root.setLabel("ROOT");
        root.setLabel("岗位技能树");
        root.setChildren(new ArrayList<>());
        getChildren(root, treeRoot.getChilds());

        return root;
    }

    private void getChildren(JobNodeVO parent, List<TreeNode<JobNodeVO>> children) {
        if (children == null || children.size() == 0) {
            return;
        }

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

}