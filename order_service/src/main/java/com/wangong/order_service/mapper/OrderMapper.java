package com.wangong.order_service.mapper;

import com.wangong.common.domain.order.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 获取所有订单
     * @param start
     * @param size
     * @return
     */
    List<Order> getAll(@Param("start") Integer start, @Param("size") Integer size);

}
