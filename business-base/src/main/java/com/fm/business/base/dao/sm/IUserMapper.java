package com.fm.business.base.dao.sm;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fm.business.base.model.sm.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Mapper
 * @author hubo
 * @version 1.0.0
 **/
@Mapper
public interface IUserMapper extends BaseMapper<User> {

    Page<User> pageList(com.fm.framework.core.query.Page<User> page, @Param("user") User user);
}
