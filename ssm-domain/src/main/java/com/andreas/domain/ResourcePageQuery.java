package com.andreas.domain;

import lombok.Data;

/**
 * 描述：ResourcePageQuery 类
 */
@Data
public class ResourcePageQuery {
    private Integer currentPage;
    private Integer pageSize;
    private String name;
    private Integer categoryId;
    private String url;
}
