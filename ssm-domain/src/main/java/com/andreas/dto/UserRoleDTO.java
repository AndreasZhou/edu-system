package com.andreas.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 描述：UserRoleDTO参数
 */
@Data
public class UserRoleDTO {
    // 页数
    private Integer currentPage;
    // 页大小
    private Integer pageSize;
    // 多条件查询：用户名（手机号）
    private String username;
    // 注册起始时间 2020/11/11 2020-08-04
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startCreateTime;
    // 注册结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endCreateTime;
    // 角色id列表
    private List<Integer> roleIdList;
    // 用户id
    private Integer userId;
}
