package com.wangong.admin_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.admin_service.mapper.MenuMapper;
import com.wangong.common.domain.menu.Menu;
import com.wangong.common.service.MenuService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 导航栏逻辑层
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 获取树形结构
     * @return
     */
    @Override
    public List<Menu> getTreeMenu(String positionId) {

        List<Menu> menus = menuMapper.getTreeMenu(positionId);
        return menus;

    }

    /**
     * 根据id获取菜单
     * @param id
     * @return
     */
    @Override
    public Menu getMenuById(String id) {
        Menu menu = menuMapper.getMenuById(id);
        return menu;

    }

    /**
     * 添加菜单
     * @param menu
     */
    @Override
    public Menu addMenu(Menu menu) {
        menu.setId(UUID.randomUUID().toString());
        menu.setCtime(new Date());
        menuMapper.addMenu(menu);
        return null;
    }

    /**
     * 更新菜单
     * @param menu
     */
    @Override
    public Menu editMenu(Menu menu) {
        menuMapper.editMenu(menu);
        return null;
    }

    /**
     * 根据id删除菜单
     * @param id
     */
    @Override
    public void deleteMenuById(String id) throws Exception {
        menuMapper.deleteMenuById(id);
    }
}
