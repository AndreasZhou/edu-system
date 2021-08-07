package com.andreas.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ResourceVO {
    // 资源id
    private Integer id;
    // 资源名称
    private String name;
    // 资源url
    private String url;
    // 资源分类id
    private Integer categoryId;
    // 资源描述
    private String description;
    // 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    // 结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
    // 创建人
    private String createdBy;
    // 更新人
    private String updatedBy;
}
