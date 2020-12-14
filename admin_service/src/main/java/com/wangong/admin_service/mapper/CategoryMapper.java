package com.wangong.admin_service.mapper;

import com.wangong.common.domain.category.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类目实体类
 */
@Mapper
public interface CategoryMapper {

    /**
     * 获取
     * @param start
     * @param size
     * @return
     */
    List<Category> getAll(@Param("start") Integer start, @Param("size") Integer size);

    /**
     * 根据类目名称获取类目数量
     * @param name
     * @return
     */
    Long getCountByName(@Param("name") String name);

    /**
     * 根据父级id获取类目
     * @param id
     * @return
     */
    List<Category> getCateByParentId(@Param("id") String id);

    /**
     * 获取总条数
     * @return
     */
    Long getCount(@Param("parentId") String parentId);

    /**
     * 根据id获取类目
     * @param id
     * @return
     */
    Category getCateById(@Param("id") String id);

    /**
     * 添加类目
     * @param category
     */
    void addCate(@Param("category")Category category);

    /**
     * 更新类目
     * @param category
     */
    void editCate(@Param("category") Category category);

    /**
     * s删除类目
     * @param ids
     */
    void deleteCateByIds(@Param("ids") String[] ids);

}
