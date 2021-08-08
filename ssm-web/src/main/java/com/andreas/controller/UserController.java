package com.andreas.controller;

import com.andreas.dto.UserDTO;
import com.andreas.dto.UserRoleDTO;
import com.andreas.service.UserService;
import com.andreas.vo.ResponseResultVO;
import com.andreas.vo.RoleVO;
import com.andreas.vo.UserVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
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
     * @Return ResponseResultVO
     */
    @RequestMapping("findAllUserByPage")
    public ResponseResultVO findAllUserByPage(@RequestBody UserDTO dto) {
        PageInfo<UserVO> userPageInfo = userService.findAllUserByPage(dto);
        return new ResponseResultVO(true, 200, "响应成功", userPageInfo);
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改用户状态
     * @DateTime: 2021/7/23 15:45
     * @Params:
     * @Return
     */
    @RequestMapping("updateUserStatus")
    public ResponseResultVO updateUserStatus(@RequestBody UserDTO dto) {
        userService.updateUserStatus(dto.getId(), dto.getStatus());
        return new ResponseResultVO(true, 200, "修改成功", null);
    }

    /**
     * @Author: andreaszhou
     * @Description: 用户登录
     * @DateTime: 2021/8/1 17:08
     * @Params:
     * @Return
     */
    @RequestMapping("/login")
    public ResponseResultVO login(@RequestBody UserDTO dto, HttpServletRequest request) {
        UserVO userLogin = userService.login(dto);
        ResponseResultVO responseResultVO = null;
        if (userLogin != null) {
            // 保存access_token
            Map<String, Object> map = new HashMap<>();
            String access_token = UUID.randomUUID().toString();
            map.put("access_token", access_token);
            map.put("user_id", userLogin.getId());
            HttpSession session = request.getSession();
            session.setAttribute("access_token", access_token);
            session.setAttribute("user_id", userLogin.getId());
            responseResultVO = new ResponseResultVO(true, 1, "响应成功，用户登录成功", map);
        } else {
            responseResultVO = new ResponseResultVO(true, 1, "用户名或密码错误，请重新输入", null);
        }
        return responseResultVO;
    }

    /**
     * @Author: andreaszhou
     * @Description: 分配角色回显 - 根据用户id查找对应的角色的id
     * @DateTime: 2021/8/1 21:43
     * @Params:
     * @Return
     */
    @RequestMapping("findUserRoleById/{id}")
    public ResponseResultVO findUserRoleById(@PathVariable Integer id) {
        List<RoleVO> roleVOS = userService.findUserRoleById(id);
        return new ResponseResultVO(true, 200, "分配角色回显成功", roleVOS);
    }

    /**
     * @Author: andreaszhou
     * @Description: 根据用户的id分配对应的角色
     * @DateTime: 2021/8/1 22:13
     * @Params:
     * @Return
     */
    @RequestMapping("/userContextRole")
    public ResponseResultVO userContextRole(@RequestBody UserRoleDTO dto) {
        userService.userContextRole(dto);
        return new ResponseResultVO(true, 200, "分配角色成功", null);
    }

    /**
     * @Author: andreaszhou
     * @Description: 获取用户权限 -- 菜单权限和资源权限
     * @DateTime: 2021/8/1 23:09
     * @Params:
     * @Return
     */
    @RequestMapping("getUserPermissions")
    public ResponseResultVO getUserPermissions(HttpServletRequest request) {
        //获取请求头中的 token
        String token = request.getHeader("Authorization");
        // 从session中获取token
        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");
        //判断
        if (token.equals(access_token)) {
            int user_id = (Integer) session.getAttribute("user_id");
            return userService.getUserPermissions(user_id);
        } else {
            return new ResponseResultVO(false, 400, "获取失败", "");
        }
    }
}
