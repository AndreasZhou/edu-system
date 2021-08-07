package com.andreas.service;

import com.andreas.domain.Course;
import com.andreas.dto.CoursePageQueryDTO;
import com.andreas.vo.CourseVO;
import com.andreas.dto.CourseDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：CourseService 接口
 */
public interface CourseService {
    /**
     * @Author: andreaszhou
     * @Description: 根据搜索条件查询课程信息
     * @DateTime: 2021/7/21 8:41
     * @Params: dto
     * @Return: ResponseResultVO
     */
    PageInfo<Course> findCourseByCondition(CoursePageQueryDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 新建课程
     * @DateTime: 2021/7/21 14:02
     * @Params: dto
     * @Return: ResponseResultVO
     */
    void saveCourseOrTeacher(CourseDTO dto);

    /**
     * @Author: andreaszhou
     * @Description: 编辑课程
     * @DateTime: 2021/7/21 14:02
     * @Params: dto
     * @Return: ResponseResultVO
     */
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
     * @Description: 通过id查询课程信息，回显
     * @DateTime: 2021/7/21 14:18
     * @Params: id
     * @Return CourseVO
     */
    CourseVO findCourseById(Integer id);
}
