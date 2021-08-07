package com.andreas.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Role_menu_relationDTO {
    // 角色菜单关系id
    private Integer id;
    // 菜单id
    private Integer menuId;
    // 角色id
    private Integer roleId;
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
