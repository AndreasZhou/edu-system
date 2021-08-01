package com.andreas.service.impl;

import com.andreas.dao.RoleMapper;
import com.andreas.domain.Role;
import com.andreas.domain.Role_menu_relation;
import com.andreas.dto.RoleDTO;
import com.andreas.dto.RoleMenuDTO;
import com.andreas.dto.RoleResourceDTO;
import com.andreas.service.RoleService;
import com.andreas.vo.RoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述：RoleServiceImpl 实现类
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * @Author: andreaszhou
     * @Description: 角色列表查询&条件查询
     * @DateTime: 2021/7/25 20:05
     * @Params:
     * @Return
     */
    @Override
    public List<RoleVO> findAllRole(RoleDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        List<Role> allRole = roleMapper.findAllRole(role);
        List<RoleVO> roleVOS = new ArrayList<>();
        for (Role r : allRole
        ) {
            RoleVO vo = new RoleVO();
            BeanUtils.copyProperties(r, vo);
            roleVOS.add(vo);
        }
        return roleVOS;
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改角色
     * @DateTime: 2021/7/26 8:46
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(RoleDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        Date date = new Date();
        role.setUpdatedBy("admin");
        role.setUpdatedTime(date);
        roleMapper.updateRole(role);
    }

    /**
     * @Author: andreaszhou
     * @Description: 保存角色, 添加角色
     * @DateTime: 2021/7/26 8:46
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRole(RoleDTO dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        Date date = new Date();
        role.setCreatedTime(date);
        role.setUpdatedTime(date);
        role.setCreatedBy("admin");
        role.setUpdatedBy("admin");
        roleMapper.saveRole(role);
    }

    /**
     * @Author: andreaszhou
     * @Description: 删除角色
     * @DateTime: 2021/7/26 12:33
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRole(Integer id) {
        roleMapper.deleteRole(id);
    }

    /**
     * @Author: andreaszhou
     * @Description: 根据角色ID查询关联的菜单信息ID
     * @DateTime: 2021/7/26 15:44
     * @Params:
     * @Return
     */
    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {
        return roleMapper.findMenuByRoleId(roleId);
    }

    /**
     * @Author: andreaszhou
     * @Description: 为角色分配菜单
     * @DateTime: 2021/7/26 16:00
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void roleContextMenu(RoleMenuDTO dto) {
        // 1.清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(dto.getRoleId());
        // 2.为角色分配菜单
        for (Integer mid : dto.getMenuIdList()
        ) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setRoleId(dto.getRoleId());

            // 封装数据
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
            roleMapper.roleContextMenu(role_menu_relation);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 为角色分配资源
     * @DateTime: 2021/8/1 15:30
     * @Params:
     * @Return
     */
    @Override
    public void roleContextResource(RoleResourceDTO dto) {
        // 1.清空中间表的关联关系

        // 2.为角色分配资源
    }
}
