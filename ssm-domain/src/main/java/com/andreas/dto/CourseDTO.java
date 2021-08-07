package com.andreas.dto;

import lombok.Data;

/*
    VO:View Object 表现层对象：在表现层接收前台参数的
 */
@Data
public class CourseDTO {

    //主键
    private Integer id;

    //课程名称
    private String courseName;

    //课程一句话简介
    private String brief;

    //原价
    private Double price;

    //原价标签
    private String priceTag;

    //优惠价
    private Double discounts;

    //优惠价标签
    private String discountsTag;

    //课程内容markdown
    private String courseDescriptionMarkDown;

    //课程描述
    private String courseDescription;

    //课程分享图片url
    private String courseImgUrl;

    //是否新品
    private Integer isNew;

    //广告语
    private String isNewDes;

    //最后操作者
    private Integer lastOperatorId;


    //是否删除
    private Integer isDel;

    //总时长
    private Integer totalDuration;

    //课程列表展示图片
    private String courseListImg;

    //课程状态，0-草稿，1-上架
    private Integer status;

    //课程排序
    private Integer sortNum;

    //课程预览第一个字段
    private String previewFirstField;

    //课程预览第二个字段
    private String previewSecondField;

    //销量
    private Integer sales;

    //讲师姓名
    private String teacherName;

    //讲师职位
    private String position;

    //讲师描述
    private String description;
}
