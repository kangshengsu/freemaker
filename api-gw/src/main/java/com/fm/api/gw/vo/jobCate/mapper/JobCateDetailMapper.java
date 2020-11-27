package com.fm.api.gw.vo.jobCate.mapper;

import com.fm.api.gw.mapper.CommonMapper;
import com.fm.api.gw.vo.conf.JobCateDisplayVO;
import com.fm.api.gw.vo.jobCate.JobCateDetailVO;
import com.fm.business.base.model.job.BdJobCate;
import com.fm.business.base.model.job.BdJobCateDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/11/27 11:02
 */
@Mapper(componentModel = "spring")
public abstract class JobCateDetailMapper extends CommonMapper {

    @Mapping(source = "icon",target = "icon",qualifiedByName = "fullPath")
    public abstract JobCateDetailVO toJobCateDetailVO(BdJobCateDetail bdJobCateDetail);
}
