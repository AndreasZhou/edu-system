package com.andreas.service.impl;

import com.andreas.dao.PromotionSpaceMapper;
import com.andreas.domain.PromotionSpace;
import com.andreas.dto.PromotionSpaceDTO;
import com.andreas.service.PromotionSpaceService;
import com.andreas.vo.PromotionSpaceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        List<PromotionSpace> allPromotionSpace = promotionSpaceMapper.findAllPromotionSpace();
        List<PromotionSpaceVO> promotionSpaceVOS = new ArrayList<>();
        for (PromotionSpace p : allPromotionSpace
        ) {
            PromotionSpaceVO promotionSpaceVO = new PromotionSpaceVO();
            BeanUtils.copyProperties(p, promotionSpaceVO);
            promotionSpaceVOS.add(promotionSpaceVO);
        }
        return promotionSpaceVOS;
    }

    /**
     * @Author: andreaszhou
     * @Description: 编辑广告位
     * @DateTime: 2021/7/22 21:18
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePromotionSpace(PromotionSpaceDTO dto) {
        PromotionSpace promotionSpace = new PromotionSpace();
        BeanUtils.copyProperties(dto, promotionSpace);
        // 封装数据
        Date date = new Date();
        promotionSpace.setUpdateTime(date);
        // 调用mapper
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }

    /**
     * @Author: andreaszhou
     * @Description: 添加广告位
     * @DateTime: 2021/7/22 21:18
     * @Params: dto
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePromotionSpace(PromotionSpaceDTO dto) {
        PromotionSpace promotionSpace = new PromotionSpace();
        BeanUtils.copyProperties(dto, promotionSpace);
        // 封装数据
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);
        // 调用mapper
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改操作，回显广告位
     * @DateTime: 2021/7/23 10:31
     * @Params: id
     * @Return
     */
    @Override
    public PromotionSpace findPromotionSpaceById(Integer id) {
        return promotionSpaceMapper.findPromotionSpaceById(id);
    }
}
