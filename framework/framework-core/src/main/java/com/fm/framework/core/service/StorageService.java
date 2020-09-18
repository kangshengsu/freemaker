package com.fm.framework.core.service;

import com.fm.framework.core.model.CosTmpSecret;

import java.io.File;
import java.io.InputStream;

/**
 * 文件存储
 * @author zhangleqi
 * @date 2020/9/13
 */
public interface StorageService {

    String upload(String patch, byte[] bytes);

    String upload(String patch, String fileName, File file);

    void download();

    CosTmpSecret getTmpSecret();
}
