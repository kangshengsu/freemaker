package com.fm.api.web.controller.sm;

import com.fm.api.web.util.R;
import com.fm.api.web.util.RestRequest;
import com.fm.api.web.vo.sm.OrgVO;
import com.fm.api.web.vo.sm.TreeNodeVO;
import com.fm.api.web.vo.sm.mapper.OrgMapper;
import com.fm.business.base.model.sm.Org;
import com.fm.business.base.model.sm.OrgType;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.service.sm.IOrgService;
import com.fm.business.base.service.sm.IUserService;
import com.fm.framework.core.exception.BusinessException;
import com.fm.framework.core.model.DBFieldConst;
import com.fm.framework.core.model.DataStatus;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.TreeIncodeUtil;
import com.fm.framework.core.utils.TreeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 组织.
 */
@RestController
@RequestMapping(path = "/api/org")
public class OrgController extends BaseController<Org, OrgVO> {

    @Autowired
    private IOrgService orgService;
    @Autowired
    private IUserService userService;


    @Override
    protected Service<Org> service() {
        return this.orgService;
    }

    /**
     * 查询所有有效树形节点
     * @return 返回组织好的组织书
     */
    @RequestMapping("/tree")
    public R getTree() {
        List<OrgVO> orgVOList = orgService.getAllEnableStatus().stream().map(OrgMapper.INSTANCE::toOrgVO).collect(Collectors.toList());
        return getTreeR(orgVOList);
    }
    /**
     * 查询所有树形节点（包括失效的）
     * @return 返回组织好的组织书
     */
    @RequestMapping("/allTree")
    public R allTree() {
        List<OrgVO> orgVOList = orgService.getAll().stream().map(OrgMapper.INSTANCE::toOrgVO).collect(Collectors.toList());
        return getTreeR(orgVOList);

    }

    private R getTreeR(List<OrgVO> orgVOList) {
        TreeNode<OrgVO> root = TreeUtil.buildTree(orgVOList);
        List<TreeNode<OrgVO>> childs = root.getChilds();
        if (CollectionUtils.isEmpty(childs)){
            return R.createSuccessR();
        }

        TreeNode<OrgVO> orgRoot = childs.get(0);

        //jackson 循环问题
        TreeUtil.setParentNull(orgRoot);
        return R.createSuccessR().data(convert(orgRoot));
    }

    /**
     * 树形节点显示转换
     * @param node 树节点
     * @return 显示的树节点
     */
    private TreeNodeVO convert(TreeNode<OrgVO> node) {
        TreeNodeVO treeNodeVO = new TreeNodeVO();
        treeNodeVO.setId(node.getValue().getId());
//        treeNodeVO.setLabel(node.getValue().getCode() + " " + node.getValue().getName());
        treeNodeVO.setLabel(node.getValue().getName());
        if(!node.isLeaf()) {

            List<TreeNodeVO> child = new ArrayList<>();

            node.getChilds().forEach(n -> {
                child.add(convert(n));
            });
            treeNodeVO.setChildren(child);
        }

        return treeNodeVO;

    }

    @PostMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public R list(@RequestBody RestRequest<OrgVO> restRequest){
        List<QueryItem> queryItemList = getQueryItems(restRequest);
        //查询符合条件的组织
        List<Org> orgList = orgService.get(queryItemList,null);
        //为了构造树状结构，补充未查询出的父节点
        orgList = appendParentOrg(orgList);

        //构造树
        List<OrgVO> orgVOList = orgList.stream().map(OrgMapper.INSTANCE::toOrgVO).collect(Collectors.toList());

        TreeNode<OrgVO> root = TreeUtil.buildTree(orgVOList);
        List<TreeNode<OrgVO>> childs = root.getChilds();
        if (CollectionUtils.isEmpty(childs)){
            return R.createSuccessR();
        }
        //每个租户都只有一个根节点
        TreeNode<OrgVO> orgRoot = childs.get(0);
        //jackson 循环问题
        TreeUtil.setParentNull(orgRoot);
        return R.createSuccessR().data(orgRoot);
    }


    private List<Org> appendParentOrg(List<Org> orgList) {
        if(orgList==null){
            return Lists.newArrayList();
        }
        Set<Long> existsIds = new HashSet<>();
        Set<String> notExistsInCodes = new HashSet<>();
        orgList.stream().forEach(a->existsIds.add(a.getId()));
        orgList.stream().forEach(a->{
            if(a.getParentId()!=-1 && !existsIds.contains(a.getParentId())){
               // 当前节点的父节点不在list中；组织incode条件
                notExistsInCodes.addAll(getSplitIncode(a.getIncode()));
            }
        });
        if(notExistsInCodes.isEmpty()){
            return orgList;
        }
        //查询;通过incode查询父节点加到列表中
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField(DBFieldConst.INCODE);
        queryItem.setType(QueryType.in);
        queryItem.setValue(notExistsInCodes);
        List<Org> orgs =orgService.get(Arrays.asList(queryItem));
        if(!CollectionUtils.isEmpty(orgs)){
            orgList.addAll(orgs);
        }
        return orgList;
    }

    private List<String> getSplitIncode(String incode) {
        //incode每一级2位字符；将父路径上的全部incode加入list
        List<String> inCodes = new ArrayList<String>();
        for(int i = incode.length() - 2; i> 0 ;i=i-2) {
            inCodes.add(incode.substring(0,i));
        }
        return inCodes;
    }

    private List<QueryItem> getQueryItems(RestRequest<OrgVO> restRequest) {
        List<QueryItem> queryItemList = Lists.newArrayList();
        if(restRequest!=null && restRequest.getData()!=null) {
            OrgVO orgVO = restRequest.getData();
            if(!StringUtils.isEmpty(orgVO.getCode())){
                queryItemList.add(getLikeItem(DBFieldConst.CODE,orgVO.getCode()));
            }
            if(!StringUtils.isEmpty(orgVO.getName())){
                queryItemList.add(getLikeItem(DBFieldConst.NAME,orgVO.getName()));

            }
            if(orgVO.getType()!=null){
                queryItemList.add(getEqualItem("type",orgVO.getType()));
            }
            if(orgVO.getStatus()!=null){
                queryItemList.add(getEqualItem(DBFieldConst.STATUS,orgVO.getStatus()));
            }

        }
        return queryItemList;
    }

    private QueryItem getLikeItem(String column, String val) {
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField(column);
        queryItem.setType(QueryType.like);
        queryItem.setValue(val);
        return queryItem;
    }

    private QueryItem getEqualItem(String column,Object val) {
        QueryItem queryItem = new QueryItem();
        queryItem.setQueryField(column);
        queryItem.setType(QueryType.eq);
        queryItem.setValue(val);
        return queryItem;
    }

    @PostMapping("/save")
    public ApiResponse<Boolean> create(@RequestBody RestRequest<OrgVO> restRequest){
        return super.create(restRequest.getData());
    }


    @PostMapping("/deleteById")
    public ApiResponse<Boolean> deleteById(@RequestBody RestRequest<OrgVO> restRequest){

        OrgVO orgVO = restRequest.getData();
        //删除机构规则
        //1、机构下不能有子机构
        List<QueryItem> orgItems = new ArrayList<>();
        QueryItem parentIdOrgItem = new QueryItem();
        parentIdOrgItem.setType(QueryType.eq);
        parentIdOrgItem.setValue(orgVO.getId());
        parentIdOrgItem.setQueryField("parent_id");
        orgItems.add(parentIdOrgItem);

        int orgCount = this.orgService.countEnableStatus(orgItems);
        if (orgCount > 0){
            return failed("待删除的机构下不能存在子机构！");
        }
        //2、机构下不能有用户
        List<QueryItem> userItems = new ArrayList<>();
        QueryItem roleIdItem = new QueryItem();
        roleIdItem.setType(QueryType.eq);
        roleIdItem.setValue(orgVO.getId());
        roleIdItem.setQueryField("org_id");
        userItems.add(roleIdItem);

        int userCount = this.userService.countEnableStatus(userItems);
        if (userCount > 0){
            return failed("待删除的机构下不能存在用户！");
        }

        return success(service().delete(restRequest.getData().getId()));
//        return super.standardDeleteById(restRequest);
    }



    @PostMapping("/update")
    public ApiResponse<Boolean> update(@RequestBody RestRequest<OrgVO> restRequest){

        Org org = doConvertModel(restRequest.getData());

        Org orgOld = this.orgService.get(org.getId());
        //根机构不能修改父级机构
        if(orgOld.getParentId() == -1 ){
            org.setParentId(-1L);
        }
        if((orgOld.getParentId()!=null&&!orgOld.getParentId().equals(org.getParentId()))||orgOld.getParentId()==null&&(org.getParentId()!=null)){
            //父级机构可以修改的条件：当机构为末级机构，且机构下无用户、机构未关联数据权限才能修改父级机构
            if(!this.orgService.canChangeParent(org)){
                throw new BusinessException("不能修改父级机构" );
            }
            Org parent = orgService.get(org.getParentId());
            // 更新incode
            org.setIncode(TreeIncodeUtil.create(parent.getIncode()));
        }

        return success(service().update(org));
    }


    @RequestMapping("/canChangeParent")
    public R canChangeParent(@RequestBody OrgVO orgVO) {

        if (Objects.isNull(orgVO)) {
            R.createSuccessR().data(false);
        }
        return R.createSuccessR().data(this.orgService.canChangeParent(doConvertModel(orgVO)));
    }

    @PostMapping("/getAllChild")
    public R getAllChild(@RequestBody RestRequest<OrgVO> restRequest){
        return this.findChild(restRequest, true);
    }

    @PostMapping("/getDirectChild")
    public R getDirectChild(@RequestBody RestRequest<OrgVO> restRequest){
        return this.findChild(restRequest, false);
    }

    @PostMapping("/enable")
    public R enable(@RequestBody RestRequest<OrgVO> restRequest){
        return this.changeDataStatus(restRequest, DataStatus.enable);
    }

    @PostMapping("/disable")
    public R disable(@RequestBody RestRequest<OrgVO> restRequest){
        return this.changeDataStatus(restRequest, DataStatus.disable);
    }

    /**
     * 更改数据状态 启动 禁用
     * @param dataStatus  enable：启用  disable：禁用
     * */
    private R changeDataStatus(@RequestBody RestRequest<OrgVO> restRequest, DataStatus dataStatus) {
        if (!restRequest.baseCheck() || restRequest.getData().getId() == null){
            return R.create().code(R.FAILED_CODE).message("参数错误 请重试!");
        }
        if(dataStatus == DataStatus.disable){
            //禁用的情况
            QueryItem item = new QueryItem();
            item.setQueryField(DBFieldConst.ORG_ID);
            item.setValue(restRequest.getData().getId());
            item.setType(QueryType.eq);
            List<User> userList = userService.get(Arrays.asList(item));
            if(!CollectionUtils.isEmpty(userList)){
                return R.create().code(R.FAILED_CODE).message("该组织下还有有效用户，不能禁用");
            }
        }
        Org org = new Org();
        org.setId(restRequest.getData().getId());
        org.setTs(restRequest.getData().getTs());

        if (dataStatus.equals(DataStatus.enable)){
            // 启用是如果父机构为禁用，报错
            Org tempOrg = orgService.get(org.getId());
            if(tempOrg.getParentId() != -1){
                tempOrg = orgService.get(tempOrg.getParentId());
                if(tempOrg.getStatus() == DataStatus.disable.code()){
                    return R.create().code(R.FAILED_CODE).message("父机构处于禁用状态无法启用子机构！");
                }
            }
            org.setStatus(DataStatus.enable.code());
        }else {
            //禁用组织时不能有启用的子级组织
            QueryItem item = new QueryItem();
            item.setType(QueryType.eq);
            item.setValue(org.getId());
            item.setQueryField("parent_id");
            int count = orgService.countEnableStatus(Collections.singletonList(item));
            if (count >= 1){
                return R.create().code(R.FAILED_CODE).message("禁用组织机构时不能存在已启用的子级组织机构！");
            }

            org.setStatus(DataStatus.disable.code());
        }

        boolean update = this.orgService.update(org);
        if (update){
            return R.create().code(R.SUCCESS_CODE).message(R.SUCCESS_MSG);
        }else {
            return R.create().code(R.FAILED_CODE).message(R.FAILED_MSG);
        }
    }

    /**
     * 查找组织子节点
     * @param ifAll  true:查询所有(直接和间接子节点)   false:查询直接子节点
     * */
    private R findChild(@RequestBody RestRequest<OrgVO> restRequest, boolean ifAll) {
        if (!restRequest.baseCheck()){
            return R.create().code(R.FAILED_CODE).message("查询参数不能为空!");
        }

        OrgVO data = restRequest.getData();
        Long parentId = data.getParentId();
        if (parentId == null){
            return R.create().code(R.FAILED_CODE).message("父级id不能为空!");
        }

        List<Org> children = Collections.emptyList();
        if (ifAll){
            children = this.orgService.findAllChild(parentId);
        }else {
            Org org = new Org();
            org.setParentId(parentId);
            children = this.orgService.findChild(org);
        }
        List<OrgVO> orgVOs = this.doConvertVOs(children);

        return R.create().data(orgVOs).code(R.SUCCESS_CODE).message(R.SUCCESS_MSG);
    }

    @PostMapping("/checkIfExists")
    public ApiResponse<Boolean> checkIfExists(@RequestBody RestRequest<OrgVO> restRequest){
        if (!restRequest.baseCheck()){
            return failed("参数错误 请重试!");
        }

        OrgVO data = restRequest.getData();


        List<QueryItem> items = this.doBeforeCheckExistsAddSearchParam(data);

        int count = this.service().count(items);

        return success(count >= 1);
    }

    @GetMapping("/getAllOrgType")
    public R getAllOrgType(){
        List<OrgType> orgTypes = this.orgService.getAllOrgType();
        return R.createSuccessR().data(orgTypes);
    }

    /**
     * 转换VO页面显示数据
     *
     * @param data
     */
    protected  List<OrgVO> doConvertVOs(List<Org> data) {
        if (CollectionUtils.isEmpty(data)){
            return Collections.emptyList();
        }

        List<OrgVO> vos = data.stream().map(OrgMapper.INSTANCE::toOrgVO)
                .collect(Collectors.toList());

        List<Long> ids = data.stream().map(Org::getParentId).collect(Collectors.toList());
        Map<Long, String> orgMap = orgService.getByIds(ids).stream().collect(Collectors.toMap(Org::getId, Org::getName, (oldKey, newKey) -> newKey));

        vos.stream().map(orgVO -> {
            orgVO.setParentName(orgMap.get(orgVO.getParentId()));
            return orgVO;
        }).collect(Collectors.toList());

        return vos;
    }

    /**
     * 分页查询拼装参数
     * */
    protected List<QueryItem> doBeforePageAddSearchParam(OrgVO vo) {
        List<QueryItem> queryItems = new ArrayList<>();
        if (StringUtils.isNotBlank(vo.getName())){
            QueryItem item = new QueryItem();
            item.setQueryField("name");
            item.setValue(vo.getName());
            item.setType(QueryType.leftLike);
            queryItems.add(item);
        }
        if (vo.getType() != null){
            QueryItem item = new QueryItem();
            item.setQueryField("type");
            item.setValue(vo.getType());
            item.setType(QueryType.eq);
            queryItems.add(item);
        }
        if (vo.getStatus() != null ){
            QueryItem item = new QueryItem();
            item.setQueryField("status");
            item.setValue(vo.getStatus());
            item.setType(QueryType.eq);
            queryItems.add(item);
        } else{
            QueryItem item = new QueryItem();
            item.setQueryField("parent_id");
            item.setValue(Lists.newArrayList(0, -1)); // 父节点
            item.setType(QueryType.in);
            queryItems.add(item);
        }

    return queryItems;
    }

    /**
     * 新增校验
     *
     * @param data
     */
    protected R parametericCheckBeforeCreate(OrgVO data) {
        if(StringUtils.isBlank(data.getName())){
            return R.create().code(R.FAILED_CODE).message("组织名称不能为空!");
        }

        if(data.getType() == null){
            return R.create().code(R.FAILED_CODE).message("组织类型不能为空!");
        }

        if (data.getParentId() == null){
            return R.create().code(R.FAILED_CODE).message("组织父节点不能为空!");
        }

        return R.create().code(R.SUCCESS_CODE);
    }

    /**
     * 展示层&model实体转换
     *
     * @param data
     */
    protected Org doConvertModel(OrgVO data) {
        return OrgMapper.INSTANCE.to(data);
    }


    /**
     * model->VO
     *
     * @param org
     */
    protected OrgVO doConvertVO(Org org) {
        return OrgMapper.INSTANCE.toOrgVO(org);
    }

    /**
     * 更新校验
     *
     * @param data
     */
    protected R parametericCheckBeforeUpdate(OrgVO data) {
        if(StringUtils.isBlank(data.getName())){
            return R.create().code(R.FAILED_CODE).message("组织名称不能为空!");
        }

        return R.create().code(R.SUCCESS_CODE);
    }

    protected void doBeforeDelete(Org org) {
    }




    /**
     * 查询是否存在时拼接查询参数
     * */
    protected List<QueryItem> doBeforeCheckExistsAddSearchParam(OrgVO data) {
        List<QueryItem> items = new ArrayList<>();
        if (StringUtils.isNotBlank(data.getName())){
            QueryItem nameItem =  new QueryItem();
            nameItem.setQueryField("name");
            nameItem.setValue(data.getName());
            nameItem.setType(QueryType.eq);
            items.add(nameItem);
        }
        if (StringUtils.isNotBlank(data.getCode())){
            QueryItem codeItem =  new QueryItem();
            codeItem.setQueryField("code");
            codeItem.setValue(data.getCode());
            codeItem.setType(QueryType.eq);
            items.add(codeItem);
        }

        return items;
    }
}