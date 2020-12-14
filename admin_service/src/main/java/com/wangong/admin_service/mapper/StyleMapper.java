package com.wangong.admin_service.mapper;

import com.wangong.common.domain.style.Style;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 *风格实体类
 */
@Mapper
public interface StyleMapper {

    /**
     * 获取所有风格(含分页)
     * @param start
     * @param size
     * @return
     */
    List<Style> getAll(@Param("start") Integer start, @Param("size") Integer size);

    /**
     * 获取总条数
     * @return
     */
    Long getCount();

    /**
     * 根据id获取风格
     * @param id
     * @return
     */
    Style getStyleById(@Param("id") String id);

    /**
     * 根据名称获取数量
     * @param name
     * @return
     */
    Long getCountByName(@Param("name") String name);

    /**
     * 添加风格
     * @param style
     */
    void addStyle(@Param("style") Style style);

    /**
     * 更新风格
     * @param style
     */
    void editStyle(@Param("style") Style style);

    /**
     * 根据id删除风格
     * @param ids
     */
    void deleteStyleByIds(@Param("ids") String[] ids);

}
