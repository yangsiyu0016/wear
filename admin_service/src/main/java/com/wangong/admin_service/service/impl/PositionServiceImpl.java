package com.wangong.admin_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.admin_service.mapper.PositionMapper;
import com.wangong.common.domain.position.Position;
import com.wangong.common.service.PositionService;

import javax.annotation.Resource;

/**
 * 职位逻辑层实现
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;

    /**
     * 根据id获取职位权限
     * @param id
     * @return
     */
    @Override
    public Position getPositionById(String id) {
        return positionMapper.getPositionById(id);
    }
}
