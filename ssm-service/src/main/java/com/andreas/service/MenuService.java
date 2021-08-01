package com.andreas.service;

import com.andreas.domain.Menu;
import com.andreas.dto.MenuDTO;
import com.andreas.vo.MenuVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：MenuService接口
 */
public interface MenuService {
    /**
     * @Author: andreaszhou
     * @Description: 查看所有的父子菜单信息
     * @DateTime: 2021/7/25 19:26
     * @Params:
     * @Return
     */
    List<MenuVO> findSubMenuListByPid(int id);

    /**
     * @Author: andreaszhou
     * @Description: 查询菜单列表
     * @DateTime: 2021/7/26 21:42
     * @Params:
     * @Return
     */
    PageInfo<MenuVO> findAllMenu(Integer currentPage, Integer pageSize);

    /**
     * @Author: andreaszhou
     * @Description: 修改菜单
     * @DateTime: 2021/7/26 22:11
     * @Params:
     * @Return
     */
    void updateMenu(MenuDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 添加菜单
     * @DateTime: 2021/7/26 22:11
     * @Params:
     * @Return
     */
    void saveMenu(MenuDTO dto);
    /**
     * @Author: andreaszhou
     * @Description: 根据id查找对应的Menu信息
     * @DateTime: 2021/7/27 12:36
     * @Params:
     * @Return
     */
    Menu findMenuById(Integer id);
    /**
     * @Author: andreaszhou
     * @Description: 删除菜单信息
     * @DateTime: 2021/7/29 22:45
     * @Params:
     * @Return
     */
    void deleteMenu(Integer id);
}
