package com.wangong.common.service;

import com.wangong.common.domain.goods.GoodsPicture;

import java.util.List;

/***
 * 商品图片逻辑层
 */
public interface GoodsPictureService {

    /**
     * 根据商品id获取图片集合
     * @param goodsId
     * @return
     */
    List<GoodsPicture> getGoodsPicByGoodsId(String goodsId);

    /**
     * 根据id获取商品图片
     * @param id
     * @return
     */
    GoodsPicture getGoodsPicById(String id);

    /**
     * 添加商品图片
     * @param goodsPicture
     */
    void addGoodsPic(GoodsPicture goodsPicture);

    /**
     * 更新商品图片
     * @param goodsPicture
     */
    void  editGoodsPic(GoodsPicture goodsPicture);

    /**
     * 根据id删除商品图片
     * @param id
     */
    void deleteGoodsPic(String id);

    /**
     * 根据商品id删除商品图片
     * @param goodsId
     */
    void deleteGoodsPicByGoodsId(String goodsId);

}
