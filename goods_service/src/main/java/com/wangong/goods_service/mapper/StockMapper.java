package com.wangong.goods_service.mapper;

import com.wangong.common.domain.goods.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 库存持久层
 */
@Mapper
public interface StockMapper {

    /**
     * 根据商品id获取库存对象
     * @param goodsId
     * @return
     */
    Stock getStockByGoodsId(@Param("goodsId") String goodsId);

    /**
     * 添加库存
     */
    void addStock(@Param("stock") Stock stock);

    /**
     * 更新库存
     * @param stock
     */
    void editStock(@Param("stock") Stock stock);

    /**
     * 根据商品id删除库存
     * @param goodsId
     */
    void deleteStock(@Param("goodsId") String goodsId);
}
