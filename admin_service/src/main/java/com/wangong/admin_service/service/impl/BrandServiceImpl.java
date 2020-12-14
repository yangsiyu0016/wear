package com.wangong.admin_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.admin_service.mapper.BrandMapper;
import com.wangong.common.domain.brand.Brand;
import com.wangong.common.service.BrandService;
import com.wangong.common.utils.String2IntArr;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 品牌逻辑层实现
 */
@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    /**
     * 获取所有含分页
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Brand> getAll(Integer page, Integer size) {
        Integer start = 0;
        if (page > 0) {
            start = (page - 1) * size;
        }
        List<Brand> brands = brandMapper.getAll(start, size);
        return brands;
    }

    /**
     * 获取总条数
     * @return
     */
    @Override
    public Long getCount() {
        return brandMapper.getCount();
    }

    /**
     * 根据id获取品牌
     * @param id
     * @return
     */
    @Override
    public Brand getBrandById(String id) {
        return brandMapper.getBrandById(id);
    }

    /**
     * 根据品牌名称获取数量
     * @param name
     * @return
     */
    @Override
    public Long getCountByName(String name) {
        return brandMapper.getCountByName(name);
    }

    /**
     * 添加品牌
     * @param brand
     */
    @Override
    public void addBrand(Brand brand) throws Exception {
        Long count = this.getCountByName(brand.getName());
        if (count > 0) {
            throw new Exception("该品牌已存在");
        }
        brand.setId(UUID.randomUUID().toString());
        brandMapper.addBrand(brand);
    }

    /**
     * 更新品牌
     * @param brand
     */
    @Override
    public void editBrand(Brand brand) throws Exception {
        Long count = this.getCountByName(brand.getName());
        if (count > 0) {
            throw new Exception("该品牌已存在");
        }
        brandMapper.editBrand(brand);
    }

    /**
     * 删除品牌
     * @param ids
     */
    @Override
    public void deleteBrandByIds(String ids) {
        String[] split = ids.split(",");
        brandMapper.deleteBrandByIds(split);
    }
}
