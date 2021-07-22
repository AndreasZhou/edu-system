package com.andreas.service;

import com.andreas.domain.Course;
import com.andreas.vo.CourseVO;
import com.andreas.dto.CourseDTO;

import java.util.List;

/**
 * 描述：CourseService 接口
 */
public interface CourseService {
    List<Course> findCourseByCondition(CourseDTO dto);


    void saveCourseOrTeacher(CourseDTO dto);

    void updateCourseOrTeacher(CourseDTO dto);
    /**
     * @Author: andreaszhou
     * @Description: 修改课程转态
     * @DateTime: 2021/7/21 14:06
     * @Params: dto
     * @Return
     */
    void updateCourseStatus(CourseDTO dto);
    /**
     * @Author: andreaszhou
     * @Description: TODO
     * @DateTime: 2021/7/21 14:18
     * @Params: id
     * @Return CourseVO
     */
    CourseVO findCourseById(Integer id);
}
