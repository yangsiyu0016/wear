package com.wangong.admin_web.controller;

import com.wangong.common.domain.brand.Brand;
import com.wangong.common.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 品牌控制层
 */
@Slf4j
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    /**
     * 获取所有含分页
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/page")
    public Map<Object, Object> getAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<Brand> brands = brandService.getAll(page, size);
            Long count = brandService.getCount();
            map.put("result", "success");
            map.put("brands", brands);
            map.put("count", count);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据id获取品牌
     * @param id
     * @return
     */
    @GetMapping("/getBrandById")
    public Map<Object, Object> getBrandById(@RequestParam("id") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            Brand brand = brandService.getBrandById(id);
            map.put("result", "success");
            map.put("brand", brand);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 添加品牌
     * @param brand
     * @return
     */
    @PostMapping("/add")
    public Map<Object, Object> addBrand(@RequestBody Brand brand) {
        Map<Object, Object> map = new HashMap<>();
        try {
            brandService.addBrand(brand);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 更新品牌
     * @param brand
     * @return
     */
    @PostMapping("/edit")
    public Map<Object, Object> editBrand(@RequestBody Brand brand) {
        Map<Object, Object> map = new HashMap<>();
        try {
            brandService.editBrand(brand);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 删除品牌
     * @param ids
     */
    @GetMapping("/delete")
    public Map<Object, Object> deleteBrandByIds(@RequestParam("ids") String ids) {
        Map<Object, Object> map = new HashMap<>();
        try {
            brandService.deleteBrandByIds(ids);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

}
