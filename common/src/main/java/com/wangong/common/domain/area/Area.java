package com.wangong.common.domain.area;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 区域实体类
 */
@Data
public class Area implements Serializable {

    Integer id;
    String code;
    String name;
    Integer parentId;
    List<Area> children;
}
