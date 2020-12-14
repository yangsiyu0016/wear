package com.wangong.common.service;

import com.wangong.common.domain.specification.SpecificationOption;

import java.util.List;

/**
 * 规格选项逻辑层接口
 */
public interface SpecificationOptionService {

    /**
     * 分页获取所有规格选项
     * @param page
     * @param size
     * @return
     */
    List<SpecificationOption> getAllByPage(Integer page, Integer size);

    /**
     * 获取所有规格选项
     * @return
     */
    List<SpecificationOption> getAll();

    /**
     * 获取总条数
     */
    Long getCount();

    /**
     * 根据规格id获取规格选项
     * @param specId
     * @return
     */
    List<SpecificationOption> getOptionBySpecId(String specId);

    /**
     * 根据id获取规格选项
     * @param id
     * @return
     */
    SpecificationOption getOptionById(String id);

    /**
     * 添加规格选项
     * @param specificationOption
     */
    void addOption(SpecificationOption specificationOption) throws Exception;

    /**
     * 更新规格选项
     * @param specificationOption
     */
    void editOption(SpecificationOption specificationOption) throws Exception;

    /**
     * 删除规格选项
     * @param ids
     */
    void deleteOption(String ids);


}
