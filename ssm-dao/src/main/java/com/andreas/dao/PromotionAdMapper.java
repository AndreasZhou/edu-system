package com.andreas.dao;

import com.andreas.domain.PromotionAd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 */
public interface PromotionAdMapper {
    /**
     * @Author: andreaszhou
     * @Description: 分页获取广告列表数据
     * @DateTime: 2021/7/23 11:17
     * @Params: dto
     * @Return
     */
    List<PromotionAd> findAllPromotionAdByPage();

    /**
     * @Author: andreaszhou
     * @Description: 修改广告
     * @DateTime: 2021/7/23 11:18
     * @Params:
     * @Return
     */
    void updatePromotionAd(@Param("promotionAd") PromotionAd promotionAd);

    /**
     * @Author: andreaszhou
     * @Description: 新建广告
     * @DateTime: 2021/7/23 11:18
     * @Params:
     * @Return
     */
    void savePromotionAd(@Param("promotionAd") PromotionAd promotionAd);

    /**
     * @Author: andreaszhou
     * @Description: 接收广告ID, 返回广告详细信息
     * @DateTime: 2021/7/23 14:37
     * @Params:
     * @Return
     */
    PromotionAd findPromotionAdById(@Param("id") Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 广告状态上下线
     * @DateTime: 2021/7/23 14:46
     * @Params:
     * @Return
     */
    void updatePromotionAdStatus(@Param("promotionAd") PromotionAd promotionAd);

}
