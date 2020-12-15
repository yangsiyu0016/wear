package com.wangong.goods_web.controller;


import com.wangong.common.domain.goods.Goods;
import com.wangong.common.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品控制层
 */
@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    /**
     * 获取所有商品
     * @param sort
     * @param isDelete
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/page")
    public Map<Object, Object> getAll(@RequestParam("sort") String sort,
                                      @RequestParam("isDelete") Boolean isDelete,
                                      @RequestParam("keywords") String keywords,
                                      @RequestParam("page") Integer page,
                                      @RequestParam("size") Integer size) {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<Goods> goods = goodsService.getAll(sort, isDelete, keywords, page, size);
            Long count = goodsService.getCount(isDelete);
            map.put("result", "success");
            map.put("count", count);
            map.put("goods", goods);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据id获取商品
     * @param id
     * @return
     */
    @GetMapping("/getGoodsById")
    public Map<Object, Object> getGoodsById(@RequestParam("id") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            Goods goods = goodsService.getGoodsById(id);
            map.put("result", "success");
            map.put("goods", goods);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @PostMapping("/add")
    public Map<Object, Object> addGoods(@RequestBody Goods goods) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsService.addGoods(goods);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 更新商品
     * @param goods
     * @return
     */
    @PostMapping("/edit")
    public Map<Object, Object> editGoods(@RequestBody Goods goods) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsService.editGoods(goods);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 是否上架
     * @param isMarketable
     * @param id
     * @return
     */
    @GetMapping("/isMarketable")
    public Map<Object, Object> isMarketable(@RequestParam("isMarketable") Boolean isMarketable,
                                            @RequestParam("id") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsService.isMarketable(isMarketable, id);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 是否删除
     * @param isDelete
     * @param id
     * @return
     */
    @GetMapping("/isDelete")
    public Map<Object, Object> isDelete(@RequestParam("isDelete") Boolean isDelete,
                                        @RequestParam("id") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsService.isDelete(isDelete, id);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 删除商品
     * @param ids
     * @return
     */
    @GetMapping("/delete")
    public Map<Object, Object> deleteGoods(@RequestParam("ids") String ids) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsService.deleteGoods(ids);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

}
