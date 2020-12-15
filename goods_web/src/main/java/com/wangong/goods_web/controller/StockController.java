package com.wangong.goods_web.controller;

import com.wangong.common.domain.goods.Stock;
import com.wangong.common.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 库存控制层
 */
@Slf4j
@RestController
@RequestMapping("/stock")
public class StockController {

    @Resource
    private StockService stockService;

    /**
     * 根据商品id获取库存
     * @param goodsId
     * @return
     */
    @GetMapping("/getStockByGoodsId")
    public Map<Object, Object> getStockByGoodsId(@RequestParam("goodsId") String goodsId) {
        Map<Object, Object> map = new HashMap<>();
        try {
            Stock stock = stockService.getStockByGoodsId(goodsId);
            map.put("result", "success");
            map.put("stock", stock);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 添加库存
     * @param stock
     * @return
     */
    @PostMapping("/add")
    public Map<Object, Object> addStock(@RequestBody Stock stock) {
        Map<Object, Object> map = new HashMap<>();
        try {
            stockService.addStock(stock);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 更新库存
     * @param stock
     * @return
     */
    @PostMapping("/edit")
    public Map<Object, Object> editStock(@RequestBody Stock stock) {
        Map<Object, Object> map = new HashMap<>();
        try {
            stockService.editStock(stock);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据商品id删除库存
     * @param goodsId
     * @return
     */
    @GetMapping("/delete")
    public Map<Object, Object> deleteStock(@RequestParam("goodsId") String goodsId) {
        Map<Object, Object> map = new HashMap<>();
        try {
            stockService.deleteStock(goodsId);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

}
