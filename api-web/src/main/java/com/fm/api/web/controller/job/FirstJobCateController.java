package com.fm.api.web.controller.job;

import com.fm.api.web.vo.job.BdJobCateVO;
import com.fm.business.base.constant.CacheKeyConstants;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobCateDetail;
import com.fm.business.base.service.impl.BdJobCateDetailServiceImpl;
import com.fm.business.base.service.job.IBdJobCateDetailService;
import com.fm.business.base.service.job.IBdJobCateService;
import com.fm.business.base.service.production.IProductionInfoService;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.service.Service;
import com.fm.framework.core.utils.CodeUtil;
import com.fm.framework.core.utils.TreeIncodeUtil;
import com.fm.framework.web.controller.BaseController;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/20 17:19
 */
@RestController
@RequestMapping(value = "/job/firstJobCate")
public class FirstJobCateController extends BaseController<BdJobCate, BdJobCateVO> {
    @Autowired
    private IBdJobCateService bdJobCateService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IBdJobCateDetailService bdJobCateDetailService;

    @Autowired
    private IProductionInfoService productionInfoService;


    @Override
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ApiResponse<Page<BdJobCateVO>> list(@RequestBody QueryRequest queryRequest) {
        ApiResponse<Page<BdJobCateVO>> list = super.list(queryRequest);
        return list;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ApiResponse<Boolean> create(@RequestBody BdJobCateVO bdJobCateVO) {
        if (StringUtils.isBlank(bdJobCateVO.getCateCode())) {
            bdJobCateVO.setCateCode(CodeUtil.generateNewCode2yyMMddHH());
        }
        bdJobCateVO.setTreeCode(TreeIncodeUtil.create(bdJobCateVO.getParentCode()));
        ApiResponse<Boolean> result = super.create(bdJobCateVO);
        if (!redisTemplate.opsForList().range(CacheKeyConstants.FIRST_JOB_CATE.getKey(), 0, 100).isEmpty()) {
            redisTemplate.delete(CacheKeyConstants.FIRST_JOB_CATE.getKey());
        }
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @Transactional(rollbackFor = RuntimeException.class)
    public ApiResponse<Boolean> update(@RequestBody BdJobCateVO bdJobCateVO) {
        if (bdJobCateVO.getCateType() == 10 && bdJobCateVO.getBdJobCateDetail().getCategoryShow() == 20) {
            if (Optional.ofNullable(bdJobCateService.getSecondJobCate(bdJobCateVO.getId())).map(CollectionUtils::isEmpty).orElse(false)) {
                if (!redisTemplate.opsForList().range(CacheKeyConstants.FIRST_JOB_CATE.getKey(), 0, 100).isEmpty()) {
                    redisTemplate.delete(CacheKeyConstants.FIRST_JOB_CATE.getKey());
                }
                return super.update(bdJobCateVO);
            }
            List<Long> secondJobCateIds = bdJobCateService.getSecondJobCate(bdJobCateVO.getId());
            if (!CollectionUtils.isEmpty(bdJobCateDetailService.getSecondJobCate(secondJobCateIds))){
                return failed("二级类目未关闭，不得关闭一级类目");
            }
        }else if(bdJobCateVO.getCateType() == 20 && bdJobCateVO.getBdJobCateDetail().getCategoryShow() == 20){
            if (Optional.ofNullable(productionInfoService.getByJobCateId(bdJobCateVO.getId()))
                    .map(p -> !CollectionUtils.isEmpty(p))
                    .orElse(false)){
                return ApiResponse.of(ApiStatus.FAILED,"类目下有作品不能关闭");
            }else{
                if (!redisTemplate.opsForList().range(CacheKeyConstants.FIRST_JOB_CATE.getKey(), 0, 100).isEmpty()) {
                    redisTemplate.delete(CacheKeyConstants.FIRST_JOB_CATE.getKey());
                }
                return super.update(bdJobCateVO);
            }
        }
        if (!redisTemplate.opsForList().range(CacheKeyConstants.FIRST_JOB_CATE.getKey(), 0, 100).isEmpty()) {
            redisTemplate.delete(CacheKeyConstants.FIRST_JOB_CATE.getKey());
        }
        return super.update(bdJobCateVO);
    }

    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public ApiResponse<Boolean> delete(@RequestBody BdJobCateVO form) {

        if (Optional.ofNullable(bdJobCateService.getByParentId(form.getParentId()))
                .map(Objects::nonNull)
                .orElse(false)) {
            return ApiResponse.of(ApiStatus.FAILED, "不能删除有二级类目的一级类目");
        }
        if (!redisTemplate.opsForList().range(CacheKeyConstants.FIRST_JOB_CATE.getKey(), 0, 100).isEmpty()) {
            redisTemplate.delete(CacheKeyConstants.FIRST_JOB_CATE.getKey());
        }
        return super.delete(form.getParentId());
    }

    @Override
    protected Service<BdJobCate> service() {
        return bdJobCateService;
    }
}
