package com.fm.api.web.controller.sm;


import com.fm.api.web.util.R;
import com.fm.api.web.vo.sm.UserFormVO;
import com.fm.api.web.vo.sm.UserTableVO;
import com.fm.api.web.vo.sm.mapper.UserMapper;
import com.fm.business.base.model.sm.Account;
import com.fm.business.base.model.sm.Org;
import com.fm.business.base.model.sm.RoleUser;
import com.fm.business.base.model.sm.User;
import com.fm.business.base.service.sm.*;
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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 用户.
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController extends BaseController<User, UserFormVO> {

    private static final int UPLOAD_LIMIT_COUNT = 10000;
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IOrgService orgService;

    @Autowired
    private FileService fileService;

    @Autowired
    private IRoleUserService roleUserService;


//    @Autowired
//    private PermissionMenuVOCache permissionMenuVOCache;
    @Autowired
    private IAccountService accountService;

    @Autowired
    private RedissonClient redissonClient;

    @Override
    protected Service service() {
        return this.userService;
    }

    @Autowired
    private ObjectProvider<UserController> userControllerProvider;



    @RequestMapping("/info")
    public R getInfo() {
        User user = userService.get(Context.getCurrUserId());
        UserTableVO userVO = UserMapper.INSTANCE.toUserTableVO(user);
        return R.createSuccessR().data(userVO);

    }

    @RequestMapping("/code/{userCode}")
    public R getInfo(@PathVariable String userCode) {

        if (Objects.isNull(userCode)) {
            R.createSuccessR().data(false);
        }
        return R.createSuccessR().data(this.userService.exists(userCode));

    }

    @RequestMapping("/phone/{phone}")
    public R getInfoByPhone(@PathVariable String phone) {

        if (Objects.isNull(phone)) {
            R.createSuccessR().data(false);
        }
        return R.createSuccessR().data(this.userService.existsPhone(phone));

    }

    @RequestMapping(path = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public R logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        permissionMenuVOCache.clear(Context.getCurrUserId());
        return R.createSuccessR();
    }

    @PostMapping("/list")
    public R list(@RequestBody QueryRequest request, @RequestParam(required = false) Long orgId) {
        List<QueryItem> queryItems = request.getQueryItems();

        Page<User> page = userService.listFullUser(orgId, queryItems, request.getPagination().getCurrentPage(), request.getPagination().getPageSize());

        PageInfo<UserTableVO> resultPage = new PageInfo<>();

        resultPage.setCurrentPage(page.getCurrentPage());
        resultPage.setPageSize(page.getPageSize());
        resultPage.setData(convert0(page.getData()));
        resultPage.setTotal((int) page.getTotal());

        return R.createSuccessR().data(resultPage);

    }


    public List<UserTableVO> convert0(List<User> users) {

        if (CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }

        users.forEach(user -> {
            user.setPhone(StringUtils.overlay(user.getPhone(), "****", 3, 7));
        });

        return users.stream().map(UserMapper.INSTANCE::toUserTableVO).collect(Collectors.toList());
    }

    @PostMapping("/listForRoleUser")
    public R listForRoleUser(@RequestBody QueryRequest request, @RequestParam("roleId") Long roleId, @RequestParam(name = "type", required = false, defaultValue = "1") int type) {

        List<RoleUser> roleUsers = roleUserService.getRoleUsersRoleId(roleId);
        List<QueryItem> items = request.getQueryItems();

        if (!CollectionUtils.isEmpty(roleUsers)) {
            List<Long> uids = roleUsers.stream().map(RoleUser::getUserId).collect(Collectors.toList());

            QueryItem item = new QueryItem();
            item.setQueryField(DBFieldConst.ID);
            item.setValue(uids);
            if(type == 0){
                item.setType(QueryType.in); //删除
            }else {
                item.setType(QueryType.notIn); //新增
            }
            items.add(item);
        }else {
            if(type == 0){//删除
                return R.createSuccessR().data(new PageInfo<>());
            }
        }

        Page<User> page = userService.listEnableStatus(items, request.getPagination().getCurrentPage(), request.getPagination().getPageSize());

        List<Long> orgIds = page.getData().stream().map(User::getOrgId).collect(Collectors.toList());
        List<Long> userIds = page.getData().stream().map(User::getId).collect(Collectors.toList());

        Map<Long, Org >  orgNameMap = orgService.getByIds(orgIds).stream().collect(Collectors.toMap(Org::getId, Function.identity(), (key1, key2) -> key2));
        Map<Long, List<Account>> accountMap = accountService.getAccountMap(userIds);

        page.getData().forEach(user -> {
            user.setOrg(orgNameMap.get(user.getOrgId()));
            user.setAccounts(accountMap.containsKey(user.getId()) ? accountMap.get(user.getId()) : new ArrayList<>());
        });

        PageInfo<UserTableVO> resultPage = new PageInfo<>();

        resultPage.setCurrentPage(page.getCurrentPage());
        resultPage.setPageSize(page.getPageSize());

        resultPage.setData(convert0(page.getData()));
        resultPage.setTotal((int) page.getTotal());

        return R.createSuccessR().data(resultPage);

    }



    @PostMapping("")
    public ApiResponse<Boolean> create(@RequestBody UserFormVO userFormVO) {
        if (Objects.isNull(userFormVO)) {
            log.warn("创建用户数据时，传入参数[UserVO]为空！");
            return failed("数据添加失败！");
        }


        if (validateUserCode(userFormVO)) {return failed("用户编码重复");};

        User user = UserMapper.INSTANCE.toUser(userFormVO);
        boolean success = userService.save(user);

        if (!success) {
            return failed("数据添加失败！");
        }
        return success(true);
    }


    @PutMapping("")
    public ApiResponse<Boolean> update(@RequestBody UserFormVO userFormVO) {

        if(userFormVO.getOldCode()!=null && !userFormVO.getOldCode().equals(userFormVO.getCode())){
            // 用户编码修改，重新判断新的编码数据库是否存在
            if (validateUserCode(userFormVO)) {
                return failed("用户编码重复");
            }
        }

        String phone = userFormVO.getPhone();
        if (StringUtils.containsIgnoreCase(phone, "*")){
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
    public R updateAvatarHref(@RequestParam("userId") Long userId, @RequestParam("file") MultipartFile file) throws IOException {

        try(InputStream uploadedStream = file.getInputStream()) {
            ;
            byte[] imgBytes = IOUtils.toByteArray(uploadedStream);
            String url = fileService.upload(file.getName(), imgBytes);
            log.debug("图片上传成功,图片名称:{},url为:{}", file, url);
            User user = new User();
            user.setId(userId);
            boolean success = userService.updateAvatarHref(user, url);
            if (!success) {
                return R.createFailR().message("头像更新失败");
            }
            return R.createSuccessR().data(url).message("头像更新成功");
        }


    }


    @DeleteMapping("")
    public R delete(@RequestBody List<UserTableVO> userFormVOS){

        List<User> users = userFormVOS.stream().map(UserMapper.INSTANCE::toUser).collect(Collectors.toList());

        if (users.isEmpty()) {
            return R.createFailR().message("没有需要删除数据！");
        }

        boolean success = userService.delete(users);

        if (!success) {
            return R.createFailR().message("删除数据失败，请确认要数据是存在！");
        }

        return R.createSuccessR().data(true);

    }


    @PutMapping("/status")
    public R setStatus(@RequestBody List<UserTableVO> userFormVOS, @RequestParam boolean enable){
        //过滤掉状态相同的重复操作
        List<User> users = userFormVOS.stream().filter(a ->!a.getStatus().equals(enable ? DataStatus.enable.code() : DataStatus.disable.code())
        ).map(UserMapper.INSTANCE::toUser).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(users)) {
            boolean success = userService.setStatus(users, enable);

            if (!success) {
                return R.createFailR().message((enable ? "启用" : "禁用") + "操作失败！");
            }
        }
        return R.createSuccessR().data(true);
    }


    @RequestMapping("/getPhone")
    public R getUserPhone(@RequestParam("userId") Long userId) {
        User user = this.userService.get(userId);
        if (user == null){
            return R.createSuccessR();
        }
        return R.createSuccessR().data(user.getPhone());
    }



    @RequestMapping("/existsAccount/{acctName}")
    public R getInfoByPin(@PathVariable String acctName) {
        return R.createSuccessR().data(this.accountService.existsAccount( acctName));
    }


    /**
     * 转换VO页面显示数据
     *
     * @param data
     */
    protected List<UserFormVO> doConvertVOs(List<User> data) {
        if (CollectionUtils.isEmpty(data)) {
            return Collections.emptyList();
        }

        return data.stream().map(UserMapper.INSTANCE::toUserVO)
                .collect(Collectors.toList());
    }



    /**
     * 展示层&model实体转换
     *
     * @param data
     */
    protected User doConvertModel(UserFormVO data) {
        return UserMapper.INSTANCE.toUser(data);
    }


    /**
     * model->VO
     *
     * @param user
     */
    protected UserFormVO doConvertVO(User user) {
        return UserMapper.INSTANCE.toUserVO(user);
    }




}
