package com.andreas.dao;

import com.andreas.domain.Test;

import java.util.List;

/**
 * 描述：TestMapper接口
 */
public interface TestMapper {
    /**
     * @Author: andreaszhou
     * @Description: 对Test表进行查询所有操作
     * @DateTime: 2021/7/20 22:43
     * @Params: 
     * @Return 
     */
    public List<Test> findAllTest();
}
