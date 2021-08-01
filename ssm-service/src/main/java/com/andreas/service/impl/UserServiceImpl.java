package com.andreas.service.impl;

import com.andreas.dao.UserMapper;
import com.andreas.domain.User;
import com.andreas.dto.UserDTO;
import com.andreas.service.UserService;
import com.andreas.utils.MD5;
import com.andreas.vo.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}


