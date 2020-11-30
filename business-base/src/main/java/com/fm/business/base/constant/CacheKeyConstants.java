package com.fm.business.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 缓存key常量池
 * liuduo
 * 2020年9月14日 22:39:17
 */
@AllArgsConstructor
@Getter
public enum CacheKeyConstants {
    /**
     * 登录token redis key
     */
    LOGIN_TOKEN("login:token:%s"),
    FIRST_JOB_CATE("jobCate:firstJobCate:%s");

    private String key;

}
