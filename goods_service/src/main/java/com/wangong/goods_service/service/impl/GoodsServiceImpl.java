package com.wangong.goods_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.common.domain.goods.Goods;
import com.wangong.common.domain.goods.GoodsDesc;
import com.wangong.common.domain.goods.GoodsPicture;
import com.wangong.common.domain.goods.Stock;
import com.wangong.common.service.GoodsDescService;
import com.wangong.common.service.GoodsPictureService;
import com.wangong.common.service.GoodsService;
import com.wangong.common.service.StockService;
import com.wangong.common.utils.String2IntArr;
import com.wangong.goods_service.mapper.GoodsDescMapper;
import com.wangong.goods_service.mapper.GoodsMapper;
import com.wangong.goods_service.mapper.GoodsPictureMapper;
import com.wangong.goods_service.mapper.StockMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 商品逻辑层实现
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsPictureMapper goodsPictureMapper;

    @Resource
    private GoodsDescMapper goodsDescMapper;

    @Resource
    private StockMapper stockMapper;

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
        String id = UUID.randomUUID().toString();//商品id
        goods.setId(id);
        goodsMapper.addGoods(goods);//添加商品
        /*------添加商品详情开始------*/
        GoodsDesc goodsDesc = goods.getGoodsDesc();
        goodsDesc.setId(UUID.randomUUID().toString());
        goodsDesc.setGoodsId(id);
        goodsDescMapper.addDesc(goodsDesc);
        /*------添加商品详情结束------*/

        /*------添加商品库存结束------*/
        Stock stock = goods.getStock();
        stock.setId(UUID.randomUUID().toString());
        stock.setGoodsId(id);
        stockMapper.addStock(stock);
        /*------添加商品库存结束------*/

        /*------添加商品图片结束------*/
        List<GoodsPicture> goodsPictures = goods.getGoodsPictures();
        for (GoodsPicture goodsPicture: goodsPictures){
            goodsPicture.setId(UUID.randomUUID().toString());
            goodsPicture.setGoodsId(id);
            goodsPicture.setCtime(new Date());
            goodsPictureMapper.addGoodsPic(goodsPicture);
        }
        /*------添加商品图片结束------*/
    }

    /**
     * 更新商品信息
     * @param goods
     */
    @Override
    public void editGoods(Goods goods) {
        goodsMapper.editGoods(goods);
        GoodsDesc goodsDesc = goods.getGoodsDesc();
        goodsDescMapper.editDesc(goodsDesc);//更新商品详情
        Stock stock = goods.getStock();
        stockMapper.editStock(stock);//更新库存
        List<GoodsPicture> goodsPictures = goods.getGoodsPictures();
        for (GoodsPicture goodsPicture: goodsPictures) {
            goodsPictureMapper.editGoodsPic(goodsPicture);//更新商品图片
        }
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
        for (String id: split) {
            goodsDescMapper.deleteDesc(id);
            goodsPictureMapper.deleteGoodsPicByGoodsId(id);
            stockMapper.deleteStock(id);
        }
    }
}
