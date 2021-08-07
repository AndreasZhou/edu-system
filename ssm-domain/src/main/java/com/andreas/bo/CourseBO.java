package com.andreas.bo;

import com.andreas.domain.Course;
import lombok.Data;

/*
    VO:View Object 表现层对象：在表现层接收前台参数的
 */
@Data
public class CourseBO extends Course {

    //讲师姓名
    private String teacherName;

    //讲师职位
    private String position;

    //讲师描述
    private String description;
}
