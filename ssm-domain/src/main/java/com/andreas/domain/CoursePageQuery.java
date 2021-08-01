package com.andreas.domain;

/**
 * 描述：
 */
public class CoursePageQuery {
    //课程名称
    private String courseName;
    //课程状态，0-草稿，1-上架
    private Integer status;
    // 页数
    private Integer pageNum;
    // 页大小
    private Integer pageSize;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
