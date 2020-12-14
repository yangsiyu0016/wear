package com.wangong.admin_web.controller;

import com.wangong.common.domain.category.Category;
import com.wangong.common.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 获取所有类目含分页
     * @param page
     * @param size
     * @param parentId
     * @return
     */
    @GetMapping("/page")
    public Map<Object, Object> getAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("parentId") String parentId) {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<Category> categories = categoryService.getAll(page, size);
            Long count = categoryService.getCount(parentId);
            map.put("result", "success");
            map.put("categories", categories);
            map.put("count", count);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据父级id获取类目
     * @param id
     * @return
     */
    @GetMapping("/getCateByParentId")
    public Map<Object, Object> getCateByParentId(@RequestParam("parentId") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<Category> categories = categoryService.getCateByParentId(id);
            map.put("result", "success");
            map.put("categories", categories);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据id获取类目
     * @param id
     * @return
     */
    @GetMapping("/getCateById")
    public Map<Object, Object> getCateById(@RequestParam("id") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            Category category = categoryService.getCateById(id);
            map.put("result", "success");
            map.put("category", category);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 添加类目
     * @param category
     */
    @PostMapping("/add")
    public Map<Object, Object> addCate(@RequestBody Category category) {
        Map<Object, Object> map = new HashMap<>();
        try {
            categoryService.addCate(category);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 更新类目
     * @param category
     */
    @PostMapping("/edit")
    public Map<Object, Object> editCate(@RequestBody Category category) {
        Map<Object, Object> map = new HashMap<>();
        try {
            categoryService.editCate(category);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 删除类目
     * @param ids
     */
    @GetMapping("/delete")
    public Map<Object, Object> deleteCateByIds(@RequestParam("ids") String ids) {
        Map<Object, Object> map = new HashMap<>();
        try {
            categoryService.deleteCateByIds(ids);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

}
