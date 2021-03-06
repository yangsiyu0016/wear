package com.wangong.goods_web.controller;


import com.wangong.common.domain.goods.GoodsDesc;
import com.wangong.common.service.GoodsDescService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品详情控制层
 */
@Slf4j
@RestController
@RequestMapping("/goodsDesc")
public class GoodsDescController {

    @Resource
    private GoodsDescService goodsDescService;

    /**
     * 根据商品id获取商品详情
     * @param goodsId
     * @return
     */
    @GetMapping("/getDescByGoodsId")
    public Map<Object, Object> getDescByGoodsId(@RequestParam("goodsId") String goodsId) {
        Map<Object, Object> map = new HashMap<>();
        try {
            GoodsDesc goodsDesc = goodsDescService.getDescByGoodsId(goodsId);
            map.put("result", "success");
            map.put("goodsDesc", goodsDesc);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 添加商品详情
     * @param goodsDesc
     * @return
     */
    @PostMapping("/add")
    public Map<Object, Object> addDesc(@RequestBody GoodsDesc goodsDesc) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsDescService.addDesc(goodsDesc);
            map.put("result", "success");
            map.put("goodsDesc", goodsDesc);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 更新商品详情
     * @param goodsDesc
     * @return
     */
    @PostMapping("/edit")
    public Map<Object,Object> editDesc(@RequestBody GoodsDesc goodsDesc) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsDescService.editDesc(goodsDesc);
            map.put("result", "success");
            map.put("goodsDesc", goodsDesc);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 删除详情
     * @param goodsId
     * @return
     */
    @GetMapping("/delete")
    public Map<Object,Object> deleteDesc(@RequestParam("goodsId") String goodsId) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsDescService.deleteDesc(goodsId);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

}
