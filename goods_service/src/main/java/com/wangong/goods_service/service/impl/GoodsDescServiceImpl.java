package com.wangong.goods_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.common.domain.goods.GoodsDesc;
import com.wangong.common.service.GoodsDescService;
import com.wangong.goods_service.mapper.GoodsDescMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 商品详情描述逻辑层实现
 */
@Slf4j
@Service
public class GoodsDescServiceImpl implements GoodsDescService {

    @Resource
    private GoodsDescMapper goodsDescMapper;

    /**
     * 根据商品id获取商品详情
     * @param goodsId
     * @return
     */
    @Override
    public GoodsDesc getDescByGoodsId(String goodsId) {
        return goodsDescMapper.getDescByGoodsId(goodsId);
    }

    /**
     * 添加商品详情
     * @param goodsDesc
     */
    @Override
    public void addDesc(GoodsDesc goodsDesc) {
        goodsDesc.setId(UUID.randomUUID().toString());
        goodsDescMapper.addDesc(goodsDesc);
    }

    /**
     * 更新商品详情
     * @param goodsDesc
     */
    @Override
    public void editDesc(GoodsDesc goodsDesc) {
        goodsDescMapper.editDesc(goodsDesc);
    }

    /**
     * 删除详情
     * @param goodsId
     */
    @Override
    public void deleteDesc(String goodsId) {
        goodsDescMapper.deleteDesc(goodsId);
    }
}
