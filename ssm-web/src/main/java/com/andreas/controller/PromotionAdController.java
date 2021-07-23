package com.andreas.controller;

import com.andreas.domain.PromotionAd;
import com.andreas.domain.ResponseResult;
import com.andreas.dto.PromotionAdDTO;
import com.andreas.dto.PromotionAdPageInfoDTO;
import com.andreas.service.PromotionAdService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：PromotionAdController类
 */
@RestController
@RequestMapping("PromotionAd")
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
    public ResponseResult findAllPromotionAdByPage(@RequestBody PromotionAdPageInfoDTO dto){
        PageInfo<PromotionAd> promotionAdPageInfo = promotionAdService.findAllPromotionAdByPage(dto);
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",promotionAdPageInfo);
        return responseResult;
    }
    /**
     * @Author: andreaszhou
     * @Description: TODO
     * @DateTime: 2021/7/23 11:18
     * @Params: 
     * @Return 
     */
    @RequestMapping("PromotionAdUpload")
    public ResponseResult promotionAdUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
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
        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", map);
        return responseResult;
    }
    /**
     * @Author: andreaszhou
     * @Description: 新建&修改广告位
     * @DateTime: 2021/7/23 11:38
     * @Params: 
     * @Return 
     */
    @RequestMapping("saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd (@RequestBody PromotionAdDTO dto){
        if (dto.getId()!=null){
            promotionAdService.updatePromotionAd(dto);
            ResponseResult responseResult = new ResponseResult(true,200,"修改成功",null);
            return responseResult;
        }else {
            promotionAdService.savePromotionAd(dto);
            ResponseResult responseResult = new ResponseResult(true,200,"保存成功",null);
            return responseResult;
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 接收广告ID,返回广告详细信息
     * @DateTime: 2021/7/23 14:37
     * @Params:
     * @Return
     */
    @RequestMapping("findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam("id") Integer id){
         PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);
         ResponseResult responseResult = new ResponseResult(true,200,"响应成功",promotionAd);
         return responseResult;
    }

    /**
     * @Author: andreaszhou
     * @Description: 广告状态上下线
     * @DateTime: 2021/7/23 14:46
     * @Params:
     * @Return
     */
    @RequestMapping("findPromotionAdById")
    public ResponseResult updatePromotionAdStatus(@RequestBody PromotionAdDTO dto){
        promotionAdService.updatePromotionAdStatus(dto);
        ResponseResult responseResult = new ResponseResult(true,200,"修改成功",null);
        return responseResult;
    }

}
