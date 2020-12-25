package com.fm.business.base.service.advert;

import com.fm.business.base.model.advert.AdvertInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @author G
 * @date 2020/12/24 下午2:14
 */
public interface AdvertInfoService extends Service<AdvertInfo> {

    List<AdvertInfo> findAll();

    Integer findValidCount();
}
