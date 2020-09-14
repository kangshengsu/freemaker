package com.fm.api.web.controller.common;

import com.fm.api.web.vo.common.EnumVO;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liuduo
 * @description：TODO
 * @date ：2020/9/14 21:57
 */
@RestController
@RequestMapping("/enum")
@Slf4j
public class EnumController {

    private static String ENUM_PACKAGE_PATH = "com.fm.business.base.enums.";

    /**
     * 获取枚举内容
     * @param enumName
     * @return
     */
    @RequestMapping(value = "/values",method = RequestMethod.GET)
    public ApiResponse<List<EnumVO>> get(@RequestBody String enumName){
        List<EnumVO> data = new ArrayList<>();
        String className = ENUM_PACKAGE_PATH + enumName;
        try{
            // 得到枚举类对象
            Class<Enum> clazz = (Class<Enum>) Class.forName(className);
            //获取所有枚举实例
            Enum[] enumConstants = clazz.getEnumConstants();
            //根据方法名获取方法
            Method getCode = clazz.getMethod("getCode");
            Method getName = clazz.getMethod("getName");
            for (Enum _enum : enumConstants) {
                EnumVO enumVO = new EnumVO();
                //执行枚举方法获得枚举实例对应的值
                enumVO.setCode((Integer)getCode.invoke(_enum));
                enumVO.setName((String)getName.invoke(_enum));
                data.add(enumVO);
            }
        } catch (ClassNotFoundException e) {
            log.error("请确认{}是否存在{}此包路径下",enumName,ENUM_PACKAGE_PATH);
            return ApiResponse.of(ApiStatus.FAILED,data);
        } catch (NoSuchMethodException e) {
            log.error("请设置{}枚举的getCode和getName方法",enumName);
            return ApiResponse.of(ApiStatus.FAILED,data);
        } catch (IllegalAccessException e) {
            log.error("请确认{}枚举的getCode和getName方法是否正确",enumName);
            return ApiResponse.of(ApiStatus.FAILED,data);
        } catch (InvocationTargetException e) {
            log.error("请确认{}枚举的getCode和getName方法是否正确",enumName);
            return ApiResponse.of(ApiStatus.FAILED,data);
        }

        return ApiResponse.of(ApiStatus.SUCCESS,data);
    }



}
