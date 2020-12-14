package com.wangong.common.service;

import com.wangong.common.domain.style.Style;

import java.util.List;

/**
 * 风格逻辑层接口
 */
public interface StyleService {

    /**
     * 获取所有风格(含分页)
     * @param page
     * @param size
     * @return
     */
    List<Style> getAll(Integer page, Integer size);

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
    Style getStyleById(String id);

    /**
     * 根据名称获取数量
     * @param name
     * @return
     */
    Long getCountByName(String name);

    /**
     * 添加风格
     * @param style
     */
    void addStyle(Style style) throws Exception;

    /**
     * 更新风格
     * @param style
     */
    void editStyle(Style style) throws Exception;

    /**
     * 根据id删除风格
     * @param ids
     */
    void deleteStyleByIds(String ids);

}
