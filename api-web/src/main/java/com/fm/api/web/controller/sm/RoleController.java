//package com.fm.api.web.controller.sm;
//
//import com.google.common.collect.Lists;
//import com.jd.labbed.common.mapper.BeanMapper;
//import com.jd.labbed.common.page.PageImpl;
//import com.jd.labbed.core.base.DataStatus;
//import com.jd.labbed.core.base.TreeNode;
//import com.jd.labbed.core.base.query.QueryItem;
//import com.jd.labbed.core.base.query.QueryType;
//import com.jd.labbed.core.base.service.Service;
//import com.jd.labbed.core.sm.model.Menu;
//import com.jd.labbed.core.sm.model.Role;
//import com.jd.labbed.core.sm.model.RoleUser;
//import com.jd.labbed.core.sm.model.User;
//import com.jd.labbed.core.sm.service.*;
//import com.jd.labbed.core.util.TreeUtil;
//import com.jd.labbed.mvc.tenant.mapper.RoleMapper;
//import com.jd.labbed.mvc.tenant.util.R;
//import com.jd.labbed.mvc.tenant.util.RestRequest;
//import com.jd.labbed.mvc.tenant.vo.RoleVO;
//import com.jd.labbed.mvc.tenant.vo.UserTableVO;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * 角色.
// */
//@RestController
//@RequestMapping("api/role")
//@Slf4j
//public class RoleController extends BaseController<Role, RoleVO> {
//
//    @Resource(name = "roleService")
//    private RoleService roleService;
//
//    @Autowired
//    private PermissionService permissionService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleUserService roleUserService;
//
//    @Autowired
//    private MenuService menuService;
//    @Override
//    protected Service<Role> service() {
//        return this.roleService;
//    }
//
//    @Override
//    protected String cnName() {
//        return "角色";
//    }
//
//    @PostMapping("/list")
//    public R list(@RequestBody RestRequest<RoleVO> restRequest){
//        //分页
//        return super.standardPageList(restRequest);
//    }
//    @GetMapping("/list")
//    public R list(){
//        return R.createSuccessR().data(roleService.getAllEnableStatus());
//    }
//
//    @Override
//    protected void doAfterPageSearch(PageImpl<RoleVO> page) {
//        super.doAfterPageSearch(page);
//        List<RoleVO> roleVOs = page.getData();
//        roleVOs.stream().map(r ->{
//            Role role = new Role();
//            role.setId(r.getId());
//            List<Menu> menus = this.permissionService.getAllPermissions(role);
//            // 只保留叶子节点
//            //删除父节点
//            if (CollectionUtils.isNotEmpty(menus)){
//                TreeNode<Menu> menuTreeNode = TreeUtil.buildTree(menus);
//                if (!menuTreeNode.isLeaf()){
//                    menus.remove(menuTreeNode.getValue());
//                    this.buildMenuForLeafNode(menus, menuTreeNode.getChilds());
//                }
//
//                List<Long> ids = menus.stream().map(Menu::getId).collect(Collectors.toList());
//                r.setMenuIds(ids);
//            }
//            return r;
//        }).collect(Collectors.toList());
//    }
//
//    private void buildMenuForLeafNode(List<Menu> menus, List<TreeNode<Menu>> childs) {
//        childs.forEach(menuTreeNode -> {
//            if (!menuTreeNode.isLeaf()){
//                menus.remove(menuTreeNode.getValue());
//                this.buildMenuForLeafNode(menus, menuTreeNode.getChilds());
//            }
//        });
//    }
//
//    @PostMapping("/save")
//    public R create(@RequestBody RestRequest<RoleVO> restRequest){
//        R r = super.standardCreate(restRequest);
//        return r;
//    }
//
//    @PostMapping("/deleteById")
//    public R deleteById(@RequestBody RestRequest<RoleVO> restRequest){
//        return super.standardDeleteById(restRequest);
//    }
//
//    @Override
//    protected R parametericCheckBeforeDelete(RoleVO roleVO) {
//        //角色删除规则
//        //1、角色下无用户
//        List<QueryItem> userItems = new ArrayList<>();
//        QueryItem roleIdItem = new QueryItem();
//        roleIdItem.setType(QueryType.eq);
//        roleIdItem.setValue(roleVO.getId());
//        roleIdItem.setQueryField("role_id");
//        userItems.add(roleIdItem);
//
//        int count = roleUserService.countEnableStatus(userItems);
//
//        if (count > 0){
//            return R.createFailR().message("待删除的角色下不能存在用户！");
//        }
//        return R.createSuccessR();
//    }
//
//    @PostMapping("/update")
//    public R update(@RequestBody RestRequest<RoleVO> restRequest){
//        return super.standardUpdate(restRequest);
//    }
//
//    @PostMapping("/checkIfExists")
//    public R checkIfExists(@RequestBody RestRequest<RoleVO> restRequest){
//        return super.standardCheckExists(restRequest);
//    }
//    @PostMapping("/enable")
//    public R enable(@RequestBody RestRequest<RoleVO> restRequest){
//        return this.changeDataStatus(restRequest, DataStatus.enable);
//    }
//
//    @PostMapping("/disable")
//    public R disable(@RequestBody RestRequest<RoleVO> restRequest){
//        return this.changeDataStatus(restRequest, DataStatus.disable);
//    }
//
//    @PostMapping("updatePermSetting")
//    public R rolePermSetting(@RequestBody RestRequest<RoleVO> restRequest){
//        if (!restRequest.baseCheck() || restRequest.getData().getId() == null){
//            return R.create().code(R.FAILED_CODE).message("参数错误 请重试!");
//        }
//
//        Role role = RoleMapper.INSTANCE.toRole(restRequest.getData());
//
//        List<Long> menuIds = role.getMenuIds();
//        List<Long> newMenuIds = Lists.newArrayList(role.getMenuIds());
//        if (CollectionUtils.isNotEmpty(menuIds)){
//            menuIds.forEach(id ->{
//                Menu menu = menuService.get(id);
//                long parentId = menu.getParentId();
//                if (parentId != -1){
//                    newMenuIds.add(parentId);
//                }
//            });
//        }
//
//        role.setMenuIds(newMenuIds);
//        boolean result = roleService.updatePermissionMenu(role);
//
//        return R.createSuccessR();
//    }
//
//    /**
//     * 授权用户角色权限
//     * */
//    @PostMapping("userRoleSetting")
//    public R userRoleSetting(@RequestBody RestRequest<RoleVO> restRequest, @RequestParam(name = "type", required = false, defaultValue = "1") int type){
//        if (!restRequest.baseCheck() || restRequest.getData().getId() == null){
//            return R.create().code(R.FAILED_CODE).message("参数错误 请选择角色后重试!");
//        }
//
//        //新增授予用户角色
//        List<UserTableVO> addUsers = restRequest.getData().getUsers();
//        if (CollectionUtils.isEmpty(addUsers)){
//            return  R.createFailR().message("请选择用户!");
//        }
//
//        Long roleId = restRequest.getData().getId();
//
//        if ( type == 0){
//            roleUserService.deleteByUserIdAndRoleId(roleId, addUsers.stream().map(UserTableVO::getId).collect(Collectors.toList()));
//        }else {
//            Role role = roleService.get(roleId);
//            List<User> users = userService.getByIds(addUsers.stream().map(UserTableVO::getId).collect(Collectors.toList()));
//            List<RoleUser> roleUsers = users.stream().map(u -> {
//                RoleUser ru = new RoleUser();
//                ru.setRoleId(role.getId());
//                ru.setRoleCode(role.getCode());
//                ru.setUserId(u.getId());
//                ru.setUserCode(u.getCode());
//                return ru;
//            }).collect(Collectors.toList());
//            roleUserService.save(roleUsers);
//        }
//        return R.createSuccessR();
//    }
//
//    /**
//     * 更改数据状态 启动 禁用
//     * @param dataStatus  enable：启用  disable：禁用
//     * */
//    private R changeDataStatus(@RequestBody RestRequest<RoleVO> restRequest, DataStatus dataStatus) {
//        if (!restRequest.baseCheck() || restRequest.getData().getId() == null){
//            return R.create().code(R.FAILED_CODE).message("参数错误 请重试!");
//        }
//
//        Role role = new Role();
//        role.setId(restRequest.getData().getId());
//        role.setTs(restRequest.getData().getTs());
//
//        if (dataStatus.value() == (DataStatus.enable.value())){
//            role.setStatus(DataStatus.enable.value());
//        }else {
//            role.setStatus(DataStatus.disable.value());
//        }
//
//        boolean update = this.roleService.setStatus(role, dataStatus == DataStatus.enable);
//        if (update){
//            return R.create().code(R.SUCCESS_CODE).message(R.SUCCESS_MSG);
//        }else {
//            return R.create().code(R.FAILED_CODE).message(R.FAILED_MSG);
//        }
//    }
//
//    /**
//     * 转换VO页面显示数据
//     *
//     * @param data
//     */
//    @Override
//    protected  List<RoleVO> doConvertVOs(List<Role> data) {
//        if (CollectionUtils.isEmpty(data)){
//            return Collections.EMPTY_LIST;
//        }
//
//        List<RoleVO> vos = data.stream().map(o -> BeanMapper.map(o, BeanMapper.getType(Role.class), BeanMapper.getType(RoleVO.class)))
//                .collect(Collectors.toList());
//        return vos;
//    }
//
//    @Override
//    protected List<QueryItem> doBeforePageAddSearchParam(RoleVO vo) {
//        List<QueryItem> items = super.doBeforePageAddSearchParam(vo);
//        if(StringUtils.isNotBlank(vo.getName())){
//            QueryItem item = new QueryItem();
//            item.setQueryField("name");
//            item.setValue(vo.getName());
//            item.setType(QueryType.like);
//            items.add(item);
//        }
//        if(StringUtils.isNotBlank(vo.getCode())){
//            QueryItem item = new QueryItem();
//            item.setQueryField("code");
//            item.setValue(vo.getCode());
//            item.setType(QueryType.like);
//            items.add(item);
//        }
//        if (vo.getStatus() != null ){
//            QueryItem item = new QueryItem();
//            item.setQueryField("status");
//            item.setValue(vo.getStatus());
//            item.setType(QueryType.eq);
//            items.add(item);
//        }
//        if (vo.getType() != null ){
//            QueryItem item = new QueryItem();
//            item.setQueryField("type");
//            item.setValue(vo.getType());
//            item.setType(QueryType.eq);
//            items.add(item);
//        }
//
//        return items;
//    }
//
//    /**
//     * 新增校验
//     *
//     * @param data
//     */
//    @Override
//    protected R parametericCheckBeforeCreate(RoleVO data) {
//        if (StringUtils.isBlank(data.getName())){
//            return R.create().code(R.FAILED_CODE).message("角色名称不能为空！");
//        }
//
//        //敏感词校验
//        R r = super.validCheck(data);
//        if (r.getCode() == R.FAILED_CODE){
//            r.message(r.getMessage());
//            return r;
//        }
//
//        if (StringUtils.isBlank(data.getCode())){
//            return R.create().code(R.FAILED_CODE).message("角色编码不能为空！");
//        }
//        return R.create().code(R.SUCCESS_CODE);
//    }
//
//    /**
//     * 展示层&model实体转换
//     *
//     * @param data
//     */
//    @Override
//    protected Role doConvertModel(RoleVO data) {
//        return BeanMapper.map(data, BeanMapper.getType(RoleVO.class), BeanMapper.getType(Role.class));
//    }
//
//    @Override
//    protected void doBeforeCreate(Role role) {
//        //
//    }
//
//    /**
//     * model->VO
//     *
//     * @param role
//     */
//    @Override
//    protected RoleVO doConvertVO(Role role) {
//        return BeanMapper.map(role, BeanMapper.getType(Role.class), BeanMapper.getType(RoleVO.class));
//    }
//
//    /**
//     * 更新校验
//     *
//     * @param data
//     */
//    @Override
//    protected R parametericCheckBeforeUpdate(RoleVO data) {
//        if (StringUtils.isBlank(data.getName())){
//            return R.create().code(R.FAILED_CODE).message("角色名称不能为空！");
//        }
//        //敏感词校验
//        R r = super.validCheck(data);
//        if (r.getCode() == R.FAILED_CODE){
//            r.message(r.getMessage());
//            return r;
//        }
//
//        if (StringUtils.isBlank(data.getCode())){
//            return R.create().code(R.FAILED_CODE).message("角色编码不能为空！");
//        }
//        return R.create().code(R.SUCCESS_CODE);
//    }
//
//    @Override
//    protected void doBeforeDelete(Role role) {
//    }
//
//    /**
//     * 是否存在添加动态查询参数
//     *
//     * @param data
//     */
//    @Override
//    protected List<QueryItem> doBeforeCheckExistsAddSearchParam(RoleVO data) {
//        List<QueryItem> items = new ArrayList<>();
//        if (StringUtils.isNotBlank(data.getName())){
//            QueryItem item = new QueryItem();
//            item.setQueryField("name");
//            item.setValue(data.getName());
//            item.setType(QueryType.eq);
//            items.add(item);
//        }
//        if (StringUtils.isNotBlank(data.getCode())){
//            QueryItem item = new QueryItem();
//            item.setQueryField("code");
//            item.setValue(data.getCode());
//            item.setType(QueryType.eq);
//            items.add(item);
//        }
//
//        return items;
//    }
//
//
//    @Override
//    protected void doBeforeUpdate(Role role) {
////        List<Long> menuIds = role.getMenuIds();
////        if (CollectionUtils.isEmpty(menuIds)){
////            return;
////        }
////
////        List<Long> newMenuIds = Lists.newArrayList(menuIds);
////        menuIds.forEach(id ->{
////            Menu menu = menuService.get(id);
////            long parentId = menu.getParentId();
////            if (parentId != -1){
////                newMenuIds.add(parentId);
////            }
////        });
////
////        role.setMenuIds(newMenuIds);
//    }
//
//}
