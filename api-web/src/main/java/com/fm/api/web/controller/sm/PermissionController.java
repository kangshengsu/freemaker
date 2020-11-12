package com.fm.api.web.controller.sm;

import com.fm.api.web.vo.sm.OrgVO;
import com.fm.api.web.vo.sm.PermissionMenuMeta;
import com.fm.api.web.vo.sm.PermissionMenuVO;
import com.fm.business.base.model.sm.Menu;
import com.fm.business.base.model.sm.Org;
import com.fm.business.base.model.sm.Role;
import com.fm.business.base.service.sm.IMenuService;
import com.fm.business.base.service.sm.IPermissionService;
import com.fm.business.base.service.sm.IRoleService;
import com.fm.framework.core.Context;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.utils.TreeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>类描述</p>
 *
 * @author hubo
 */
@RestController
@RequestMapping("/user")
public class PermissionController{

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private IMenuService menuService;

    @RequestMapping("/permissions")
    public ApiResponse<List<PermissionMenuVO>> getPermissions() {
        Long currUserId = Context.getCurrUserId();

        //获取登录用户的角色信息
        List<Role> roles = roleService.getUserRoles(currUserId);
        if (roles.isEmpty()) {
            return ApiResponse.ofSuccess(Collections.emptyList());
        }

        //获取角色的菜单信息
        List<Menu> menus = permissionService.getPermissionsByRoles(roles);
        if (CollectionUtils.isEmpty(menus)) {
            return ApiResponse.ofSuccess(Collections.emptyList());
        }
        menuService.completionParentNode(menus);

        TreeNode<Menu> root = TreeUtil.buildTree(menus);
        List<TreeNode<Menu>> menuNodes = root.getChilds();
        menuNodes.forEach(TreeUtil::setParentNull);

        List<String> roleCodes = roles.stream().map(Role::getCode).collect(Collectors.toList());
        List<PermissionMenuVO> menuVOs = menuNodes.stream().map(node -> covert(node, roleCodes)).collect(Collectors.toList());

        //menuVOs.forEach(permissionMenuVO -> permissionMenuVO.setAlwaysShow(true));
        sort(menuVOs);

        return ApiResponse.ofSuccess(menuVOs);
    }


    public void sort(List<PermissionMenuVO> menuVOs) {
        if(CollectionUtils.isEmpty(menuVOs)) {
            return;
        }

        menuVOs.sort(Comparator.comparingInt(PermissionMenuVO::getSq));

        menuVOs.forEach(permissionMenuVO -> sort(permissionMenuVO.getChildren()));

    }

    private PermissionMenuVO covert(TreeNode<Menu> node, List<String> roles) {

        PermissionMenuVO menuVO = new PermissionMenuVO();
        menuVO.setName(node.getValue().getCode());
        menuVO.setPath(Objects.isNull(node.getValue().getHref()) ? "/" + node.getValue().getCode() : node.getValue().getHref());
        menuVO.setComponent(node.getValue().getComponent());
        menuVO.setSq(node.getValue().getSq());
//        menuVO.setAlwaysShow(menuVO.isAlwaysShow());
        PermissionMenuMeta meta = new PermissionMenuMeta();
        meta.setTitle(node.getValue().getName());
        meta.setIcon(node.getValue().getIcon());
        meta.setMenuCode(node.getValue().getCode());
        meta.setRoles(roles);
        menuVO.setMeta(meta);

        if (!node.isLeaf()) {

            List<PermissionMenuVO> childs = new ArrayList<>();
            node.getChilds().forEach(childNode -> {
                childs.add(covert(childNode, roles));
            });

            childs.sort(Comparator.comparingInt(PermissionMenuVO::getSq));

            menuVO.setChildren(childs);

        } else {
//            menuVO.setChildren(Collections.emptyList());
        }

        return menuVO;

    }

}
