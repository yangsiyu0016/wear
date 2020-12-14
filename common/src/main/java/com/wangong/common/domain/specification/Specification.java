package com.wangong.common.domain.specification;

import lombok.Data;

import java.io.Serializable;

/**
 * 规格实体类
 */
@Data
public class Specification implements Serializable {

    String id;
    String specName;

}
