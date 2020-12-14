package com.wangong.admin_web.controller;

import com.wangong.common.domain.style.Style;
import com.wangong.common.service.StyleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 风格控制层
 */
@Slf4j
@RestController
@RequestMapping("/style")
public class StyleController {

    @Resource
    private StyleService styleService;

    /**
     * 获取所有风格(含分页)
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/page")
    public Map<Object, Object> getAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<Style> styles = styleService.getAll(page, size);
            Long count = styleService.getCount();
            map.put("result", "success");
            map.put("styles", styles);
            map.put("count", count);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据id获取风格
     * @param id
     * @return
     */
    @GetMapping("/getStyleById")
    public Map<Object, Object> getStyleById(@RequestParam("id") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            Style style = styleService.getStyleById(id);
            map.put("result", "success");
            map.put("style", style);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 添加风格
     * @param style
     * @return
     */
    @PostMapping("/add")
    public Map<Object, Object> addStyle(@RequestBody Style style) {
        Map<Object, Object> map = new HashMap<>();
        try {
            styleService.addStyle(style);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 更新风格
     * @param style
     * @return
     */
    @PostMapping("/edit")
    public Map<Object, Object> editStyle(@RequestBody Style style) {
        Map<Object, Object> map = new HashMap<>();
        try {
            styleService.editStyle(style);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据id删除风格
     * @param ids
     * @return
     */
    @GetMapping("/delete")
    public Map<Object, Object> deleteStyleByIds(@RequestParam("ids") String ids) {
        Map<Object, Object> map = new HashMap<>();
        try {
            styleService.deleteStyleByIds(ids);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

}
