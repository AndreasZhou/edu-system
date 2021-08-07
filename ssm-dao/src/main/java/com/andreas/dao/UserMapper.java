package com.andreas.dao;

import com.andreas.domain.*;
import com.andreas.dto.UserDTO;
import com.andreas.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：UserMapper
 */
public interface UserMapper {
    /**
     * @Author: andreaszhou
     * @Description: 用户分页&条件查询
     * @DateTime: 2021/7/23 15:28
     * @Params: dto
     * @Return
     */
    List<User> findAllUserByPage(@Param("dto") UserDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 修改用户状态
     * @DateTime: 2021/7/23 15:45
     * @Params:
     * @Return
     */
    void updateUserStatus(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * @Author: andreaszhou
     * @Description: 用户登录
     * @DateTime: 2021/8/1 17:11
     * @Params:
     * @Return
     */
    UserVO login(@Param("user") User user);

    /**
     * @Author: andreaszhou
     * @Description: 分配角色回显
     * @DateTime: 2021/8/1 21:43
     * @Params:
     * @Return
     */
    List<Role> findUserRoleById(@Param("id") Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 根据用户ID清空中间表的关联关系
     * @DateTime: 2021/8/1 22:27
     * @Params:
     * @Return
     */
    void deleteUserContextRole(@Param("userId") Integer userId);

    /**
     * @Author: andreaszhou
     * @Description: 根据用户的id分配对应的角色
     * @DateTime: 2021/8/1 22:13
     * @Params:
     * @Return
     */
    void userContextRole(User_Role_relation user_role_relation);

    /**
     * 根据ID查询用户当前角色
     * */
    public List<Role> findUserRelationRoleById(int id);
    /**
     * 根据角色id,查询角色拥有的顶级菜单信息
     * */
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);
    /**
     * 根据PID 查询子菜单信息
     * */
    public List<Menu> findSubMenuByPid(int pid);
    /**
     * 获取用户拥有的资源权限信息
     * */
    public List<Resource> findResourceByRoleId(List<Integer> ids);
}
