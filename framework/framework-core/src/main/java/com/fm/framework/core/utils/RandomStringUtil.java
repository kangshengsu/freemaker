package com.fm.framework.core.utils;

import java.util.Random;

/**
 * @author qdl
 * @version 1.1
 * @date 2021/1/4 11:42
 */
public class RandomStringUtil {

    public static String getRandomStringByLength(int length) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
