package com.wangong.admin_service.mapper;

import com.wangong.common.domain.specification.Specification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 规格持久层
 */
@Mapper
public interface SpecificationMapper {

    /**
     * 分页获取所有规格
     * @param start
     * @param size
     * @return
     */
    List<Specification> getAllByPage(@Param("start") Integer start, @Param("size") Integer size);

    /**
     * 获取所有规格
     * @return
     */
    List<Specification> getAll();

    /**
     * 获取总条数
     * @return
     */
    Long getCount();

    /**
     * 根据规格名称获取数量
     * @param specName
     * @return
     */
    Long getCountBySpecName(@Param("specName") String specName);

    /**
     * 根据id获取规格
     * @param id
     * @return
     */
    Specification getSpecById(@Param("id") String id);

    /**
     * 添加规格
     * @param specification
     */
    void addSpec(@Param("specification") Specification specification);

    /**
     * 更新规格
     * @param specification
     */
    void editSpec(@Param("specification") Specification specification);

    /**
     * 删除规格
     * @param ids
     */
    void deleteSpec(@Param("ids") String[] ids);

}
