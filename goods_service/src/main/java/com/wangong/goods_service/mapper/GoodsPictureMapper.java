package com.wangong.goods_service.mapper;

import com.wangong.common.domain.goods.GoodsPicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品图片持久层
 */
@Mapper
public interface GoodsPictureMapper {

    /**
     * 根据商品id获取图片集合
     * @param goodsId
     * @return
     */
    List<GoodsPicture> getGoodsPicByGoodsId(@Param("goodsId") String goodsId);

    /**
     * 根据id获取商品图片
     * @param id
     * @return
     */
    GoodsPicture getGoodsPicById(@Param("id") String id);

    /**
     * 添加商品图片
     * @param goodsPicture
     */
    void addGoodsPic(@Param("goodsPicture") GoodsPicture goodsPicture);

    /**
     * 更新商品图片
     * @param goodsPicture
     */
    void  editGoodsPic(@Param("goodsPicture") GoodsPicture goodsPicture);

    /**
     * 根据id删除商品图片
     * @param id
     */
    void deleteGoodsPic(@Param("id") String id);

    /**
     * 根据商品id删除商品图片
     * @param goodsId
     */
    void deleteGoodsPicByGoodsId(@Param("goodsId") String goodsId);

    /**
     * 根据图片路径删除
     * @param picUrl
     */
    void deleteByPicUrl(@Param("picUrl") String picUrl);
}
