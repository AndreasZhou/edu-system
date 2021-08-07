package com.andreas.controller;

import com.andreas.domain.PromotionSpace;
import com.andreas.dto.PromotionSpaceDTO;
import com.andreas.service.PromotionSpaceService;
import com.andreas.vo.PromotionSpaceVO;
import com.andreas.vo.ResponseResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：PromotionSpaceController
 */
@RestController
@RequestMapping("PromotionSpace")
public class PromotionSpaceController {
    @Autowired
    private PromotionSpaceService promotionSpaceService;

    /**
     * @Author: andreaszhou
     * @Description: 查询广告位列表
     * @DateTime: 2021/7/22 20:57
     * @Params:
     * @Return
     */
    @RequestMapping("findAllPromotionSpace")
    public ResponseResultVO findAllPromotionSpace() {
        List<PromotionSpaceVO> promotionSpaceVOS = promotionSpaceService.findAllPromotionSpace();
        return new ResponseResultVO(true, 200, "响应成功", promotionSpaceVOS);
    }

    /**
     * @Author: andreaszhou
     * @Description: 添加、编辑广告位
     * @DateTime: 2021/7/22 21:00
     * @Params:
     * @Return
     */
    @RequestMapping("saveOrUpdatePromotionSpace")
    public ResponseResultVO saveOrUpdatePromotionSpace(@RequestBody PromotionSpaceDTO dto) {
        if (dto.getId() != null) {
            promotionSpaceService.updatePromotionSpace(dto);
            return new ResponseResultVO(true, 200, "修改成功", null);
        } else {
            promotionSpaceService.savePromotionSpace(dto);
            return new ResponseResultVO(true, 200, "保存成功", null);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改操作，回显广告位
     * @DateTime: 2021/7/23 10:31
     * @Params:
     * @Return
     */
    @RequestMapping("findPromotionSpaceById/{id}")
    public ResponseResultVO findPromotionSpaceById(@PathVariable Integer id) {
        PromotionSpace promotionSpace = promotionSpaceService.findPromotionSpaceById(id);
        return new ResponseResultVO(true, 200, "响应成功", promotionSpace);
    }
}
