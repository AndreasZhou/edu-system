package com.andreas.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleMenuDTO {
    // 角色id
    private Integer roleId;
    // 菜单id列表
    private List<Integer> menuIdList;
}
