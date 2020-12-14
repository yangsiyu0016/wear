package com.wangong.admin_service.mapper;

import com.wangong.common.domain.position.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 职位权限持久层接口
 */
@Mapper
public interface PositionMapper {

    /**
     * 根据id获取职位权限
     * @param id
     * @return
     */
    Position getPositionById(@Param("id") String id);

}
