package com.fm.framework.core.service;

import java.io.File;
import java.io.InputStream;

/**
 * 文件存储
 * @author zhangleqi
 * @date 2020/9/13
 */
public interface StorageService {

    public String upload(String patch, byte[] bytes);

    public String upload(String patch, String fileName, File file);

    public void download();
}
