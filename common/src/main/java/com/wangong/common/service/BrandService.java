package com.wangong.common.service;

import com.wangong.common.domain.brand.Brand;

import java.util.List;

/**
 * 品牌逻辑层接口
 */
public interface BrandService {

    /**
     * 获取所有含分页
     * @param page
     * @param size
     * @return
     */
    List<Brand> getAll(Integer page, Integer size);

    /**
     * 获取总条数
     * @return
     */
    Long getCount();

    /**
     * 根据id获取品牌
     * @param id
     * @return
     */
    Brand getBrandById(String id);

    /**
     * 根据品牌名称获取数量
     * @param name
     * @return
     */
    Long getCountByName(String name);

    /**
     * 添加品牌
     * @param brand
     */
    void addBrand(Brand brand) throws Exception;

    /**
     * 更新品牌
     * @param brand
     */
    void editBrand(Brand brand) throws Exception;

    /**
     * 删除品牌
     * @param ids
     */
    void deleteBrandByIds(String ids);

}
