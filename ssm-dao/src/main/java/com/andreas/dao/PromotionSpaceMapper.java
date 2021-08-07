package com.andreas.dao;

import com.andreas.domain.PromotionSpace;
import com.andreas.dto.PromotionSpaceDTO;
import com.andreas.vo.PromotionSpaceVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：PromotionSpaceMapper接口
 */
public interface PromotionSpaceMapper {
    /**
     * @Author: andreaszhou
     * @Description: 查询广告位列表
     * @DateTime: 2021/7/22 20:57
     * @Params:
     * @Return
     */
    List<PromotionSpace> findAllPromotionSpace();
    /**
     * @Author: andreaszhou
     * @Description: 编辑广告位
     * @DateTime: 2021/7/22 21:18
     * @Params:
     * @Return
     */
    void updatePromotionSpace(@Param("promotionSpace") PromotionSpace promotionSpace);
    /**
     * @Author: andreaszhou
     * @Description: 添加广告位
     * @DateTime: 2021/7/22 21:18
     * @Params:
     * @Return
     */
    void savePromotionSpace(@Param("promotionSpace") PromotionSpace promotionSpace);
    /**
     * @Author: andreaszhou
     * @Description: 修改操作，回显广告位
     * @DateTime: 2021/7/23 10:31
     * @Params:
     * @Return
     */
    PromotionSpace findPromotionSpaceById(@Param("id") Integer id);
}
