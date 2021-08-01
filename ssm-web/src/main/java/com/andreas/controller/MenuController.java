package com.andreas.controller;

import com.andreas.domain.Menu;
import com.andreas.domain.ResponseResult;
import com.andreas.dto.MenuDTO;
import com.andreas.service.MenuService;
import com.andreas.vo.MenuVO;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：MenuController
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * @Author: andreaszhou
     * @Description: 查询菜单列表
     * @DateTime: 2021/7/26 21:42
     * @Params:
     * @Return
     */
    @RequestMapping("findAllMenu")
    public ResponseResult findAllMenu(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize) {
        PageInfo<MenuVO> pageInfo = menuService.findAllMenu(currentPage, pageSize);
        return new ResponseResult(null, 200, "响应成功", pageInfo);
    }

    /**
     * @Author: andreaszhou
     * @Description: 根据菜单ID查询菜单信息  ### 接口是最重要的接口, 这是一个最复杂的菜单信息回显接口
     * 如果是新增菜单，则ID值为-1, 那么就是新增时候的回显，如果是修改菜单，则为当前选择的id的值，那么就是修改时候的回显
     * 查询菜单的信息，也就是一个回显的过程，因此在这里我们要做一个回显的操作 因为全部挂载到同一个地方，所以在这里的只要显示腹肌为-1的代码即可。
     * @DateTime: 2021/7/26 21:57
     * @Params:
     * @Return
     */
    @RequestMapping("findMenuInfoById")
    public ResponseResult findMenuInfoById(@Param("id") Integer id) {
        // 根据id的值判断当前是更新还是添加操作，判断id的值是否为-1
        if (id == -1) {
            // 添加  回显信息中不需要查询menu信息
            List<MenuVO> subMenuListByPid = menuService.findSubMenuListByPid(-1);
            // 封装数据
            Map<String, Object> map = new HashMap<>();
            map.put("menuInfo", null);
            map.put("parentMenuList", subMenuListByPid);
            return new ResponseResult(true, 200, "添加回显成功", map);
        } else {
            // 修改操作 回显所有menu信息
            Menu menu = menuService.findMenuById(id);
            List<MenuVO> subMenuListByPid = menuService.findSubMenuListByPid(-1);
            // 封装数据
            Map<String, Object> map = new HashMap<>();
            map.put("menuInfo", menu);
            map.put("parentMenuList", subMenuListByPid);
            return new ResponseResult(true, 200, "响应成功", map);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 添加&修改菜单
     * @DateTime: 2021/7/26 22:04
     * @Params:
     * @Return
     */
    @RequestMapping("saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody MenuDTO dto) {
        if (dto.getId() != null) {
            menuService.updateMenu(dto);
            return new ResponseResult(true, 200, "修改成功", null);
        } else {
            menuService.saveMenu(dto);
            return new ResponseResult(true, 200, "保存成功", null);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 删除菜单信息
     * @DateTime: 2021/7/29 22:45
     * @Params:
     * @Return
     */
    @RequestMapping("deleteMenu")
    public ResponseResult deleteMenu(@RequestParam("id") Integer id) {
        menuService.deleteMenu(id);
        return new ResponseResult(true, 200, "删除成功", null);
    }

}
