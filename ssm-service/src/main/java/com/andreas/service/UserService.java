package com.andreas.service;

import com.andreas.vo.ResponseResultVO;
import com.andreas.domain.User;
import com.andreas.dto.UserDTO;
import com.andreas.dto.UserRoleDTO;
import com.andreas.vo.RoleVO;
import com.andreas.vo.UserVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：UserService
 */
public interface UserService {
    /**
     * @Author: andreaszhou
     * @Description: 用户分页&条件查询
     * @DateTime: 2021/7/23 15:28
     * @Params: dto
     * @Return
     */
    PageInfo<User> findAllUserByPage(UserDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 修改用户状态
     * @DateTime: 2021/7/23 15:45
     * @Params:
     * @Return
     */
    void updateUserStatus(Integer id, Integer status);

    /**
     * @Author: andreaszhou
     * @Description: 用户登录
     * @DateTime: 2021/8/1 17:11
     * @Params:
     * @Return
     */
    UserVO login(UserDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 分配角色回显
     * @DateTime: 2021/8/1 21:43
     * @Params:
     * @Return
     */
    List<RoleVO> findUserRoleById(Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 根据用户的id分配对应的角色
     * @DateTime: 2021/8/1 22:13
     * @Params:
     * @Return
     */
    void userContextRole(UserRoleDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 获取用户权限
     * @DateTime: 2021/8/1 23:14
     * @Params:
     * @Return
     */
    ResponseResultVO getUserPermissions(Integer user_id);
}
