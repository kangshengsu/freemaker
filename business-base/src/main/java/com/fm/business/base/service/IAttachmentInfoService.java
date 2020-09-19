/**
 * @filename:AttachmentInfoService 2020年09月11日
 * @project HowWork  V1.0
 * Copyright(c) 2020 LiuDuo Co. Ltd.
 * All right reserved.
 */
package com.fm.business.base.service;


import com.fm.business.base.enums.AttachmentBusinessType;
import com.fm.business.base.model.AttachmentInfo;
import com.fm.framework.core.service.Service;

import java.util.List;

/**
 * @Description:(附件服务层)
 * @version: V1.0
 * @author: LiuDuo
 *
 */
public interface IAttachmentInfoService extends Service<AttachmentInfo> {

    /**
     * 根据附件编码和业务类型获取附件信息
     *
     * @param businessCode 业务编码
     * @param type  业务类型
     * @return 附件信息
     */
     List<AttachmentInfo> getByCodeAndType(String businessCode, AttachmentBusinessType type);

}
