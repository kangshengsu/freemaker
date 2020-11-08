package com.fm.api.web.vo.sm.mapper;

import com.fm.api.web.vo.sm.MenuVO;
import com.fm.business.base.model.sm.Menu;
import com.fm.business.base.service.sm.IMenuService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 组织Mapper
 *
 * @author zhangleqi
 */
@Mapper(componentModel = "spring")
public abstract class MenuMapper {

    @Autowired
    private IMenuService menuService;

    public abstract MenuVO convert(Menu menu);

    public abstract List<MenuVO> convert(List<Menu> menuList);

    @AfterMapping
    public void populateParentMenus(List<Menu> menuList, @MappingTarget List<MenuVO> menuVOList) {
        if (CollectionUtils.isEmpty(menuList)) {
            return;
        }
        //// TODO: 2020/3/22 产品名称
        List<Long> ids = menuList.stream().map(Menu::getParentId).collect(Collectors.toList());
        List<Menu> parentMenus = menuService.getMenus(ids);
        Map<Long, String> menuMap = parentMenus.stream().collect(Collectors.toMap(Menu::getId, Menu::getName, (oldKey, newKey) -> newKey));
        menuVOList.forEach(menuVO -> {
            menuVO.setParentName(menuMap.get(menuVO.getParentId()));
            menuVO.setHref(null);
        });
    }
}
