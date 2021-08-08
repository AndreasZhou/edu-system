package com.andreas.dao;

import com.andreas.domain.Resource;
import com.andreas.domain.Role;
import com.andreas.domain.Role_menu_relation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：RoleMapper
 */
public interface RoleMapper {
    /**
     * @Author: andreaszhou
     * @Description: 角色列表查询&条件查询
     * @DateTime: 2021/7/25 20:05
     * @Params:
     * @Return
     */
    List<Role> findAllRole(@Param("role") Role role);

    /**
     * @Author: andreaszhou
     * @Description: 修改角色
     * @DateTime: 2021/7/26 8:46
     * @Params:
     * @Return
     */
    void updateRole(@Param("role") Role role);

    /**
     * @Author: andreaszhou
     * @Description: 保存角色
     * @DateTime: 2021/7/26 8:46
     * @Params:
     * @Return
     */
    void saveRole(@Param("role") Role role);

    /**
     * @Author: andreaszhou
     * @Description: 删除角色
     * @DateTime: 2021/7/26 12:33
     * @Params:
     * @Return
     */
    void deleteRole(@Param("id") Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 根据角色ID查询关联的菜单信息ID
     * @DateTime: 2021/7/26 15:44
     * @Params:
     * @Return
     */
    List<Integer> findMenuByRoleId(@Param("roleId") Integer roleId);

    /**
     * @Author: andreaszhou
     * @Description: 为角色分配菜单
     * @DateTime: 2021/7/26 16:00
     * @Params:
     * @Return
     */
    void roleContextMenu(@Param("role_menu_relation") Role_menu_relation role_menu_relation);

    /**
     * @Author: andreaszhou
     * @Description: 根据RoleId清空中间表关联关系
     * @DateTime: 2021/7/26 16:33
     * @Params:
     * @Return
     */
    void deleteRoleContextMenu(@Param("roleId") Integer roleId);

    /**
     * @Author: andreaszhou
     * @Description: 根据角色ID查询关联的资源信息ID
     * @DateTime: 2021/8/8 9:24
     * @Params: roleId
     * @Return
     */
    List<Resource> findResourceRoleId(Integer roleId);
}
