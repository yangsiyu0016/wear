package com.wangong.common.service;

import com.wangong.common.domain.goods.Goods;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 商品逻辑层接口
 */
public interface GoodsService {

    /**
     * 获取所有商品
     * @param sort
     * @param isDelete
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    List<Goods> getAll(
            String sort,
            Boolean isDelete,
            String keywords,
            Integer page,
            Integer size);

    /**
     * 获取总条数
     * @param isDelete
     * @return
     */
    Long getCount(Boolean isDelete);

    /**
     * 根据id获取商品
     * @param id
     * @return
     */
    Goods getGoodsById(String id);

    /**
     * 添加商品
     * @param goods
     */
    void addGoods(Goods goods);

    /**
     * 更新商品信息
     * @param goods
     */
    void editGoods(Goods goods);

    /**
     * 是否上架
     * @param isMarketable
     * @param id
     */
    void isMarketable(Boolean isMarketable, String id);

    /**
     * 是否删除
     * @param isDelete
     * @param id
     */
    void isDelete(Boolean isDelete, String id);

    /**
     * 删除商品
     * @param ids
     */
    void deleteGoods(String ids);

}
