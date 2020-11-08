//package com.fm.api.web.controller.sm;
//
//import com.fm.business.base.model.sm.Menu;
//import com.fm.business.base.service.sm.IMenuService;
//import com.fm.business.base.service.sm.IPermissionService;
//import com.fm.framework.core.query.QueryItem;
//import com.fm.framework.core.query.QueryType;
//import com.fm.framework.core.service.Service;
//import com.google.common.collect.Lists;
//
//import lombok.RequiredArgsConstructor;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
///**
// * 菜单.
// */
//@RestController
//@RequestMapping("api/menu")
//@RequiredArgsConstructor
//public class MenuController extends BaseController<Menu, MenuVO> {
//
//    private final IMenuService menuService;
//
//    private final IPermissionService permissionService;
//
//    @Override
//    protected Service<Menu> service() {
//        return this.menuService;
//    }
//
//    @Override
//    protected String cnName() {
//        return "菜单";
//    }
//
//
//    @PostMapping("/pagelist")
//    public R list(@RequestBody RestRequest<MenuVO> restRequest){
//        //分页
//        return super.standardPageList(restRequest);
//    }
//
//    @PostMapping("/queryList")
//    public R queryList(@RequestBody RestRequest<MenuVO> restRequest){
//        if (!restRequest.baseCheck()){
//            return R.create().code(R.FAILED_CODE).message("请求参数异常!");
//        }
//        MenuVO vo = restRequest.getData();
//
//        List<QueryItem> queryItems = new ArrayList<>();
//        if (StringUtils.isNotBlank(vo.getName())){
//            QueryItem item = new QueryItem();
//            item.setQueryField("name");
//            item.setValue(vo.getName());
//            item.setType(QueryType.like);
//            queryItems.add(item);
//        }
//        if (StringUtils.isNotBlank(vo.getCode())){
//            QueryItem item = new QueryItem();
//            item.setQueryField("code");
//            item.setValue(vo.getCode());
//            item.setType(QueryType.rightLike);
//            queryItems.add(item);
//        }
//
//        if (vo.getStatus() != null ){
//            QueryItem item = new QueryItem();
//            item.setQueryField("status");
//            item.setValue(vo.getStatus());
//            item.setType(QueryType.eq);
//            queryItems.add(item);
//        }
//
//        if (vo.getProductId() != null){
//            QueryItem item = new QueryItem();
//            item.setQueryField("product_id");
//            item.setValue(vo.getProductId());
//            item.setType(QueryType.eq);
//            queryItems.add(item);
//        }
//
//        if (vo.getType() != null){
//            QueryItem item = new QueryItem();
//            item.setQueryField("type");
//            item.setValue(vo.getType());
//            item.setType(QueryType.eq);
//            queryItems.add(item);
//        }
//
//        List<Menu> menus = menuService.get(queryItems);
//
//        if (CollectionUtils.isEmpty(menus)){
//            return R.createSuccessR();
//        }
//
//        List<MenuVO> menuVOS = this.doConvertVOs(menus);// 反馈前端忽略菜单url
//
//        List<String> codeList = menus.stream().map(Menu::getProductCode).collect(Collectors.toList());
//        Map<String, Product> productMap = productService.getProducts(codeList).stream().collect(Collectors.toMap(Product::getCode, Function.identity()));
//
//        menuVOS = menuVOS.stream().peek(m -> {m.setProductName(productMap.get(m.getProductCode()).getName());
//                            m.setHasChildren(false);//普通查询设置无子节点，消失页面三角
//                        }).collect(Collectors.toList());
//        menuVOS.sort(Comparator.comparingInt(MenuVO::getSq));
//        return R.createSuccessR().data(menuVOS);
//    }
//
//    @PostMapping("/listAll")
//    public R listAll(){
//
//        QueryItem item = new QueryItem();
//        item.setQueryField("parent_id");
//        item.setValue(Lists.newArrayList(0, -1)); // 父节点
//        item.setType(QueryType.in);
//
//        List<Menu> menus = menuService.get(Collections.singletonList(item));
//        if (CollectionUtils.isEmpty(menus)){
//            return R.createSuccessR();
//        }
//
//        List<MenuVO> menuVOS = this.doConvertVOs(menus);
//
//        List<String> codeList = menus.stream().map(Menu::getProductCode).collect(Collectors.toList());
//        Map<String, Product> productMap = productService.getProducts(codeList).stream().collect(Collectors.toMap(Product::getCode, Function.identity()));
//
//        menuVOS = menuVOS.stream().peek(m -> m.setProductName(productMap.get(m.getProductCode()).getName())).collect(Collectors.toList());
//        menuVOS.sort(Comparator.comparingInt(MenuVO::getSq));
//
//
//        return R.createSuccessR().data(menuVOS);
//    }
//
//    @Override
//    protected void doAfterPageSearch(PageImpl<MenuVO> page) {
//        super.doAfterPageSearch(page);
//        List<MenuVO> data = page.getData();
//        if (CollectionUtils.isEmpty(data)){
//            return;
//        }
//
//        TreeNode<MenuVO> root = TreeUtil.buildTree(data);
//        List<TreeNode<MenuVO>> childs = root.getChilds();
//        if (CollectionUtils.isEmpty(childs)){
//            return;
//        }
//        TreeNode<MenuVO> menuRoot = childs.get(0);
//        TreeUtil.setParentNull(menuRoot);
//    }
//
//    @PostMapping("/save")
//    public R create(@RequestBody RestRequest<MenuVO> restRequest){
//        return super.standardCreate(restRequest);
//    }
//
//    @PostMapping("/deleteById")
//    public R deleteById(@RequestBody RestRequest<MenuVO> restRequest){
//        return super.standardDeleteById(restRequest);
//    }
//
//    @Override
//    protected R parametericCheckBeforeDelete(MenuVO menuVO) {
//        //菜单删除规则
//        //1、没有子菜单
////        List<QueryItem> menuItems = new ArrayList<>();
////        QueryItem parentIdMenuItem = new QueryItem();
////        parentIdMenuItem.setType(QueryType.eq);
////        parentIdMenuItem.setValue(menuVO.getId());
////        parentIdMenuItem.setQueryField("parent_id");
////        menuItems.add(parentIdMenuItem);
////
////        int menuCount = this.menuService.countEnableStatus(menuItems);
////        if (menuCount > 0){
////            return R.createFailR().message("待删除的菜单不能存在子菜单！");
////        }
//
//        //2、没有关联角色
//        List<QueryItem> roleItems = new ArrayList<>();
//        QueryItem menuIdItem = new QueryItem();
//        menuIdItem.setType(QueryType.eq);
//        menuIdItem.setValue(menuVO.getId());
//        menuIdItem.setQueryField("menu_id");
//        roleItems.add(menuIdItem);
//
//        int roleCount = this.permissionService.countEnableStatus(roleItems);
//        if (roleCount > 0){
//            return R.createFailR().message("待删除的菜单不能存在关联的角色！");
//        }
//        return R.createSuccessR();
//    }
//
//    @PostMapping("/update")
//    public R update(@RequestBody RestRequest<MenuVO> restRequest){
//        return super.standardUpdate(restRequest);
//    }
//
//    @Override
//    protected void doBeforeUpdate(Menu menu) {
//        super.doBeforeUpdate(menu);
//        //父级菜单不能修改
////        Menu menuOld = this.menuService.get(menu.getId());
////        menu.setParentId(menuOld.getParentId());
//    }
//
//    @PostMapping("/getAllChild")
//    public R getAllChild(@RequestBody RestRequest<MenuVO> restRequest){
//        return this.findChild(restRequest, true);
//    }
//
//    @PostMapping("/getDirectChild")
//    public R getDirectChild(@RequestBody RestRequest<MenuVO> restRequest){
//        return this.findChild(restRequest, false);
//    }
//
//    @PostMapping("getMenusByRoleId")
//    public R getMenusByRoleId(@RequestBody RestRequest<MenuVO> restRequest){
//        if (!restRequest.baseCheck() || restRequest.getData().getId() == null){
//            return  R.create().code(R.FAILED_CODE).message("参数错误, 请重试!");
//        }
//
//        //通过角色id查询菜单
//        Role role = new Role();
//        role.setId(restRequest.getData().getId());
//
//        List<Menu> menus = permissionService.getPermissions(role);
//        return R.create().data(menus).code(R.SUCCESS_CODE).message(R.SUCCESS_MSG);
//    }
//
//    /*
//    * 查询当前租户下所有已启用的菜单
//    * */
//    @GetMapping("getAllMenus")
//    public R getAllMenus(){
//        List<Menu> allEnableMenus = menuService.getAllEnableMenus(Collections.emptyList());
//        List<MenuVO> menuVOs = this.doConvertVOs(allEnableMenus);
//
//        return R.create().data(menuVOs).code(R.SUCCESS_CODE).message(R.SUCCESS_MSG);
//    }
//
//    /*
//    * 根据产品查询当前租户下所有已启用的菜单
//    * */
//    @PostMapping("getAllMenusByProduct")
//    public R getAllMenusByProduct(@RequestBody MenuVO menuVO){
//        QueryItem item = new QueryItem();
//        item.setQueryField("product_id");
//        item.setValue(menuVO.getProductId());
//        item.setType(QueryType.eq);
//
//        List<Menu> allEnableMenus = menuService.getAllEnableMenus(Collections.singletonList(item));
//        List<MenuVO> menuVOs = this.doConvertVOs(allEnableMenus);
//
//        return R.create().data(menuVOs).code(R.SUCCESS_CODE).message(R.SUCCESS_MSG);
//    }
//
//
//    /**
//     * 查找菜单子节点
//     * @param ifAll  true:查询所有(直接和间接子节点)   false:查询直接子节点
//     * */
//    private R findChild(@RequestBody RestRequest<MenuVO> restRequest, boolean ifAll) {
//        if (!restRequest.baseCheck()){
//            return R.create().code(R.FAILED_CODE).message("查询参数不能为空!");
//        }
//
//        MenuVO data = restRequest.getData();
//        Long parentId = data.getParentId();
//        if (parentId == null){
//            return R.create().code(R.FAILED_CODE).message("父级id不能为空!");
//        }
//
//        List<Menu> children;
//        if (ifAll){
//            children = this.menuService.findAllChild(parentId);
//        }else {
//            Menu menu = new Menu();
//            menu.setId(parentId);
//            children = this.menuService.findChild(menu);
//        }
//
//        if (CollectionUtils.isEmpty(children)){
//            return R.createSuccessR();
//        }
//
//        List<MenuVO> menuVOs = this.doConvertVOs(children);
//
//        List<String> codeList = menuVOs.stream().map(MenuVO::getProductCode).collect(Collectors.toList());
//        Map<String, Product> productMap = productService.getProducts(codeList).stream().collect(Collectors.toMap(Product::getCode, Function.identity()));
//
//        menuVOs = menuVOs.stream().peek(m -> m.setProductName(productMap.get(m.getProductCode()).getName())).collect(Collectors.toList());
//
//        menuVOs.sort(Comparator.comparingInt(MenuVO::getSq));
//        return R.create().data(menuVOs).code(R.SUCCESS_CODE).message(R.SUCCESS_MSG);
//    }
//
//    @PostMapping("/checkIfExists")
//    public R checkIfExists(@RequestBody RestRequest<MenuVO> restRequest){
//        return super.standardCheckExists(restRequest);
//    }
//
//    @PostMapping("/enable")
//    public R enable(@RequestBody RestRequest<MenuVO> restRequest){
//        return this.changeDataStatus(restRequest, DataStatus.enable);
//    }
//
//    @PostMapping("/disable")
//    public R disable(@RequestBody RestRequest<MenuVO> restRequest){
//        return this.changeDataStatus(restRequest, DataStatus.disable);
//    }
//
//    /**
//     * 更改数据状态 启动 禁用
//     * @param dataStatus  enable：启用  disable：禁用
//     * */
//    private R changeDataStatus(@RequestBody RestRequest<MenuVO> restRequest, DataStatus dataStatus) {
//        if (!restRequest.baseCheck() || restRequest.getData().getId() == null){
//            return R.create().code(R.FAILED_CODE).message("参数错误 请重试!");
//        }
//
//        Menu menu = new Menu();
//        menu.setId(restRequest.getData().getId());
//        menu.setTs(restRequest.getData().getTs());
//
//        if (dataStatus.value() == (DataStatus.enable.value())){
//            menu.setStatus(DataStatus.enable.value());
//        }else {
//            menu.setStatus(DataStatus.disable.value());
//        }
//
//        boolean update = this.menuService.update(menu);
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
//    protected  List<MenuVO> doConvertVOs(List<Menu> data) {
//        if (CollectionUtils.isEmpty(data)){
//            return Collections.emptyList();
//        }
//
//        //// TODO: 2020/3/22 产品名称
//
//        List<Long> ids = data.stream().map(Menu::getParentId).collect(Collectors.toList());
//        List<Menu> parentMenus = menuService.getMenus(ids);
//        Map<Long, String> menuMap = parentMenus.stream().collect(Collectors.toMap(Menu::getId, Menu::getName, (oldKey, newKey) -> newKey));
//
//        List<MenuVO> vos = data.stream().map(o -> {
//            MenuVO vo = BeanMapper.map(o, BeanMapper.getType(Menu.class), BeanMapper.getType(MenuVO.class));
//            vo.setParentName(menuMap.get(vo.getParentId()));
//            vo.setHref(null);
//            return vo;
//        }).collect(Collectors.toList());
//
//        return vos;
//    }
//
//    @GetMapping("/tree")
//    public R getTree() {
//        List<Menu> menus = menuService.getAllEnableStatus();
//        List<MenuVO> menuVOs = this.doConvertVOs(menus);
//        if (CollectionUtils.isEmpty(menuVOs)){
//            return R.createSuccessR();
//        }
//        TreeNode<MenuVO> root = TreeUtil.buildTree(menuVOs);
//        List<TreeNode<MenuVO>> childs = root.getChilds();
//        if (CollectionUtils.isEmpty(childs)){
//            return R.createSuccessR();
//        }
//
//        List<TreeNodeVO> result = new ArrayList<>();
//
//        for (TreeNode<MenuVO> child : childs) {
//            result.add(convert(child));
//        }
//
//        result.sort(Comparator.comparingInt(TreeNodeVO::getSq));
//
//        return R.createSuccessR().data(result);
//
//    }
//
//    @PostMapping("/parentMenuTree")
//    public R getMenuTree(@RequestBody MenuVO menuVO) {
//        Long productId = menuVO.getProductId();
//        List<QueryItem> items = new ArrayList<>();
////        QueryItem productIdItem = new QueryItem();
////        productIdItem.setQueryField("product_id");
////        productIdItem.setValue(productId);
////        productIdItem.setType(QueryType.eq);
////        items.add(productIdItem);
//
//
//
//        List<Menu> childMenu = menuService.findAllChildByNodeId(menuVO.getId());
//
//        List<Long> exIds = childMenu.stream().map(Menu::getId).collect(Collectors.toList());
//        exIds.add(menuVO.getId());
//
//        QueryItem exIdItem = new QueryItem();
//        exIdItem.setQueryField(DBFieldConst.ID);
//        exIdItem.setValue(exIds);
//        exIdItem.setType(QueryType.notIn);
//        items.add(exIdItem);
//
//        QueryItem typeItem = new QueryItem();
//        typeItem.setQueryField("type");
//        typeItem.setValue(MenuType.button.value());
//        typeItem.setType(QueryType.ne);
//        items.add(typeItem);
//
//        List<Menu> menus = menuService.get(items);
//
//        List<MenuVO> menuVOs = menus.stream().map(o -> {
//            MenuVO vo = BeanMapper.map(o, BeanMapper.getType(Menu.class), BeanMapper.getType(MenuVO.class));
//            vo.setHref(null);
//            return vo;
//        }).collect(Collectors.toList());
//
//
//        if (CollectionUtils.isEmpty(menuVOs)){
//            return R.createSuccessR();
//        }
//
//        TreeNode<MenuVO> root = TreeUtil.buildTree(menuVOs);
//        List<TreeNode<MenuVO>> childs = root.getChilds();
//        if (CollectionUtils.isEmpty(childs)){
//            return R.createSuccessR();
//        }
//
//        List<TreeNodeVO> result = new ArrayList<>();
//
//        for (TreeNode<MenuVO> child : childs) {
//            result.add(convert(child));
//        }
//
//        return R.createSuccessR().data(result);
//
//    }
//
//    private TreeNodeVO convert(TreeNode<MenuVO> node) {
//        TreeNodeVO treeNodeVO = new TreeNodeVO();
//        MenuVO menu = node.getValue();
//        String typeStr = "";
//        if (menu.getType() == MenuType.menu.value()){
//            typeStr = "菜单";
//        }
//        if (menu.getType() == MenuType.button.value()){
//            typeStr = "按钮";
//        }
//        if (menu.getType() == MenuType.module.value()){
//            typeStr = "模块";
//        }
//        treeNodeVO.setId(menu.getId());
//        treeNodeVO.setLabel(menu.getCode() + " " + menu.getName() + " | " + typeStr);
//        treeNodeVO.setSq(menu.getSq());
//
//        if(!node.isLeaf()) {
//
//            List<TreeNodeVO> child = new ArrayList<>();
//
//            node.getChilds().forEach(n -> {
//                TreeNodeVO childNode = convert(n);
//                child.add(childNode);
//            });
//            treeNodeVO.setChildren(child);
//        }
//
//        return treeNodeVO;
//
//    }
//
//
//    /*
//    * 添加分页查询参数
//    * */
//    @Override
//    protected List<QueryItem> doBeforePageAddSearchParam(MenuVO vo) {
//        List<QueryItem> queryItems = super.doBeforePageAddSearchParam(vo);
//        if (StringUtils.isNotBlank(vo.getName())){
//            QueryItem item = new QueryItem();
//            item.setQueryField("name");
//            item.setValue(vo.getName());
//            item.setType(QueryType.leftLike);
//            queryItems.add(item);
//        }
//        if (StringUtils.isNotBlank(vo.getCode())){
//            QueryItem item = new QueryItem();
//            item.setQueryField("code");
//            item.setValue(vo.getCode());
//            item.setType(QueryType.leftLike);
//            queryItems.add(item);
//        }
//
//        if (vo.getStatus() != null ){
//            QueryItem item = new QueryItem();
//            item.setQueryField("status");
//            item.setValue(vo.getStatus());
//            item.setType(QueryType.eq);
//            queryItems.add(item);
//        }
//
//        if (vo.getParentId() != null){
//            QueryItem item = new QueryItem();
//            item.setQueryField("parent_id");
//            item.setValue(vo.getParentId());
//            item.setType(QueryType.eq);
//            queryItems.add(item);
//        }else{
//            QueryItem item = new QueryItem();
//            item.setQueryField("parent_id");
//            item.setValue(Lists.newArrayList(0, -1)); // 父节点
//            item.setType(QueryType.in);
//            queryItems.add(item);
//        }
//
//        if (vo.getProductId() != null){
//            QueryItem item = new QueryItem();
//            item.setQueryField("product_id");
//            item.setValue(vo.getProductId());
//            item.setType(QueryType.eq);
//            queryItems.add(item);
//        }
//        return queryItems;
//    }
//
//    /**
//     * 新增校验
//     *
//     * @param data
//     */
//    @Override
//    protected R parametericCheckBeforeCreate(MenuVO data) {
//        if (StringUtils.isBlank(data.getName())){
//            return R.create().code(R.FAILED_CODE).message("菜单名称不能为空!");
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
//            return R.create().code(R.FAILED_CODE).message("菜单编码不能为空!");
//        }
//
//        if (data.getProductId() == null){
//            return R.create().code(R.FAILED_CODE).message("菜单关联产品不能为空!");
//        }
//
//
//        if (data.getType() != null && MenuType.menu.value() == (data.getType()) && StringUtils.isBlank(data.getHref())){
//            return R.create().code(R.FAILED_CODE).message("菜单链接不能为空!");
//        }
//
//        return R.create().code(R.SUCCESS_CODE);
//    }
//
//    /**
//     * 展示层&model实体转换
//     *
//     * @param data
//     */
//    @Override
//    protected Menu doConvertModel(MenuVO data) {
//        return BeanMapper.map(data, BeanMapper.getType(MenuVO.class), BeanMapper.getType(Menu.class));
//    }
//
//    @Override
//    protected void doBeforeCreate(Menu menu) {
//        // 菜单授权
//
//    }
//
//    /**
//     * model->VO
//     *
//     * @param menu
//     */
//    @Override
//    protected MenuVO doConvertVO(Menu menu) {
//        return BeanMapper.map(menu, BeanMapper.getType(Menu.class), BeanMapper.getType(MenuVO.class));
//    }
//
//    /**
//     * 更新校验
//     *
//     * @param data
//     */
//    @Override
//    protected R parametericCheckBeforeUpdate(MenuVO data) {
//        if (StringUtils.isBlank(data.getName())){
//            return R.create().code(R.FAILED_CODE).message("菜单名称不能为空!");
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
//            return R.create().code(R.FAILED_CODE).message("菜单编码不能为空!");
//        }
//
//        if (data.getProductId() == null){
//            return R.create().code(R.FAILED_CODE).message("菜单关联产品不能为空!");
//        }
//
//        Menu old = this.menuService.get(data.getId());
//
//        if(!old.getParentId().equals(data.getParentId())) {
//            //2、没有关联角色
//            List<QueryItem> roleItems = new ArrayList<>();
//            QueryItem menuIdItem = new QueryItem();
//            menuIdItem.setType(QueryType.eq);
//            menuIdItem.setValue(data.getId());
//            menuIdItem.setQueryField("menu_id");
//            roleItems.add(menuIdItem);
//
//            int roleCount = this.permissionService.countEnableStatus(roleItems);
//
//            if (roleCount > 0){
//                return R.createFailR().message("如果需要修改菜单父节点，请先取消关联的角色！");
//            }
//        }
//
//        //todo add 不能修改的属性
//
//        return R.create().code(R.SUCCESS_CODE);
//    }
//
//    @Override
//    protected void doBeforeDelete(Menu menu) {
//    }
//
//    /**
//     * 是否存在添加动态查询参数
//     *
//     * @param data
//     */
//    @Override
//    protected List<QueryItem> doBeforeCheckExistsAddSearchParam(MenuVO data) {
//        List<QueryItem> items =  new ArrayList<>();
//
//        if (StringUtils.isNotBlank(data.getName())){
//            QueryItem item =  new QueryItem();
//            item.setQueryField("name");
//            item.setValue(data.getName());
//            item.setType(QueryType.eq);
//            items.add(item);
//        }
//
//        if (StringUtils.isNotBlank(data.getCode())){
//            QueryItem item =  new QueryItem();
//            item.setQueryField("code");
//            item.setValue(data.getCode());
//            item.setType(QueryType.eq);
//            items.add(item);
//        }
//
//        if (StringUtils.isNotBlank(data.getHref())){
//            QueryItem item =  new QueryItem();
//            item.setQueryField("href");
//            item.setValue(data.getCode());
//            item.setType(QueryType.eq);
//            items.add(item);
//        }
//        if (data.getParentId() == null){
//            QueryItem parentIdItem =  new QueryItem();
//            parentIdItem.setQueryField("parent_id");
//            parentIdItem.setValue(Arrays.asList(0, -1));
//            parentIdItem.setType(QueryType.in);
//            items.add(parentIdItem);
//        }else {
//            QueryItem parentIdItem =  new QueryItem();
//            parentIdItem.setQueryField("parent_id");
//            parentIdItem.setValue(data.getParentId());
//            parentIdItem.setType(QueryType.eq);
//        }
//
//        return items;
//    }
//
//    /**
//     * 检查是否存在参数校验
//     * */
//    @Override
//    protected R doParametericCheckBeforeCheckExists(MenuVO data) {
//
//        return super.doParametericCheckBeforeCheckExists(data);
//    }
//
//}
