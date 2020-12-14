package com.wangong.common.domain.goods;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品详情实体类
 */
@Data
public class GoodsDesc implements Serializable {

    String id;
    String goodsId;//商品id
    String introduction;//描述
    String specificationItems;//规格结果集
    String packageList;//包装列表
    String saleService;//售后服务

}
