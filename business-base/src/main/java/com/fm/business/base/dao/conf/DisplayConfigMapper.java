package com.fm.business.base.dao.conf;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fm.business.base.model.conf.DisplayConfig;
import org.apache.ibatis.annotations.Mapper;

/**
 * 展现配置Mybatis Mapper
 * @author clufeng
 * @version 1.0.0
 **/
@Mapper
public interface DisplayConfigMapper extends BaseMapper<DisplayConfig> {

    String DISPLAY_TYPE_DB_FIELD = "display_type";

}
