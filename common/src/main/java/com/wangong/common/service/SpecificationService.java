package com.wangong.common.service;

import com.wangong.common.domain.specification.Specification;

import java.util.List;

/**
 * 规格逻辑层接口
 */
public interface SpecificationService {

    /**
     * 分页获取所有规格
     * @param page
     * @param size
     * @return
     */
    List<Specification> getAllByPage(Integer page, Integer size);

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
     * 根据id获取规格
     * @param id
     * @return
     */
    Specification getSpecById(String id);

    /**
     * 添加规格
     * @param specification
     */
    void addSpec(Specification specification) throws Exception;

    /**
     * 更新规格
     * @param specification
     */
    void editSpec(Specification specification) throws Exception;

    /**
     * 删除规格
     * @param ids
     */
    void deleteSpec(String ids);
}
