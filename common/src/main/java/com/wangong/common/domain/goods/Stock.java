package com.wangong.common.domain.goods;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 库存实体类
 */
@Data
public class Stock implements Serializable {

    String id;
    String goodsId;
    BigDecimal number;//库存数量
    BigDecimal sellNumber;//销售数量

}
