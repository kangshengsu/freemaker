package com.fm.business.base.model.conf;

import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author hubo
 * @version 1.0.0
 **/
@Mapper
public interface DisplayConfigItemConvert {

    DisplayConfigItemConvert INSTANCE = Mappers.getMapper(DisplayConfigItemConvert.class);

    @Mapping(target = "displayId", source = "id")
    @Mapping(target = "resName", source = "cateName")
    DisplayConfigItem to(BdJobCate bdJobCate);


    @Mapping(target = "displayId", source = "id")
    @Mapping(target = "resName", source = "title")
    DisplayConfigItem to(ProductionInfo productionInfo);

}
