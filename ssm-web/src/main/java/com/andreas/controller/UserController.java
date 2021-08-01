package com.andreas.controller;

import com.andreas.domain.ResponseResult;
import com.andreas.domain.User;
import com.andreas.dto.UserDTO;
import com.andreas.service.UserService;
import com.andreas.vo.UserVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
        return new ResponseResult(true, 200, "响应成功", userPageInfo);
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
        return new ResponseResult(true, 200, "修改成功", null);
    }

    /**
     * @Author: andreaszhou
     * @Description: 用户登录
     * @DateTime: 2021/8/1 17:08
     * @Params:
     * @Return
     */
    @RequestMapping("/login")
    public ResponseResult login(@RequestBody UserDTO dto, HttpServletRequest request) {
        UserVO userLogin = userService.login(dto);
        ResponseResult responseResult = null;
        if (userLogin != null) {
            // 保存access_token
            Map<String, Object> map = new HashMap<>();
            String access_token = UUID.randomUUID().toString();
            map.put("access_token", access_token);
            map.put("user_id", userLogin.getId());
            HttpSession session = request.getSession();
            session.setAttribute("access_token", access_token);
            session.setAttribute("user_id", userLogin.getId());
            responseResult = new ResponseResult(true, 1, "响应成功", map);
        } else {
            responseResult = new ResponseResult(true, 1, "用户名密码错误", null);
        }
        return responseResult;
    }
}
