package com.wangong.order_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.common.domain.order.Order;
import com.wangong.common.service.OrderService;
import com.wangong.order_service.mapper.OrderMapper;

import javax.annotation.Resource;
import java.util.List;

@Service(version = "1.0.0")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    /**
     * 分页获取所有数据
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Order> getAll(Integer page, Integer size) {

        Integer start = 0;
        if (page > 0) {
            start = (page - 1) * size;
        }
        List<Order> orders = orderMapper.getAll(start, size);

        return orders;
        /*Order order = new Order();
        order.setId(1);
        List<Order> list = new ArrayList<>();
        list.add(order);
        return list;*/
    }
}
