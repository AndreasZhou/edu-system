package com.andreas.service;

import com.andreas.domain.ResourceCategory;
import com.andreas.dto.ResourceCategoryDTO;
import com.andreas.vo.ResourceCategoryVO;

import java.util.List;

/**
 * 描述：ResourceCategoryService接口
 */
public interface ResourceCategoryService {
    /**
     * @Author: andreaszhou
     * @Description: 查看资源分类信息
     * @DateTime: 2021/7/27 14:48
     * @Params:
     * @Return
     */
    List<ResourceCategoryVO> findAllResourceCategory();

    /**
     * @Author: andreaszhou
     * @Description: 资源分类编辑
     * @DateTime: 2021/8/1 14:42
     * @Params:
     * @Return
     */
    void updateResourceCategory(ResourceCategoryDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 资源分类添加
     * @DateTime: 2021/8/1 14:42
     * @Params:
     * @Return
     */
    void saveResourceCategory(ResourceCategoryDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 删除资源分类
     * @DateTime: 2021/8/1 15:08
     * @Params:
     * @Return
     */
    void deleteResourceCategory(Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 编辑信息回显
     * @DateTime: 2021/8/1 15:47
     * @Params:
     * @Return
     */
    ResourceCategoryVO showResourceCategoryById(Integer id);
}
