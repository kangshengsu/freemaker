package com.fm.api.web.controller.sm;


import com.fm.api.web.vo.sm.UserFormVO;
import com.fm.api.web.vo.sm.UserTableVO;
import com.fm.api.web.vo.sm.mapper.UserMapper;
import com.fm.business.base.model.sm.Account;
import com.fm.business.base.model.sm.Org;
import com.fm.business.base.model.sm.RoleUser;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.service.sm.IAccountService;
import com.fm.business.base.service.sm.IOrgService;
import com.fm.business.base.service.sm.IRoleUserService;
import com.fm.business.base.service.sm.IUserService;
import com.fm.framework.core.Context;
import com.fm.framework.core.model.DBFieldConst;
import com.fm.framework.core.model.DataStatus;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.FileService;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 用户.
 */
@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController extends BaseController<User, UserFormVO> {


    private final IUserService userService;

//    private final IRoleService roleService;

    private final IOrgService orgService;

    private final FileService fileService;

    private final IRoleUserService roleUserService;


    //    private final PermissionMenuVOCache permissionMenuVOCache;
    private final IAccountService accountService;

//    private final RedissonClient redissonClient;

    @Override
    protected Service<User> service() {
        return this.userService;
    }

    @RequestMapping("/info")
    public ApiResponse<UserTableVO> getInfo() {
        User user = userService.get(Context.getCurrUserId());
        UserTableVO userVO = UserMapper.INSTANCE.toUserTableVO(user);
        return success(userVO);

    }

    @RequestMapping("/code/{userCode}")
    public ApiResponse<Boolean> getInfo(@PathVariable String userCode) {

        if (Objects.isNull(userCode)) {
            success(false);
        }
        return success(this.userService.exists(userCode));

    }

    @RequestMapping("/phone/{phone}")
    public ApiResponse<Boolean> getInfoByPhone(@PathVariable String phone) {

        if (Objects.isNull(phone)) {
            success(false);
        }
        return success(this.userService.existsPhone(phone));

    }

    @RequestMapping(path = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public ApiResponse<Boolean> logout() {
//        permissionMenuVOCache.clear(Context.getCurrUserId());
        return success(null);
    }

    @PostMapping("/list")
    public ApiResponse<PageInfo<UserTableVO>> list(@RequestBody QueryRequest request, @RequestParam(required = false) Long orgId) {
        List<QueryItem> queryItems = request.getQueryItems();

        Page<User> page = userService.listFullUser(orgId, queryItems, request.getPagination().getCurrentPage(), request.getPagination().getPageSize());

        PageInfo<UserTableVO> resultPage = new PageInfo<>();
        resultPage.setCurrentPage(page.getCurrentPage());
        resultPage.setPageSize(page.getPageSize());
        resultPage.setData(convert0(page.getData()));
        resultPage.setTotal(page.getTotal());

        return success(resultPage);

    }


    public List<UserTableVO> convert0(List<User> users) {

        if (CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }

        users.forEach(user -> user.setPhone(StringUtils.overlay(user.getPhone(), "****", 3, 7)));

        return users.stream().map(UserMapper.INSTANCE::toUserTableVO).collect(Collectors.toList());
    }

    @PostMapping("/listForRoleUser")
    public ApiResponse<PageInfo<UserTableVO>> listForRoleUser(@RequestBody QueryRequest request, @RequestParam("roleId") Long roleId, @RequestParam(name = "type", required = false, defaultValue = "1") int type) {

        List<RoleUser> roleUsers = roleUserService.getRoleUsersRoleId(roleId);
        List<QueryItem> items = request.getQueryItems();

        if (!CollectionUtils.isEmpty(roleUsers)) {
            List<Long> uids = roleUsers.stream().map(RoleUser::getUserId).collect(Collectors.toList());

            QueryItem item = new QueryItem();
            item.setQueryField(DBFieldConst.ID);
            item.setValue(uids);
            if (type == 0) {
                item.setType(QueryType.in); //删除
            } else {
                item.setType(QueryType.notIn); //新增
            }
            items.add(item);
        } else {
            if (type == 0) {//删除
                return success(new PageInfo<>());
            }
        }

        Page<User> page = userService.listEnableStatus(items, request.getPagination().getCurrentPage(), request.getPagination().getPageSize());

        userService.fillUserOtherInfo(page.getData());

        PageInfo<UserTableVO> resultPage = new PageInfo<>();
        resultPage.setCurrentPage(page.getCurrentPage());
        resultPage.setPageSize(page.getPageSize());
        resultPage.setData(convert0(page.getData()));
        resultPage.setTotal(page.getTotal());

        return success(resultPage);

    }


    @PostMapping("")
    public ApiResponse<Boolean> create(@RequestBody UserFormVO userFormVO) {
        if (Objects.isNull(userFormVO)) {
            log.warn("创建用户数据时，传入参数[UserVO]为空！");
            return failed("数据添加失败！");
        }

        if (validateUserCode(userFormVO)) {
            return failed("用户编码重复");
        }

        User user = UserMapper.INSTANCE.toUser(userFormVO);
        boolean success = userService.save(user);

        if (!success) {
            return failed("数据添加失败！");
        }
        return success(true);
    }


    @PutMapping("")
    public ApiResponse<Boolean> update(@RequestBody UserFormVO userFormVO) {

        if (userFormVO.getOldCode() != null && !userFormVO.getOldCode().equals(userFormVO.getCode())) {
            // 用户编码修改，重新判断新的编码数据库是否存在
            if (validateUserCode(userFormVO)) {
                return failed("用户编码重复");
            }
        }

        String phone = userFormVO.getPhone();
        if (StringUtils.containsIgnoreCase(phone, "*")) {
            userFormVO.setPhone(userService.get(userFormVO.getId()).getPhone());
        }

        User user = UserMapper.INSTANCE.toUser(userFormVO);
        boolean success = userService.update(user);

        if (!success) {
            return failed("数据已被他人修改，请刷新后再修改！");
        }
        return success(true);

    }

    private boolean validateUserCode(@RequestBody UserFormVO userFormVO) {
        return userService.exists(userFormVO.getCode());
    }


    @RequestMapping(path = "/updateAvatarURL", method = {RequestMethod.GET, RequestMethod.POST})
    public ApiResponse<String> updateAvatarHref(@RequestParam("userId") Long userId, @RequestParam("file") MultipartFile file) throws IOException {

        try (InputStream uploadedStream = file.getInputStream()) {
            byte[] imgBytes = IOUtils.toByteArray(uploadedStream);
            String url = fileService.upload(file.getName(), imgBytes);
            log.debug("图片上传成功,图片名称:{},url为:{}", file, url);
            User user = new User();
            user.setId(userId);
            boolean success = userService.updateAvatarHref(user, url);
            if (!success) {
                return failed("头像更新失败");
            }
            return success(url);
        }


    }


    @DeleteMapping("")
    public ApiResponse<Boolean> delete(@RequestBody List<UserTableVO> userFormVOS) {

        List<User> users = userFormVOS.stream().map(UserMapper.INSTANCE::toUser).collect(Collectors.toList());

        if (users.isEmpty()) {
            return failed("没有需要删除数据！");
        }

        boolean success = userService.delete(users);

        if (!success) {
            return failed("删除数据失败，请确认要数据是存在！");
        }

        return success(true);

    }


    @PutMapping("/status")
    public ApiResponse<Boolean> setStatus(@RequestBody List<UserTableVO> userFormVOS, @RequestParam boolean enable) {
        //过滤掉状态相同的重复操作
        List<User> users = userFormVOS.stream().filter(a -> !a.getStatus().equals(enable ? DataStatus.enable.code() : DataStatus.disable.code())
        ).map(UserMapper.INSTANCE::toUser).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(users)) {
            boolean success = userService.setStatus(users, enable);

            if (!success) {
                return failed((enable ? "启用" : "禁用") + "操作失败！");
            }
        }
        return success(true);
    }


    @RequestMapping("/getPhone")
    public ApiResponse<String> getUserPhone(@RequestParam("userId") Long userId) {
        User user = this.userService.get(userId);
        if (user == null) {
            return success(null);
        }
        return success(user.getPhone());
    }


    @RequestMapping("/existsAccount/{acctName}")
    public ApiResponse<Boolean> getInfoByPin(@PathVariable String acctName) {
        return success(this.accountService.existsAccount(acctName));
    }


//    /**
//     * 转换VO页面显示数据
//     *
//     */
//    protected List<UserFormVO> doConvertVOs(List<User> data) {
//        if (CollectionUtils.isEmpty(data)) {
//            return Collections.emptyList();
//        }
//
//        return data.stream().map(UserMapper.INSTANCE::toUserVO)
//                .collect(Collectors.toList());
//    }
//
//
//
//    /**
//     * 展示层&model实体转换
//     *
//     */
//    protected User doConvertModel(UserFormVO data) {
//        return UserMapper.INSTANCE.toUser(data);
//    }
//
//
//    /**
//     * model->VO
//     *
//     */
//    protected UserFormVO doConvertVO(User user) {
//        return UserMapper.INSTANCE.toUserVO(user);
//    }


}
