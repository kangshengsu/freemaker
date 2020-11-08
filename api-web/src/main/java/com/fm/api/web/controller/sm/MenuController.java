package com.fm.api.web.controller.sm;

import com.fm.api.web.vo.sm.MenuVO;
import com.fm.api.web.vo.sm.TreeNodeVO;
import com.fm.api.web.vo.sm.mapper.MenuMapper;
import com.fm.business.base.model.sm.Menu;
import com.fm.business.base.model.sm.MenuType;
import com.fm.business.base.model.sm.Role;
import com.fm.business.base.service.sm.IMenuService;
import com.fm.business.base.service.sm.IPermissionService;
import com.fm.framework.core.model.DBFieldConst;
import com.fm.framework.core.model.DataStatus;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.TreeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 菜单.
 */
@RestController
@RequestMapping("api/menu")
@RequiredArgsConstructor
public class MenuController extends BaseController<Menu, MenuVO> {

    @Autowired
    private IMenuService menuService;
    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    protected Service<Menu> service() {
        return this.menuService;
    }

    /**
     * 分页获取菜单信息
     *
     * @param QueryRequest
     * @return
     */
    @PostMapping("/pagelist")
    public ApiResponse<Page<MenuVO>> list(@RequestBody QueryRequest queryRequest) {
        // TODO: 2020/11/8 暂时定位前台组装参数,不在后台进行拼装
        return super.list(queryRequest);
    }


    @PostMapping("/queryList")
    public ApiResponse<List<MenuVO>> queryList(@RequestBody QueryRequest queryRequest) {
        // TODO: 2020/11/8 暂时定位前台组装参数,不在后台进行拼装
        /*List<QueryItem> queryItems = new ArrayList<>();
        if (StringUtils.isNotBlank(vo.getName())) {
            QueryItem item = new QueryItem();
            item.setQueryField("name");
            item.setValue(vo.getName());
            item.setType(QueryType.like);
            queryItems.add(item);
        }
        if (StringUtils.isNotBlank(vo.getCode())) {
            QueryItem item = new QueryItem();
            item.setQueryField("code");
            item.setValue(vo.getCode());
            item.setType(QueryType.rightLike);
            queryItems.add(item);
        }

        if (vo.getStatus() != null) {
            QueryItem item = new QueryItem();
            item.setQueryField("status");
            item.setValue(vo.getStatus());
            item.setType(QueryType.eq);
            queryItems.add(item);
        }

        if (vo.getProductId() != null) {
            QueryItem item = new QueryItem();
            item.setQueryField("product_id");
            item.setValue(vo.getProductId());
            item.setType(QueryType.eq);
            queryItems.add(item);
        }

        if (vo.getType() != null) {
            QueryItem item = new QueryItem();
            item.setQueryField("type");
            item.setValue(vo.getType());
            item.setType(QueryType.eq);
            queryItems.add(item);
        }*/

        //获取菜单信息
        List<MenuVO> menuVOList = this.convert(menuService.get(queryRequest.getQueryItems()));

        if (CollectionUtils.isEmpty(menuVOList)) {
            return this.success(Collections.EMPTY_LIST);
        }
        //菜单排序
        menuVOList.sort(Comparator.comparingInt(MenuVO::getSq));
        return this.success(menuVOList);
    }



    @PostMapping("/listAll")
    public ApiResponse<List<MenuVO>> listAll() {

        QueryItem item = new QueryItem();
        item.setQueryField("parent_id");
        item.setValue(Lists.newArrayList(0, -1)); // 父节点
        item.setType(QueryType.in);

        List<Menu> menus = menuService.get(Collections.singletonList(item));
        if (CollectionUtils.isEmpty(menus)) {
            return this.success(Collections.EMPTY_LIST);
        }

        List<MenuVO> menuVOS = this.convert(menus);

        /*List<String> codeList = menus.stream().map(Menu::getProductCode).collect(Collectors.toList());
        Map<String, Product> productMap = productService.getProducts(codeList).stream().collect(Collectors.toMap(Product::getCode, Function.identity()));

        menuVOS = menuVOS.stream().peek(m -> m.setProductName(productMap.get(m.getProductCode()).getName())).collect(Collectors.toList());
       */

        menuVOS.sort(Comparator.comparingInt(MenuVO::getSq));

        return this.success(menuVOS);
    }

    @PostMapping("/save")
    public ApiResponse<Boolean> create(@RequestBody MenuVO menuVO) {
        if (StringUtils.isBlank(menuVO.getName())) {
            return this.failed("菜单名称不能为空!");
        }

        if (StringUtils.isBlank(menuVO.getCode())) {
            return this.failed("菜单编码不能为空!");
        }

        if (menuVO.getProductId() == null) {
            return this.failed("菜单关联产品不能为空!");
        }


        if (menuVO.getType() != null && MenuType.menu.value() == (menuVO.getType()) && StringUtils.isBlank(menuVO.getHref())) {
            return this.failed("菜单链接不能为空!");
        }

        return super.create(menuVO);
    }

    @PostMapping("/deleteById")
    public ApiResponse<Boolean> deleteById(@RequestBody Long id) {
        //菜单删除规则
        //1、没有子菜单
//        List<QueryItem> menuItems = new ArrayList<>();
//        QueryItem parentIdMenuItem = new QueryItem();
//        parentIdMenuItem.setType(QueryType.eq);
//        parentIdMenuItem.setValue(menuVO.getId());
//        parentIdMenuItem.setQueryField("parent_id");
//        menuItems.add(parentIdMenuItem);
//
//        int menuCount = this.menuService.countEnableStatus(menuItems);
//        if (menuCount > 0){
//            return R.createFailR().message("待删除的菜单不能存在子菜单！");
//        }

        //2、没有关联角色
        List<QueryItem> roleItems = new ArrayList<>();
        QueryItem menuIdItem = new QueryItem();
        menuIdItem.setType(QueryType.eq);
        menuIdItem.setValue(id);
        menuIdItem.setQueryField("menu_id");
        roleItems.add(menuIdItem);

        int roleCount = this.permissionService.countEnableStatus(roleItems);
        if (roleCount > 0) {
            return failed("待删除的菜单不能存在关联的角色！");
        }
        return success(service().delete(id));
    }

    @PostMapping("/update")
    public ApiResponse<Boolean> update(@RequestBody MenuVO menuVO) {
        return super.update(menuVO);
    }


    @PostMapping("/getAllChild")
    public ApiResponse<List<MenuVO>>  getAllChild(@RequestBody Long parentId) {
        return this.findChild(parentId, true);
    }

    @PostMapping("/getDirectChild")
    public ApiResponse<List<MenuVO>>  getDirectChild(@RequestBody Long parentId) {
        return this.findChild(parentId, false);
    }

    @PostMapping("getMenusByRoleId")
    public ApiResponse<List<Menu>> getMenusByRoleId(@RequestBody Long roleId) {

        //通过角色id查询菜单
        Role role = new Role();
        role.setId(roleId);
        List<Menu> menus = permissionService.getPermissions(role);
        return this.success(menus);
    }

    /*
     * 查询当前租户下所有已启用的菜单
     * */
    @GetMapping("getAllMenus")
    public ApiResponse<List<MenuVO>>  getAllMenus() {
        List<Menu> allEnableMenus = menuService.getAllEnableMenus(Collections.emptyList());
        List<MenuVO> menuVOs = this.convert(allEnableMenus);
        return this.success(menuVOs);
    }

    /*
     * 根据产品查询当前租户下所有已启用的菜单
     * */
    @PostMapping("getAllMenusByProduct")
    public ApiResponse<List<MenuVO>> getAllMenusByProduct(@RequestBody MenuVO menuVO) {
        QueryItem item = new QueryItem();
        item.setQueryField("product_id");
        item.setValue(menuVO.getProductId());
        item.setType(QueryType.eq);

        List<Menu> allEnableMenus = menuService.getAllEnableMenus(Collections.singletonList(item));
        List<MenuVO> menuVOs = this.convert(allEnableMenus);
        return this.success(menuVOs);
    }


    /**
     * 查找菜单子节点
     *
     * @param ifAll true:查询所有(直接和间接子节点)   false:查询直接子节点
     */
    private ApiResponse<List<MenuVO>> findChild(Long parentId, boolean ifAll) {
        if (parentId == null) {
            return this.failed("父级id不能为空!");
        }

        List<Menu> children;
        if (ifAll) {
            children = this.menuService.findAllChild(parentId);
        } else {
            Menu menu = new Menu();
            menu.setId(parentId);
            children = this.menuService.findChild(menu);
        }

        if (CollectionUtils.isEmpty(children)) {
            return this.success(Collections.EMPTY_LIST);
        }

        List<MenuVO> menuVOs = this.convert(children);

        /*
            这个目前不要了
            List<String> codeList = menuVOs.stream().map(MenuVO::getProductCode).collect(Collectors.toList());
            Map<String, Product> productMap = productService.getProducts(codeList).stream().collect(Collectors.toMap(Product::getCode, Function.identity()));

            menuVOs = menuVOs.stream().peek(m -> m.setProductName(productMap.get(m.getProductCode()).getName())).collect(Collectors.toList());
        */
        menuVOs.sort(Comparator.comparingInt(MenuVO::getSq));
        return this.success(menuVOs);
    }

    @PostMapping("/checkIfExists")
    public ApiResponse<Boolean> checkIfExists(@RequestBody QueryRequest queryRequest) {
        // TODO: 2020/11/8 暂时定位前台组装参数,不在后台进行拼装
        int count = this.service().count(queryRequest.getQueryItems());
        return this.success(count > 0);
    }

    @PostMapping("/enable")
    public ApiResponse enable(@RequestBody Long id) {
        return this.changeDataStatus(id, DataStatus.enable);
    }

    @PostMapping("/disable")
    public ApiResponse disable(@RequestBody Long id) {
        return this.changeDataStatus(id, DataStatus.disable);
    }

    /**
     * 更改数据状态 启动 禁用
     *
     * @param dataStatus enable：启用  disable：禁用
     */
    private ApiResponse<Boolean> changeDataStatus(Long id, DataStatus dataStatus) {
        if (id == null) {
            return this.failed("参数错误 请重试!");
        }
        Menu menu = new Menu();
        menu.setId(id);

        if (dataStatus == (DataStatus.enable)) {
            menu.setStatus(DataStatus.enable.code());
        } else {
            menu.setStatus(DataStatus.disable.code());
        }

        boolean update = this.menuService.update(menu);
        if (update) {
            return this.success(Boolean.TRUE);
        } else {
            return this.failed(ApiStatus.FAILED.getMessage());
        }
    }


    @GetMapping("/tree")
    public ApiResponse<List<TreeNodeVO>> getTree() {
        List<Menu> menus = menuService.getAllEnableStatus();
        List<MenuVO> menuVOs = this.convert(menus);
        if (CollectionUtils.isEmpty(menuVOs)) {
            return this.success(Collections.EMPTY_LIST);
        }
        TreeNode<MenuVO> root = TreeUtil.buildTree(menuVOs);
        List<TreeNode<MenuVO>> childs = root.getChilds();
        if (CollectionUtils.isEmpty(childs)) {
            return this.success(Collections.EMPTY_LIST);
        }

        List<TreeNodeVO> result = new ArrayList<>();

        for (TreeNode<MenuVO> child : childs) {
            result.add(convert(child));
        }

        result.sort(Comparator.comparingInt(TreeNodeVO::getSq));

        return this.success(result);

    }

    @PostMapping("/parentMenuTree")
    public ApiResponse< List<TreeNodeVO>> getMenuTree(@RequestBody MenuVO menuVO) {
        Long productId = menuVO.getProductId();
        List<QueryItem> items = new ArrayList<>();
//        QueryItem productIdItem = new QueryItem();
//        productIdItem.setQueryField("product_id");
//        productIdItem.setValue(productId);
//        productIdItem.setType(QueryType.eq);
//        items.add(productIdItem);


        List<Menu> childMenu = menuService.findAllChildByNodeId(menuVO.getId());

        List<Long> exIds = childMenu.stream().map(Menu::getId).collect(Collectors.toList());
        exIds.add(menuVO.getId());

        QueryItem exIdItem = new QueryItem();
        exIdItem.setQueryField(DBFieldConst.ID);
        exIdItem.setValue(exIds);
        exIdItem.setType(QueryType.notIn);
        items.add(exIdItem);

        QueryItem typeItem = new QueryItem();
        typeItem.setQueryField("type");
        typeItem.setValue(MenuType.button.value());
        typeItem.setType(QueryType.ne);
        items.add(typeItem);

        List<Menu> menus = menuService.get(items);

        List<MenuVO> menuVOs = this.convert(menus);

        if (CollectionUtils.isEmpty(menuVOs)) {
            return this.success(Collections.EMPTY_LIST);
        }

        TreeNode<MenuVO> root = TreeUtil.buildTree(menuVOs);
        List<TreeNode<MenuVO>> childs = root.getChilds();
        if (CollectionUtils.isEmpty(childs)) {
            return this.success(Collections.EMPTY_LIST);
        }

        List<TreeNodeVO> result = new ArrayList<>();

        for (TreeNode<MenuVO> child : childs) {
            result.add(convert(child));
        }

        return this.success(result);

    }

    private TreeNodeVO convert(TreeNode<MenuVO> node) {
        TreeNodeVO treeNodeVO = new TreeNodeVO();
        MenuVO menu = node.getValue();
        String typeStr = "";
        if (menu.getType() == MenuType.menu.value()) {
            typeStr = "菜单";
        }
        if (menu.getType() == MenuType.button.value()) {
            typeStr = "按钮";
        }
        if (menu.getType() == MenuType.catalog.value()) {
            typeStr = "目录";
        }
        treeNodeVO.setId(menu.getId());
        treeNodeVO.setLabel(menu.getCode() + " " + menu.getName() + " | " + typeStr);
        treeNodeVO.setSq(menu.getSq());

        if (!node.isLeaf()) {

            List<TreeNodeVO> child = new ArrayList<>();

            node.getChilds().forEach(n -> {
                TreeNodeVO childNode = convert(n);
                child.add(childNode);
            });
            treeNodeVO.setChildren(child);
        }

        return treeNodeVO;

    }

    /**
     * 是否存在添加动态查询参数
     *
     * @param data
     */
    protected List<QueryItem> doBeforeCheckExistsAddSearchParam(MenuVO data) {
        List<QueryItem> items = new ArrayList<>();

        if (StringUtils.isNotBlank(data.getName())) {
            QueryItem item = new QueryItem();
            item.setQueryField("name");
            item.setValue(data.getName());
            item.setType(QueryType.eq);
            items.add(item);
        }

        if (StringUtils.isNotBlank(data.getCode())) {
            QueryItem item = new QueryItem();
            item.setQueryField("code");
            item.setValue(data.getCode());
            item.setType(QueryType.eq);
            items.add(item);
        }

        if (StringUtils.isNotBlank(data.getHref())) {
            QueryItem item = new QueryItem();
            item.setQueryField("href");
            item.setValue(data.getCode());
            item.setType(QueryType.eq);
            items.add(item);
        }
        if (data.getParentId() == null) {
            QueryItem parentIdItem = new QueryItem();
            parentIdItem.setQueryField("parent_id");
            parentIdItem.setValue(Arrays.asList(0, -1));
            parentIdItem.setType(QueryType.in);
            items.add(parentIdItem);
        } else {
            QueryItem parentIdItem = new QueryItem();
            parentIdItem.setQueryField("parent_id");
            parentIdItem.setValue(data.getParentId());
            parentIdItem.setType(QueryType.eq);
        }

        return items;
    }


    protected Page<MenuVO> convert(Page<Menu> page) {
        PageInfo<MenuVO> result = new PageInfo<>();
        result.setCurrentPage(page.getCurrentPage());
        result.setPageSize(page.getPageSize());
        result.setTotal(page.getTotal());
        if (page.getData() != null) {
            //对象转换
            List<MenuVO> menuVOList = menuMapper.convert(page.getData());
            //每个租户都只有一个根节点
            TreeNode<MenuVO> root = TreeUtil.buildTree(menuVOList);
            List<TreeNode<MenuVO>> childs = root.getChilds();
            if (CollectionUtils.isEmpty(childs)) {
                return result;
            }
            //jackson 循环问题
            TreeNode<MenuVO> menuRoot = childs.get(0);
            TreeUtil.setParentNull(menuRoot);
            result.setData(menuVOList);
        }
        return result;
    }


    /*
     * 添加分页查询参数
     * */
    /*protected List<QueryItem> doBeforePageAddSearchParam(RestRequest<MenuVO> restRequest) {
        List<QueryItem> queryItems = Lists.newArrayList();
        MenuVO vo = restRequest.getData();
        if (restRequest == null || vo == null) {
            return queryItems;
        }
        if (StringUtils.isNotBlank(vo.getName())) {
            QueryItem item = new QueryItem();
            item.setQueryField("name");
            item.setValue(vo.getName());
            item.setType(QueryType.leftLike);
            queryItems.add(item);
        }
        if (StringUtils.isNotBlank(vo.getCode())) {
            QueryItem item = new QueryItem();
            item.setQueryField("code");
            item.setValue(vo.getCode());
            item.setType(QueryType.leftLike);
            queryItems.add(item);
        }

        if (vo.getStatus() != null) {
            QueryItem item = new QueryItem();
            item.setQueryField("status");
            item.setValue(vo.getStatus());
            item.setType(QueryType.eq);
            queryItems.add(item);
        }

        if (vo.getParentId() != null) {
            QueryItem item = new QueryItem();
            item.setQueryField("parent_id");
            item.setValue(vo.getParentId());
            item.setType(QueryType.eq);
            queryItems.add(item);
        } else {
            QueryItem item = new QueryItem();
            item.setQueryField("parent_id");
            item.setValue(Lists.newArrayList(0, -1)); // 父节点
            item.setType(QueryType.in);
            queryItems.add(item);
        }

        if (vo.getProductId() != null) {
            QueryItem item = new QueryItem();
            item.setQueryField("product_id");
            item.setValue(vo.getProductId());
            item.setType(QueryType.eq);
            queryItems.add(item);
        }
        return queryItems;
    }*/

    protected List<MenuVO> convert(List<Menu> menus) {
        if (CollectionUtils.isEmpty(menus)) {
            return Collections.EMPTY_LIST;
        }

        //// TODO: 2020/3/22 产品名称
        List<Long> ids = menus.stream().map(Menu::getParentId).collect(Collectors.toList());
        List<Menu> parentMenus = menuService.getMenus(ids);
        Map<Long, String> menuMap = parentMenus.stream().collect(Collectors.toMap(Menu::getId, Menu::getName, (oldKey, newKey) -> newKey));

        List<MenuVO> vos = menus.stream().map(o -> {
            MenuVO vo = menuMapper.convert(o);
            vo.setParentName(menuMap.get(vo.getParentId()));
            vo.setHref(null);
            return vo;
        }).collect(Collectors.toList());

        /*
         胡老师说这个产品不要了
        List<String> codeList = menus.stream().map(Menu::getProductCode).collect(Collectors.toList());
        Map<String, Product> productMap = productService.getProducts(codeList).stream().collect(Collectors.toMap(Product::getCode, Function.identity()));

        menuVOS = menuVOS.stream().peek(m -> {
            m.setProductName(productMap.get(m.getProductCode()).getName());
            m.setHasChildren(false);//普通查询设置无子节点，消失页面三角
        }).collect(Collectors.toList());
        */

        return menus.stream().map(this::convert).collect(Collectors.toList());
    }
}
