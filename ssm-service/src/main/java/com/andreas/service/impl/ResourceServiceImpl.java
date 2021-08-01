package com.andreas.service.impl;

import com.andreas.dao.ResourceMapper;
import com.andreas.domain.Resource;
import com.andreas.domain.ResourcePageQuery;
import com.andreas.dto.ResourceDTO;
import com.andreas.dto.ResourcePageQueryDTO;
import com.andreas.service.ResourceService;
import com.andreas.vo.ResourceVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 描述：ResourceServiceImpl实现类
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * @Author: andreaszhou
     * @Description: 资源信息分页&条件查询
     * @DateTime: 2021/7/27 15:16
     * @Params:
     * @Return
     */
    @Override
    public PageInfo<ResourceVO> findAllResource(ResourcePageQueryDTO dto) {
        ResourcePageQuery resourcePageQuery = new ResourcePageQuery();
        BeanUtils.copyProperties(dto, resourcePageQuery);
        PageHelper.startPage(resourcePageQuery.getCurrentPage(), resourcePageQuery.getPageSize());
        List<ResourceVO> resources = resourceMapper.findAllResource(resourcePageQuery);
        return new PageInfo<>(resources);
    }

    /**
     * @Author: andreaszhou
     * @Description: 添加和编辑时信息回显
     * @DateTime: 2021/8/1 13:53
     * @Params:
     * @Return
     */
    @Override
    public ResourceVO showResourceById(Integer id) {
        Resource resource = resourceMapper.showResourceById(id);
        ResourceVO resourceVO = new ResourceVO();
        BeanUtils.copyProperties(resource, resourceVO);
        return resourceVO;
    }

    /**
     * @Author: andreaszhou
     * @Description: 更新资源信息
     * @DateTime: 2021/7/27 15:40
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateResource(ResourceDTO dto) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(dto, resource);
        Date date = new Date();
        resource.setUpdatedTime(date);
        resource.setUpdatedBy("system");
        resourceMapper.updateResource(resource);

    }

    /**
     * @Author: andreaszhou
     * @Description: 添加资源信息
     * @DateTime: 2021/7/27 15:40
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveResource(ResourceDTO dto) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(dto, resource);
        Date date = new Date();
        resource.setUpdatedTime(date);
        resource.setCreatedTime(date);
        resource.setCreatedBy("system");
        resource.setUpdatedBy("system");
        resourceMapper.saveResource(resource);
    }

    /**
     * @Author: andreaszhou
     * @Description: 删除资源信息
     * @DateTime: 2021/7/27 17:54
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteResource(Integer id) {
        resourceMapper.deleteResource(id);
    }

    /**
     * @Author: andreaszhou
     * @Description: 删除对应的资源的分类的id
     * @DateTime: 2021/8/1 16:31
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteResourceCategoryId(Integer id) {
        resourceMapper.deleteResourceCategoryId(id);
    }
}
