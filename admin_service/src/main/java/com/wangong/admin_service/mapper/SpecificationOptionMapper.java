package com.wangong.admin_service.mapper;

import com.wangong.common.domain.specification.SpecificationOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 规格选项持久层
 */
@Mapper
public interface SpecificationOptionMapper {

    /**
     * 分页获取所有规格选项
     * @param start
     * @param size
     * @return
     */
    List<SpecificationOption> getAllByPage(@Param("start") Integer start, @Param("size") Integer size);

    /**
     * 获取所有规格选项
     * @return
     */
    List<SpecificationOption> getAll();

    /**
     * 获取总条数
     * @return
     */
    Long getCount();

    /**
     * 根据规格id获取规格选项
     * @param specId
     * @return
     */
    List<SpecificationOption> getOptionBySpecId(@Param("specId") String specId);

    /**
     * 根据id获取规格选项
     * @param id
     * @return
     */
    SpecificationOption getOptionById(@Param("id") String id);

    /**
     * 根据规格选项名称获取数量
     * @param optionName
     * @return
     */
    Long getCountByName(@Param("optionName") String optionName);

    /**
     * 添加规格选项
     * @param specificationOption
     */
    void addOption(@Param("specificationOption") SpecificationOption specificationOption);

    /**
     * 更新规格选项
     * @param specificationOption
     */
    void editOption(@Param("specificationOption") SpecificationOption specificationOption);

    /**
     * 删除规格选项
     * @param ids
     */
    void deleteOption(@Param("ids") String[] ids);

}
