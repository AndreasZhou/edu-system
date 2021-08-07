package com.andreas.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class RoleVO {
    // 角色id
    private Integer id;
    // 角色code
    private String code;
    // 角色名称
    private String name;
    // 角色描述
    private String description;
    // 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    // 更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
    // 创建人
    private String createdBy;
    // 更新人
    private String updatedBy;
}
