package com.andreas.service.impl;

import com.andreas.dao.UserMapper;
import com.andreas.vo.ResponseResultVO;
import com.andreas.domain.Role;
import com.andreas.domain.User;
import com.andreas.domain.User_Role_relation;
import com.andreas.dto.UserDTO;
import com.andreas.dto.UserRoleDTO;
import com.andreas.service.UserService;
import com.andreas.utils.MD5;
import com.andreas.vo.RoleVO;
import com.andreas.vo.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述：UserServiceImpl实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @Author: andreaszhou
     * @Description: 用户分页&条件查询
     * @DateTime: 2021/7/23 15:28
     * @Params: dto
     * @Return
     */
    @Override
    public PageInfo<User> findAllUserByPage(UserDTO dto) {
        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        List<User> users = userMapper.findAllUserByPage(dto);
        return new PageInfo<User>(users);
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改用户状态
     * @DateTime: 2021/7/23 15:45
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserStatus(Integer id, Integer status) {
        userMapper.updateUserStatus(id, status);
    }

    /**
     * @Author: andreaszhou
     * @Description: 用户登录
     * @DateTime: 2021/8/1 17:11
     * @Params:
     * @Return
     */
    @Override
    public UserVO login(UserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        UserVO userLogin = userMapper.login(user);
        if (userLogin != null && MD5.verify(user.getPassword(), "lagou", userLogin.getPassword())) {
            return userLogin;
        }
        return null;
    }

    /**
     * @Author: andreaszhou
     * @Description: 分配角色回显
     * @DateTime: 2021/8/1 21:43
     * @Params:
     * @Return
     */
    @Override
    public List<RoleVO> findUserRoleById(Integer id) {
        List<Role> roles = userMapper.findUserRoleById(id);
        List<RoleVO> roleVOS = new ArrayList<>();
        for (Role r : roles
        ) {
            RoleVO roleVO = new RoleVO();
            BeanUtils.copyProperties(r, roleVO);
            roleVOS.add(roleVO);
        }
        return roleVOS;
    }

    /**
     * @Author: andreaszhou
     * @Description: 根据用户的id分配对应的角色
     * @DateTime: 2021/8/1 22:13
     * @Params:
     * @Return
     */
    @Override
    public void userContextRole(UserRoleDTO dto) {
        // 根据用户ID清空中间表的关联关系
        userMapper.deleteUserContextRole(dto.getUserId());
        // 向中间表添加记录
        for (Integer roleId: dto.getRoleIdList()){
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(dto.getUserId());
            user_role_relation.setRoleId(roleId);
            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);
            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedBy("system");
            userMapper.userContextRole(user_role_relation);
        }
    }

    /**
     * @Author: andreaszhou
     * @Description: 获取用户权限
     * @DateTime: 2021/8/1 23:14
     * @Params:
     * @Return
     */
    @Override
    public ResponseResultVO getUserPermissions(Integer user_id) {
        // 1.获取当前用户拥有的角色
        return null;
    }
}


