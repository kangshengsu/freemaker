package com.fm.business.base.service.rotation;

import com.fm.business.base.model.rotation.RotationInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @author G
 * @date 2020/12/25 下午2:19
 */
public interface RotationService extends Service<RotationInfo> {

    List<RotationInfo> findAll();
}
