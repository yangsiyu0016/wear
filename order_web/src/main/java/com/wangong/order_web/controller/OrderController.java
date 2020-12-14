package com.wangong.order_web.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wangong.common.domain.order.Order;
import com.wangong.common.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    @Reference(version = "1.0.0")
    private OrderService orderService;


    @GetMapping("page")
    public Map<Object, Object> getAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Map<Object, Object> map = new HashMap<>();
        try {
            List<Order> orders = orderService.getAll(page, size);
            map.put("result", "success");
            map.put("orders", orders);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

}
