package com.andreas.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PromotionSpaceVO {
    // 广告位id
    private Integer id;
    // 广告位名称
    private String name;
    // 广告位key
    private String spaceKey;
    // 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    // 更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    // 是否删除 0表示未删除 1表示删除
    private Integer isDel;
}
