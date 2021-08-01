package com.andreas.service.impl;

import com.andreas.dao.MenuMapper;
import com.andreas.domain.Menu;
import com.andreas.dto.MenuDTO;
import com.andreas.service.MenuService;
import com.andreas.vo.MenuVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述：MenuServiceImpl实现类
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * @Author: andreaszhou
     * @Description: 查看所有的父子菜单信息
     * @DateTime: 2021/7/25 19:26
     * @Params:
     * @Return
     */
    @Override
    public List<MenuVO> findSubMenuListByPid(int id) {
        List<Menu> subMenuList = menuMapper.findSubMenuListByPid(id);
        List<MenuVO> menuVOList = new ArrayList<>();
        for (Menu m : subMenuList
        ) {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(m, menuVO);
            menuVOList.add(menuVO);
        }
        return menuVOList;
    }

    /**
     * @Author: andreaszhou
     * @Description: 查询菜单列表
     * @DateTime: 2021/7/26 21:42
     * @Params:
     * @Return
     */
    @Override
    public PageInfo<MenuVO> findAllMenu(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<MenuVO> menuVOList = new ArrayList<>();
        List<Menu> menuList = menuMapper.findAllMenu();
        for (Menu m : menuList
        ) {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(m, menuVO);
            menuVOList.add(menuVO);
        }
        return new PageInfo<>(menuVOList);
    }

    /**
     * @Author: andreaszhou
     * @Description: 修改菜单
     * @DateTime: 2021/7/26 22:11
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(MenuDTO dto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(dto, menu);
        Date date = new Date();
        menu.setUpdatedBy("system");
        menu.setUpdatedTime(date);
        menuMapper.updateMenu(menu);
    }

    /**
     * @Author: andreaszhou
     * @Description: 保存菜单
     * @DateTime: 2021/7/26 22:11
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveMenu(MenuDTO dto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(dto, menu);
        Date date = new Date();
        menu.setCreatedTime(date);
        menu.setUpdatedTime(date);
        menu.setCreatedBy("system");
        menu.setUpdatedBy("system");
        menuMapper.saveMenu(menu);
    }

    /**
     * @Author: andreaszhou
     * @Description: 菜单层级，从0开始, 保存信息的时候和修改信息的时候需要对应的层级修改
     * @DateTime: 2021/7/31 21:00
     * @Params: 
     * @Return 
     */
//    public Integer level(){
//
//    }

    /**
     * @Author: andreaszhou
     * @Description: 根据id查找对应的Menu信息
     * @DateTime: 2021/7/27 12:36
     * @Params:
     * @Return
     */
    @Override
    public Menu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }

    /**
     * @Author: andreaszhou
     * @Description: 删除菜单信息
     * @DateTime: 2021/7/29 22:45
     * @Params:
     * @Return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMenu(Integer id) {
        menuMapper.deleteMenu(id);
    }
}
