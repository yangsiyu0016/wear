package com.wangong.common.domain.category;

import lombok.Data;

import java.io.Serializable;

/**
 * 类目实体类
 */
@Data
public class Category implements Serializable {

    String id;
    String parentId;//fu'ji父级id
    String name;//类目名称

}
