package com.wangong.common.service;

import com.wangong.common.domain.order.Order;

import java.util.List;

/**
 * 订单逻辑接口
 */
public interface OrderService {

    List<Order> getAll(Integer page, Integer size);

}
