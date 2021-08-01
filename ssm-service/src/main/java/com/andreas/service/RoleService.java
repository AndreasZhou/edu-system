package com.andreas.service;

import com.andreas.dto.RoleDTO;
import com.andreas.dto.RoleMenuDTO;
import com.andreas.dto.RoleResourceDTO;
import com.andreas.vo.RoleVO;

import java.util.List;

/**
 * 描述：RoleService 接口
 */
public interface RoleService {
    /**
     * @Author: andreaszhou
     * @Description: 角色列表查询&条件查询
     * @DateTime: 2021/7/25 20:05
     * @Params:
     * @Return
     */
    List<RoleVO> findAllRole(RoleDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 修改角色
     * @DateTime: 2021/7/26 8:46
     * @Params:
     * @Return
     */
    void updateRole(RoleDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 保存角色
     * @DateTime: 2021/7/26 8:46
     * @Params:
     * @Return
     */
    void saveRole(RoleDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 删除角色
     * @DateTime: 2021/7/26 12:33
     * @Params:
     * @Return
     */
    void deleteRole(Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 根据角色ID查询关联的菜单信息ID
     * @DateTime: 2021/7/26 15:44
     * @Params:
     * @Return
     */
    List<Integer> findMenuByRoleId(Integer roleId);

    /**
     * @Author: andreaszhou
     * @Description: 为角色分配菜单
     * @DateTime: 2021/7/26 16:00
     * @Params:
     * @Return
     */
    void roleContextMenu(RoleMenuDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 为角色分配资源
     * @DateTime: 2021/8/1 15:30
     * @Params:
     * @Return
     */
    void roleContextResource(RoleResourceDTO dto);
}
