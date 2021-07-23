package com.andreas.service.impl;

import com.andreas.dao.UserMapper;
import com.andreas.domain.User;
import com.andreas.dto.UserDTO;
import com.andreas.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改用户状态
     * @DateTime: 2021/7/23 15:45
     * @Params:
     * @Return
     */
    @Override
    public void updateUserStatus(Integer id, Integer status) {
        userMapper.updateUserStatus(id, status);
    }
}
