package com.andreas.dto;

import lombok.Data;

@Data
public class PromotionAdPageInfoDTO {

    //当前页
    private Integer pageNum;

    //每页显示的条数
    private Integer pageSize;
}
