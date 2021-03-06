package com.fm.framework.core;


/**
 * 上下文
 * @author clufeng
 * @version 1.0.0
 **/
public class Context {

    private static ThreadLocal<Long> loginUserThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> loginUserCodeThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> loginUserNameThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> loginUserTokenThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Long> loginFreelancerIdThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Long> loginEmployerIdThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> loginMiniAppSecretKeyThreadLocal = new ThreadLocal<>();

    public static void setMiniAppSecretKey(String secreteKey) {
        if(secreteKey != null) {
            loginMiniAppSecretKeyThreadLocal.set(secreteKey);
        }
    }

    public static String getMiniAppSecretKey() {
        return loginMiniAppSecretKeyThreadLocal.get();
    }

    public static void setCurrUser(Long user) {
        if(user != null) {
            loginUserThreadLocal.set(user);
        }
    }

    public static void setCurrUserCode(String userCode) {
        if(userCode != null) {
            loginUserCodeThreadLocal.set(userCode);
        }
    }

    public static void setCurrUserName(String userName) {
        if(userName != null) {
            loginUserNameThreadLocal.set(userName);
        }
    }

    public static void setCurrUserToken(String userToken) {
        if(userToken != null) {
            loginUserTokenThreadLocal.set(userToken);
        }
    }

    public static Long getCurrUserId() {
        return loginUserThreadLocal.get();
    }

    public static void setCurrFreelancerId(Long freelancerId) {
        if(freelancerId != null) {
            loginFreelancerIdThreadLocal.set(freelancerId);
        }
    }
    public static void setCurrEmployerId(Long employerId) {
        if(employerId != null) {
            loginEmployerIdThreadLocal.set(employerId);
        }
    }

    public static Long getCurrFreelancerId() {
        return loginFreelancerIdThreadLocal.get();
    }

    public static Long getCurrEmployerId() {
        return loginEmployerIdThreadLocal.get();
    }

    public static String getCurrUserCode() {
        return loginUserCodeThreadLocal.get();
    }

    public static String getCurrUserName() {
        return loginUserNameThreadLocal.get();
    }

    public static String getCurrUserToken() {
        return loginUserTokenThreadLocal.get();
    }

    public static void removeCurrUserCode() {
        loginUserCodeThreadLocal.remove();
    }

    public static void removeCurrUser() {
        loginUserThreadLocal.remove();
    }

    public static void removeCurrName() {
        loginUserNameThreadLocal.remove();
    }
    public static void removeCurrToken() {
        loginUserTokenThreadLocal.remove();
    }


}
