package com.andreas.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ResourceDTO {
    // 资源id
    private Integer id;
    // 资源名称
    private String name;
    // 资源url
    private String url;
    // 资源分类
    private Integer categoryId;
    // 资源描述
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
