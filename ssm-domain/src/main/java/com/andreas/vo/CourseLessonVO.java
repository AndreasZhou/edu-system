package com.andreas.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 课时类
 */
@Data
public class CourseLessonVO {

    //主键
    private Integer id;

    //课程id
    private Integer courseId;

    //章节id
    private Integer sectionId;

    //课时主题
    private String theme;

    //课时时长
    private Integer duration;

    //是否免费
    private Integer isFree;

    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    //是否删除
    private Integer isDel;

    //排序
    private Integer orderNum;

    //状态
    private Integer status;
}
