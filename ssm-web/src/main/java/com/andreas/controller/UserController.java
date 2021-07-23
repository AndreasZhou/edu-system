package com.andreas.controller;

import com.andreas.domain.ResponseResult;
import com.andreas.domain.User;
import com.andreas.dto.UserDTO;
import com.andreas.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：UserController
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * @Author: andreaszhou
     * @Description: 用户分页&条件查询
     * @DateTime: 2021/7/23 15:28
     * @Params: dto
     * @Return ResponseResult
     */
    @RequestMapping("findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserDTO dto) {
        PageInfo<User> userPageInfo = userService.findAllUserByPage(dto);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", userPageInfo);
        return responseResult;
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改用户状态
     * @DateTime: 2021/7/23 15:45
     * @Params:
     * @Return
     */
    @RequestMapping("updateUserStatus")
    public ResponseResult updateUserStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        userService.updateUserStatus(id, status);
        ResponseResult responseResult = new ResponseResult(true, 200, "修改成功", null);
        return responseResult;
    }
}
