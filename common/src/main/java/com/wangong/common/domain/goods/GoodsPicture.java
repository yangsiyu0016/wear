package com.wangong.common.domain.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品图片实体类
 */
@Data
public class GoodsPicture implements Serializable {

    String id;
    String goodsId;
    String picUrl;//图片绝对路径
    Integer picLevel;//图片顺序
    Boolean isMain;//是否主图
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date ctime;//创建时间

}
