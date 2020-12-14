package com.wangong.goods_service.mapper;

import com.wangong.common.domain.goods.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品持久层
 */
@Mapper
public interface GoodsMapper {

    /**
     * 获取所有商品
     * @param sort
     * @param isDelete
     * @param keywords
     * @param start
     * @param size
     * @return
     */
    List<Goods> getAll(
            @Param("sort") String sort,
            @Param("isDelete") Boolean isDelete,
            @Param("keywords") String keywords,
            @Param("start") Integer start,
            @Param("size") Integer size);

    /**
     * 获取总条数
     * @param isDelete
     * @return
     */
    Long getCount(@Param("isDelete") Boolean isDelete);

    /**
     * 根据id获取商品
     * @param id
     * @return
     */
    Goods getGoodsById(@Param("id") String id);

    /**
     * 添加商品
     * @param goods
     */
    void addGoods(@Param("goods") Goods goods);

    /**
     * 更新商品信息
     * @param goods
     */
    void editGoods(@Param("goods") Goods goods);

    /**
     * 是否上架
     * @param isMarketable
     * @param id
     */
    void isMarketable(@Param("isMarketable") Boolean isMarketable, @Param("id") String id);

    /**
     * 是否删除
     * @param isDelete
     * @param id
     */
    void isDelete(@Param("isDelete") Boolean isDelete, @Param("id") String id);

    /**
     * 删除商品
     * @param ids
     */
    void deleteGoods(@Param("ids") String[] ids);

}
