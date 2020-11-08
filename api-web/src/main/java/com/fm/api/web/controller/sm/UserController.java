//package com.fm.api.web.controller.sm;
//
//import com.alibaba.fastjson.JSON;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.jd.labbed.common.io.IOUtil;
//import com.jd.labbed.common.mapper.BeanMapper;
//import com.jd.labbed.common.page.PageImpl;
//import com.jd.labbed.core.auth.Account;
//import com.jd.labbed.core.auth.service.AccountService;
//import com.jd.labbed.core.base.Context;
//import com.jd.labbed.core.base.DBFieldConst;
//import com.jd.labbed.core.base.DataStatus;
//import com.jd.labbed.core.base.exception.BusinessException;
//import com.jd.labbed.core.base.query.QueryItem;
//import com.jd.labbed.core.base.query.QueryType;
//import com.jd.labbed.core.base.service.Service;
//import com.jd.labbed.core.file.FileService;
//import com.jd.labbed.core.file.impl.FileTransException;
//import com.jd.labbed.core.sm.model.*;
//import com.jd.labbed.core.sm.service.*;
//import com.jd.labbed.core.tenant.TenantExtLinkConfigService;
//import com.jd.labbed.core.tenant.TenantService;
//import com.jd.labbed.core.tenant.model.Tenant;
//import com.jd.labbed.core.tenant.model.TenantExtLinkConfig;
//import com.jd.labbed.mvc.tenant.cache.PermissionMenuVOCache;
//import com.jd.labbed.mvc.tenant.cache.UserTableVOCache;
//import com.jd.labbed.mvc.tenant.easyexcel.AsyncContext;
//import com.jd.labbed.mvc.tenant.easyexcel.ExcelAsyncService;
//import com.jd.labbed.mvc.tenant.easyexcel.listener.UserDataListener;
//import com.jd.labbed.mvc.tenant.easyexcel.listener.validate.ValidateChain;
//import com.jd.labbed.mvc.tenant.interceptor.SSOInterceptorProxy;
//import com.jd.labbed.mvc.tenant.mapper.TenantExtLinkConfigMapper;
//import com.jd.labbed.mvc.tenant.mapper.UserMapper;
//import com.jd.labbed.mvc.tenant.util.QueryRequest;
//import com.jd.labbed.mvc.tenant.util.R;
//import com.jd.labbed.mvc.tenant.vo.TenantExtLinkConfigVO;
//import com.jd.labbed.mvc.tenant.vo.UserFormVO;
//import com.jd.labbed.mvc.tenant.vo.UserTableVO;
//import io.netty.buffer.ByteBufInputStream;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
///**
// * 用户.
// */
//@RestController
//@RequestMapping("/api/user")
//@Slf4j
//public class UserController extends BaseController<User, UserFormVO> {
//
//    private static final int UPLOAD_LIMIT_COUNT = 10000;
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;
//
//    @Autowired
//    private OrgService orgService;
//    @Autowired
//    private BizCodeGenerator bizCodeGenerator;
//
//    @Autowired
//    private SSOInterceptorProxy ssoProxy;
//    @Autowired
//    private RoleUserService roleUserService;
//    @Autowired
//    private UserDataPermissionService userDataPermissionService;
//    @Autowired
//    private UserTableVOCache userTableVOCache;
//
//    @Autowired
//    private FileService fileService;
//
//    @Autowired
//    private PermissionMenuVOCache permissionMenuVOCache;
//    @Autowired
//    private AccountService accountService;
//    @Autowired
//    private ValidateChain validateChain;
//
//    @Autowired
//    private RedissonClient redissonClient;
//    @Autowired
//    private ExcelAsyncService excelAsyncService;
//
//    @Autowired
//    private TenantService tenantService;
//
//    @Override
//    protected Service service() {
//        return this.userService;
//    }
//
//    @Autowired
//    private ObjectProvider<UserController> userControllerProvider;
//    @Override
//    protected String cnName() {
//        return "用户";
//    }
//
//
//    @RequestMapping("/info")
//    public R getInfo() {
//        User user = Context.getCurrUser();
//        UserTableVO userVO = userTableVOCache.getOne(user.getId());
//        return R.createSuccessR().data(userVO);
//
//    }
//
//    @RequestMapping("/code/{userCode}")
//    public R getInfo(@PathVariable String userCode) {
//
//        if (Objects.isNull(userCode)) {
//            R.createSuccessR().data(false);
//        }
//        return R.createSuccessR().data(this.userService.exists(userCode));
//
//    }
//
//    @RequestMapping("/phone/{phone}")
//    public R getInfoByPhone(@PathVariable String phone) {
//
//        if (Objects.isNull(phone)) {
//            R.createSuccessR().data(false);
//        }
//        return R.createSuccessR().data(this.userService.existsPhone(phone));
//
//    }
//
//    @RequestMapping(path = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
//    public R logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        permissionMenuVOCache.clear(Context.getCurrUser().getId());
//        ssoProxy.logout(request, response);
//        return R.createSuccessR();
//    }
//    @PostMapping("/list")
//    public R list(@RequestBody QueryRequest request, @RequestParam(required = false) Long orgId) {
//        List<QueryItem> queryItems = request.getItems();
//
//        Page<User> page = userService.listFullUser(orgId, queryItems, request.getCurrPage(), request.getPageSize());
//
//        PageImpl<UserTableVO> resultPage = new PageImpl<>((int) page.getCurrent(), (int) page.getSize());
//
//        resultPage.setData(convert(page.getRecords()));
//        resultPage.setTotal((int) page.getTotal());
//
//        return R.createSuccessR().data(resultPage);
//
//    }
//
//
//    private List<UserTableVO> convert(List<User> users) {
//
//        if (CollectionUtils.isEmpty(users)) {
//            return Collections.emptyList();
//        }
//
//        users.forEach(user -> {
//            user.setPhone(StringUtils.overlay(user.getPhone(), "****", 3, 7));
//        });
//
//        return users.stream().map(UserMapper.INSTANCE::toUserTableVO).collect(Collectors.toList());
//    }
//
//    @PostMapping("/listForRoleUser")
//    public R listForRoleUser(@RequestBody QueryRequest request, @RequestParam("roleId") Long roleId, @RequestParam(name = "type", required = false, defaultValue = "1") int type) {
//
//        List<RoleUser> roleUsers = roleUserService.getRoleUsersRoleId(roleId);
//        List<QueryItem> items = request.getItems();
//
//        if (CollectionUtils.isNotEmpty(roleUsers)) {
//            List<Long> uids = roleUsers.stream().map(RoleUser::getUserId).collect(Collectors.toList());
//
//            QueryItem item = new QueryItem();
//            item.setQueryField(DBFieldConst.ID);
//            item.setValue(uids);
//            if(type == 0){
//                item.setType(QueryType.in); //删除
//            }else {
//                item.setType(QueryType.notIn); //新增
//            }
//            items.add(item);
//        }else {
//            if(type == 0){//删除
//                return R.createSuccessR().data(new PageImpl<>());
//            }
//        }
//
//        Page<User> page = userService.listEnableStatus(items, request.getCurrPage(), request.getPageSize());
//
//        List<Long> orgIds = page.getRecords().stream().map(User::getOrgId).collect(Collectors.toList());
//        List<Long> userIds = page.getRecords().stream().map(User::getId).collect(Collectors.toList());
//
//        Map<Long, Org >  orgNameMap = orgService.getByIds(orgIds).stream().collect(Collectors.toMap(Org::getId, Function.identity(), (key1, key2) -> key2));
//        Map<Long, List<Account>> accountMap = accountService.getAccountMap(userIds);
//
//        page.getRecords().forEach(user -> {
//            user.setOrg(orgNameMap.get(user.getOrgId()));
//            user.setAccounts(accountMap.containsKey(user.getId()) ? accountMap.get(user.getId()) : new ArrayList<>());
//        });
//
//        PageImpl<UserTableVO> resultPage = new PageImpl<>((int) page.getCurrent(), (int) page.getSize());
//
//        resultPage.setData(convert(page.getRecords()));
//        resultPage.setTotal((int) page.getTotal());
//
//        return R.createSuccessR().data(resultPage);
//
//    }
//
//    @PostMapping("/listForUserDataPermission")
//    public R listForUserDataPermission(@RequestBody QueryRequest request, @RequestParam("datapermissionId") Long datapermissionId,  @RequestParam(name = "type", required = false, defaultValue = "1") Long queryType){
//
//        List<UserDataPermission> udps = userDataPermissionService.getUsersByDatapermissionId(datapermissionId);
//        List<QueryItem> items = request.getItems();
//
//        if (CollectionUtils.isNotEmpty(udps)){
//            List<Long> uids = udps.stream().map(UserDataPermission::getUserId).collect(Collectors.toList());
//
//            QueryItem item = new QueryItem();
//            item.setQueryField(DBFieldConst.ID);
//            item.setValue(uids);
//
//            if(queryType == 0){
//                item.setType(QueryType.in); //删除
//            }else {
//                item.setType(QueryType.notIn); //新增
//            }
//            items.add(item);
//        }else {
//            if(queryType == 0){//删除
//                return R.createSuccessR().data(new PageImpl<>());
//            }
//        }
//
//        Page<User> page = userService.listEnableStatus(items, request.getCurrPage(), request.getPageSize());
//        List<Long> orgIds = page.getRecords().stream().map(User::getOrgId).collect(Collectors.toList());
//        List<Long> userIds = page.getRecords().stream().map(User::getId).collect(Collectors.toList());
//
//        Map<Long, Org >  orgNameMap = orgService.getByIds(orgIds).stream().collect(Collectors.toMap(Org::getId, Function.identity(), (key1, key2) -> key2));
//        Map<Long, List<Account>> accountMap = accountService.getAccountMap(userIds);
//
//        page.getRecords().forEach(user -> {
//            user.setOrg(orgNameMap.get(user.getOrgId()));
//            user.setAccounts(accountMap.containsKey(user.getId()) ? accountMap.get(user.getId()) : new ArrayList<>());
//        });
//
//        PageImpl<UserTableVO> resultPage = new PageImpl<>((int) page.getCurrent(), (int) page.getSize());
//
//        resultPage.setData(convert(page.getRecords()));
//        resultPage.setTotal((int) page.getTotal());
//
//        return R.createSuccessR().data(resultPage);
//
//    }
//
//    @PostMapping("")
//    public R create(@RequestBody UserFormVO userFormVO) {
//        if (Objects.isNull(userFormVO)) {
//            log.warn("创建用户数据时，传入参数[UserVO]为空！");
//            return R.createFailR().message("数据添加失败！");
//        }
//        //敏感词校验
//        R r = super.validCheck(userFormVO);
//        if (r.getCode() == R.FAILED_CODE){
//            r.message(r.getMessage());
//            return r;
//        }
//
//        if (validateUserCode(userFormVO)) {return R.createFailR().message("用户编码重复");};
//
//        User user = UserMapper.INSTANCE.toUser(userFormVO);
//        boolean success = userService.save(user);
//
//        if (!success) {
//            return R.createFailR().message("数据添加失败！");
//        }
//        return R.createSuccessR().data(true);
//    }
//
//
//    @PutMapping("")
//    public R update(@RequestBody UserFormVO userFormVO) {
//
//        //敏感词校验
//        R r = super.validCheck(userFormVO);
//        if (r.getCode() == R.FAILED_CODE){
//            r.message(r.getMessage());
//            return r;
//        }
//        if(userFormVO.getOldCode()!=null && !userFormVO.getOldCode().equals(userFormVO.getCode())){
//            // 用户编码修改，重新判断新的编码数据库是否存在
//            if (validateUserCode(userFormVO)) {
//                return R.createFailR().message("用户编码重复");
//            }
//        }
//
//        String phone = userFormVO.getPhone();
//        if (StringUtils.containsIgnoreCase(phone, "*")){
//            userFormVO.setPhone(userService.get(userFormVO.getId()).getPhone());
//        }
//
//        User user = UserMapper.INSTANCE.toUser(userFormVO);
//        boolean success = userService.update(user);
//
//        if (!success) {
//            return R.createFailR().message("数据已被他人修改，请刷新后再修改！");
//        }
//        return R.createSuccessR().data(true);
//
//    }
//
//    private boolean validateUserCode(@RequestBody UserFormVO userFormVO) {
//        if(StringUtils.isEmpty(userFormVO.getCode())) {
//            userFormVO.setCode(bizCodeGenerator.genBizCode(BizType.user));
//        }else{
//            if(userService.exists(userFormVO.getCode())){
//                return true;
//            }
//            //是否与自动编码冲突
//            if(!bizCodeGenerator.isCodeConflict(BizType.user,userFormVO.getCode())){
//                // validateFromDb方法查询数据库里是否存在，报告冲突无需处理。
//                // 但需要调用原因是：如果用户输入10位数字，比自动编码大，增加自动编码，否则将来生成的自动编码可能重复
//            }
//        }
//        return false;
//    }
//
//
//    @RequestMapping(path = "/updateAvatarURL", method = {RequestMethod.GET, RequestMethod.POST})
//    public R updateAvatarHref(@RequestParam("userId") Long userId, @RequestParam("file") MultipartFile file) throws IOException, FileTransException {
//
//        InputStream uploadedStream = null;
//        try {
//            uploadedStream = file.getInputStream();
//            byte[] imgBytes = IOUtils.toByteArray(uploadedStream);
//            String url = fileService.uploadImage(imgBytes);
//            log.debug("图片上传成功,图片名称:{},url为:{}", file, url);
//            User user = new User();
//            user.setId(userId);
//            boolean success = userService.updateAvatarHref(user, url);
//            if (!success) {
//                return R.createFailR().message("头像更新失败");
//            }
//            return R.createSuccessR().data(url).message("头像更新成功");
//        } finally {
//            IOUtil.closeQuietly(uploadedStream);
//        }
//
//
//    }
//
//
//    @DeleteMapping("")
//    public R delete(@RequestBody List<UserTableVO> userFormVOS){
//
//        List<User> users = userFormVOS.stream().map(UserMapper.INSTANCE::toUser).collect(Collectors.toList());
//
//        if (users.isEmpty()) {
//            return R.createFailR().message("没有需要删除数据！");
//        }
//
//        boolean success = userService.delete(users);
//
//        if (!success) {
//            return R.createFailR().message("删除数据失败，请确认要数据是存在！");
//        }
//
//        return R.createSuccessR().data(true);
//
//    }
//
//
//    @PutMapping("/status")
//    public R setStatus(@RequestBody List<UserTableVO> userFormVOS, @RequestParam boolean enable){
//        //过滤掉状态相同的重复操作
//        List<User> users = userFormVOS.stream().filter(a ->!a.getStatus().equals(enable ? DataStatus.enable.value() : DataStatus.disable.value())
//        ).map(UserMapper.INSTANCE::toUser).collect(Collectors.toList());
//        if(CollectionUtils.isNotEmpty(users)) {
//            boolean success = userService.setStatus(users, enable);
//
//            if (!success) {
//                return R.createFailR().message((enable ? "启用" : "禁用") + "操作失败！");
//            }
//        }
//        return R.createSuccessR().data(true);
//    }
//
//    /*
//        prd要求导入10000行，处理时间比较长，改为异步
//        请求时生成uuid的缓存key，直接返回前台，前台已uuidkey为参数开始轮询
//        excel处理完成，向缓存中存入处理结果；
//        轮询到结果，前台轮询程序展示结果
//     */
//    @PostMapping("/importUserFromFile")
//    public R importUserFromFile(@RequestParam("file") MultipartFile file) {
//
//        try {
//            String ext = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
//            if (!ext.equalsIgnoreCase("xls") && !ext.equalsIgnoreCase("xlsx")) {
//                return R.createFailR().message("文件格式有误，请重新导入!只支持excel");
//            }
//            String catchKey = UUID.randomUUID().toString();
//            log.info("用户导入异步开始 catchKey = {}",catchKey);
//            final UserDataListener userDataListener = new UserDataListener.Builder()
//                    .setUserService(userService)
//                    .setBizCodeGenerator(bizCodeGenerator)
//                    .setCacheClient(redissonClient)
//                    .setCatchKey(catchKey)
//                    .setFileService(fileService)
//                    .setValidateChain(validateChain).build();
//            AsyncContext context = new AsyncContext(Context.getTenant(),Context.getCurrUser());
//            byte[] bytes = IOUtils.toByteArray(file.getInputStream());
//            InputStream inputStream = new ByteArrayInputStream(bytes);
//            excelAsyncService.asyncSaveExcelUsers(userDataListener,inputStream, catchKey,context);
//            log.info("用户导入处理catchkey = {}返回，结果正在异步处理中 ",catchKey);
//            return R.createSuccessR().data(catchKey);
//        }catch(BusinessException e){
//            //空文档时报错
//            log.error("批量导入用户失败",e);
//            return R.createFailR().message(e.getMessage());
//        } catch (Exception e) {
//            log.error("批量导入用户失败",e);
//            return R.createFailR().message(e.getMessage());
//        }
//    }
//
//    @RequestMapping("/fetchUploadResult/{catchKey}")
//    public R fetchUploadResult(@PathVariable String catchKey) {
//        String result = (String) redissonClient.getBucket(catchKey.trim()).get();
//        log.info("result key = {} value={}",catchKey,result);
//        if(result==null) {
//            Map resultMap = new HashMap();
//            resultMap.put("errMsg","任务超时");
//            return R.createSuccessR().data(resultMap);
//        }else if("begin".equals(result)){
//            return R.createSuccessR().data("Processing");
//        }else{
//            return R.createSuccessR().data(JSON.parse(result));
//        }
//    }
//
//    @RequestMapping("/getPhone")
//    public R getUserPhone(@RequestParam("userId") Long userId) {
//        User user = this.userService.get(userId);
//        if (user == null){
//            return R.createSuccessR();
//        }
//        return R.createSuccessR().data(user.getPhone());
//    }
//
//    @RequestMapping("/pin/{pin}")
//    public R getInfoByPin(@PathVariable String pin) {
//
//        if (Objects.isNull(pin)) {
//            R.createSuccessR().data(false);
//        }
//        return R.createSuccessR().data(this.accountService.existsPin(pin));
//
//    }
//
//    @RequestMapping("/existsAccount/{acctType}/{acctName}")
//    public R getInfoByPin(@PathVariable Integer acctType, @PathVariable String acctName) {
//        return R.createSuccessR().data(this.accountService.existsAccount(acctType, acctName));
//    }
//
//    @RequestMapping("/erp/{erp}")
//    public R getInfoByErp(@PathVariable String erp) {
//
//        if (Objects.isNull(erp)) {
//            R.createSuccessR().data(false);
//        }
//        return R.createSuccessR().data(this.accountService.existsErp(erp));
//
//    }
//
//    @RequestMapping("/wxcp/{wxcp}")
//    public R getInfoByWxcp(@PathVariable String wxcp) {
//
//        if (Objects.isNull(wxcp)) {
//            R.createSuccessR().data(false);
//        }
//        return R.createSuccessR().data(this.accountService.existsWxcp(wxcp));
//
//    }
//
//    /**
//     * 转换VO页面显示数据
//     *
//     * @param data
//     */
//    @Override
//    protected List<UserFormVO> doConvertVOs(List<User> data) {
//        if (CollectionUtils.isEmpty(data)) {
//            return Collections.emptyList();
//        }
//
//        return data.stream().map(o -> BeanMapper.map(o, BeanMapper.getType(User.class), BeanMapper.getType(UserFormVO.class)))
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * 新增校验
//     *
//     * @param data
//     */
//    @Override
//    protected R parametericCheckBeforeCreate(UserFormVO data) {
//        return R.create().code(R.SUCCESS_CODE);
//    }
//
//    /**
//     * 展示层&model实体转换
//     *
//     * @param data
//     */
//    @Override
//    protected User doConvertModel(UserFormVO data) {
//        return BeanMapper.map(data, BeanMapper.getType(UserFormVO.class), BeanMapper.getType(User.class));
//    }
//
//    @Override
//    protected void doBeforeCreate(User user) {
//        //
//    }
//
//    /**
//     * model->VO
//     *
//     * @param user
//     */
//    @Override
//    protected UserFormVO doConvertVO(User user) {
//        return BeanMapper.map(user, BeanMapper.getType(User.class), BeanMapper.getType(UserFormVO.class));
//    }
//
//    /**
//     * 更新校验
//     *
//     * @param data
//     */
//    @Override
//    protected R parametericCheckBeforeUpdate(UserFormVO data) {
//        return R.create().code(R.SUCCESS_CODE);
//    }
//
//    /**
//     * 删除数据扩展点
//     *
//     * @param userFormVO
//     */
//    @Override
//    protected R parametericCheckBeforeDelete(UserFormVO userFormVO) {
//        return R.createSuccessR();
//    }
//
//    @Override
//    protected void doBeforeDelete(User user) {
//    }
//
//    /**
//     * 是否存在添加动态查询参数
//     *
//     * @param data
//     */
//    @Override
//    protected List<QueryItem> doBeforeCheckExistsAddSearchParam(UserFormVO data) {
//        return null;
//    }
//
//}
