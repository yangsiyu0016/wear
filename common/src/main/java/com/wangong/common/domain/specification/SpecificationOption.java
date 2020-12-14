package com.wangong.common.domain.specification;

import lombok.Data;

import java.io.Serializable;

/**
 * 规格选项实体类
 */
@Data
public class SpecificationOption implements Serializable {

    String id;
    String optionName;//规格选项名称
    String specId;//规格id
    Integer orders;//排序值

}
