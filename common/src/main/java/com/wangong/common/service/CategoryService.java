package com.wangong.common.service;

import com.wangong.common.domain.category.Category;

import java.util.List;

/**
 * 类目逻辑层接口
 */
public interface CategoryService {

    /**
     * 获取
     * @param page
     * @param size
     * @return
     */
    List<Category> getAll(Integer page, Integer size);

    /**
     * 根据父级id获取类目
     * @param id
     * @return
     */
    List<Category> getCateByParentId(String id);

    /**
     * 获取总条数
     * @return
     */
    Long getCount(String parentId);

    /**
     * 根据类目名称获取类目数量
     * @param name
     * @return
     */
    Long getCountByName(String name);

    /**
     * 根据id获取类目
     * @param id
     * @return
     */
    Category getCateById(String id);

    /**
     * 添加类目
     * @param category
     */
    void addCate(Category category)throws Exception;

    /**
     * 更新类目
     * @param category
     */
    void editCate(Category category) throws Exception;

    /**
     * 删除类目
     * @param ids
     */
    void deleteCateByIds(String ids);

}
