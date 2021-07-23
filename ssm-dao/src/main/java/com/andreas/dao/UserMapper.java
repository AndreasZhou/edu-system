package com.andreas.dao;

import com.andreas.domain.User;
import com.andreas.dto.UserDTO;
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
}
