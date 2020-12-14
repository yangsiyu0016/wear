package com.wangong.goods_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.common.domain.goods.Goods;
import com.wangong.common.service.GoodsService;
import com.wangong.common.utils.String2IntArr;
import com.wangong.goods_service.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品逻辑层实现
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 获取所有商品
     * @param sort
     * @param isDelete
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Goods> getAll(String sort, Boolean isDelete, String keywords, Integer page, Integer size) {
        Integer start = 0;
        if (page > 0) {
            start = (page - 1) * size;
        }
        return goodsMapper.getAll(sort, isDelete, keywords, start, size);
    }

    /**
     * 获取总条数
     * @param isDelete
     * @return
     */
    @Override
    public Long getCount(Boolean isDelete) {
        return goodsMapper.getCount(isDelete);
    }

    /**
     * 根据id获取商品
     * @param id
     * @return
     */
    @Override
    public Goods getGoodsById(String id) {
        return goodsMapper.getGoodsById(id);
    }

    /**
     * 添加商品
     * @param goods
     */
    @Override
    public void addGoods(Goods goods) {
        if (goods.getIsDelete() == null) {
            goods.setIsDelete(false);
        }
        goodsMapper.addGoods(goods);
    }

    /**
     * 更新商品信息
     * @param goods
     */
    @Override
    public void editGoods(Goods goods) {
        goodsMapper.editGoods(goods);
    }

    /**
     * 是否上架
     * @param isMarketable
     * @param id
     */
    @Override
    public void isMarketable(Boolean isMarketable, String id) {
        goodsMapper.isMarketable(isMarketable, id);
    }

    /**
     * 是否删除
     * @param isDelete
     * @param id
     */
    @Override
    public void isDelete(Boolean isDelete, String id) {
        goodsMapper.isDelete(isDelete, id);
    }

    /**
     * 删除商品
     * @param ids
     */
    @Override
    public void deleteGoods(String ids) {
        String[] split = ids.split(",");
        goodsMapper.deleteGoods(split);
    }
}
