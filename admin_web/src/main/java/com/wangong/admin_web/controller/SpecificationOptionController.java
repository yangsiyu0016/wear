package com.wangong.admin_web.controller;

import com.wangong.common.domain.specification.SpecificationOption;
import com.wangong.common.service.SpecificationOptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 规格选项控制层
 */
@Slf4j
@RequestMapping("/specOption")
@RestController
public class SpecificationOptionController {

    @Resource
    private SpecificationOptionService specificationOptionService;

    /**
     * 分页获取所有规格选项
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/page")
    public Map<Object, Object> getAllByPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<SpecificationOption> specificationOptions = specificationOptionService.getAllByPage(page, size);
            Long count = specificationOptionService.getCount();
            map.put("result", "success");
            map.put("count", count);
            map.put("specificationOptions", specificationOptions);
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 获取所有规格选项
     * @return
     */
    @GetMapping("/getAll")
    public Map<Object, Object> getAll() {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<SpecificationOption> specificationOptions = specificationOptionService.getAll();
            Long count = specificationOptionService.getCount();
            map.put("result", "success");
            map.put("count", count);
            map.put("specificationOptions", specificationOptions);
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据规格id获取规格选项
     * @param specId
     * @return
     */
    @GetMapping("/getOptionBySpecId")
    public Map<Object, Object> getOptionBySpecId(@RequestParam("specId") String specId) {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<SpecificationOption> specificationOptions = specificationOptionService.getOptionBySpecId(specId);
            map.put("result", "success");
            map.put("specificationOptions", specificationOptions);
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /***
     * 根据id获取规格选项
     * @param id
     * @return
     */
    @GetMapping("/getOptionById")
    public Map<Object, Object> getOptionById(@RequestParam("id") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            SpecificationOption specificationOption = specificationOptionService.getOptionById(id);
            map.put("result", "success");
            map.put("specificationOption", specificationOption);
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 添加规格选项
     * @param specificationOption
     * @return
     */
    @PostMapping("/add")
    public Map<Object, Object> addOption(@RequestBody SpecificationOption specificationOption) {
        Map<Object, Object> map = new HashMap<>();
        try {
            specificationOptionService.addOption(specificationOption);
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 更新规格选项
     * @param specificationOption
     * @return
     */
    @PostMapping("/edit")
    public Map<Object, Object> editOption(@RequestBody SpecificationOption specificationOption) {
        Map<Object, Object> map = new HashMap<>();
        try {
            specificationOptionService.editOption(specificationOption);
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 删除规格选项
     * @param ids
     */
    @GetMapping("/delete")
    public Map<Object, Object> deleteOption(@RequestParam("ids") String ids) {
        Map<Object, Object> map = new HashMap<>();
        try {
            specificationOptionService.deleteOption(ids);
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

}
