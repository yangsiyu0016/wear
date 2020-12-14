package com.wangong.admin_service.mapper;

import com.wangong.common.domain.menu.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 导航栏持久层接口
 */
@Mapper
public interface MenuMapper {

    /**
     * 获取树形结构
     * @return
     */
    List<Menu> getTreeMenu(@Param("positionId") String positionId);

    /**
     * 根据id获取菜单
     * @param id
     * @return
     */
    Menu getMenuById(@Param("id") String id);

    /**
     * 添加菜单
     * @param menu
     */
    void addMenu(@Param("menu") Menu menu);

    /**
     * 更新菜单
     * @param menu
     */
    void editMenu(@Param("menu") Menu menu);

    /**
     * 根据id删除菜单
     * @param id
     */
    void deleteMenuById(@Param("id") String id);

}
