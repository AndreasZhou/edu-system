package com.andreas.service.impl;

import com.andreas.bo.MenuBO;
import com.andreas.bo.UserBO;
import com.andreas.dao.UserMapper;
import com.andreas.domain.*;
import com.andreas.dto.UserDTO;
import com.andreas.dto.UserRoleDTO;
import com.andreas.service.UserService;
import com.andreas.utils.MD5;
import com.andreas.vo.MenuVO;
import com.andreas.vo.ResponseResultVO;
import com.andreas.vo.RoleVO;
import com.andreas.vo.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    public PageInfo<UserVO> findAllUserByPage(UserDTO dto) {
        PageHelper.startPage(dto.getPageSize(), dto.getPageSize());
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(dto, userBO);
        List<User> users = userMapper.findAllUserByPage(userBO);
        List<UserVO> userVOS = new ArrayList<>();
        for (User u : users
        ) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(u, userVO);
            userVOS.add(userVO);
        }
        return new PageInfo<>(userVOS);
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
    public void updateUserStatus(Integer id, String status) {
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
        User u = userMapper.login(user);
        if (u != null && MD5.verify(user.getPassword(), "lagou", u.getPassword())) {
            UserVO userLogin = new UserVO();
            BeanUtils.copyProperties(u, userLogin);
            return userLogin;
        }
        return null;
        //$2a$10$DDOW0oJO9cNm.ZEDNmJmF.AZhsQxoyQ84zSx.UKZBbc58qJWh9HSy
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
        for (Integer roleId : dto.getRoleIdList()) {
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
        List<Role> roleList = userMapper.findUserRelationRoleById(user_id);
        List<RoleVO> roleVOS = new ArrayList<>();
        for (Role r : roleList
        ) {
            RoleVO roleVO = new RoleVO();
            BeanUtils.copyProperties(r, roleVO);
            roleVOS.add(roleVO);
        }
        // 2.获取角色id，保存到list中
        List<Integer> list = new ArrayList<>();
        for (RoleVO r : roleVOS
        ) {
            list.add(r.getId());
        }
        // 3.根据角色id查询父菜单
        List<MenuBO> parentMenu = userMapper.findParentMenuByRoleId(list);
        List<MenuVO> parentMenuVO = new ArrayList<>();
        for (MenuBO m : parentMenu
        ) {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(m, menuVO);
            parentMenuVO.add(menuVO);
        }
        //4.封装父菜单下的子菜单
        for (MenuBO menu : parentMenu) {
            List<MenuBO> subMenu = userMapper.findSubMenuByPid(menu.getId());
            List<Menu> menus = new ArrayList<>();
            for (MenuBO m : subMenu
            ) {
                Menu temp = new Menu();
                BeanUtils.copyProperties(m, temp);
                menus.add(temp);
            }
            menu.setSubMenuList(menus);
        }
        //5.获取资源权限
        List<Resource> resourceList = userMapper.findResourceByRoleId(list);
        //6.封装数据
        Map<String, Object> map = new HashMap<>();
        map.put("menuList", parentMenuVO); //menuList: 菜单权限数据
        map.put("resourceList", resourceList);//resourceList: 资源权限数据
        return new ResponseResultVO(true, 200, "响应成功", map);
    }
}


