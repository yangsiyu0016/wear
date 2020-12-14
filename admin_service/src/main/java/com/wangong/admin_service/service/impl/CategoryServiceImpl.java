package com.wangong.admin_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.admin_service.mapper.CategoryMapper;
import com.wangong.common.domain.category.Category;
import com.wangong.common.service.CategoryService;
import com.wangong.common.utils.String2IntArr;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 类目逻辑层实现
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 获取所有含分页
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Category> getAll(Integer page, Integer size) {
        Integer start = 0;
        if (page > 0) {
            start = (page - 1) * size;
        }
        List<Category> categories = categoryMapper.getAll(start, size);
        return categories;
    }

    /**
     * 根据父级id获取类目
     * @param id
     * @return
     */
    @Override
    public List<Category> getCateByParentId(String id) {
        return categoryMapper.getCateByParentId(id);
    }

    /**
     * 获取总条数
     * @return
     */
    @Override
    public Long getCount(String parentId) {
        if (parentId == null) {
            parentId = "0";
        }
        return categoryMapper.getCount(parentId);
    }

    /**
     * 根据类目名称获取类目数量
     * @param name
     * @return
     */
    @Override
    public Long getCountByName(String name) {
        return categoryMapper.getCountByName(name);
    }

    /**
     * 根据id获取类目
     * @param id
     * @return
     */
    @Override
    public Category getCateById(String id) {
        return categoryMapper.getCateById(id);
    }

    /**
     * 添加类目
     * @param category
     */
    @Override
    public void addCate(Category category)throws Exception {
        Long count = this.getCountByName(category.getName());
        if (count > 0) {
            throw new Exception("该类目已存在");
        }
        category.setId(UUID.randomUUID().toString());
        categoryMapper.addCate(category);
    }

    /**
     * 更新类目
     * @param category
     */
    @Override
    public void editCate(Category category) throws Exception {
        Long count = this.getCountByName(category.getName());
        if (count > 0) {
            throw new Exception("该类目已存在");
        }
        categoryMapper.editCate(category);
    }

    /**
     * 删除类目
     * @param ids
     */
    @Override
    public void deleteCateByIds(String ids) {
        String[] split = ids.split(",");
        categoryMapper.deleteCateByIds(split);
    }
}
