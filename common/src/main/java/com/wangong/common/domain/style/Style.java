package com.wangong.common.domain.style;

import lombok.Data;

import java.io.Serializable;

/**
 * 风格实体类
 */
@Data
public class Style implements Serializable {
    String id;
    String styleName;
}
