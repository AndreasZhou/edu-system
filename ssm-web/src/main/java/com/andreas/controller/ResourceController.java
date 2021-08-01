package com.andreas.controller;

import com.andreas.domain.ResponseResult;
import com.andreas.dto.ResourceDTO;
import com.andreas.dto.ResourcePageQueryDTO;
import com.andreas.service.ResourceService;
import com.andreas.vo.ResourceVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：ResourceController  VO是显示给前端工程师使用的JSON数据，DTO是前端工程师传递过来的JSON数据，
 * BO实体类：适用于数据库的操作时候的实体类
 */
@RestController
@RequestMapping("resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    /**
     * @Author: andreaszhou
     * @Description: 资源信息分页&条件查询  查询资源分类和资源的信息
     * @DateTime: 2021/7/27 15:16
     * @Params:
     * @Return
     */
    @RequestMapping("findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourcePageQueryDTO dto) {
        PageInfo<ResourceVO> pageInfo = resourceService.findAllResource(dto);
        return new ResponseResult(true, 200, "响应成功", pageInfo);
    }

    /**
     * @Author: andreaszhou
     * @Description: 添加和编辑时信息回显
     * @DateTime: 2021/8/1 13:53
     * @Params:
     * @Return
     */
    @RequestMapping("showResourceById/{id}")
    public ResponseResult showResourceId(@PathVariable Integer id) {
        ResourceVO resourceVO = resourceService.showResourceById(id);
        return new ResponseResult(true, 200, "响应成功", resourceVO);
    }

    /**
     * @Author: andreaszhou
     * @Description: 添加和更新资源信息
     * @DateTime: 2021/7/27 15:40
     * @Params:
     * @Return
     */
    @RequestMapping("saveOrUpdateResource")
    public ResponseResult saveOrUpdateResource(@RequestBody ResourceDTO dto) {
        if (dto.getId() != null) {
            // 如果有id的值不为null，那么操作的是更新的操作
            resourceService.updateResource(dto);
            return new ResponseResult(true, 200, "修改成功", null);
        } else {
            // 如果id1的值为null, 那么操作的是保存的操作
            resourceService.saveResource(dto);
            return new ResponseResult(true, 200, "保存成功", null);
        }

    }

    /**
     * @Author: andreaszhou
     * @Description: 删除资源信息
     * @DateTime: 2021/7/27 17:54
     * @Params:
     * @Return
     */
    @RequestMapping("deleteResource/{id}")
    public ResponseResult deleteResource(@PathVariable Integer id) {
        resourceService.deleteResource(id);
        return new ResponseResult(null, 200, "删除成功", null);
    }


}
