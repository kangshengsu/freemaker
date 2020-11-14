package com.fm.business.base.service.sm.impl;

import com.fm.business.base.dao.sm.IMenuMapper;
import com.fm.business.base.model.sm.Menu;
import com.fm.business.base.model.sm.MenuComponentType;
import com.fm.business.base.model.sm.MenuType;
import com.fm.business.base.service.sm.IMenuService;
import com.fm.framework.core.Context;
import com.fm.framework.core.event.BatchUpdateOperationEvent;
import com.fm.framework.core.model.DBFieldConst;
import com.fm.framework.core.model.TreeNode;
import com.fm.framework.core.query.OrderItem;
import com.fm.framework.core.query.OrderType;
import com.fm.framework.core.query.QueryItem;
import com.fm.framework.core.query.QueryType;
import com.fm.framework.core.service.TreeAuditStatusBaseService;
import com.fm.framework.core.utils.TreeIncodeUtil;
import com.fm.framework.core.utils.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hubo
 * @version 1.0.0
 **/
@Service("menuService")
@Slf4j
public class DefaultMenuServiceImpl extends TreeAuditStatusBaseService<IMenuMapper, Menu> implements IMenuService {

    /**
     * 查询菜单
     *
     * @param ids 待查询菜单id集合
     */
    @Override
    public List<Menu> getMenus(List<Long> ids) {

        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }

        return this.getByIds(ids);
    }

    /**
     * 查询租户下已安装的所有菜单
     */
    @Override
    public List<Menu> getAllEnableMenus(List<QueryItem> queryItems) {
        return this.getEnableStatus(queryItems);
    }

    @Override
    public Menu getByCode(String menuCode) {
        QueryItem item = new QueryItem();
        item.setQueryField(DBFieldConst.CODE);
        item.setValue(menuCode);
        item.setType(QueryType.eq);
        return this.getOneFromExistSame(Collections.singletonList(item));
    }

    /**
     * 通过菜单编码查找用户
     *
     */
    @Override
    public List<Menu> getAllEnableByCode(List<String> menuCodes) {
        if (CollectionUtils.isEmpty(menuCodes)){
            return Collections.emptyList();
        }

        QueryItem item = new QueryItem();
        item.setType(QueryType.in);
        item.setQueryField(DBFieldConst.CODE);
        item.setValue(menuCodes);
        return this.getAllEnableMenus(Collections.singletonList(item));
    }


    private void updateTreeNodeIncode(String parentIncode, List<TreeNode<Menu>> nodes) {
        for (TreeNode<Menu> node : nodes) {
            node.getValue().setIncode(TreeIncodeUtil.create(parentIncode));
            update(node.getValue());
            if(!CollectionUtils.isEmpty(node.getChilds())) {
                updateTreeNodeIncode(node.getValue().getIncode(), node.getChilds());
            }
        }
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class, Throwable.class}, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @Override
    public boolean save(Menu model) {
        return super.save(model);
    }

    @Override
    protected void beforeSave(Menu menu) {
        super.beforeSave(menu);

        this.updateSq(menu);
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class, Throwable.class})
    @Override
    public boolean update(Menu model) {

        Menu old = get(model.getId());

        if(!old.getParentId().equals(model.getParentId())) {

            if(model.getParentId() != -1) {
                Menu newParent = get(model.getParentId());
                model.setIncode(TreeIncodeUtil.create(newParent.getIncode()));

                if(MenuComponentType.frame.value().equals(newParent.getComponent())) {
                    newParent.setComponent(MenuComponentType.nested.value());
                    update(newParent);
                }

            }else {
                model.setIncode(TreeIncodeUtil.create(null));
            }

            List<Menu> allChilds = findAllChildByNodeId(model.getId());

            if(model.getParentId() == -1) {
                model.setComponent(MenuComponentType.layout.value());
            } else {

                List<Menu> menuChild = allChilds.stream()
                        .filter(menu -> menu.getType() != MenuType.button.value())
                        .collect(Collectors.toList());

                if(menuChild.isEmpty()) {
                    model.setComponent(MenuComponentType.frame.value());
                } else {
                    model.setComponent(MenuComponentType.nested.value());
                }
            }

            if(!allChilds.isEmpty()) {
                List<Menu> updateList = new ArrayList<>();
                List<TreeNode<Menu>> childNodes = TreeUtil.buildTree(allChilds).getChilds();
                for (TreeNode<Menu> childNode : childNodes) {
                    updateComponent(childNode);
                    updateIncode(model.getIncode(), childNode);
                    updateList.addAll(getAllMenuData(childNode));
                }
                if(!updateList.isEmpty()) {
                    update(updateList);
                }
            }

        }

        return super.update(model);
    }

    private void updateComponent(TreeNode<Menu> node) {
        if(node.isLeaf()) {
            if(node.getValue().getType()== MenuType.button.value()) {
                node.getValue().setComponent("button");
            }
        } else {
            boolean hasNotButtonChild = false;
            for (TreeNode<Menu> childNode : node.getChilds()) {
                if(childNode.getValue().getType() != MenuType.button.value()) {
                    hasNotButtonChild = true;
                }
                updateComponent(childNode);
            }/*
            if(hasNotButtonChild) {
                node.getValue().setComponent("nested");
            } else {
                node.getValue().setComponent("frame");
            }*/
        }
    }

    private void updateIncode(String parentIncode, TreeNode<Menu> node) {
        node.getValue().setIncode(TreeIncodeUtil.create(parentIncode));
        if(!node.isLeaf()) {
            for (TreeNode<Menu> childNode : node.getChilds()) {
                updateIncode(node.getValue().getIncode(), childNode);
            }
        }
    }

    private List<Menu> getAllMenuData(TreeNode<Menu> node) {

        List<Menu> result = new ArrayList<>();

        result.add(node.getValue());

        if(!node.isLeaf()) {
            for (TreeNode<Menu> childNode : node.getChilds()) {
                result.addAll(getAllMenuData(childNode));
            }
        }

        return result;
    }


    @Override
    protected void beforeUpdate(Menu menu) {
        super.beforeUpdate(menu);
        Integer sq = menu.getSq();
        if (sq == null){
            return;
        }
        Long id = menu.getId();
        Menu oldMenu = this.get(id);
        Integer oldSq = oldMenu.getSq();
        if (!sq.equals(oldSq)) {
            this.updateSq(menu);
        }

    }

    private void updateSq(Menu menu) {
        List<QueryItem> items = new ArrayList<>();

        QueryItem itemSq = new QueryItem();
        itemSq.setQueryField(DBFieldConst.SQ);
        itemSq.setValue(menu.getSq());
        itemSq.setType(QueryType.gte);
        items.add(itemSq);

        QueryItem itemParent = new QueryItem();
        itemParent.setQueryField(DBFieldConst.PARENT_ID);
        itemParent.setValue(menu.getParentId());
        itemParent.setType(QueryType.eq);
        items.add(itemParent);

        List<Menu> menus = this.get(items, new OrderItem(OrderType.asc, DBFieldConst.SQ));
        if (menus == null || menus.isEmpty()) {
            return;
        }

        List<Integer> sqSortedList = menus.stream().map(Menu::getSq).collect(Collectors.toList());
        if (!sqSortedList.contains(menu.getSq())) {
            return;
        }

        /**
         * 步长 1， 当两个元素相隔大于1时跳出循环
         * */
        List<Menu> updateMenus = new ArrayList<>();
        for (Menu m : menus) {
            int tempSq = m.getSq() + 1;
            if (sqSortedList.contains(tempSq)) {
                updateMenus.add(m);
            } else {
                updateMenus.add(m);
                break;
            }
        }

        if (updateMenus.isEmpty()){
            return;
        }

        List<Menu> newMenus = updateMenus.stream().peek(m -> m.setSq(m.getSq() + 1)).collect(Collectors.toList());

        newMenus.forEach(m -> {
            m.setUpdateTime(new Date());
            m.setUpdateUser(Context.getCurrUserId());
        });

        boolean result = this.updateBatchById(newMenus, newMenus.size());

        if (result) {
            super.getApplicationContext().publishEvent(new BatchUpdateOperationEvent(this, menus, newMenus));
        }
    }


    @Override
    @Transactional
    public boolean delete(Menu model) {

        List<Menu> childMenus = findAllChildByNode(model);

        if(!childMenus.isEmpty()) {
            delete(childMenus);
        }

        return super.delete(model);

    }
}
