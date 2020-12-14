package com.wangong.admin_service.mapper;

import com.wangong.common.domain.brand.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 品牌实体类
 */
@Mapper
public interface BrandMapper {

    /**
     * 获取所有含分页
     * @param start
     * @param size
     * @return
     */
    List<Brand> getAll(@Param("start") Integer start, @Param("size") Integer size);

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
    Brand getBrandById(@Param("id") String id);

    /**
     * 根据品牌名称获取数量
     * @param name
     * @return
     */
    Long getCountByName(@Param("name") String name);

    /**
     * 添加品牌
     * @param brand
     */
    void addBrand(@Param("brand") Brand brand);

    /**
     * 更新品牌
     * @param brand
     */
    void editBrand(@Param("brand") Brand brand);

    /**
     * 删除品牌
     * @param ids
     */
    void deleteBrandByIds(@Param("ids") String[] ids);

}
