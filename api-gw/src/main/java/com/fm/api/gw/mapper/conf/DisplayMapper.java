package com.fm.api.gw.mapper.conf;

import com.fm.api.gw.vo.conf.JobCateDisplayVO;
import com.fm.api.gw.vo.conf.ProductListVO;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.production.ProductionInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author clufeng
 * @version 1.0.0
 **/
@Mapper(componentModel = "spring")
public interface DisplayMapper {

    JobCateDisplayVO toJobCateDisplayVO(BdJobCate bdJobCate);

    @Mapping(target = "name", source = "title")
    @Mapping(target = "images", source = "attachmentInfos")
    ProductListVO toProductListVO(ProductionInfo productionInfo);


}
