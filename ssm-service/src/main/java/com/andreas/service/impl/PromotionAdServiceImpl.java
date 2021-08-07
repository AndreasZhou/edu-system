package com.andreas.service.impl;

import com.andreas.dao.PromotionAdMapper;
import com.andreas.domain.PromotionAd;
import com.andreas.dto.PromotionAdDTO;
import com.andreas.dto.PromotionAdPageInfoDTO;
import com.andreas.service.PromotionAdService;
import com.andreas.vo.PromotionAdVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public PageInfo<PromotionAdVO> findAllPromotionAdByPage(PromotionAdPageInfoDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<PromotionAd> allPromotionAdByPage = promotionAdMapper.findAllPromotionAdByPage();
        List<PromotionAdVO> promotionAdVOS = new ArrayList<>();
        for (PromotionAd p : allPromotionAdByPage
        ) {
            PromotionAdVO promotionAdVO = new PromotionAdVO();
            BeanUtils.copyProperties(p, promotionAdVO);
            promotionAdVOS.add(promotionAdVO);
        }
        return new PageInfo<>(promotionAdVOS);
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改广告
     * @DateTime: 2021/7/23 11:18
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePromotionAd(PromotionAdDTO dto) {
        PromotionAd promotionAd = new PromotionAd();
        BeanUtils.copyProperties(dto, promotionAd);
        Date date = new Date();
        promotionAd.setUpdateTime(date);
        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    /**
     * @Author: andreaszhou
     * @Description: 新建广告
     * @DateTime: 2021/7/23 11:18
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePromotionAd(PromotionAdDTO dto) {
        PromotionAd promotionAd = new PromotionAd();
        BeanUtils.copyProperties(dto, promotionAd);
        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);
        promotionAdMapper.savePromotionAd(promotionAd);
    }

    /**
     * @Author: andreaszhou
     * @Description: 接收广告ID, 返回广告详细信息
     * @DateTime: 2021/7/23 14:37
     * @Params: id
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
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePromotionAdStatus(PromotionAdDTO dto) {
        PromotionAd promotionAd = new PromotionAd();
        BeanUtils.copyProperties(dto, promotionAd);
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
