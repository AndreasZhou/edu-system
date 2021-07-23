package com.andreas.service;

import com.andreas.domain.PromotionAd;
import com.andreas.dto.PromotionAdDTO;
import com.andreas.dto.PromotionAdPageInfoDTO;
import com.github.pagehelper.PageInfo;

/**
 * 描述：
 */
public interface PromotionAdService {
    /**
     * @Author: andreaszhou
     * @Description: 分页获取广告列表数据
     * @DateTime: 2021/7/23 11:17
     * @Params: dto
     * @Return
     */
    PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdPageInfoDTO dto);
    /**
     * @Author: andreaszhou
     * @Description: 修改广告位
     * @DateTime: 2021/7/23 11:38
     * @Params:
     * @Return
     */
    void updatePromotionAd(PromotionAdDTO dto);
    /**
     * @Author: andreaszhou
     * @Description: 新建广告位
     * @DateTime: 2021/7/23 11:38
     * @Params:
     * @Return
     */
    void savePromotionAd(PromotionAdDTO dto);
    /**
     * @Author: andreaszhou
     * @Description: 接收广告ID,返回广告详细信息
     * @DateTime: 2021/7/23 14:37
     * @Params:
     * @Return
     */
    PromotionAd findPromotionAdById(Integer id);
    /**
     * @Author: andreaszhou
     * @Description: 广告状态上下线
     * @DateTime: 2021/7/23 14:46
     * @Params:
     * @Return
     */
    void updatePromotionAdStatus(PromotionAdDTO dto);
}
