package com.andreas.service;

import com.andreas.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 描述：TestService
 */
public interface TestService {
    public List<Test> findAllTest();
}
