package com.andreas.service.impl;

import com.andreas.dao.ResourceCategoryMapper;
import com.andreas.domain.ResourceCategory;
import com.andreas.dto.ResourceCategoryDTO;
import com.andreas.service.ResourceCategoryService;
import com.andreas.vo.ResourceCategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 描述：ResourceCategoryServiceImpl实现类
 */
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {
    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    /**
     * @Author: andreaszhou
     * @Description: 查看资源分类信息
     * @DateTime: 2021/7/27 14:48
     * @Params:
     * @Return
     */
    @Override
    public List<ResourceCategoryVO> findAllResourceCategory() {
        return resourceCategoryMapper.findAllResourceCategory();
    }

    /**
     * @Author: andreaszhou
     * @Description: 资源分类编辑
     * @DateTime: 2021/8/1 14:42
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateResourceCategory(ResourceCategoryDTO dto) {
        ResourceCategory resourceCategory = new ResourceCategory();
        BeanUtils.copyProperties(dto, resourceCategory);
        Date date = new Date();
        resourceCategory.setUpdatedBy("system");
        resourceCategory.setUpdatedTime(date);
        resourceCategoryMapper.updateResourceCategory(resourceCategory);
    }

    /**
     * @Author: andreaszhou
     * @Description: 资源分类添加
     * @DateTime: 2021/8/1 14:42
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveResourceCategory(ResourceCategoryDTO dto) {
        ResourceCategory resourceCategory = new ResourceCategory();
        BeanUtils.copyProperties(dto, resourceCategory);
        Date date = new Date();
        resourceCategory.setCreatedTime(date);
        resourceCategory.setUpdatedTime(date);
        resourceCategory.setCreatedBy("system");
        resourceCategory.setUpdatedBy("system");
        resourceCategoryMapper.savaResourceCategory(resourceCategory);
    }

    /**
     * @Author: andreaszhou
     * @Description: 删除资源分类
     * @DateTime: 2021/8/1 15:08
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteResourceCategory(Integer id) {
        resourceCategoryMapper.deleteResourceCategory(id);
    }

    /**
     * @Author: andreaszhou
     * @Description: 编辑信息回显
     * @DateTime: 2021/8/1 15:47
     * @Params:
     * @Return
     */
    @Override
    public ResourceCategoryVO showResourceCategoryById(Integer id) {
        ResourceCategory resourceCategory = resourceCategoryMapper.showResourceCategoryById(id);
        ResourceCategoryVO resourceCategoryVO = new ResourceCategoryVO();
        BeanUtils.copyProperties(resourceCategory, resourceCategoryVO);
        return resourceCategoryVO;
    }
}
