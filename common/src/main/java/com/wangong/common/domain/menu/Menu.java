package com.wangong.common.domain.menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 导航栏地址实体类
 */
@Data
public class Menu implements Serializable {

    String id;
    String iconCls;//icon图标
    String title;//标题
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date ctime;//创建时间
    String parentId;//父级id
    List<Menu> menus;
    String url;//路径
    String name;//名称
    Boolean enabled;//是否启用
    Integer level;//页面等级
    String description;
}
