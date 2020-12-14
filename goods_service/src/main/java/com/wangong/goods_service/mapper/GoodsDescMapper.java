package com.wangong.goods_service.mapper;

import com.wangong.common.domain.goods.GoodsDesc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品详情持久层
 */
@Mapper
public interface GoodsDescMapper {

    /**
     * 根据商品id获取详情
     * @param goodsId
     * @return
     */
    GoodsDesc getDescByGoodsId(@Param("goodsId") String goodsId);

    /**
     * 添加商品详情
     * @param goodsDesc
     */
    void addDesc(@Param("goodsDesc") GoodsDesc goodsDesc);

    /**
     * 更新商品详情
     * @param goodsDesc
     */
    void editDesc(@Param("goodsDesc") GoodsDesc goodsDesc);

    /**
     * 删除库存
     * @param goodsId
     */
    void deleteDesc(@Param("goodsId") String goodsId);

}
