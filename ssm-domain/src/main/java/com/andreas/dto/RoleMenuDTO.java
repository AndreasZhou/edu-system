package com.andreas.dto;

import java.util.List;

public class RoleMenuDTO {

    private Integer roleId;

    private List<Integer> menuIdList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Integer> menuIdList) {
        this.menuIdList = menuIdList;
    }

    @Override
    public String toString() {
        return "RoleMenuVo{" +
                "roleId=" + roleId +
                ", menuIdList=" + menuIdList +
                '}';
    }
}
