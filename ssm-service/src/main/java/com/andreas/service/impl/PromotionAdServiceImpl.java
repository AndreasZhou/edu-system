package com.andreas.service.impl;

import com.andreas.dao.PromotionAdMapper;
import com.andreas.domain.PromotionAd;
import com.andreas.dto.PromotionAdDTO;
import com.andreas.dto.PromotionAdPageInfoDTO;
import com.andreas.service.PromotionAdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 描述：PromotionAdServiceImpl 实现类
 */
@Service
public class PromotionAdServiceImpl implements PromotionAdService {
    @Autowired
    private PromotionAdMapper promotionAdMapper;

    /**
     * @Author: andreaszhou
     * @Description: 分页获取广告列表数据
     * @DateTime: 2021/7/23 11:17
     * @Params: dto
     * @Return
     */
    @Override
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdPageInfoDTO dto) {
        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        List<PromotionAd> promotionAds = promotionAdMapper.findAllPromotionAdByPage(dto);
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(promotionAds);
        return pageInfo;
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改广告
     * @DateTime: 2021/7/23 11:18
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePromotionAd(PromotionAdDTO dto) {
        Date date = new Date();
        dto.setUpdateTime(date);
        promotionAdMapper.updatePromotionAd(dto);
    }

    /**
     * @Author: andreaszhou
     * @Description: 新建广告
     * @DateTime: 2021/7/23 11:18
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePromotionAd(PromotionAdDTO dto) {
        Date date = new Date();
        dto.setCreateTime(date);
        dto.setUpdateTime(date);
        promotionAdMapper.savePromotionAd(dto);
    }

    /**
     * @Author: andreaszhou
     * @Description: 接收广告ID, 返回广告详细信息
     * @DateTime: 2021/7/23 14:37
     * @Params:
     * @Return
     */
    @Override
    public PromotionAd findPromotionAdById(Integer id) {
        return promotionAdMapper.findPromotionAdById(id);
    }

    /**
     * @Author: andreaszhou
     * @Description: 广告状态上下线
     * @DateTime: 2021/7/23 14:46
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePromotionAdStatus(PromotionAdDTO dto) {
        promotionAdMapper.updatePromotionAdStatus(dto);
    }
}
