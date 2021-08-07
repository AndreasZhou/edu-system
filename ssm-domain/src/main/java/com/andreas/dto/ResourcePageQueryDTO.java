package com.andreas.dto;

import lombok.Data;

@Data
public class ResourcePageQueryDTO {
    // 页数
    private Integer currentPage;
    // 页大小
    private Integer pageSize;
    // 资源名称
    private String name;
    // 资源分类id
    private Integer categoryId;
    // 资源url
    private String url;
}
