package com.andreas.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 菜单类
 */
@Data
@TableName("menu")
public class Menu {

    //主键id
    @TableId("id")
    private Integer id;

    //父菜单id
    private Integer parentId;

    //菜单路径
    private String href;

    //菜单图标
    private String icon;

    //菜单名称
    private String name;

    //描述
    private String description;

    //排序号
    private Integer orderNum;

    //是否展示
    private Integer shown;

    //菜单层级，从0开始
    private Integer level;

    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    //创建人
    private String createdBy;

    //更新人
    private String updatedBy;
}
