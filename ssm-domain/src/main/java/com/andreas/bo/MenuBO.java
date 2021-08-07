package com.andreas.bo;

import com.andreas.domain.Menu;
import lombok.Data;

import java.util.List;

/**
 * 菜单类MenuBO
 */
@Data
public class MenuBO extends Menu {
    // 声明集合：当前父级菜单所关联的子级菜单
    private List<Menu> subMenuList;
}
