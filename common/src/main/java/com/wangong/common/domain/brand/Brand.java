package com.wangong.common.domain.brand;

import lombok.Data;

import java.io.Serializable;

/**
 * 品牌实体类
 */
@Data
public class Brand implements Serializable {

    String id;
    String name;//品牌名称
    String firstChar;//首字母
}
