package com.wangong.admin_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangong.admin_service.mapper.SpecificationOptionMapper;
import com.wangong.common.domain.specification.SpecificationOption;
import com.wangong.common.service.SpecificationOptionService;
import com.wangong.common.utils.String2IntArr;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 规格选项逻辑层
 */
@Slf4j
@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

    @Resource
    private SpecificationOptionMapper specificationOptionMapper;

    /**
     * 分页获取所有规格选项
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<SpecificationOption> getAllByPage(Integer page, Integer size) {
        Integer start = 0;
        if (page > 0) {
            start = (page - 1) * size;
        }
        List<SpecificationOption> specificationOptions = specificationOptionMapper.getAllByPage(start, size);
        return specificationOptions;
    }

    /**
     * 获取所有规格选项
     * @return
     */
    @Override
    public List<SpecificationOption> getAll() {
        return specificationOptionMapper.getAll();
    }

    /**
     * 获取总条数
     * @return
     */
    @Override
    public Long getCount() {
        return specificationOptionMapper.getCount();
    }

    /**
     * 根据规格id获取规格选项
     * @param specId
     * @return
     */
    @Override
    public List<SpecificationOption> getOptionBySpecId(String specId) {
        return specificationOptionMapper.getOptionBySpecId(specId);
    }

    /**
     * 根据id获取规格选项
     * @param id
     * @return
     */
    @Override
    public SpecificationOption getOptionById(String id) {
        return specificationOptionMapper.getOptionById(id);
    }

    /**
     * 添加规格选项
     * @param specificationOption
     */
    @Override
    public void addOption(SpecificationOption specificationOption) throws Exception {
        Long count = specificationOptionMapper.getCountByName(specificationOption.getOptionName());
        if (count > 0) {
            throw new Exception("该规格选项已存在");
        }
        specificationOption.setId(UUID.randomUUID().toString());
        specificationOptionMapper.addOption(specificationOption);
    }

    /**
     * 更新规格选项
     * @param specificationOption
     */
    @Override
    public void editOption(SpecificationOption specificationOption) throws Exception {
        Long count = specificationOptionMapper.getCountByName(specificationOption.getOptionName());
        if (count > 0) {
            throw new Exception("该规格选项已存在");
        }
        specificationOptionMapper.editOption(specificationOption);
    }

    /**
     * 删除规格选项
     * @param ids
     */
    @Override
    public void deleteOption(String ids) {
        String[] split = ids.split(",");
        specificationOptionMapper.deleteOption(split);
    }
}
