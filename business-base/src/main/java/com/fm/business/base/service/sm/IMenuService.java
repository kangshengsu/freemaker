package com.fm.business.base.service.sm;


import com.fm.business.base.model.sm.Menu;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.service.TreeService;

import java.util.List;

/**
 * 菜单服务
 * @author hubo
 * @version 1.0.0
 **/
public interface IMenuService extends TreeService<Menu> {

    /**
     * 查询菜单
     * @param ids 待查询菜单id集合
     * */
    List<Menu> getMenus(List<Long> ids);

    /**
     * 查询租户下已安装的所有菜单
     *
     * */
    List<Menu> getAllEnableMenus(List<QueryItem> queryItems);

    Menu getByCode(String menuCode);

    /**
     * 通过菜单编码查找用户
     * */
    List<Menu> getAllEnableByCode(List<String> menuCodes);

}
