package com.andreas.dto;

import lombok.Data;

/**
 * 描述：CoursePageQueryDTO:参数
 */
@Data
public class CoursePageQueryDTO {
    //课程名称
    private String courseName;
    //课程状态，0-草稿，1-上架
    private Integer status;
    // 页数
    private Integer pageNum;
    // 页大小
    private Integer pageSize;
}
