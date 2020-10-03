package com.fm.api.gw.mapper.conf;

import com.fm.api.gw.vo.conf.JobCateDisplayVO;
import com.fm.business.base.model.job.BdJobCate;
import org.mapstruct.Mapper;

/**
 * @author clufeng
 * @version 1.0.0
 **/
@Mapper(componentModel = "spring")
public interface DisplayMapper {

    JobCateDisplayVO toJobCateDisplayVO(BdJobCate bdJobCate);

}
