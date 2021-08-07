package com.andreas.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应结果封装对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResultVO {
    // 返回是否成功
    private Boolean success;
    // 返回状态码
    private Integer state;
    // 返回消息
    private String message;
    // 返回数据内容
    private Object content;
}
