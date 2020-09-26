package com.fm.framework.core.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fm.framework.core.constants.DbFieldConsts;
import com.fm.framework.core.enums.DeleteEnum;
import com.fm.framework.core.enums.YesNoEnum;

/**
 * Created by zhongyicun on 2020/8/12.
 */
public class WrapperUtil{

    /**
     * 返回附带默认值的查询条件包装
     *
     * @return
     */
    public static <T> QueryWrapper<T> getQueryWrapperUtil() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DbFieldConsts.IS_DELETE, DeleteEnum.VALID.getValue());
        return queryWrapper;
    }

}

