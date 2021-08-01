package com.andreas.dao;

import com.andreas.domain.Resource;
import com.andreas.domain.ResourcePageQuery;
import com.andreas.vo.ResourceVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：ResourceServiceMapper接口
 */
public interface ResourceMapper {
    /**
     * @Author: andreaszhou
     * @Description: 资源信息分页&条件查询
     * @DateTime: 2021/7/27 15:16
     * @Params:
     * @Return
     */
    List<ResourceVO> findAllResource(@Param("resourcePageQuery") ResourcePageQuery resourcePageQuery);

    /**
     * @Author: andreaszhou
     * @Description: 更新资源信息
     * @DateTime: 2021/7/27 15:40
     * @Params:
     * @Return
     */
    void updateResource(@Param("resource") Resource resource);

    /**
     * @Author: andreaszhou
     * @Description: 添加资源信息
     * @DateTime: 2021/7/27 15:40
     * @Params:
     * @Return
     */
    void saveResource(@Param("resource") Resource resource);

    /**
     * @Author: andreaszhou
     * @Description: 删除资源信息
     * @DateTime: 2021/7/27 17:54
     * @Params:
     * @Return
     */
    void deleteResource(@Param("id") Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 添加和编辑时信息回显
     * @DateTime: 2021/8/1 13:53
     * @Params:
     * @Return
     */
    Resource showResourceById(@Param("id") Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 删除对应的资源的分类的id
     * @DateTime: 2021/8/1 16:31
     * @Params:
     * @Return
     */
    void deleteResourceCategoryId(@Param("id") Integer id);
}
