package com.wangong.admin_web.controller;


import com.wangong.common.domain.specification.Specification;
import com.wangong.common.service.SpecificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 规格控制层
 */
@Slf4j
@RestController
@RequestMapping("/spec")
public class SpecificationController {

    @Resource
    private SpecificationService specificationService;

    /**
     * 分页获取所有规格
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/page")
    public Map<Object, Object> getAllByPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<Specification> specifications = specificationService.getAllByPage(page, size);
            Long count = specificationService.getCount();
            map.put("result", "success");
            map.put("count", count);
            map.put("specifications", specifications);
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 获取所有规格
     * @return
     */
    @GetMapping("/getAll")
    public Map<Object, Object> getAll() {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<Specification> specifications = specificationService.getAll();
            Long count = specificationService.getCount();
            map.put("result", "success");
            map.put("count", count);
            map.put("specifications", specifications);
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据id获取规格
     * @param id
     * @return
     */
    @GetMapping("/getSpecById")
    public Map<Object, Object> getSpecById(@RequestParam("id") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            Specification specification = specificationService.getSpecById(id);
            map.put("result", "success");
            map.put("specification", specification);
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 添加规格
     * @param specification
     */
    @PostMapping("/add")
    public Map<Object ,Object> addSpec(@RequestBody Specification specification) {
        Map<Object, Object> map = new HashMap<>();
        try {
            specificationService.addSpec(specification);
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 更新规格
     * @param specification
     */
    @PostMapping("/edit")
    public Map<Object, Object> editSpec(@RequestBody Specification specification) {
        Map<Object, Object> map = new HashMap<>();
        try {
            specificationService.editSpec(specification);
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 删除规格
     * @param ids
     */
    @GetMapping("/delete")
    public Map<Object,  Object> deleteSpec(@RequestParam("ids") String ids) {
        Map<Object, Object> map = new HashMap<>();
        try {
            specificationService.deleteSpec(ids);
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

}
