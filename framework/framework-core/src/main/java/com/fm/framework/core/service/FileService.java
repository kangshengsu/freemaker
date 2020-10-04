package com.fm.framework.core.service;

import com.fm.framework.core.model.OssTmpSecret;

/**
 * 文件存储
 * @author zhangleqi
 * @date 2020/9/13
 */
public interface FileService {

    /**
     * 文件上传
     * @param patch
     * @param bytes
     * @return
     */
    String upload(String patch, byte[] bytes);

    /**
     * 获取文件url
     *
     * 例: https://howwork-1301749332.cos.ap-beijing.myqcloud.com/path
     * @return 文件url
     */
    String getBaseUrl();

    /**
     * 获取临时秘钥
     *
     * @return 临时秘钥
     */
    OssTmpSecret getTmpSecret();

    String getFullPath(String path);
}
