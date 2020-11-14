package com.fm.framework.core.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fm.framework.core.Context;
import com.fm.framework.core.model.AuditStatusBaseModel;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Date;

/**
 * <p>审计服务</p>
 *
 * @author clufeng
 */
public class AuditStatusBaseService<M extends BaseMapper<T>, T extends AuditStatusBaseModel> extends StatusBaseService<M, T> {

    @Override
    protected void initDefaultField(T model) {
        super.initDefaultField(model);
        model.setCreateTime(new Date());
        model.setCreateUser(Context.getCurrUserId() != null ? Context.getCurrUserId() : -1L);
        model.setUpdateTime(new Date());
        model.setUpdateUser(Context.getCurrUserId() != null ? Context.getCurrUserId() : -1L);
    }

    @Override
    protected void beforeUpdate(T model) {
        super.beforeUpdate(model);
        model.setUpdateTime(new Date());
        model.setUpdateUser(Context.getCurrUserId()!=null?Context.getCurrUserId():-1L);
    }

    @Override
    protected void beforeUpdate(Collection<T> models) {
        super.beforeUpdate(models);
        if(!CollectionUtils.isEmpty(models)) {
            models.forEach(model -> {
                model.setUpdateTime(new Date());
                model.setUpdateUser(Context.getCurrUserId()!=null?Context.getCurrUserId():-1L);
            });
        }
    }
}
