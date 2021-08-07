package com.andreas.controller;

/**
 * 描述：TestController
 */

import com.andreas.domain.Test;
import com.andreas.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/findAllTest")
    public List<Test> findAllTest() {
        return testService.findAllTest();
    }
}
