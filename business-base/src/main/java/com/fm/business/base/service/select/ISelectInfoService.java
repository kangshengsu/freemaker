package com.fm.business.base.service.select;

import com.fm.business.base.model.select.SelectInfo;
import com.fm.framework.core.service.Service;

import java.util.List;
import java.util.Map;

/**
 * @author qdl
 * @version 1.1
 * @date 2020/12/24 13:58
 */
public interface ISelectInfoService extends Service<SelectInfo> {
    Map<String, List<String>> getKeyWordsByUserId(Long userId);

   List<SelectInfo> getRecommendKeywordsByWeight();

    Boolean deleteKeyword(Long userId);

    SelectInfo selectByUserIdAndKeyword(Long userId, String keyword);
}
