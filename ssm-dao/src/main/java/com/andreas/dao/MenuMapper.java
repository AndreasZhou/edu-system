package com.andreas.dao;

import com.andreas.domain.Menu;
import com.andreas.dto.MenuDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：MenuMapper mapper接口
 */
public interface MenuMapper {
    /**
     * @Author: andreaszhou
     * @Description: 查看所有的父子菜单信息 -- 查询所有的父菜单以及对应的子菜单的信息(分配菜单的第一个接口)
     * @DateTime: 2021/7/25 19:26
     * @Params:
     * @Return
     */
    List<Menu> findSubMenuListByPid(@Param("id") int id);

    /**
     * @Author: andreaszhou
     * @Description: 查询菜单列表
     * @DateTime: 2021/7/26 21:42
     * @Params:
     * @Return
     */
    List<Menu> findAllMenu();

    /**
     * @Author: andreaszhou
     * @Description: 修改菜单
     * @DateTime: 2021/7/26 22:11
     * @Params:
     * @Return
     */
    void updateMenu(@Param("menu") Menu menu);

    /**
     * @Author: andreaszhou
     * @Description: 保存菜单
     * @DateTime: 2021/7/26 22:11
     * @Params:
     * @Return
     */
    void saveMenu(@Param("menu") Menu menu);

    /**
     * @Author: andreaszhou
     * @Description: 根据id查找对应的Menu信息
     * @DateTime: 2021/7/27 12:36
     * @Params:
     * @Return
     */
    Menu findMenuById(@Param("id") Integer id);

    /**
     * @Author: andreaszhou
     * @Description: 删除菜单信息
     * @DateTime: 2021/7/29 22:45
     * @Params:
     * @Return
     */
    void deleteMenu(@Param("id") Integer id);
}
