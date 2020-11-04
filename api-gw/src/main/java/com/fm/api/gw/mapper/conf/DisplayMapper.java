package com.fm.api.gw.mapper.conf;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.conf.JobCateDisplayVO;
import com.fm.business.base.model.job.BdJobCate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author clufeng
 * @version 1.0.0
 **/
@Mapper(componentModel = "spring")
public abstract class DisplayMapper extends CommonMapper {

    @Mapping(source = "icon",target = "icon",qualifiedByName = "fullPath")
    public abstract JobCateDisplayVO toJobCateDisplayVO(BdJobCate bdJobCate);

    @Mapping(source = "icon",target = "icon",qualifiedByName = "fullPath")
    public abstract BdJobCate toBdJobCate(JobCateDisplayVO jobCateDisplayVO);

}
