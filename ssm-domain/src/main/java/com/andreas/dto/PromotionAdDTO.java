package com.andreas.dto;

import com.andreas.domain.PromotionSpace;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PromotionAdDTO {

    // 标识
    private Integer id;
    // 广告名
    private String name;
    // 广告位id
    private Integer spaceId;
    // 精确搜索关键词
    private String keyword;
    // 静态广告的内容
    private String htmlContent;
    // 文字一
    private String text;
    // 链接一
    private String link;
    // 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    // 结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    // 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    // 更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    // 状态 0 下线 1上线
    private Integer status;
    // 优先级
    private Integer priority;
    // 广告图片地址
    private String img;
    //声明一方关系：PromotionSpace
    private PromotionSpace promotionSpace;
}
