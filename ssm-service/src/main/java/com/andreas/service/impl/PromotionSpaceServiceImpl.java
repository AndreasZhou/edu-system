package com.andreas.service.impl;

import com.andreas.dao.PromotionSpaceMapper;
import com.andreas.domain.PromotionSpace;
import com.andreas.dto.PromotionSpaceDTO;
import com.andreas.service.PromotionSpaceService;
import com.andreas.vo.PromotionSpaceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 描述：PromotionSpaceServiceImpl 实现类
 */
@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {
    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;
    /**
     * @Author: andreaszhou
     * @Description: 查询广告位列表
     * @DateTime: 2021/7/22 20:57
     * @Params:
     * @Return
     */
    @Override
    public List<PromotionSpaceVO> findAllPromotionSpace() {
        return promotionSpaceMapper.findAllPromotionSpace();
    }

    /**
     * @Author: andreaszhou
     * @Description: 编辑广告位
     * @DateTime: 2021/7/22 21:18
     * @Params:
     * @Return
     */
    @Override
    public void updatePromotionSpace(PromotionSpaceDTO dto) {
        // 封装数据
        Date date = new Date();
        dto.setUpdateTime(date);
        // 调用mapper
        promotionSpaceMapper.updatePromotionSpace(dto);
    }
    /**
     * @Author: andreaszhou
     * @Description: 添加广告位
     * @DateTime: 2021/7/22 21:18
     * @Params:
     * @Return
     */
    @Override
    public void savePromotionSpace(PromotionSpaceDTO dto) {
        // 封装数据
        dto.setSpaceKey(UUID.randomUUID().toString());
        Date date = new Date();
        dto.setCreateTime(date);
        dto.setCreateTime(date);
        dto.setIsDel(0);
        // 调用mapper
        promotionSpaceMapper.savePromotionSpace(dto);
    }
    /**
     * @Author: andreaszhou
     * @Description: 修改操作，回显广告位
     * @DateTime: 2021/7/23 10:31
     * @Params:
     * @Return
     */
    @Override
    public PromotionSpace findPromotionSpaceById(Integer id) {
        PromotionSpace promotionSpace = promotionSpaceMapper.findPromotionSpaceById(id);
        return promotionSpace;
    }
}
