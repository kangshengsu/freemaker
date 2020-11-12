package com.fm.api.web.controller.sm;

import com.fm.api.web.util.R;
import com.fm.api.web.util.RestRequest;
import com.fm.api.web.vo.sm.RoleVO;
import com.fm.api.web.vo.sm.UserTableVO;
import com.fm.api.web.vo.sm.mapper.RoleMapper;
import com.fm.business.base.model.sm.Menu;
import com.fm.business.base.model.sm.Role;
import com.fm.business.base.model.sm.RoleUser;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.service.sm.*;
import com.fm.framework.core.model.DataStatus;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.TreeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色.
 */
@RestController
@RequestMapping("/role")
@Slf4j
@RequiredArgsConstructor
public class RoleController extends BaseController<Role, RoleVO> {

    private final IRoleService roleService;

    private final IPermissionService permissionService;

    private final IUserService userService;

    private final IRoleUserService roleUserService;

    private IMenuService menuService;
    @Override
    protected Service<Role> service() {
        return this.roleService;
    }


    @PostMapping("/list")
    public ApiResponse<PageInfo<RoleVO>> list(@RequestBody RestRequest<RoleVO> restRequest){

        RoleVO vo = restRequest.getData();

        List<QueryItem> items = new ArrayList<>();
        if(StringUtils.isNotBlank(vo.getName())){
            QueryItem item = new QueryItem();
            item.setQueryField("name");
            item.setValue(vo.getName());
            item.setType(QueryType.like);
            items.add(item);
        }
        if(StringUtils.isNotBlank(vo.getCode())){
            QueryItem item = new QueryItem();
            item.setQueryField("code");
            item.setValue(vo.getCode());
            item.setType(QueryType.like);
            items.add(item);
        }
        if (vo.getStatus() != null ){
            QueryItem item = new QueryItem();
            item.setQueryField("status");
            item.setValue(vo.getStatus());
            item.setType(QueryType.eq);
            items.add(item);
        }
        if (vo.getType() != null ){
            QueryItem item = new QueryItem();
            item.setQueryField("type");
            item.setValue(vo.getType());
            item.setType(QueryType.eq);
            items.add(item);
        }

        Page<Role> page = service().list(items, restRequest.getPage().getCurrentPage(), restRequest.getPage().getPageSize());

        PageInfo<RoleVO> resultPage = new PageInfo<>();
        resultPage.setCurrentPage(page.getCurrentPage());
        resultPage.setPageSize(page.getPageSize());
        resultPage.setData(doConvertVOs(page.getData()));
        resultPage.setTotal(page.getTotal());

        doAfterPageSearch(resultPage);
        //分页
        return success(resultPage);
    }
    @GetMapping("/list")
    public R list(){
        return R.createSuccessR().data(roleService.getAllEnableStatus());
    }

    protected void doAfterPageSearch(Page<RoleVO> page) {
        List<RoleVO> roleVOs = page.getData();
        roleVOs.stream().map(r ->{
            Role role = new Role();
            role.setId(r.getId());
            List<Menu> menus = this.permissionService.getAllPermissions(role);
            // 只保留叶子节点
            //删除父节点
            if (!CollectionUtils.isEmpty(menus)){
                TreeNode<Menu> menuTreeNode = TreeUtil.buildTree(menus);
                if (!menuTreeNode.isLeaf()){
                    menus.remove(menuTreeNode.getValue());
                    this.buildMenuForLeafNode(menus, menuTreeNode.getChilds());
                }

                List<Long> ids = menus.stream().map(Menu::getId).collect(Collectors.toList());
                r.setMenuIds(ids);
            }
            return r;
        }).collect(Collectors.toList());
    }

    private void buildMenuForLeafNode(List<Menu> menus, List<TreeNode<Menu>> childs) {
        childs.forEach(menuTreeNode -> {
            if (!menuTreeNode.isLeaf()){
                menus.remove(menuTreeNode.getValue());
                this.buildMenuForLeafNode(menus, menuTreeNode.getChilds());
            }
        });
    }

    @PostMapping("/save")
    public ApiResponse<Boolean> create(@RequestBody RestRequest<RoleVO> restRequest){

        RoleVO roleVO = restRequest.getData();

        if (StringUtils.isBlank(roleVO.getName())){
            return failed("角色名称不能为空！");
        }

        if (StringUtils.isBlank(roleVO.getCode())){
            return failed("角色编码不能为空！");
        }

        Role role = doConvertModel(roleVO);

        return success(service().save(role));

    }

    @PostMapping("/deleteById")
    public ApiResponse<Boolean> deleteById(@RequestBody RestRequest<RoleVO> restRequest){

        RoleVO roleVO = restRequest.getData();
        //角色删除规则
        //1、角色下无用户
        List<QueryItem> userItems = new ArrayList<>();
        QueryItem roleIdItem = new QueryItem();
        roleIdItem.setType(QueryType.eq);
        roleIdItem.setValue(roleVO.getId());
        roleIdItem.setQueryField("role_id");
        userItems.add(roleIdItem);

        int count = roleUserService.countEnableStatus(userItems);

        if (count > 0){
            return failed("待删除的角色下不能存在用户！");
        }

        return success(roleService.delete(roleVO.getId()));
    }


    @PostMapping("/update")
    public ApiResponse<Boolean> update(@RequestBody RestRequest<RoleVO> restRequest){
        RoleVO roleVO = restRequest.getData();

        if (StringUtils.isBlank(roleVO.getName())){
            return failed("角色名称不能为空！");
        }

        if (StringUtils.isBlank(roleVO.getCode())){
            return failed("角色编码不能为空！");
        }
        Role role = doConvertModel(roleVO);

        return success(service().update(role));
    }

    @PostMapping("/checkIfExists")
    public ApiResponse<Boolean> checkIfExists(@RequestBody RestRequest<RoleVO> restRequest){

        RoleVO vo = restRequest.getData();

        List<QueryItem> items = new ArrayList<>();

        if (StringUtils.isNotBlank(vo.getName())){
            QueryItem item = new QueryItem();
            item.setQueryField("name");
            item.setValue(vo.getName());
            item.setType(QueryType.eq);
            items.add(item);
        }
        if (StringUtils.isNotBlank(vo.getCode())){
            QueryItem item = new QueryItem();
            item.setQueryField("code");
            item.setValue(vo.getCode());
            item.setType(QueryType.eq);
            items.add(item);
        }

        int count = this.service().count(items);

        return success(count >= 1);
    }
    @PostMapping("/enable")
    public R enable(@RequestBody RestRequest<RoleVO> restRequest){
        return this.changeDataStatus(restRequest, DataStatus.enable);
    }

    @PostMapping("/disable")
    public R disable(@RequestBody RestRequest<RoleVO> restRequest){
        return this.changeDataStatus(restRequest, DataStatus.disable);
    }

    @PostMapping("updatePermSetting")
    public R rolePermSetting(@RequestBody RestRequest<RoleVO> restRequest){
        if (!restRequest.baseCheck() || restRequest.getData().getId() == null){
            return R.create().code(R.FAILED_CODE).message("参数错误 请重试!");
        }

        Role role = RoleMapper.INSTANCE.toRole(restRequest.getData());

        List<Long> menuIds = role.getMenuIds();
        List<Long> newMenuIds = Lists.newArrayList(role.getMenuIds());
        if (!CollectionUtils.isEmpty(menuIds)){
            menuIds.forEach(id ->{
                Menu menu = menuService.get(id);
                long parentId = menu.getParentId();
                if (parentId != -1){
                    newMenuIds.add(parentId);
                }
            });
        }

        role.setMenuIds(newMenuIds);
        boolean result = roleService.updatePermissionMenu(role);

        return R.createSuccessR();
    }

    /**
     * 授权用户角色权限
     * */
    @PostMapping("userRoleSetting")
    public R userRoleSetting(@RequestBody RestRequest<RoleVO> restRequest, @RequestParam(name = "type", required = false, defaultValue = "1") int type){
        if (!restRequest.baseCheck() || restRequest.getData().getId() == null){
            return R.create().code(R.FAILED_CODE).message("参数错误 请选择角色后重试!");
        }

        //新增授予用户角色
        List<UserTableVO> addUsers = restRequest.getData().getUsers();
        if (CollectionUtils.isEmpty(addUsers)){
            return  R.createFailR().message("请选择用户!");
        }

        Long roleId = restRequest.getData().getId();

        if ( type == 0){
            roleUserService.deleteByUserIdAndRoleId(roleId, addUsers.stream().map(UserTableVO::getId).collect(Collectors.toList()));
        }else {
            Role role = roleService.get(roleId);
            List<User> users = userService.getByIds(addUsers.stream().map(UserTableVO::getId).collect(Collectors.toList()));
            List<RoleUser> roleUsers = users.stream().map(u -> {
                RoleUser ru = new RoleUser();
                ru.setRoleId(role.getId());
                ru.setUserId(u.getId());
                return ru;
            }).collect(Collectors.toList());
            roleUserService.save(roleUsers);
        }
        return R.createSuccessR();
    }

    /**
     * 更改数据状态 启动 禁用
     * @param dataStatus  enable：启用  disable：禁用
     * */
    private R changeDataStatus(@RequestBody RestRequest<RoleVO> restRequest, DataStatus dataStatus) {
        if (!restRequest.baseCheck() || restRequest.getData().getId() == null){
            return R.create().code(R.FAILED_CODE).message("参数错误 请重试!");
        }

        Role role = new Role();
        role.setId(restRequest.getData().getId());
        role.setTs(restRequest.getData().getTs());

        if (dataStatus.code() == (DataStatus.enable.code())){
            role.setStatus(DataStatus.enable.code());
        }else {
            role.setStatus(DataStatus.disable.code());
        }

        boolean update = this.roleService.setStatus(role, dataStatus == DataStatus.enable);
        if (update){
            return R.create().code(R.SUCCESS_CODE).message(R.SUCCESS_MSG);
        }else {
            return R.create().code(R.FAILED_CODE).message(R.FAILED_MSG);
        }
    }

    /**
     * 转换VO页面显示数据
     *
     * @param data
     */
    protected  List<RoleVO> doConvertVOs(List<Role> data) {
        if (CollectionUtils.isEmpty(data)){
            return Collections.emptyList();
        }

        return data.stream().map(RoleMapper.INSTANCE::toRoleVO)
                .collect(Collectors.toList());
    }



    /**
     * 展示层&model实体转换
     *
     * @param data
     */
    protected Role doConvertModel(RoleVO data) {
        return RoleMapper.INSTANCE.toRole(data);
    }

    /**
     * model->VO
     *
     */

    protected RoleVO doConvertVO(Role role) {
        return RoleMapper.INSTANCE.toRoleVO(role);
    }



}
