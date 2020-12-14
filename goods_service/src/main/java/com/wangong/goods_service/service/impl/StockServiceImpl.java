package com.wangong.goods_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.common.domain.goods.Stock;
import com.wangong.common.service.StockService;
import com.wangong.goods_service.mapper.StockMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * 库存逻辑层实现类
 */
@Slf4j
@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

    /**
     * 根据商品id获取库存对象
     * @param goodsId
     * @return
     */
    @Override
    public Stock getStockByGoodsId(String goodsId) {
        return stockMapper.getStockByGoodsId(goodsId);
    }

    /**
     * 添加库存
     */
    @Override
    public void addStock(Stock stock) {
        stockMapper.addStock(stock);
    }

    /**
     * 更新库存
     * @param stock
     */
    @Override
    public void editStock(Stock stock) {
        stockMapper.editStock(stock);
    }

    /**
     * 根据商品id删除库存
     * @param goodsId
     */
    @Override
    public void deleteStock(String goodsId) {
        stockMapper.deleteStock(goodsId);
    }
}
