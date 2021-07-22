package com.andreas.service.impl;

import com.andreas.domain.Test;
import com.andreas.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import com.andreas.dao.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public List<Test> findAllTest() {
        List<Test> allTest = testMapper.findAllTest();
        return allTest;
    }
}
