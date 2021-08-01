package com.andreas.controller;

import com.andreas.domain.ResponseResult;
import com.andreas.dto.ResourceCategoryDTO;
import com.andreas.service.ResourceCategoryService;
import com.andreas.service.ResourceService;
import com.andreas.vo.ResourceCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：ResourceCategoryController
 */
@RestController
@RequestMapping("ResourceCategory")
public class ResourceCategoryController {
    @Autowired
    private ResourceCategoryService resourceCategoryService;
    @Autowired
    private ResourceService resourceService;

    /**
     * @Author: andreaszhou
     * @Description: 查看资源分类信息 , 并且是在添加的时回显
     * @DateTime: 2021/7/27 14:48
     * @Params:
     * @Return
     */
    @RequestMapping("findAllResourceCategory")
    public ResponseResult findAllResourceCategory() {
        List<ResourceCategoryVO> resourceCategoryVOS = resourceCategoryService.findAllResourceCategory();
        return new ResponseResult(true, 200, "响应成功", resourceCategoryVOS);
    }

    /**
     * @Author: andreaszhou
     * @Description: 资源分类添加和编辑
     * @DateTime: 2021/8/1 14:42
     * @Params:
     * @Return
     */
    @RequestMapping("saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategoryDTO dto) {
        if (dto.getId() != null) {
            resourceCategoryService.updateResourceCategory(dto);
            return new ResponseResult(true, 200, "保存成功", null);
        } else {
            resourceCategoryService.saveResourceCategory(dto);
            return new ResponseResult(true, 200, "修改成功", null);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 删除资源分类
     * @DateTime: 2021/8/1 15:08
     * @Params:
     * @Return
     */
    @RequestMapping("deleteResourceCategory/{id}")
    public ResponseResult deleteResourceCategory(@PathVariable Integer id) {
        // 1.首先将资源对应的资源的category_id设置为null，因为删除资源分类的时，对应的资源的分类的id的值为null
        resourceService.deleteResourceCategoryId(id);
        // 2.将对应的资源的分类删除
        resourceCategoryService.deleteResourceCategory(id);
        return new ResponseResult(true, 200, "删除成功", null);
    }


    /**
     * @Author: andreaszhou
     * @Description: 编辑信息回显
     * @DateTime: 2021/8/1 15:47
     * @Params:
     * @Return
     */
    @RequestMapping("showResourceCategoryById/{id}")
    public ResponseResult showResourceCategoryById(@PathVariable Integer id) {
        ResourceCategoryVO resourceCategoryVO = resourceCategoryService.showResourceCategoryById(id);
        return new ResponseResult(true, 200, "响应成功", resourceCategoryVO);
    }
}
