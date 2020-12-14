package com.wangong.common.service;

import com.wangong.common.domain.goods.Stock;

/**
 * 库存逻辑层接口
 */
public interface StockService {

    /**
     * 根据商品id获取库存对象
     * @param goodsId
     * @return
     */
    Stock getStockByGoodsId(String goodsId);

    /**
     * 添加库存
     */
    void addStock(Stock stock);

    /**
     * 更新库存
     * @param stock
     */
    void editStock(Stock stock);

    /**
     * 根据商品id删除库存
     * @param goodsId
     */
    void deleteStock(String goodsId);

}
