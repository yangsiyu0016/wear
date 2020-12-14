package com.wangong.common.service;

import com.wangong.common.domain.goods.GoodsDesc;

/**
 * 商品详情逻辑层接口
 */
public interface GoodsDescService {

    /**
     * 根据商品id获取详情
     * @param goodsId
     * @return
     */
    GoodsDesc getDescByGoodsId(String goodsId);

    /**
     * 添加商品详情
     * @param goodsDesc
     */
    void addDesc(GoodsDesc goodsDesc);

    /**
     * 更新商品详情
     * @param goodsDesc
     */
    void editDesc(GoodsDesc goodsDesc);

    /**
     * 删除库存
     * @param goodsId
     */
    void deleteDesc(String goodsId);

}
