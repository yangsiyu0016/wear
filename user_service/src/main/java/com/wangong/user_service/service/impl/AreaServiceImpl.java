package com.wangong.user_service.service.impl;

import com.wangong.common.domain.area.Area;
import com.wangong.common.service.AreaService;
import com.wangong.user_service.mapper.AreaMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 区域逻辑层实现
 */
public class AreaServiceImpl  implements AreaService {

    @Resource
    private AreaMapper areaMapper;


    /**
     * 根据id获取树形结构
     * @param id
     * @return
     */
    @Override
    public List<Area> getSubTreeData(Integer id) {
        return areaMapper.getSubTreeData(id);
    }

    /**
     * 获取整体树形结构
     * @return
     */
    @Override
    public List<Area> getTreeData() {
        return areaMapper.getTreeData();
    }

    /**
     * 根据父级id获取区域集合
     * @return
     */
    @Override
    public List<Area> getAreaByParentId(Integer parentId) {
        return areaMapper.getAreaByParentId(parentId);
    }

    /**
     * 根据id获取区域
     * @param id
     * @return
     */
    @Override
    public Area getAreaById(Integer id) {
        return areaMapper.getAreaById(id);
    }
}
