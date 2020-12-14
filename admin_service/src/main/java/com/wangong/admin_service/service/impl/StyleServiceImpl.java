package com.wangong.admin_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.admin_service.mapper.StyleMapper;
import com.wangong.common.domain.style.Style;
import com.wangong.common.service.StyleService;
import com.wangong.common.utils.String2IntArr;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 风格逻辑层实现
 */
@Slf4j
@Service
public class StyleServiceImpl implements StyleService {

    @Resource
    private StyleMapper styleMapper;

    /**
     * 获取所有风格(含分页)
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Style> getAll(Integer page, Integer size) {
        Integer start = 0;
        if (page > 0) {
            start = (page - 1) * size;
        }
        List<Style> styles = styleMapper.getAll(start, size);
        return styles;
    }

    /**
     * 获取总条数
     * @return
     */
    @Override
    public Long getCount() {
        return styleMapper.getCount();
    }

    /**
     * 根据id获取风格
     * @param id
     * @return
     */
    @Override
    public Style getStyleById(String id) {
        return styleMapper.getStyleById(id);
    }

    /**
     * 根据名称获取数量
     * @param name
     * @return
     */
    @Override
    public Long getCountByName(String name) {
        return styleMapper.getCountByName(name);
    }

    /**
     * 添加风格
     * @param style
     */
    @Override
    public void addStyle(Style style) throws Exception{
        Long count = this.getCountByName(style.getStyleName());
        if (count > 0) {
            throw new Exception("该风格已存在");
        }
        style.setId(UUID.randomUUID().toString());
        styleMapper.addStyle(style);
    }

    /**
     * 更新风格
     * @param style
     */
    @Override
    public void editStyle(Style style) throws  Exception {
        Long count = this.getCountByName(style.getStyleName());
        if (count > 0) {
            throw new Exception("该风格已存在");
        }
        styleMapper.editStyle(style);
    }

    /**
     * 根据id删除风格
     * @param ids
     */
    @Override
    public void deleteStyleByIds(String ids) {
        String[] split = ids.split(",");
        styleMapper.deleteStyleByIds(split);
    }
}
