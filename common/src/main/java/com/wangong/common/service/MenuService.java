package com.wangong.common.service;

import com.wangong.common.domain.menu.Menu;

import java.util.List;

/**
 * 导航栏接口
 */
public interface MenuService {

    /**
     * 获取树形结构
     * @return
     */
    List<Menu> getTreeMenu(String positionId);

    /**
     * 根据id获取菜单
     * @param id
     * @return
     */
    Menu getMenuById(String id);

    /**
     * 添加菜单
     * @param menu
     */
    Menu addMenu(Menu menu);

    /**
     * 更新菜单
     * @param menu
     */
    Menu editMenu(Menu menu);

    /**
     * 根据id删除菜单
     * @param id
     */
    void deleteMenuById(String id) throws Exception;

}
