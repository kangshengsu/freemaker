//package com.fm.api.web.controller.sm;
//
//import com.jd.labbed.core.base.Context;
//import com.jd.labbed.core.base.TreeNode;
//import com.jd.labbed.core.sm.model.Menu;
//import com.jd.labbed.core.sm.model.Role;
//import com.jd.labbed.core.sm.model.User;
//import com.jd.labbed.core.sm.service.PermissionService;
//import com.jd.labbed.core.sm.service.RoleService;
//import com.jd.labbed.core.util.TreeUtil;
//import com.jd.labbed.mvc.tenant.cache.PermissionMenuVOCache;
//import com.jd.labbed.mvc.tenant.util.R;
//import com.jd.labbed.mvc.tenant.vo.PermissionMenuMeta;
//import com.jd.labbed.mvc.tenant.vo.PermissionMenuVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * <p>类描述</p>
// *
// * @author hubo
// */
//@RestController
//@RequestMapping("/api/user")
//public class PermissionController {
//
//    @Autowired
//    private PermissionMenuVOCache permissionMenuVOCache;
//
//    @RequestMapping("/permissions")
//    public R getPermissions() {
//        List<PermissionMenuVO> menuVOs = permissionMenuVOCache.getAll(Context.getCurrUser().getId());
//
////        menuVOs.forEach(permissionMenuVO -> permissionMenuVO.setAlwaysShow(true));
//
//        sort(menuVOs);
//
//        return R.createSuccessR().data(menuVOs);
//    }
//
//
//    public void sort(List<PermissionMenuVO> menuVOs) {
//        if(CollectionUtils.isEmpty(menuVOs)) {
//            return;
//        }
//
//        menuVOs.sort(Comparator.comparingInt(PermissionMenuVO::getSq));
//
//        menuVOs.forEach(permissionMenuVO -> sort(permissionMenuVO.getChildren()));
//
//    }
//
//}
