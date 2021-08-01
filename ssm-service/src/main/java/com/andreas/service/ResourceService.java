package com.andreas.service;

import com.andreas.dto.ResourceDTO;
import com.andreas.dto.ResourcePageQueryDTO;
import com.andreas.vo.ResourceVO;
import com.github.pagehelper.PageInfo;

/**
 * 描述：ResourceService接口
 */
public interface ResourceService {
    /**
     * @Author: andreaszhou
     * @Description: 资源信息分页&条件查询
     * @DateTime: 2021/7/27 15:16
     * @Params:
     * @Return
     */
    PageInfo<ResourceVO> findAllResource(ResourcePageQueryDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 更新资源信息
     * @DateTime: 2021/7/27 15:40
     * @Params:
     * @Return
     */
    void updateResource(ResourceDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 添加资源信息
     * @DateTime: 2021/7/27 15:40
     * @Params:
     * @Return
     */
    void saveResource(ResourceDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 删除资源信息
     * @DateTime: 2021/7/27 17:54
     * @Params:
     * @Return
     */
    void deleteResource(Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 添加和编辑时信息回显
     * @DateTime: 2021/8/1 13:53
     * @Params:
     * @Return
     */
    ResourceVO showResourceById(Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 删除对应的资源的分类的id
     * @DateTime: 2021/8/1 16:31
     * @Params:
     * @Return
     */
    void deleteResourceCategoryId(Integer id);
}
