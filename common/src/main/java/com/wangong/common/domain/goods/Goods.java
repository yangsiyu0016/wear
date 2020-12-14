package com.wangong.common.domain.goods;

import com.wangong.common.domain.brand.Brand;
import com.wangong.common.domain.category.Category;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品实体类
 */
@Data
public class Goods implements Serializable {

    String id;
    String goodsName;
    String sellPoint;//卖点
    String defaultItemId;
    String auditStatus;
    Boolean isMarketable;
    String brandId;
    Brand brand;
    String caption;
    String category1Id;
    Category category1;
    String category2Id;
    Category category2;
    BigDecimal price;
    String mainPic;
    Boolean isDelete;
    String stockId;
    Stock stock;
    GoodsDesc goodsDesc;
    GoodsPicture goodsPicture;
}
