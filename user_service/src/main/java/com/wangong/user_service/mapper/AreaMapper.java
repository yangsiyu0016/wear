package com.wangong.user_service.mapper;

import com.wangong.common.domain.area.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 区域持久层
 */
@Mapper
public interface AreaMapper {

    /**
     * 根据id获取树形结构
     * @param id
     * @return
     */
    List<Area> getSubTreeData(@Param("id") Integer id);

    /**
     * 获取整体树形结构
     * @return
     */
    List<Area> getTreeData();

    /**
     * 根据父级id获取区域集合
     * @return
     */
    List<Area> getAreaByParentId(@Param("parentId") Integer parentId);

    /**
     * 根据id获取区域
     * @param id
     * @return
     */
    Area getAreaById(@Param("id") Integer id);

}
