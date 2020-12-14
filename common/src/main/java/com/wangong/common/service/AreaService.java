package com.wangong.common.service;

import com.wangong.common.domain.area.Area;

import java.util.List;

/**
 * 区域接口
 */
public interface AreaService {

    /**
     * 根据id获取树形结构
     * @param id
     * @return
     */
    List<Area> getSubTreeData(Integer id);

    /**
     * 获取整体树形结构
     * @return
     */
    List<Area> getTreeData();

    /**
     * 根据父级id获取区域集合
     * @return
     */
    List<Area> getAreaByParentId(Integer parentId);

    /**
     * 根据id获取区域
     * @param id
     * @return
     */
    Area getAreaById(Integer id);

}
