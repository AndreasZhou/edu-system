package com.andreas.service;

import com.andreas.domain.PromotionSpace;
import com.andreas.dto.PromotionSpaceDTO;
import com.andreas.vo.PromotionSpaceVO;

import java.util.List;

/**
 * 描述：PromotionSpaceService 层
 */
public interface PromotionSpaceService {

    /**
     * @Author: andreaszhou
     * @Description: 查询广告位列表
     * @DateTime: 2021/7/22 20:57
     * @Params:
     * @Return
     */
    List<PromotionSpaceVO> findAllPromotionSpace();
    /**
     * @Author: andreaszhou
     * @Description: 编辑广告位
     * @DateTime: 2021/7/22 21:18
     * @Params:
     * @Return
     */
    void updatePromotionSpace(PromotionSpaceDTO dto);
    /**
     * @Author: andreaszhou
     * @Description: 添加广告位
     * @DateTime: 2021/7/22 21:18
     * @Params:
     * @Return
     */
    void savePromotionSpace(PromotionSpaceDTO dto);
    /**
     * @Author: andreaszhou
     * @Description: 修改操作，回显广告位
     * @DateTime: 2021/7/23 10:31
     * @Params:
     * @Return
     */
    PromotionSpace findPromotionSpaceById(Integer id);
}
