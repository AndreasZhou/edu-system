package com.andreas.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("resource_category")
public class ResourceCategory {
    @TableId("id'")
    // 资源分类id
    private Integer id;
    // 分类名称
    private String name;
    // 排序
    private Integer sort;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // 创建时间
    private Date createdTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // 更新时间
    private Date updatedTime;
    // 创建人
    private String createdBy;
    // 更新人
    private String updatedBy;
}
