package com.andreas.service;

import com.andreas.domain.User;
import com.andreas.dto.UserDTO;
import com.github.pagehelper.PageInfo;

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
}
