package com.andreas.dto;

import lombok.Data;

import java.util.List;

/**
 * 描述：RoleResourceDTO 参数封装
 */
@Data
public class RoleResourceDTO {
    private Integer roleId;
    private List<Integer> resourceIdList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getResourceIdList() {
        return resourceIdList;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        this.resourceIdList = resourceIdList;
    }

    @Override
    public String toString() {
        return "RoleResourceDTO{" +
                "roleId=" + roleId +
                ", resourceIdList=" + resourceIdList +
                '}';
    }
}
