package com.andreas.controller;

import com.andreas.domain.PromotionAd;
import com.andreas.dto.PromotionAdDTO;
import com.andreas.dto.PromotionAdPageInfoDTO;
import com.andreas.service.PromotionAdService;
import com.andreas.vo.PromotionAdVO;
import com.andreas.vo.ResponseResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：PromotionAdController类
 */
@RestController
@RequestMapping("promotionAd")
public class PromotionAdController {
    @Autowired
    private PromotionAdService promotionAdService;

    /**
     * @Author: andreaszhou
     * @Description: 分页获取广告列表数据
     * @DateTime: 2021/7/23 11:17
     * @Params: dto
     * @Return
     */
    @RequestMapping("findAllPromotionAdByPage")
    public ResponseResultVO findAllPromotionAdByPage(@RequestBody PromotionAdPageInfoDTO dto) {
        PageInfo<PromotionAdVO> promotionAdVOPageInfo = promotionAdService.findAllPromotionAdByPage(dto);
        return new ResponseResultVO(true, 200, "响应成功", promotionAdVOPageInfo);
    }

    /**
     * @Author: andreaszhou
     * @Description: TODO
     * @DateTime: 2021/7/23 11:18
     * @Params:
     * @Return
     */
    @RequestMapping("promotionAdUpload")
    public ResponseResultVO promotionAdUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("/");
        String substring = realPath.substring(0, realPath.indexOf("ssm_web"));
        String uploadPath = substring + "upload\\";
        String originalFilename = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
        File filePath = new File(uploadPath, newFileName);
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录：" + filePath);
        }
        file.transferTo(filePath);
        Map<String, String> map = new HashMap<>();
        map.put("fileName", newFileName);
        map.put("filePath", "http://localhost:8080/upload/" + newFileName);
        return new ResponseResultVO(true, 200, "图片上传成功", map);
    }

    /**
     * @Author: andreaszhou
     * @Description: 新建&修改广告位
     * @DateTime: 2021/7/23 11:38
     * @Params:
     * @Return
     */
    @RequestMapping("saveOrUpdatePromotionAd")
    public ResponseResultVO saveOrUpdatePromotionAd(@RequestBody PromotionAdDTO dto) {
        if (dto.getId() != null) {
            promotionAdService.updatePromotionAd(dto);
            return new ResponseResultVO(true, 200, "修改成功", null);
        } else {
            promotionAdService.savePromotionAd(dto);
            return new ResponseResultVO(true, 200, "保存成功", null);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 接收广告ID, 返回广告详细信息
     * @DateTime: 2021/7/23 14:37
     * @Params:
     * @Return
     */
    @RequestMapping("findPromotionAdById/{id}")
    public ResponseResultVO findPromotionAdById(@PathVariable Integer id) {
        PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);
        return new ResponseResultVO(true, 200, "响应成功", promotionAd);
    }

    /**
     * @Author: andreaszhou
     * @Description: 广告状态上下线
     * @DateTime: 2021/7/23 14:46
     * @Params:
     * @Return
     */
    @RequestMapping("updatePromotionAdStatus")
    public ResponseResultVO updatePromotionAdStatus(@RequestBody PromotionAdDTO dto) {
        promotionAdService.updatePromotionAdStatus(dto);
        return new ResponseResultVO(true, 200, "修改成功", null);
    }

}
