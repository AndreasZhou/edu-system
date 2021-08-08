package com.andreas.controller;

import com.andreas.dto.RoleDTO;
import com.andreas.dto.RoleMenuDTO;
import com.andreas.dto.RoleResourceDTO;
import com.andreas.service.MenuService;
import com.andreas.service.RoleService;
import com.andreas.vo.MenuVO;
import com.andreas.vo.ResourceVO;
import com.andreas.vo.ResponseResultVO;
import com.andreas.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：RoleController springmvc默认会用json格式返回，做到前后端的分离  spring mvc 会将返回的数据作为json格式返回，然后供前端使用。
 */
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    /**
     * @Author: andreaszhou
     * @Description: 角色列表查询&条件查询  -- 点击角色列表 查询  角色列表
     * @DateTime: 2021/7/25 20:05
     * @Params:
     * @Return
     */
    @RequestMapping("/findAllRole")
    public ResponseResultVO findAllRole(@RequestBody RoleDTO dto) {
        List<RoleVO> vos = roleService.findAllRole(dto);
        return new ResponseResultVO(true, 200, "查询所有角色成功", vos);
    }

    /**
     * @Author: andreaszhou
     * @Description: 添加和修改角色
     * @DateTime: 2021/7/26 8:37
     * @Params:
     * @Return
     */
    @RequestMapping("saveOrUpdateRole")
    public ResponseResultVO saveOrUpdateRole(@RequestBody RoleDTO dto) {
        if (dto.getId() != null) {
            roleService.updateRole(dto);
            return new ResponseResultVO(true, 200, "响应成功", null);
        } else {
            roleService.saveRole(dto);
            return new ResponseResultVO(true, 200, "响应成功", null);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 删除角色 1.先将当前的关联关系的表先删除，因为有关联关系，所以要先将关联关系给删除掉。
     * 2. 第一步删除了关联关系以后，然后在做相关的处理代码的实现。  就是单表的查询和实现。
     * @DateTime: 2021/7/26 12:33
     * @Params:
     * @Return
     */
    @RequestMapping("deleteRole")
    public ResponseResultVO deleteRole(@RequestParam("id") Integer id) {
        roleService.deleteRole(id);
        return new ResponseResultVO(true, 200, "响应成功", null);
    }

    /**
     * @Author: andreaszhou
     * @Description: 查看所有的父子菜单信息 -- 查询所有的父菜单以及对应的子菜单的信息(分配菜单的第一个接口)
     * @DateTime: 2021/7/25 19:26
     * @Params:
     * @Return
     */
    @RequestMapping("/findAllMenu")
    public ResponseResultVO findSubMenuListByPid() {
        // -1 表示查询所有的父子级菜单
        List<MenuVO> menuVOList = menuService.findSubMenuListByPid(-1);
        // 相应数据
        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList", menuVOList);
        return new ResponseResultVO(null, 200, "查询所有的父子菜单信息成功", map);
    }

    /**
     * @Author: andreaszhou
     * @Description: 根据角色ID查询关联的菜单信息ID
     * @DateTime: 2021/7/26 15:44
     * @Params:
     * @Return
     */
    @RequestMapping("findMenuByRoleId/{roleId}")
    public ResponseResultVO findMenuByRoleId(@PathVariable Integer roleId) {
        List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);
        return new ResponseResultVO(true, 200, "响应成功", menuByRoleId);
    }

    /**
     * @Author: andreaszhou
     * @Description: 根据角色ID查询关联的资源信息ID
     * @DateTime: 2021/8/8 9:24
     * @Params:
     * @Return
     */
    @RequestMapping("findResourceByRoleId/{roleId}")
    public ResponseResultVO findResourceRoleId(@PathVariable Integer roleId) {
        List<ResourceVO> resourceVOS = roleService.findResourceRoleId(roleId);
        return new ResponseResultVO(true,200,"响应成功",resourceVOS);
    }

    /**
     * @Author: andreaszhou
     * @Description: 为角色分配菜单  前端传入的是角色的id，
     * 用户关联菜单 {roleId:4,menuIdList:[19, 20, 7, 8, 9, 15, 16, 17, 18]}
     * @DateTime: 2021/7/26 16:00
     * @Params:
     * @Return
     */
    @RequestMapping("roleContextMenu")
    public ResponseResultVO roleContextMenu(@RequestBody RoleMenuDTO dto) {
        roleService.roleContextMenu(dto);
        return new ResponseResultVO(true, 200, "响应成功", null);
    }

    /**
     * @Author: andreaszhou
     * @Description: 为角色分配资源
     * @DateTime: 2021/8/1 15:30
     * @Params:
     * @Return
     */
    @RequestMapping("roleContextResource")
    public ResponseResultVO roleContextResource(@RequestBody RoleResourceDTO dto) {
        roleService.roleContextResource(dto);
        return new ResponseResultVO(true, 200, "响应成功", null);
    }
}
