package com.fm.framework.web.controller;


import com.fm.framework.core.model.BaseModel;
import com.fm.framework.core.query.Page;
import com.fm.framework.core.query.PageInfo;
import com.fm.framework.core.service.Service;
import com.fm.framework.web.VO;
import com.fm.framework.web.request.QueryRequest;
import com.fm.framework.web.response.ApiResponse;
import com.fm.framework.web.response.ApiStatus;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.stream.Collectors;

/**
 * <p>基础Controller</p>
 *
 * @author clufeng
 */
public abstract class BaseController<M extends BaseModel, V extends VO> {

    protected <T> ApiResponse<T> success(T t) {
        return ApiResponse.of(ApiStatus.SUCCESS, t);
    }

    protected <T> ApiResponse<T> failed(String error) {
        return ApiResponse.of(ApiStatus.FAILED, error);
    }

    public ApiResponse<Boolean> create(V form) {

        M model = convert(form);

        boolean result = this.service().save(model);

        return success(result);

    }

    public ApiResponse<Boolean> delete(Long id) {

        boolean result = this.service().delete(id);

        return success(result);

    }

    public ApiResponse<Boolean> update(V form) {

        M model = convert(form);

        boolean result = this.service().update(model);

        return success(result);

    }

    public ApiResponse<Page<V>> list(QueryRequest queryRequest) {

        Page<M> pageDatas = this.service().list(queryRequest.getQueryItems(), queryRequest.getOrderItem(),
                queryRequest.getPagination().getCurrentPage(), queryRequest.getPagination().getPageSize());

        PageInfo<V> result = new PageInfo<>();
        result.setCurrentPage(pageDatas.getCurrentPage());
        result.setPageSize(pageDatas.getPageSize());
        result.setTotal(pageDatas.getTotal());
        result.setData(pageDatas.getData().stream().map(this::convert).collect(Collectors.toList()));
        return success(result);
    }

    protected abstract Service<M> service();

    protected M convert(V form) {
        M model = null;
        try {
            model = getMInstance();
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        }
        BeanUtils.copyProperties(form, model);
        return model;
    }

    protected V convert(M model) {
        V form = null;
        try {
            form = getVInstance();
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        }
        BeanUtils.copyProperties(model, form);
        return form;
    }

    private M getMInstance() throws IllegalAccessException, InstantiationException {
        Class<M> clazz;
        M m = null;
        Type superclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = null;
        if (superclass instanceof ParameterizedType) {
            parameterizedType = (ParameterizedType) superclass;
            Type[] typeArray = parameterizedType.getActualTypeArguments();
            if (typeArray != null && typeArray.length > 0) {
                clazz = (Class<M>) typeArray[0];
                m = clazz.newInstance();
            }
        }

        return m;
    }

    private V getVInstance() throws IllegalAccessException, InstantiationException {
        Class<V> clazz;
        V v = null;
        Type superclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = null;
        if (superclass instanceof ParameterizedType) {
            parameterizedType = (ParameterizedType) superclass;
            Type[] typeArray = parameterizedType.getActualTypeArguments();
            if (typeArray != null && typeArray.length > 0) {
                clazz = (Class<V>) typeArray[1];
                v = clazz.newInstance();
            }
        }

        return v;
    }
}