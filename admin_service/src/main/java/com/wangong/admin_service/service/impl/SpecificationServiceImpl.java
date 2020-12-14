package com.wangong.admin_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.admin_service.mapper.SpecificationMapper;
import com.wangong.common.domain.specification.Specification;
import com.wangong.common.service.SpecificationService;
import com.wangong.common.utils.String2IntArr;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 规格逻辑层实现
 */
@Slf4j
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Resource
    private SpecificationMapper specificationMapper;

    /**
     * 分页获取所有规格
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Specification> getAllByPage(Integer page, Integer size) {
        Integer start = 0;
        if (page > 0) {
            start = (page - 1) * size;
        }
        List<Specification> specifications = specificationMapper.getAllByPage(start, size);

        return specifications;
    }

    /**
     * 获取所有规格
     * @return
     */
    @Override
    public List<Specification> getAll() {
        return specificationMapper.getAll();
    }

    /**
     * 获取总条数
     * @return
     */
    @Override
    public Long getCount() {
        return specificationMapper.getCount();
    }

    /**
     * 根据id获取规格
     * @param id
     * @return
     */
    @Override
    public Specification getSpecById(String id) {
        return specificationMapper.getSpecById(id);
    }

    /**
     * 添加规格
     * @param specification
     */
    @Override
    public void addSpec(Specification specification) throws Exception {
        Long count = specificationMapper.getCountBySpecName(specification.getSpecName());
        if (count > 0) {
            throw new  Exception("该规格已存在");
        }
        specification.setId(UUID.randomUUID().toString());
        specificationMapper.addSpec(specification);
    }

    /**
     * 更新规格
     * @param specification
     */
    @Override
    public void editSpec(Specification specification) throws Exception {
        Long count = specificationMapper.getCountBySpecName(specification.getSpecName());
        if (count > 0) {
            throw new Exception("该规格已存在");
        }
        specificationMapper.editSpec(specification);
    }

    /**
     * 删除规格
     * @param ids
     */
    @Override
    public void deleteSpec(String ids) {
        String[] split = ids.split(",");
        specificationMapper.deleteSpec(split);
    }
}
