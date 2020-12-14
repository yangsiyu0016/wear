package com.wangong.common.service;

import com.wangong.common.domain.position.Position;

/**
 * 职位接口
 */
public interface PositionService {

    /**
     * 根据id获取职位权限
     * @param id
     * @return
     */
    Position getPositionById(String id);

}
