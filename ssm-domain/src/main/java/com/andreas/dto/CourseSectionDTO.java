package com.andreas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 章节类
 */
@Data
public class CourseSectionDTO {

    //id
    private Integer id;

    //课程id
    private Integer courseId;

    //章节名
    private String sectionName;

    //章节描述
    private String description;

    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    //是否删除
    private Integer isDe;

    //排序
    private Integer orderNum;

    //状态 0:隐藏；1：待更新；2：已发布
    private Integer status;
}
