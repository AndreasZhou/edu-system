package com.andreas.dto;

import lombok.Data;

import java.util.List;

/**
 * 描述：RoleResourceDTO 参数封装
 */
@Data
public class RoleResourceDTO {
    // 角色id
    private Integer roleId;
    // 资源id列表
    private List<Integer> resourceIdList;

}
