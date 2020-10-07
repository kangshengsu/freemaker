package com.fm.api.web.convert;

import com.fm.api.web.vo.conf.DisplayConfigVO;
import com.fm.business.base.model.conf.DisplayConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author hubo
 * @version 1.0.0
 **/
@Mapper
public interface DisplayConfigConvert {

    DisplayConfigConvert INSTANCE = Mappers.getMapper(DisplayConfigConvert.class);

    @Mapping(target = "resourceName", ignore = true)
    DisplayConfigVO to(DisplayConfig displayConfig);

}
